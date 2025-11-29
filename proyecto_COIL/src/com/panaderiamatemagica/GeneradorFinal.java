package com.panaderiamatemagica;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class GeneradorFinal {

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
                // Map<DimensionID, List<ManualEx>>
                Map<Integer, List<ManualEx>> manualDataByDim = new HashMap<>();

                // Load manual data - mapping old level structure to a single list per dimension
                // Dim 1
                addToDim(manualDataByDim, 1, "¿Cuál número viene después de 29?", "28;30;31;39", 1, 1);
                addToDim(manualDataByDim, 1, "¿Cuál de los siguientes números es menor?", "7;9;6;8", 2, 1);
                addToDim(manualDataByDim, 1, "¿Cuál es el número que representa tres decenas y dos unidades?",
                                "23;32;30;22", 1, 1);
                addToDim(manualDataByDim, 1, "¿Qué número está en medio de 599 y 601?", "598;600;602;601", 1, 1);
                addToDim(manualDataByDim, 1, "¿Cómo se lee el número 507?",
                                "Quinientos siete;Cincuenta y siete;Quinientos setenta;Quinientos siete mil", 0, 1);
                addToDim(manualDataByDim, 1, "¿Qué número tiene 4 centenas, 3 decenas y 5 unidades?", "345;435;453;354",
                                1, 1);
                addToDim(manualDataByDim, 1, "¿Qué número es mayor?", "462;426;264;246", 0, 1);
                addToDim(manualDataByDim, 1, "¿Qué número tiene un 3 en la posición de centenas?", "354;543;134;431", 0,
                                1);
                addToDim(manualDataByDim, 1,
                                "Elige la opción que sea en números la siguiente cantidad “seiscientos cuarenta y ocho”",
                                "684;648;846;468", 1, 1);
                addToDim(manualDataByDim, 1, "¿Qué número ocupa el lugar de las decenas en de esta cifra 472?",
                                "2;4;7;3", 2, 1);
                addToDim(manualDataByDim, 1, "¿Cuál es el valor posicional del 8 en 384?",
                                "8 unidades;8 decenas;8 centenas;8 millares", 1, 1);
                addToDim(manualDataByDim, 1, "¿Cuál de las siguientes opciones es un número decimal?", "15;0.5;7;100",
                                1, 1);
                addToDim(manualDataByDim, 1, "¿Cuál de las siguientes fracciones usamos para decir “la mitad”?",
                                "1/2;2/3;1/3;3/4", 0, 1);
                addToDim(manualDataByDim, 1, "¿Qué número decimal equivale a 1/10?", "10;0.10;0.1;1.0", 2, 1);
                addToDim(manualDataByDim, 1, "¿Qué fracción representa tres cuartos?", "3/2;3/4;4/3;1/4", 1, 2);
                addToDim(manualDataByDim, 1, "¿Cuál número es equivalente a 0.5?", "1/5;1/2;2/5;3/4", 1, 2);
                addToDim(manualDataByDim, 1, "¿Qué número es mayor?", "0.6;0.8;0.75;0.7", 1, 2);
                addToDim(manualDataByDim, 1, "¿Qué fracción es igual a 2/4?", "1/2;2/3;3/4;1/3", 0, 2);
                addToDim(manualDataByDim, 1, "Ordena de menor a mayor: 0.4, 0.9, 0.2, 0.6.",
                                "0.2, 0.4, 0.6, 0.9;0.4, 0.2, 0.6, 0.9;0.9, 0.6, 0.4, 0.2;0.2, 0.6, 0.4, 0.9", 0, 3);
                addToDim(manualDataByDim, 1, "¿Qué fracción representa 0.75?", "3/4;2/3;1/4;4/3", 0, 3);
                // Dim 1 - Old Level 2
                addToDim(manualDataByDim, 1, "¿Cuánto es 3 + 2?", "4;5;6;3", 1, 1);
                addToDim(manualDataByDim, 1, "¿Cuánto es 9 – 4?", "6;3;5;4", 2, 1);
                addToDim(manualDataByDim, 1, "¿Cuánto es 7 + 6?", "12;13;14;15", 1, 1);
                addToDim(manualDataByDim, 1, "Si tienes 10 manzanas y regalas 3, ¿cuántas quedan?", "8;6;7;5", 2, 1);
                addToDim(manualDataByDim, 1, "¿Cuánto es 5 × 2?", "7;8;9;10", 3, 1);
                addToDim(manualDataByDim, 1, "¿Cuánto es 12 ÷ 3?", "3;4;5;6", 1, 1);
                addToDim(manualDataByDim, 1, "¿Cuál operación matemática representa “quitar”?",
                                "Suma;Resta;Multiplicación;División", 1, 1);
                addToDim(manualDataByDim, 1, "¿Qué número falta en esta suma? 4 + ___ = 9", "5;4;6;3", 0, 1);
                addToDim(manualDataByDim, 1, "¿Cuál es el resultado de esta multiplicación ? 3 × 4 = ?", "7;12;14;10",
                                1, 1);
                addToDim(manualDataByDim, 1, "¿Cuál es el resultado correcto de esta resta? 16 – 9 = ?", "7;8;6;9", 0,
                                1);
                addToDim(manualDataByDim, 1,
                                "Si 5 × 3 = 15, entonces ¿Cuál es el resultado de esta división 15 ÷ 3 = ?", "5;10;3;6",
                                0, 1);
                addToDim(manualDataByDim, 1, "¿Qué número falta para completar esta suma? 8 + ___ = 14", "6;7;8;5", 0,
                                1);
                addToDim(manualDataByDim, 1, "¿Cuál es el resultado de esta resta 25 – 8?", "16;17;18;19", 1, 2);
                addToDim(manualDataByDim, 1, "¿Cuál es el resultado de la siguiente multiplicación 9 × 6?",
                                "45;54;63;36", 1, 2);
                addToDim(manualDataByDim, 1, "¿Cuál es el resultado de esta división 36 ÷ 4?", "8;9;6;7", 1, 2);
                addToDim(manualDataByDim, 1,
                                "¿Qué operación se necesita para resolver lo siguiente: “tengo 5 cajas con 8 pelotas cada una”?",
                                "5 + 8;8 ÷ 5;5 × 8;8 – 5", 2, 2);
                addToDim(manualDataByDim, 1, "¿Cuál es el resultado de 3 × (4 + 2)?", "18;12;14;20", 0, 3);
                addToDim(manualDataByDim, 1,
                                "Si tengo 48 dulces y los reparto entre 8 niños, ¿cuántos dulces recibe cada uno?",
                                "6;7;8;5", 0, 3);
                addToDim(manualDataByDim, 1, "¿Qué número falta en esta división? ___ ÷ 5 = 7", "30;35;40;25", 1, 3);
                addToDim(manualDataByDim, 1, "¿Cuál es el resultado correcto de (15 + 9) ÷ 3?", "6;7;8;9", 2, 3);
                // Dim 1 - Old Level 3
                addToDim(manualDataByDim, 1, "Calcula mentalmente el resultado de esta suma: 6 + 3 = ?", "8;9;10;7", 1,
                                1);
                addToDim(manualDataByDim, 1, "Calcula mentalmente el resultado de esta resta: 8 – 5 = ?", "2;3;4;5", 1,
                                1);
                addToDim(manualDataByDim, 1, "¿Cuál es el doble de 7?", "14;12;10;16", 0, 1);
                addToDim(manualDataByDim, 1, "¿Cuál es la mitad de 10?", "4;5;6;3", 1, 1);
                addToDim(manualDataByDim, 1, "¿Quanto es 9 + 8 = ?", "16;18;17;19", 2, 1);
                addToDim(manualDataByDim, 1, "¿Quanto es 15 – 9 = ?", "5;6;7;8", 1, 2);
                addToDim(manualDataByDim, 1,
                                "Si sé que sumar 7 + 7 = 14, entonces ¿Cuál número falta en esta resta 14 – 7 = ?",
                                "6;7;8;9", 1, 2);
                addToDim(manualDataByDim, 1, "¿Qué número completa la serie mental? 5, 10, 15, ___", "25;20;18;30", 1,
                                2);
                addToDim(manualDataByDim, 1, "Calcula sin escribir el resultado de esta suma: 12 + 13 = ?",
                                "24;25;26;23", 1, 2);
                addToDim(manualDataByDim, 1, "Calcula mentalmente esta resta: 30 – 17 = ?", "13;14;15;16", 0, 2);
                addToDim(manualDataByDim, 1, "¿Quanto es 4 × 6 = ?", "20;22;24;26", 2, 2);
                addToDim(manualDataByDim, 1, "¿Quanto es 81 ÷ 9 = ?", "7;8;9;10", 2, 2);
                addToDim(manualDataByDim, 1, "Si 5 × 5 = 25, entonces ¿Cuál es el resultado de 5 × 6 = ?",
                                "30;35;36;25", 0, 2);
                addToDim(manualDataByDim, 1, "Calcula mentalmente: 50 + 25 = ?", "65;70;75;80", 2, 2);
                addToDim(manualDataByDim, 1, "¿Qué número falta en esta resta 100 – ___ = 45?", "45;50;55;60", 2, 2);
                addToDim(manualDataByDim, 1, "Si 6 × 4 = 24, ¿Cuánto es 24 ÷ 6?", "3;4;5;6", 1, 2);
                addToDim(manualDataByDim, 1, "¿Cuál es el resultado de 9 × 8 = ?", "64;70;72;81", 2, 3);
                addToDim(manualDataByDim, 1, "¿Cuál es el resultado de 125 + 125?", "200;225;240;250", 3, 3);
                addToDim(manualDataByDim, 1, "¿Cuál es el resultado de 144 ÷ 12?", "11;12;13;14", 1, 3);
                addToDim(manualDataByDim, 1, "Calcula mentalmente: (25 + 25) × 2 = ?", "80;90;100;110", 2, 3);

                // Dim 2
                addToDim(manualDataByDim, 2, "¿Cuál de estas figuras es plana, como un dibujo en papel?",
                                "Cubo;Esfera;Cuadrado;Prisma", 2, 1);
                addToDim(manualDataByDim, 2, "¿Cuántos lados tiene un triángulo?", "2;3;4;5", 1, 1);
                addToDim(manualDataByDim, 2, "¿Qué figura tiene 4 lados iguales y 4 esquinas (ángulos) recto?",
                                "Cuadrado;Rectángulo;Rombo;Trapecio", 0, 1);
                addToDim(manualDataByDim, 2, "¿Cuál figura tiene solo 3 puntas o vértices?",
                                "Cuadrado;Triángulo;Rectángulo;Círculo", 1, 1);
                addToDim(manualDataByDim, 2, "¿Cuál de estas figuras no tiene lados?",
                                "Cuadrado;Círculo;Triángulo;Rectángulo", 1, 1);
                addToDim(manualDataByDim, 2, "¿Cuál de estas opciones es un cuerpo geométrico (como un objeto)?",
                                "Triángulo;Cuadrado;Esfera;Círculo", 2, 1);
                addToDim(manualDataByDim, 2, "¿Qué cuerpo geométrico tiene 6 caras cuadradas iguales?",
                                "Cubo;Cilindro;Prisma;Esfera", 0, 1);
                addToDim(manualDataByDim, 2, "¿Cuál figura plana tiene lados diferentes, pero 4 puntas o vértices?",
                                "Cuadrado;Rectángulo;Rombo;Círculo", 1, 1);
                addToDim(manualDataByDim, 2, "¿Qué figura tiene una parte curva y dos bases redondas?",
                                "Cono;Cilindro;Esfera;Cubo", 1, 1);
                addToDim(manualDataByDim, 2, "¿Cuál figura tiene una base redonda y termina en punta?",
                                "Cono;Cilindro;Esfera;Cubo", 0, 1);
                addToDim(manualDataByDim, 2, "¿Cuántos lados tiene un pentágono?", "4;5;6;7", 1, 2);
                addToDim(manualDataByDim, 2, "¿Cuál de las siguientes figuras puedo rodar fácilmente?",
                                "Cubo;Esfera;Pirámide;Prisma", 1, 2);
                addToDim(manualDataByDim, 2,
                                "¿Qué figura tiene todos sus lados iguales , pero no tiene esquinas (ángulos) rectas?",
                                "Cuadrado;Rombo;Trapecio;Rectángulo", 1, 2);
                addToDim(manualDataByDim, 2, "¿Cuál figura plana tiene solo un par de lados paralelos?",
                                "Trapecio;Cuadrado;Rectángulo;Rombo", 0, 2);
                addToDim(manualDataByDim, 2, "¿Qué figura tiene 8 lados?", "Hexágono;Pentágono;Octágono;Heptágono", 2,
                                2);
                addToDim(manualDataByDim, 2, "¿Cuántas caras tiene una pirámide con base cuadrada?", "4;5;6;8", 1, 2);
                addToDim(manualDataByDim, 2, "¿Cuál de los siguientes no es un cuerpo geométrico?",
                                "Cilindro;Cubo;Triángulo;Esfera", 2, 3);
                addToDim(manualDataByDim, 2, "¿Qué figura tiene 12 aristas y 8 vértices?",
                                "Prisma rectangular;Cubo;Pirámide;Cono", 0, 3);
                addToDim(manualDataByDim, 2, "¿Cuál figura tiene muchos ejes de simetría, como infinitos?",
                                "Círculo;Cuadrado;Triángulo;Rectángulo", 0, 3);
                addToDim(manualDataByDim, 2, "Si abrimos un cubo como si fuera una caja, ¿qué figura aparece?",
                                "Red plana con 6 cuadrados;Red plana con 6 triángulos;Red circular;Red con 8 cuadrados",
                                0, 3);
                // Dim 2 - Old Level 2
                addToDim(manualDataByDim, 2, "¿Cuántos lados tiene un cuadrado?", "3;4;5;6", 1, 1);
                addToDim(manualDataByDim, 2, "¿Cuántos ángulos tiene un triángulo?", "2;3;4;5", 1, 1);
                addToDim(manualDataByDim, 2, "¿Qué figura tiene todos sus lados iguales del mismo tamaño?",
                                "Cuadrado;Rectángulo;Trapecio;Triángulo escaleno", 0, 1);
                addToDim(manualDataByDim, 2, "¿Cuál figura tiene dos lados más largos que los otros dos?",
                                "Cuadrado;Rectángulo;Rombo;Círculo", 1, 1);
                addToDim(manualDataByDim, 2,
                                "¿Qué palabra usamos cuando una figura se puede doblar en dos partes iguales?",
                                "Paralela;Simétrica;Angular;Circular", 1, 1);
                addToDim(manualDataByDim, 2, "Si un triángulo tiene todos sus lados iguales, ¿Cómo se llama?",
                                "Escaleno;Isósceles;Equilátero;Rectángulo", 2, 1);
                addToDim(manualDataByDim, 2, "¿Qué figura tiene 4 lados iguales y 4 esquinas (ángulos) rectas?",
                                "Cuadrado;Rombo;Trapecio;Pentágono", 0, 1);
                addToDim(manualDataByDim, 2, "Si cada lado de un cuadrado mide 5 cm, ¿Cuánto su perímetro?",
                                "10 cm;15 cm;20 cm;25 cm", 2, 1);
                addToDim(manualDataByDim, 2, "Un rectángulo mide 8 cm de largo y 2 cm de ancho. ¿Cuál es su perímetro?",
                                "10 cm;16 cm;18 cm;20 cm", 3, 1);
                addToDim(manualDataByDim, 2, "Si un cuadrado mide 4 cm de lado, ¿Cuál es su área?",
                                "8 cm²;12 cm²;16 cm²;20 cm²", 2, 2);
                addToDim(manualDataByDim, 2, "¿Qué unidad usamos para medir el perímetro?", "cm²;cm;m²;L", 1, 2);
                addToDim(manualDataByDim, 2, "¿Qué unidad se usamos para medir el área?", "cm;m;cm²;L", 2, 2);
                addToDim(manualDataByDim, 2, "Un rectángulo mide 10 cm por 5 cm, ¿Cuál es su área?",
                                "15 cm²;20 cm²;25 cm²;50 cm²", 3, 2);
                addToDim(manualDataByDim, 2, "Un triángulo tiene base 6 cm y altura 4 cm, ¿Cuál es su área?",
                                "12 cm²;24 cm²;10 cm²;20 cm²", 0, 2);
                addToDim(manualDataByDim, 2, "¿Cuál figura no tiene ángulos (esquinas) rectos?",
                                "Triángulo equilátero;Cuadrado;Rectángulo;Trapecio rectángulo", 0, 2);
                addToDim(manualDataByDim, 2, "¿Qué figura tiene una sola línea de simetría?",
                                "Círculo;Triángulo isósceles;Cuadrado;Rectángulo", 1, 3);
                addToDim(manualDataByDim, 2, "¿Qué figura tiene dos líneas de simetría?",
                                "Triángulo equilátero;Rectángulo;Trapecio;Rombo", 1, 3);
                addToDim(manualDataByDim, 2, "Si un cubo tiene lados de 3 cm, ¿Cuál es su volumen?",
                                "9 cm³;18 cm³;27 cm³;30 cm³", 2, 3);
                addToDim(manualDataByDim, 2, "Un prisma rectangular mide 5 cm × 2 cm × 3 cm, ¿Cuál es su volumen?",
                                "10 cm³;15 cm³;20 cm³;30 cm³", 3, 3);
                addToDim(manualDataByDim, 2, "Si un cuadrado tiene lado de 8 cm, ¿cuál es su perímetro y su área?",
                                "24 cm y 32 cm²;32 cm y 64 cm²;36 cm y 56 cm²;40 cm y 80 cm²", 1, 3);
                // Dim 2 - Old Level 3
                addToDim(manualDataByDim, 2, "Si estás frente a la pizarra y das un paso atrás, ¿A dónde te moviste?",
                                "Adelante;Atrás;Izquierda;Derecha", 1, 1);
                addToDim(manualDataByDim, 2,
                                "Si estás mirando al norte y giras a tu derecha, ¿Hacia dónde estás mirando ahora?",
                                "Sur;Este;Oeste;Norte", 1, 1);
                addToDim(manualDataByDim, 2, "¿Cuál es la dirección contraria al norte?", "Este;Oeste;Sur;Noreste", 2,
                                1);
                addToDim(manualDataByDim, 2, "Si algo está “a tu izquierda”, ¿En qué dirección se está?",
                                "Derecha;Frente;Lado izquierdo;Atrás", 2, 1);
                addToDim(manualDataByDim, 2,
                                "Un niño está al norte de un árbol y camina hacia el sur, ¿Qué está haciendo?",
                                "Se aleja;Se acerca;Da una vuelta;No se mueve", 1, 1);
                addToDim(manualDataByDim, 2, "En los mapas, ¿Qué dirección suele estar arriba?", "Sur;Norte;Este;Oeste",
                                1, 1);
                addToDim(manualDataByDim, 2,
                                "Si el parque está al Este de la escuela, ¿en qué dirección está la escuela desde el parque?",
                                "Norte;Sur;Oeste;Este", 2, 1);
                addToDim(manualDataByDim, 2,
                                "En un plano, si un punto está en la columna B y la fila 3, ¿Cómo se escribe su ubicación?",
                                "A3;B3;3B;AB", 1, 1);
                addToDim(manualDataByDim, 2, "¿Qué dirección forma un ángulo recto con el norte?",
                                "Sur;Este;Noroeste;Sureste", 1, 1);
                addToDim(manualDataByDim, 2,
                                "Si un barco va del punto (2,3) al punto (2,6), ¿en qué dirección se movió?",
                                "Norte;Sur;Este;Oeste", 0, 1);
                addToDim(manualDataByDim, 2,
                                "Si el punto A está en (1,2) y el punto B en (3,2), ¿en qué dirección se movió?",
                                "Norte;Sur;Este;Oeste", 2, 2);
                addToDim(manualDataByDim, 2,
                                "Si te mueves un cuadro hacia arriba y otro hacia la derecha en una cuadrícula, ¿Qué tipo de movimiento hiciste?",
                                "Diagonal;Horizontal;Vertical;Circular", 0, 2);
                addToDim(manualDataByDim, 2,
                                "Si el punto C está en la esquina inferior izquierda del mapa, ¿qué hay en la esquina opuesta?",
                                "Inferior derecha;Superior derecha;Superior izquierda;Centro", 1, 2);
                addToDim(manualDataByDim, 2, "¿Qué palabra usamos para decir que algo está “en medio de dos cosas”?",
                                "Dentro;Detrás;Entre;Al lado", 2, 2);
                addToDim(manualDataByDim, 2,
                                "En un mapa, el lago está al Oeste de la montaña y la escuela está al sur del lago. ¿Dónde está la escuela respecto a la montaña?",
                                "Suroeste;Noreste;Sureste;Noroeste", 0, 2);
                addToDim(manualDataByDim, 2, "En un plano cartesiano, ¿Cómo se llama el eje horizontal?",
                                "Eje X;Eje Y;Eje Z;Eje N", 0, 3);
                addToDim(manualDataByDim, 2,
                                "En un plano cartesiano, ¿Cómo se llama el punto (0,0) donde empiezan los ejes?",
                                "Inicio;Centro;Origen;Base", 2, 3);
                addToDim(manualDataByDim, 2,
                                "Si un punto está en (4,5) y baja hasta (4,2), ¿En qué dirección se movió?",
                                "Norte;Sur;Este;Oeste", 1, 3);
                addToDim(manualDataByDim, 2,
                                "El punto A está en (3,3) y el punto B en (6,6), ¿Qué tipo de movimiento hizo?",
                                "Horizontal;Vertical;Diagonal;Circular", 2, 3);
                addToDim(manualDataByDim, 2,
                                "Un personaje camina 3 pasos al Este y luego 4 al Norte, ¿En qué cuadrante termina?",
                                "I;II;III;IV", 0, 3);

                String outputPath = "c:\\Users\\Equipo Dell\\Documents\\Proyecto_COIL\\insertar_datos_completos.sql";
                StringBuilder sql = new StringBuilder();

                sql.append("-- Script generado para Proyecto COIL\n");
                sql.append("-- INSTRUCCIONES: Copia todo este texto y pégalo en el editor de consultas (Query Tool) de pgAdmin.\n");
                sql.append("-- Luego presiona el botón de ejecutar (Play/Triángulo).\n\n");

                sql.append("DELETE FROM ejercicios;\n");
                sql.append("DELETE FROM niveles;\n\n");

                // Configuration
                int[] totalExercisesPerDim = { 0, 81, 82, 80, 60, 60 }; // 1-indexed
                int maxPerLevel = 8;

                // Subdimension names mapping (approximate distribution)
                String[][] subdimNames = {
                                {}, // 0
                                { "Comprensión del sistema de numeración", "Operaciones básicas", "Cálculo mental" }, // Dim
                                                                                                                      // 1
                                { "Figuras planas y cuerpos geométricos", "Propiedades de formas",
                                                "Ubicación espacial" }, // Dim 2
                                { "Medición", "Recolección", "Lectura de información" }, // Dim 3
                                { "Sentido numérico", "Introducción a la probabilidad", "Reconocimiento de patrones" }, // Dim
                                                                                                                        // 4
                                { "Resolución de problemas", "Aplicación de los conocimientos",
                                                "Desarrollo de estrategias" } // Dim 5
                };

                for (int dim = 1; dim <= 5; dim++) {
                        int total = totalExercisesPerDim[dim];
                        List<ManualEx> manualExs = manualDataByDim.getOrDefault(dim, new ArrayList<>());
                        int currentExIndex = 0;
                        int levelId = 1;

                        // Calculate how many exercises per subdimension roughly
                        int subdimsCount = subdimNames[dim].length;
                        int exsPerSubdim = (int) Math.ceil((double) total / subdimsCount);

                        while (currentExIndex < total) {
                                int chunkSize = Math.min(maxPerLevel, total - currentExIndex);

                                // Determine subdimension name based on progress
                                int subdimIndex = Math.min(subdimsCount - 1, currentExIndex / exsPerSubdim);
                                String baseName = subdimNames[dim][subdimIndex];
                                String levelName = baseName + " - Parte "
                                                + ((currentExIndex % exsPerSubdim) / maxPerLevel + 1);

                                // Insert Level
                                sql.append(String.format(
                                                "INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (%d, '%s', %d);\n",
                                                levelId, levelName, dim));
                                sql.append(String.format("-- Dimensión %d, Nivel %d: %s (Ejercicios %d-%d)\n", dim,
                                                levelId, levelName, currentExIndex + 1, currentExIndex + chunkSize));

                                // Insert Exercises
                                for (int i = 0; i < chunkSize; i++) {
                                        int globalIndex = currentExIndex + i;
                                        if (globalIndex < manualExs.size()) {
                                                ManualEx ex = manualExs.get(globalIndex);
                                                sql.append(String.format(
                                                                "INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, nivel_id, dimension_id, dificultad) VALUES ('%s', '%s', '%s', %d, %d, %d, %d);\n",
                                                                ex.q, levelName, ex.ops, ex.ans, levelId, dim,
                                                                ex.diff));
                                        } else {
                                                sql.append(String.format(
                                                                "INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, nivel_id, dimension_id, dificultad) VALUES ('Ejercicio faltante %d para %s', '%s', 'Opción A;Opción B;Opción C;Opción D', 0, %d, %d, 2);\n",
                                                                (globalIndex + 1), baseName, levelName, levelId, dim));
                                        }
                                }
                                sql.append("\n");

                                currentExIndex += chunkSize;
                                levelId++;
                        }
                }

                Files.write(Paths.get(outputPath), sql.toString().getBytes(StandardCharsets.UTF_8));
                System.out.println("Generated SQL at " + outputPath);
        }

        static void addToDim(Map<Integer, List<ManualEx>> map, int d, String q, String ops, int ans, int diff) {
                if (!map.containsKey(d))
                        map.put(d, new ArrayList<>());
                map.get(d).add(new ManualEx(q, ops, ans, diff));
        }
}
