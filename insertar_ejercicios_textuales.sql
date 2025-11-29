-- Script SQL con ejercicios TEXTUALES (sin imágenes)
-- LISTO PARA EJECUTAR EN pgAdmin
-- CORREGIDO: Usa id_nivel e id_dimension según esquema de BD

DELETE FROM ejercicios;
DELETE FROM niveles;

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (1, 'Números y sistema de numeración - Nivel 1', 1);
-- Dimensión 1, Nivel 1: Números y sistema de numeración - Nivel 1 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál número viene después de 29?', 'Números y sistema de numeración - Nivel 1', '28;30;31;39', 1, 1, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál de los siguientes números es menor?', 'Números y sistema de numeración - Nivel 1', '7;9;6;8', 2, 1, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es el número que representa tres decenas y dos unidades?', 'Números y sistema de numeración - Nivel 1', '23;32;30;22', 1, 1, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué número está en medio de 599 y 601?', 'Números y sistema de numeración - Nivel 1', '598;600;602;601', 1, 1, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cómo se lee el número 507?', 'Números y sistema de numeración - Nivel 1', 'Quinientos siete;Cincuenta y siete;Quinientos setenta;Quinientos siete mil', 0, 1, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué número tiene 4 centenas, 3 decenas y 5 unidades?', 'Números y sistema de numeración - Nivel 1', '345;435;453;354', 1, 1, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué número es mayor?', 'Números y sistema de numeración - Nivel 1', '462;426;264;246', 0, 1, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué número tiene un 3 en la posición de centenas?', 'Números y sistema de numeración - Nivel 1', '354;543;134;431', 0, 1, 1, 1);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (2, 'Números y sistema de numeración - Nivel 2', 1);
-- Dimensión 1, Nivel 2: Números y sistema de numeración - Nivel 2 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Elige la opción que sea en números la siguiente cantidad: seiscientos cuarenta y ocho', 'Números y sistema de numeración - Nivel 2', '684;648;846;468', 1, 2, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué número ocupa el lugar de las decenas en de esta cifra 472?', 'Números y sistema de numeración - Nivel 2', '2;4;7;3', 2, 2, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es el valor posicional del 8 en 384?', 'Números y sistema de numeración - Nivel 2', '8 unidades;8 decenas;8 centenas;8 millares', 1, 2, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál de las siguientes opciones es un número decimal?', 'Números y sistema de numeración - Nivel 2', '15;0.5;7;100', 1, 2, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál de las siguientes fracciones usamos para decir la mitad?', 'Números y sistema de numeración - Nivel 2', '1/2;2/3;1/3;3/4', 0, 2, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué número decimal equivale a 1/10?', 'Números y sistema de numeración - Nivel 2', '10;0.10;0.1;1.0', 2, 2, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué fracción representa tres cuartos?', 'Números y sistema de numeración - Nivel 2', '3/2;3/4;4/3;1/4', 1, 2, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál número es equivalente a 0.5?', 'Números y sistema de numeración - Nivel 2', '1/5;1/2;2/5;3/4', 1, 2, 1, 2);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (3, 'Números y sistema de numeración - Nivel 3', 1);
-- Dimensión 1, Nivel 3: Números y sistema de numeración - Nivel 3 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué número es mayor?', 'Números y sistema de numeración - Nivel 3', '0.6;0.8;0.75;0.7', 1, 3, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué fracción es igual a 2/4?', 'Números y sistema de numeración - Nivel 3', '1/2;2/3;3/4;1/3', 0, 3, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Ordena de menor a mayor: 0.4, 0.9, 0.2, 0.6', 'Números y sistema de numeración - Nivel 3', '0.2, 0.4, 0.6, 0.9;0.4, 0.2, 0.6, 0.9;0.9, 0.6, 0.4, 0.2;0.2, 0.6, 0.4, 0.9', 0, 3, 1, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué fracción representa 0.75?', 'Números y sistema de numeración - Nivel 3', '3/4;2/3;1/4;4/3', 0, 3, 1, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuánto es 3 + 2?', 'Números y sistema de numeración - Nivel 3', '4;5;6;3', 1, 3, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuánto es 9 - 4?', 'Números y sistema de numeración - Nivel 3', '6;3;5;4', 2, 3, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuánto es 7 + 6?', 'Números y sistema de numeración - Nivel 3', '12;13;14;15', 1, 3, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si tienes 10 manzanas y regalas 3, ¿cuántas quedan?', 'Números y sistema de numeración - Nivel 3', '8;6;7;5', 2, 3, 1, 1);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (4, 'Operaciones matemáticas - Nivel 4', 1);
-- Dimensión 1, Nivel 4: Operaciones matemáticas - Nivel 4 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuánto es 5 × 2?', 'Operaciones matemáticas - Nivel 4', '7;8;9;10', 3, 4, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuánto es 12 ÷ 3?', 'Operaciones matemáticas - Nivel 4', '3;4;5;6', 1, 4, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál operación matemática representa quitar?', 'Operaciones matemáticas - Nivel 4', 'Suma;Resta;Multiplicación;División', 1, 4, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué número falta en esta suma? 4 + ___ = 9', 'Operaciones matemáticas - Nivel 4', '5;4;6;3', 0, 4, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es el resultado de esta multiplicación? 3 × 4 = ?', 'Operaciones matemáticas - Nivel 4', '7;12;14;10', 1, 4, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es el resultado correcto de esta resta? 16 - 9 = ?', 'Operaciones matemáticas - Nivel 4', '7;8;6;9', 0, 4, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si 5 × 3 = 15, entonces ¿Cuál es el resultado de esta división 15 ÷ 3 = ?', 'Operaciones matemáticas - Nivel 4', '5;10;3;6', 0, 4, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué número falta para completar esta suma? 8 + ___ = 14', 'Operaciones matemáticas - Nivel 4', '6;7;8;5', 0, 4, 1, 1);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (5, 'Operaciones matemáticas - Nivel 5', 1);
-- Dimensión 1, Nivel 5: Operaciones matemáticas - Nivel 5 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es el resultado de esta resta 25 - 8?', 'Operaciones matemáticas - Nivel 5', '16;17;18;19', 1, 5, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es el resultado de la siguiente multiplicación 9 × 6?', 'Operaciones matemáticas - Nivel 5', '45;54;63;36', 1, 5, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es el resultado de esta división 36 ÷ 4?', 'Operaciones matemáticas - Nivel 5', '8;9;6;7', 1, 5, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué operación se necesita para resolver: tengo 5 cajas con 8 pelotas cada una?', 'Operaciones matemáticas - Nivel 5', '5 + 8;8 ÷ 5;5 × 8;8 - 5', 2, 5, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es el resultado de 3 × (4 + 2)?', 'Operaciones matemáticas - Nivel 5', '18;12;14;20', 0, 5, 1, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si tengo 48 dulces y los reparto entre 8 niños, ¿cuántos dulces recibe cada uno?', 'Operaciones matemáticas - Nivel 5', '6;7;8;5', 0, 5, 1, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué número falta en esta división? ___ ÷ 5 = 7', 'Operaciones matemáticas - Nivel 5', '30;35;40;25', 1, 5, 1, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es el resultado correcto de (15 + 9) ÷ 3?', 'Operaciones matemáticas - Nivel 5', '6;7;8;9', 2, 5, 1, 3);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (6, 'Cálculo mental - Nivel 6', 1);
-- Dimensión 1, Nivel 6: Cálculo mental - Nivel 6 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Calcula mentalmente el resultado de esta suma: 6 + 3 = ?', 'Cálculo mental - Nivel 6', '8;9;10;7', 1, 6, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Calcula mentalmente el resultado de esta resta: 8 - 5 = ?', 'Cálculo mental - Nivel 6', '2;3;4;5', 1, 6, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es el doble de 7?', 'Cálculo mental - Nivel 6', '14;12;10;16', 0, 6, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es la mitad de 10?', 'Cálculo mental - Nivel 6', '4;5;6;3', 1, 6, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuánto es 9 + 8?', 'Cálculo mental - Nivel 6', '16;18;17;19', 2, 6, 1, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuánto es 15 - 9?', 'Cálculo mental - Nivel 6', '5;6;7;8', 1, 6, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si sé que 7 + 7 = 14, entonces ¿Cuál número falta en esta resta 14 - 7 = ?', 'Cálculo mental - Nivel 6', '6;7;8;9', 1, 6, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué número completa la serie mental? 5, 10, 15, ___', 'Cálculo mental - Nivel 6', '25;20;18;30', 1, 6, 1, 2);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (7, 'Cálculo mental - Nivel 7', 1);
-- Dimensión 1, Nivel 7: Cálculo mental - Nivel 7 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Calcula sin escribir el resultado de esta suma: 12 + 13 = ?', 'Cálculo mental - Nivel 7', '24;25;26;23', 1, 7, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Calcula mentalmente esta resta: 30 - 17 = ?', 'Cálculo mental - Nivel 7', '13;14;15;16', 0, 7, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuánto es 4 × 6?', 'Cálculo mental - Nivel 7', '20;22;24;26', 2, 7, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuánto es 81 ÷ 9?', 'Cálculo mental - Nivel 7', '7;8;9;10', 2, 7, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si 5 × 5 = 25, entonces ¿Cuál es el resultado de 5 × 6?', 'Cálculo mental - Nivel 7', '30;35;36;25', 0, 7, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Calcula mentalmente: 50 + 25 = ?', 'Cálculo mental - Nivel 7', '65;70;75;80', 2, 7, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué número falta en esta resta 100 - ___ = 45?', 'Cálculo mental - Nivel 7', '45;50;55;60', 2, 7, 1, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si 6 × 4 = 24, ¿Cuánto es 24 ÷ 6?', 'Cálculo mental - Nivel 7', '3;4;5;6', 1, 7, 1, 2);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (8, 'Cálculo mental - Nivel 8', 1);
-- Dimensión 1, Nivel 8: Cálculo mental - Nivel 8 (4 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es el resultado de 9 × 8?', 'Cálculo mental - Nivel 8', '64;70;72;81', 2, 8, 1, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es el resultado de 125 + 125?', 'Cálculo mental - Nivel 8', '200;225;240;250', 3, 8, 1, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es el resultado de 144 ÷ 12?', 'Cálculo mental - Nivel 8', '11;12;13;14', 1, 8, 1, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Calcula mentalmente: (25 + 25) × 2 = ?', 'Cálculo mental - Nivel 8', '80;90;100;110', 2, 8, 1, 3);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (1, 'Conceptos geométricos - Nivel 1', 2);
-- Dimensión 2, Nivel 1: Conceptos geométricos - Nivel 1 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuántos lados tiene un triángulo?', 'Conceptos geométricos - Nivel 1', '2;3;4;5', 1, 1, 2, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuántos lados tiene un cuadrado?', 'Conceptos geométricos - Nivel 1', '3;4;5;6', 1, 1, 2, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuántos ángulos tiene un triángulo?', 'Conceptos geométricos - Nivel 1', '2;3;4;5', 1, 1, 2, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuántos lados tiene un pentágono?', 'Conceptos geométricos - Nivel 1', '4;5;6;7', 1, 1, 2, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué figura tiene 8 lados?', 'Conceptos geométricos - Nivel 1', 'Hexágono;Pentágono;Octágono;Heptágono', 2, 1, 2, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuántas caras tiene una pirámide con base cuadrada?', 'Conceptos geométricos - Nivel 1', '4;5;6;8', 1, 1, 2, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si un triángulo tiene todos sus lados iguales, ¿Cómo se llama?', 'Conceptos geométricos - Nivel 1', 'Escaleno;Isósceles;Equilátero;Rectángulo', 2, 1, 2, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si cada lado de un cuadrado mide 5 cm, ¿Cuánto mide su perímetro?', 'Conceptos geométricos - Nivel 1', '10 cm;15 cm;20 cm;25 cm', 2, 1, 2, 1);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (2, 'Conceptos geométricos - Nivel 2', 2);
-- Dimensión 2, Nivel 2: Conceptos geométricos - Nivel 2 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Un rectángulo mide 8 cm de largo y 2 cm de ancho. ¿Cuál es su perímetro?', 'Conceptos geométricos - Nivel 2', '10 cm;16 cm;18 cm;20 cm', 3, 2, 2, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si un cuadrado mide 4 cm de lado, ¿Cuál es su área?', 'Conceptos geométricos - Nivel 2', '8 cm²;12 cm²;16 cm²;20 cm²', 2, 2, 2, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué unidad usamos para medir el perímetro?', 'Conceptos geométricos - Nivel 2', 'cm²;cm;m²;L', 1, 2, 2, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué unidad se usa para medir el área?', 'Conceptos geométricos - Nivel 2', 'cm;m;cm²;L', 2, 2, 2, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Un rectángulo mide 10 cm por 5 cm, ¿Cuál es su área?', 'Conceptos geométricos - Nivel 2', '15 cm²;20 cm²;25 cm²;50 cm²', 3, 2, 2, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Un triángulo tiene base 6 cm y altura 4 cm, ¿Cuál es su área?', 'Conceptos geométricos - Nivel 2', '12 cm²;24 cm²;10 cm²;20 cm²', 0, 2, 2, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si un cubo tiene lados de 3 cm, ¿Cuál es su volumen?', 'Conceptos geométricos - Nivel 2', '9 cm³;18 cm³;27 cm³;30 cm³', 2, 2, 2, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Un prisma rectangular mide 5 cm × 2 cm × 3 cm, ¿Cuál es su volumen?', 'Conceptos geométricos - Nivel 2', '10 cm³;15 cm³;20 cm³;30 cm³', 3, 2, 2, 3);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (3, 'Mediciones - Nivel 3', 2);
-- Dimensión 2, Nivel 3: Mediciones - Nivel 3 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si un cuadrado tiene lado de 8 cm, ¿cuál es su perímetro y su área?', 'Mediciones - Nivel 3', '24 cm y 32 cm²;32 cm y 64 cm²;36 cm y 56 cm²;40 cm y 80 cm²', 1, 3, 2, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si estás frente a la pizarra y das un paso atrás, ¿A dónde te moviste?', 'Mediciones - Nivel 3', 'Adelante;Atrás;Izquierda;Derecha', 1, 3, 2, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si estás mirando al norte y giras a tu derecha, ¿Hacia dónde estás mirando ahora?', 'Mediciones - Nivel 3', 'Sur;Este;Oeste;Norte', 1, 3, 2, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es la dirección contraria al norte?', 'Mediciones - Nivel 3', 'Este;Oeste;Sur;Noreste', 2, 3, 2, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si algo está a tu izquierda, ¿En qué dirección se está?', 'Mediciones - Nivel 3', 'Derecha;Frente;Lado izquierdo;Atrás', 2, 3, 2, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Un niño está al norte de un árbol y camina hacia el sur, ¿Qué está haciendo?', 'Mediciones - Nivel 3', 'Se aleja;Se acerca;Da una vuelta;No se mueve', 1, 3, 2, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En los mapas, ¿Qué dirección suele estar arriba?', 'Mediciones - Nivel 3', 'Sur;Norte;Este;Oeste', 1, 3, 2, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si el parque está al Este de la escuela, ¿en qué dirección está la escuela desde el parque?', 'Mediciones - Nivel 3', 'Norte;Sur;Oeste;Este', 2, 3, 2, 1);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (4, 'Mediciones - Nivel 4', 2);
-- Dimensión 2, Nivel 4: Mediciones - Nivel 4 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En un plano, si un punto está en la columna B y la fila 3, ¿Cómo se escribe su ubicación?', 'Mediciones - Nivel 4', 'A3;B3;3B;AB', 1, 4, 2, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué dirección forma un ángulo recto con el norte?', 'Mediciones - Nivel 4', 'Sur;Este;Noroeste;Sureste', 1, 4, 2, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si un barco va del punto (2,3) al punto (2,6), ¿en qué dirección se movió?', 'Mediciones - Nivel 4', 'Norte;Sur;Este;Oeste', 0, 4, 2, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si el punto A está en (1,2) y el punto B en (3,2), ¿en qué dirección se movió?', 'Mediciones - Nivel 4', 'Norte;Sur;Este;Oeste', 2, 4, 2, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si te mueves un cuadro hacia arriba y otro hacia la derecha en una cuadrícula, ¿Qué tipo de movimiento hiciste?', 'Mediciones - Nivel 4', 'Diagonal;Horizontal;Vertical;Circular', 0, 4, 2, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si el punto C está en la esquina inferior izquierda del mapa, ¿qué hay en la esquina opuesta?', 'Mediciones - Nivel 4', 'Inferior derecha;Superior derecha;Superior izquierda;Centro', 1, 4, 2, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué palabra usamos para decir que algo está en medio de dos cosas?', 'Mediciones - Nivel 4', 'Dentro;Detrás;Entre;Al lado', 2, 4, 2, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En un mapa, el lago está al Oeste de la montaña y la escuela está al sur del lago. ¿Dónde está la escuela respecto a la montaña?', 'Mediciones - Nivel 4', 'Suroeste;Noreste;Sureste;Noroeste', 0, 4, 2, 2);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (5, 'Ubicación espacial - Nivel 5', 2);
-- Dimensión 2, Nivel 5: Ubicación espacial - Nivel 5 (5 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En un plano cartesiano, ¿Cómo se llama el eje horizontal?', 'Ubicación espacial - Nivel 5', 'Eje X;Eje Y;Eje Z;Eje N', 0, 5, 2, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En un plano cartesiano, ¿Cómo se llama el punto (0,0) donde empiezan los ejes?', 'Ubicación espacial - Nivel 5', 'Inicio;Centro;Origen;Base', 2, 5, 2, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si un punto está en (4,5) y baja hasta (4,2), ¿En qué dirección se movió?', 'Ubicación espacial - Nivel 5', 'Norte;Sur;Este;Oeste', 1, 5, 2, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('El punto A está en (3,3) y el punto B en (6,6), ¿Qué tipo de movimiento hizo?', 'Ubicación espacial - Nivel 5', 'Horizontal;Vertical;Diagonal;Circular', 2, 5, 2, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Un personaje camina 3 pasos al Este y luego 4 al Norte, ¿En qué cuadrante termina?', 'Ubicación espacial - Nivel 5', 'I;II;III;IV', 0, 5, 2, 3);

