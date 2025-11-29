package com.panaderiamatemagica;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class GeneradorDim345 {

        static class ManualEx {
                String q, ops;
                int ans, diff;

                public ManualEx(String q, String ops, int ans, int diff) {
                        this.q = q;
                        this.ops = ops;
                        this.ans = ans;
                        this.diff = diff;
                }
        }

        public static void main(String[] args) throws Exception {
                Map<Integer, List<ManualEx>> ejercicios = new HashMap<>();

                // ============================================================
                // DIMENSIÓN 3: Geometría y medida
                // ============================================================

                // Medición - Longitud
                addToDim(ejercicios, 3, "¿Cuál unidad usarías para medir la longitud de un lápiz?",
                                "Metros;Centímetros;Kilómetros;Litros", 1, 1);
                addToDim(ejercicios, 3, "¿Cuántos centímetros hay en un metro?", "10;50;100;1000", 2, 1);
                addToDim(ejercicios, 3, "Si una regla mide 30 cm, ¿cuántos milímetros mide?", "3;30;300;3000", 2, 2);
                addToDim(ejercicios, 3, "¿Cuál es mayor: 1 metro o 50 centímetros?",
                                "1 metro;50 centímetros;Son iguales;No se puede comparar", 0, 1);
                addToDim(ejercicios, 3, "Si un libro mide 20 cm de largo, ¿cuántos milímetros mide?", "2;20;200;2000",
                                2, 2);
                addToDim(ejercicios, 3, "¿Cuántos metros hay en un kilómetro?", "10;100;1000;10000", 2, 2);

                // Medición - Peso/Masa
                addToDim(ejercicios, 3, "¿Cuál unidad usarías para medir tu peso?", "Gramos;Kilogramos;Litros;Metros",
                                1, 1);
                addToDim(ejercicios, 3, "¿Cuántos gramos hay en un kilogramo?", "10;100;1000;10000", 2, 1);
                addToDim(ejercicios, 3, "Si una manzana pesa 200 gramos, ¿cuántas manzanas necesitas para tener 1 kg?",
                                "2;5;10;20", 1, 2);
                addToDim(ejercicios, 3, "¿Qué pesa más: 1 kg de algodón o 1 kg de hierro?",
                                "Algodón;Hierro;Pesan lo mismo;El hierro pesa el doble", 2, 2);
                addToDim(ejercicios, 3, "Si una bolsa de arroz pesa 5 kg, ¿cuántos gramos pesa?", "50;500;5000;50000",
                                2, 2);

                // Medición - Capacidad/Volumen
                addToDim(ejercicios, 3, "¿Cuál unidad usarías para medir el agua en una botella?",
                                "Kilogramos;Litros;Metros;Centímetros", 1, 1);
                addToDim(ejercicios, 3, "¿Cuántos mililitros hay en un litro?", "10;100;1000;10000", 2, 1);
                addToDim(ejercicios, 3, "Si bebes 250 ml de jugo, ¿cuántos vasos necesitas para beber 1 litro?",
                                "2;4;8;10", 1,
                                2);
                addToDim(ejercicios, 3, "¿Cuál tiene mayor capacidad: una jarra de 2 litros o una de 1500 ml?",
                                "2 litros;1500 ml;Son iguales;No se puede comparar", 0, 2);

                // Medición - Tiempo
                addToDim(ejercicios, 3, "¿Cuántos minutos hay en una hora?", "30;45;60;100", 2, 1);
                addToDim(ejercicios, 3, "¿Cuántas horas hay en un día?", "12;24;36;48", 1, 1);
                addToDim(ejercicios, 3, "Si son las 3:30 y pasan 45 minutos, ¿qué hora será?", "4:00;4:15;4:30;5:00", 1,
                                2);
                addToDim(ejercicios, 3, "¿Cuántos segundos hay en un minuto?", "30;60;100;120", 1, 1);
                addToDim(ejercicios, 3, "Si una película dura 2 horas, ¿cuántos minutos dura?", "60;100;120;200", 2, 2);
                addToDim(ejercicios, 3, "Si hoy es martes, ¿qué día será en 3 días?", "Miércoles;Jueves;Viernes;Sábado",
                                2, 2);

                // Perímetro y Área (conceptual)
                addToDim(ejercicios, 3, "¿Qué mide el perímetro de una figura?",
                                "El área interior;El contorno;El volumen;El peso", 1, 2);
                addToDim(ejercicios, 3, "Si un cuadrado tiene lado de 5 cm, ¿cuál es su perímetro?",
                                "10 cm;15 cm;20 cm;25 cm",
                                2, 2);
                addToDim(ejercicios, 3, "¿Cuál es el área de un rectángulo de 4 cm × 3 cm?",
                                "7 cm²;12 cm²;14 cm²;24 cm²", 1,
                                3);
                addToDim(ejercicios, 3, "Si un jardín cuadrado mide 6 metros de lado, ¿cuál es su perímetro?",
                                "12 m;18 m;24 m;36 m", 2, 3);

                // ============================================================
                // DIMENSIÓN 4: Datos y probabilidad
                // ============================================================

                // Recolección y organización de datos
                addToDim(ejercicios, 4, "Si lanzas una moneda, ¿cuántos resultados posibles hay?", "1;2;3;4", 1, 1);
                addToDim(ejercicios, 4,
                                "En una tabla de frutas favoritas, si 5 niños prefieren manzana y 3 prefieren pera, ¿cuántos niños hay en total?",
                                "2;5;8;15", 2, 1);
                addToDim(ejercicios, 4, "Si lanzas un dado, ¿cuántos números diferentes pueden salir?", "4;5;6;7", 2,
                                1);
                addToDim(ejercicios, 4,
                                "En una encuesta, 10 niños prefieren fútbol, 7 básquet y 3 natación. ¿Cuántos niños fueron encuestados?",
                                "10;17;20;30", 2, 2);
                addToDim(ejercicios, 4, "¿Cuál deporte fue el más popular si: fútbol 12, básquet 8, natación 5?",
                                "Fútbol;Básquet;Natación;Todos igual", 0, 1);

                // Interpretación de gráficas simples
                addToDim(ejercicios, 4, "En una tabla: Lunes 3, Martes 5, Miércoles 2. ¿Qué día tuvo más?",
                                "Lunes;Martes;Miércoles;Todos igual", 1, 1);
                addToDim(ejercicios, 4, "Si hay 8 perros, 5 gatos y 3 pájaros, ¿cuántos animales hay en total?",
                                "13;16;18;20",
                                1, 1);
                addToDim(ejercicios, 4, "Si hay el doble de niñas que niños y hay 6 niños, ¿cuántas niñas hay?",
                                "3;6;12;18", 2,
                                2);

                // Probabilidad básica
                addToDim(ejercicios, 4,
                                "En una bolsa con 3 bolas rojas y 1 azul, ¿de qué color es más probable sacar una?",
                                "Roja;Azul;Igual probabilidad;Verde", 0, 2);
                addToDim(ejercicios, 4, "Si lanzas una moneda, ¿es más probable que salga cara o cruz?",
                                "Cara;Cruz;Igual probabilidad;Depende de la moneda", 2, 2);
                addToDim(ejercicios, 4, "Si un dado tiene 6 caras numeradas del 1 al 6, ¿cuál es imposible que salga?",
                                "3;6;7;1", 2, 2);
                addToDim(ejercicios, 4,
                                "En una ruleta con 4 secciones iguales (rojo, azul, verde, amarillo), ¿cuál color tiene más probabilidad?",
                                "Rojo;Azul;Todos igual;Verde", 2, 2);

                // Promedio y moda (conceptual)
                addToDim(ejercicios, 4, "Si tienes las calificaciones 8, 9 y 10, ¿cuál es el promedio?", "8;9;10;27", 1,
                                3);
                addToDim(ejercicios, 4, "En el grupo hay edades: 7, 8, 7, 9, 7. ¿Cuál edad se repite más?", "6;7;8;9",
                                1, 2);
                addToDim(ejercicios, 4, "Si Mario tiene 5 dulces, Ana 3 y Luis 4, ¿cuántos dulces tienen en promedio?",
                                "3;4;5;12", 1, 3);
                addToDim(ejercicios, 4,
                                "En una serie de números: 2, 5, 2, 8, 2, 3, ¿cuál es la moda (el más repetido)?",
                                "2;3;5;8", 0, 2);

                // Patrones en datos
                addToDim(ejercicios, 4, "Si el patrón es: 2, 4, 6, 8, ¿qué número sigue?", "9;10;12;14", 1, 2);
                addToDim(ejercicios, 4, "¿Qué número sigue en: 5, 10, 15, 20, ___?", "21;25;30;35", 1, 2);
                addToDim(ejercicios, 4, "En la secuencia: 1, 3, 5, 7, ¿qué patrón hay?",
                                "Suman 1;Suman 2;Multiplican por 2;Restan 1", 1, 2);
                addToDim(ejercicios, 4,
                                "Si cada día ahorras $2 más, y el lunes ahorraste $3, ¿cuánto ahorrarás el miércoles?",
                                "$5;$6;$7;$9", 2, 3);

                // Comparación de datos
                addToDim(ejercicios, 4, "Si Pedro mide 1.20 m y Ana 1.15 m, ¿quién es más alto?",
                                "Pedro;Ana;Miden igual;No se puede saber", 0, 1);
                addToDim(ejercicios, 4, "Si Equipo A anotó 15 puntos y Equipo B anotó 12, ¿cuántos puntos más tiene A?",
                                "2;3;4;27", 1, 2);
                addToDim(ejercicios, 4,
                                "Si la temperatura es de 25°C al mediodía y 18°C en la noche, ¿cuántos grados bajó?",
                                "3;5;7;43", 2, 2);

                // ============================================================
                // DIMENSIÓN 5: Resolución de problemas
                // ============================================================

                // Problemas de suma y resta
                addToDim(ejercicios, 5, "Ana tenía 15 dulces y le dieron 8 más. ¿Cuántos tiene ahora?", "7;15;23;120",
                                2, 1);
                addToDim(ejercicios, 5, "En una caja hay 20 lápices. Si sacas 7, ¿cuántos quedan?", "7;13;20;27", 1, 1);
                addToDim(ejercicios, 5, "Pedro tiene 12 canicas, Juan tiene 5 más que Pedro. ¿Cuántas tiene Juan?",
                                "5;7;12;17",
                                3, 2);
                addToDim(ejercicios, 5, "María ahorró $25 y gastó $18 en un libro. ¿Cuánto le quedó?", "$7;$15;$18;$43",
                                0, 2);
                addToDim(ejercicios, 5,
                                "En un autobús viajan 18 personas. Suben 7 y bajan 5. ¿Cuántas personas hay ahora?",
                                "16;18;20;30", 2, 2);

                // Problemas de multiplicación
                addToDim(ejercicios, 5, "Si compras 4 cuadernos a $3 cada uno, ¿cuánto pagas en total?",
                                "$7;$9;$12;$15", 2, 2);
                addToDim(ejercicios, 5, "Hay 5 cajas con 6 galletas cada una. ¿Cuántas galletas hay en total?",
                                "11;25;30;36",
                                2, 2);
                addToDim(ejercicios, 5, "Un libro tiene 8 páginas con 5 dibujos en cada página. ¿Cuántos dibujos hay?",
                                "13;35;40;45", 2, 2);
                addToDim(ejercicios, 5, "Si una semana tiene 7 días, ¿cuántos días hay en 3 semanas?", "10;14;21;24", 2,
                                2);

                // Problemas de división
                addToDim(ejercicios, 5,
                                "Tienes 12 galletas para repartir entre 3 amigos. ¿Cuántas le tocan a cada uno?",
                                "3;4;9;36", 1, 2);
                addToDim(ejercicios, 5, "Si 20 estudiantes se dividen en grupos de 5, ¿cuántos grupos se forman?",
                                "4;5;15;25",
                                0, 2);
                addToDim(ejercicios, 5, "Una caja de 24 chocolates se reparte entre 6 niños. ¿Cuántos recibe cada uno?",
                                "4;6;18;30", 0, 2);
                addToDim(ejercicios, 5,
                                "Si un paquete de 30 hojas se divide en 5 partes iguales, ¿cuántas hojas tiene cada parte?",
                                "5;6;10;25", 1, 2);

                // Problemas de dos pasos
                addToDim(ejercicios, 5,
                                "Luis tenía 20 pesos, gastó 8 en dulces y luego le dieron 5 más. ¿Cuánto tiene?",
                                "$12;$13;$17;$33", 2, 3);
                addToDim(ejercicios, 5,
                                "En una tienda había 30 juguetes. Vendieron 12 y luego trajeron 8 más. ¿Cuántos hay ahora?",
                                "$18;$26;$38;$50", 1, 3);
                addToDim(ejercicios, 5, "Ana compró 3 paquetes de 4 colores. Si regaló 5 colores, ¿cuántos le quedan?",
                                "2;7;12;17", 1, 3);
                addToDim(ejercicios, 5, "Pedro tenía $50, compró 2 libros de $15 cada uno. ¿Cuánto le sobró?",
                                "$20;$30;$35;$80", 0, 3);

                // Problemas con patrones
                addToDim(ejercicios, 5, "Si cada día lees 5 páginas, ¿cuántas páginas leerás en 4 días?", "9;15;20;25",
                                2, 2);
                addToDim(ejercicios, 5, "Un caracol sube 3 metros cada hora. ¿Cuánto habrá subido en 5 horas?",
                                "8 m;12 m;15 m;18 m", 2, 2);
                addToDim(ejercicios, 5, "Si plantas 2 flores por maceta y tienes 7 macetas, ¿cuántas flores plantaste?",
                                "9;12;14;16", 2, 2);

                // Problemas de comparación
                addToDim(ejercicios, 5, "Carlos tiene 18 años y su hermano 12. ¿Cuántos años más tiene Carlos?",
                                "6;12;18;30",
                                0, 2);
                addToDim(ejercicios, 5, "Si un árbol mide 8 metros y otro 12 metros, ¿cuál es la diferencia?",
                                "2 m;4 m;8 m;20 m", 1, 2);
                addToDim(ejercicios, 5, "María tiene 15 cromos y Pedro tiene el triple. ¿Cuántos cromos tiene Pedro?",
                                "3;18;30;45", 3, 3);

                // Problemas de lógica
                addToDim(ejercicios, 5, "Si todos los gatos son animales, ¿un perro es un gato?",
                                "Sí;No;A veces;Depende", 1,
                                2);
                addToDim(ejercicios, 5, "Tienes 2 manzanas y compras el doble. ¿Cuántas manzanas tienes ahora?",
                                "2;4;6;8", 2,
                                2);
                addToDim(ejercicios, 5, "¿Qué número falta? 5 + ___ = 8 + 2", "3;5;10;15", 1, 3);

                String outputPath = "c:\\Users\\Equipo Dell\\Documents\\Proyecto_COIL\\insertar_ejercicios_dim345.sql";
                StringBuilder sql = new StringBuilder();

                sql.append("-- Script SQL con ejercicios para DIMENSIONES 3, 4 y 5\n");
                sql.append("-- NOTA: Estos son ejercicios de ejemplo que puedes modificar\n");
                sql.append("-- Ejecuta este script DESPUÉS de insertar_ejercicios_textuales.sql\n\n");

                String[][] subdimNames = {
                                {}, {}, {},
                                { "Medición y unidades", "Tiempo y calendario", "Perímetro y área" },
                                { "Recolección de datos", "Probabilidad básica", "Patrones numéricos" },
                                { "Operaciones básicas", "Problemas de dos pasos", "Razonamiento lógico" }
                };

                int maxPerLevel = 8;

                for (int dim = 3; dim <= 5; dim++) {
                        List<ManualEx> ejerciciosDim = ejercicios.getOrDefault(dim, new ArrayList<>());
                        int totalEjercicios = ejerciciosDim.size();
                        int currentExIndex = 0;
                        int levelId = 1;

                        int subdimsCount = subdimNames[dim].length;
                        int exsPerSubdim = (int) Math.ceil((double) totalEjercicios / subdimsCount);

                        while (currentExIndex < totalEjercicios) {
                                int chunkSize = Math.min(maxPerLevel, totalEjercicios - currentExIndex);

                                int subdimIndex = Math.min(subdimsCount - 1, currentExIndex / exsPerSubdim);
                                String baseName = subdimNames[dim][subdimIndex];
                                String levelName = baseName + " - Nivel " + levelId;

                                sql.append(
                                                String.format("INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (%d, '%s', %d);\n",
                                                                levelId, levelName, dim));
                                sql.append(String.format("-- Dimensión %d, Nivel %d: %s (%d ejercicios)\n", dim,
                                                levelId, levelName,
                                                chunkSize));
                        }
                }

                Files.write(Paths.get(outputPath), sql.toString().getBytes(StandardCharsets.UTF_8));
                System.out.println("✓ SQL generado: " + outputPath);
                System.out.println(
                                "✓ Dimensión 3: " + ejercicios.getOrDefault(3, new ArrayList<>()).size()
                                                + " ejercicios en niveles");
                System.out.println(
                                "✓ Dimensión 4: " + ejercicios.getOrDefault(4, new ArrayList<>()).size()
                                                + " ejercicios en niveles");
                System.out.println(
                                "✓ Dimensión 5: " + ejercicios.getOrDefault(5, new ArrayList<>()).size()
                                                + " ejercicios en niveles");
        }

        static void addToDim(Map<Integer, List<ManualEx>> map, int d, String q, String ops, int ans, int diff) {
                if (!map.containsKey(d))
                        map.put(d, new ArrayList<>());
                map.get(d).add(new ManualEx(q, ops, ans, diff));
        }
}
