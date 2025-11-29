package com.panaderiamatemagica;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class GeneradorSQL {

    static class Exercise {
        String question;
        String op1, op2, op3, op4;
        int answerIdx;
        String difficulty;
        String subdim;
    }

    static class LevelDef {
        int dimId;
        int levelId;
        String subdimName;
        int targetCount;

        public LevelDef(int d, int l, String n, int t) {
            dimId = d;
            levelId = l;
            subdimName = n;
            targetCount = t;
        }
    }

    public static void main(String[] args) throws Exception {
        String inputPath = "c:\\Users\\Equipo Dell\\Documents\\Proyecto_COIL\\temp_odt_extracted\\content_utf8.txt";
        String outputPath = "c:\\Users\\Equipo Dell\\Documents\\Proyecto_COIL\\insertar_datos_completos.sql";

        List<LevelDef> levels = new ArrayList<>();
        levels.add(new LevelDef(1, 1, "Comprensión del sistema de numeración", 27));
        levels.add(new LevelDef(1, 2, "Operaciones básicas", 27));
        levels.add(new LevelDef(1, 3, "Cálculo mental", 27));
        levels.add(new LevelDef(2, 1, "Figuras planas y cuerpos geométricos", 27));
        levels.add(new LevelDef(2, 2, "propiedades de formas", 27));
        levels.add(new LevelDef(2, 3, "Ubicación espacial", 28));
        levels.add(new LevelDef(3, 1, "Medición", 26));
        levels.add(new LevelDef(3, 2, "Recolección", 27));
        levels.add(new LevelDef(3, 3, "Lectura de información", 27));
        levels.add(new LevelDef(4, 1, "Sentido numérico", 20));
        levels.add(new LevelDef(4, 2, "Introducción a la probabilidad", 20));
        levels.add(new LevelDef(4, 3, "Reconocimiento de patrones", 20));
        levels.add(new LevelDef(5, 1, "Resolución de problemas", 20));
        levels.add(new LevelDef(5, 2, "Aplicación de los conocimientos", 20));
        levels.add(new LevelDef(5, 3, "Desarrollo de estrategias", 20));

        String content = new String(Files.readAllBytes(Paths.get(inputPath)), StandardCharsets.UTF_8);
        System.out.println("Read " + content.length() + " chars.");

        // Aggressive replacement of mojibake and weird chars
        content = content.replaceAll("Ã[³3]", "ó").replaceAll("Ã[¡1]", "á").replaceAll("Ã[©9]", "é")
                .replaceAll("Ã[º0]", "ú").replaceAll("Ã[±n]", "ñ").replaceAll("Ã", "í");

        // Find subdimensions
        TreeMap<Integer, String> subdimMap = new TreeMap<>();
        Matcher mSub = Pattern.compile("Subdimensi.+?:\\s*([^\\n\\r]+)").matcher(content);
        while (mSub.find()) {
            String name = mSub.group(1).trim();
            if (name.contains("Ejercicios"))
                name = name.substring(0, name.indexOf("Ejercicios"));
            subdimMap.put(mSub.start(), name.trim());
        }
        if (subdimMap.isEmpty()) {
            // Fallback: try to find just the names
            for (LevelDef l : levels) {
                int idx = content.indexOf(l.subdimName);
                if (idx != -1)
                    subdimMap.put(idx, l.subdimName);
            }
        }

        // Regex for exercises:
        // We assume: Question ... A) ... B) ... C) ... D) ... Answer ... Diff
        // We use a lookahead/behind approach or just a simple pattern
        // Pattern: (Question) A) (Op1) B) (Op2) C) (Op3) D) (Op4) (Ans) (Diff)

        // Note: Question can be anything. We'll take the last 150 chars before A) if we
        // can't find a clear start.
        String regex = "(.{10,300}?)\\s+A\\s*\\)(.+?)\\s+B\\s*\\)(.+?)\\s+C\\s*\\)(.+?)\\s+D\\s*\\)(.+?)\\s+([A-D])\\s*\\)(.+?)\\s+(Baja|Media|Alta|Elevada|Óptima|Muy baja|[^\\s]{3,10})\\s+(Baja|Media|Alta|Elevada|Óptima|Muy baja|[^\\s]{3,10})";
        Pattern p = Pattern.compile(regex, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(content);

        List<Exercise> allExercises = new ArrayList<>();
        while (m.find()) {
            int start = m.start();
            Map.Entry<Integer, String> entry = subdimMap.floorEntry(start);
            String currentSubdim = (entry != null) ? entry.getValue() : "Desconocida";

            Exercise ex = new Exercise();
            String q = m.group(1).trim();
            // Cleanup question
            if (q.contains("Ejercicios"))
                q = q.substring(q.lastIndexOf("Ejercicios") + 10).trim();
            if (q.contains("correcta"))
                q = q.substring(q.lastIndexOf("correcta") + 8).trim();
            if (q.contains("?")) {
                // Try to find the start of the question.
                // If there is a '¿', take from there.
                int idx = q.indexOf("¿");
                if (idx != -1)
                    q = q.substring(idx);
            }

            ex.question = q;
            ex.op1 = m.group(2).trim();
            ex.op2 = m.group(3).trim();
            ex.op3 = m.group(4).trim();
            ex.op4 = m.group(5).trim();
            String ans = m.group(6).trim();
            ex.answerIdx = "A".equalsIgnoreCase(ans) ? 0
                    : "B".equalsIgnoreCase(ans) ? 1 : "C".equalsIgnoreCase(ans) ? 2 : 3;
            ex.difficulty = m.group(9).trim(); // 2nd diff
            ex.subdim = currentSubdim;

            // Basic validation
            if (ex.op1.length() < 100 && ex.op2.length() < 100) {
                allExercises.add(ex);
            }
        }

        System.out.println("Found " + allExercises.size() + " exercises.");

        // Generate SQL
        StringBuilder sql = new StringBuilder();
        sql.append("-- Script generado para Proyecto COIL\n");
        sql.append(
                "-- INSTRUCCIONES: Copia todo este texto y pégalo en el editor de consultas (Query Tool) de pgAdmin.\n");
        sql.append("-- Luego presiona el botón de ejecutar (Play/Triángulo).\n\n");

        sql.append("DELETE FROM ejercicios;\n");
        sql.append("DELETE FROM niveles;\n\n");

        for (LevelDef l : levels) {
            sql.append(String.format("INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (%d, '%s', %d);\n",
                    l.levelId, l.subdimName, l.dimId));
        }
        sql.append("\n");

        for (LevelDef l : levels) {
            List<Exercise> matches = new ArrayList<>();
            for (Exercise e : allExercises) {
                if (normalize(e.subdim).contains(normalize(l.subdimName))
                        || normalize(l.subdimName).contains(normalize(e.subdim))) {
                    matches.add(e);
                }
            }

            // If no matches, try to use *any* unassigned exercises? No, better to be safe.
            // Actually, if we have very few matches, we might want to check if the subdim
            // name matching failed.

            sql.append(String.format("-- Dimensión %d, Nivel %d: %s\n", l.dimId, l.levelId, l.subdimName));

            for (int i = 0; i < l.targetCount; i++) {
                Exercise ex;
                if (i < matches.size()) {
                    ex = matches.get(i);
                } else {
                    ex = new Exercise();
                    ex.question = "Ejercicio " + (i + 1) + " de " + l.subdimName + " (Pendiente)";
                    ex.op1 = "Opción A";
                    ex.op2 = "Opción B";
                    ex.op3 = "Opción C";
                    ex.op4 = "Opción D";
                    ex.answerIdx = 0;
                    ex.difficulty = "Media";
                }

                String q = ex.question.replace("'", "''");
                String ops = (ex.op1 + ";" + ex.op2 + ";" + ex.op3 + ";" + ex.op4).replace("'", "''");
                int diffVal = 2;
                if (normalize(ex.difficulty).contains("baja"))
                    diffVal = 1;
                if (normalize(ex.difficulty).contains("ptima") || normalize(ex.difficulty).contains("elevada"))
                    diffVal = 3;

                sql.append(String.format(
                        "INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, nivel_id, dimension_id, dificultad) VALUES ('%s', '%s', '%s', %d, %d, %d, %d);\n",
                        q, l.subdimName, ops, ex.answerIdx, l.levelId, l.dimId, diffVal));
            }
            sql.append("\n");
        }

        Files.write(Paths.get(outputPath), sql.toString().getBytes(StandardCharsets.UTF_8));
    }

    static String normalize(String s) {
        if (s == null)
            return "";
        return s.toLowerCase().replaceAll("[^a-z]", "");
    }
}
