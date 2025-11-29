-- Script SQL con ejercicios para DIMENSIONES 3, 4 y 5
-- NOTA: Estos son ejercicios de ejemplo que puedes modificar
-- Ejecuta este script DESPUÉS de insertar_ejercicios_textuales.sql

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (1, 'Medición y unidades - Nivel 1', 3);
-- Dimensión 3, Nivel 1: Medición y unidades - Nivel 1 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál unidad usarías para medir la longitud de un lápiz?', 'Medición y unidades - Nivel 1', 'Metros;Centímetros;Kilómetros;Litros', 1, 1, 3, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuántos centímetros hay en un metro?', 'Medición y unidades - Nivel 1', '10;50;100;1000', 2, 1, 3, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si una regla mide 30 cm, ¿cuántos milímetros mide?', 'Medición y unidades - Nivel 1', '3;30;300;3000', 2, 1, 3, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es mayor: 1 metro o 50 centímetros?', 'Medición y unidades - Nivel 1', '1 metro;50 centímetros;Son iguales;No se puede comparar', 0, 1, 3, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si un libro mide 20 cm de largo, ¿cuántos milímetros mide?', 'Medición y unidades - Nivel 1', '2;20;200;2000', 2, 1, 3, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuántos metros hay en un kilómetro?', 'Medición y unidades - Nivel 1', '10;100;1000;10000', 2, 1, 3, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál unidad usarías para medir tu peso?', 'Medición y unidades - Nivel 1', 'Gramos;Kilogramos;Litros;Metros', 1, 1, 3, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuántos gramos hay en un kilogramo?', 'Medición y unidades - Nivel 1', '10;100;1000;10000', 2, 1, 3, 1);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (2, 'Medición y unidades - Nivel 2', 3);
-- Dimensión 3, Nivel 2: Medición y unidades - Nivel 2 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si una manzana pesa 200 gramos, ¿cuántas manzanas necesitas para tener 1 kg?', 'Medición y unidades - Nivel 2', '2;5;10;20', 1, 2, 3, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué pesa más: 1 kg de algodón o 1 kg de hierro?', 'Medición y unidades - Nivel 2', 'Algodón;Hierro;Pesan lo mismo;El hierro pesa el doble', 2, 2, 3, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si una bolsa de arroz pesa 5 kg, ¿cuántos gramos pesa?', 'Medición y unidades - Nivel 2', '50;500;5000;50000', 2, 2, 3, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál unidad usarías para medir el agua en una botella?', 'Medición y unidades - Nivel 2', 'Kilogramos;Litros;Metros;Centímetros', 1, 2, 3, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuántos mililitros hay en un litro?', 'Medición y unidades - Nivel 2', '10;100;1000;10000', 2, 2, 3, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si bebes 250 ml de jugo, ¿cuántos vasos necesitas para beber 1 litro?', 'Medición y unidades - Nivel 2', '2;4;8;10', 1, 2, 3, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál tiene mayor capacidad: una jarra de 2 litros o una de 1500 ml?', 'Medición y unidades - Nivel 2', '2 litros;1500 ml;Son iguales;No se puede comparar', 0, 2, 3, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuántos minutos hay en una hora?', 'Medición y unidades - Nivel 2', '30;45;60;100', 2, 2, 3, 1);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (3, 'Tiempo y calendario - Nivel 3', 3);
-- Dimensión 3, Nivel 3: Tiempo y calendario - Nivel 3 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuántas horas hay en un día?', 'Tiempo y calendario - Nivel 3', '12;24;36;48', 1, 3, 3, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si son las 3:30 y pasan 45 minutos, ¿qué hora será?', 'Tiempo y calendario - Nivel 3', '4:00;4:15;4:30;5:00', 1, 3, 3, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuántos segundos hay en un minuto?', 'Tiempo y calendario - Nivel 3', '30;60;100;120', 1, 3, 3, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si una película dura 2 horas, ¿cuántos minutos dura?', 'Tiempo y calendario - Nivel 3', '60;100;120;200', 2, 3, 3, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si hoy es martes, ¿qué día será en 3 días?', 'Tiempo y calendario - Nivel 3', 'Miércoles;Jueves;Viernes;Sábado', 2, 3, 3, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué mide el perímetro de una figura?', 'Tiempo y calendario - Nivel 3', 'El área interior;El contorno;El volumen;El peso', 1, 3, 3, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si un cuadrado tiene lado de 5 cm, ¿cuál es su perímetro?', 'Tiempo y calendario - Nivel 3', '10 cm;15 cm;20 cm;25 cm', 2, 3, 3, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál es el área de un rectángulo de 4 cm × 3 cm?', 'Tiempo y calendario - Nivel 3', '7 cm²;12 cm²;14 cm²;24 cm²', 1, 3, 3, 3);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (4, 'Perímetro y área - Nivel 4', 3);
-- Dimensión 3, Nivel 4: Perímetro y área - Nivel 4 (1 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si un jardín cuadrado mide 6 metros de lado, ¿cuál es su perímetro?', 'Perímetro y área - Nivel 4', '12 m;18 m;24 m;36 m', 2, 4, 3, 3);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (1, 'Recolección de datos - Nivel 1', 4);
-- Dimensión 4, Nivel 1: Recolección de datos - Nivel 1 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si lanzas una moneda, ¿cuántos resultados posibles hay?', 'Recolección de datos - Nivel 1', '1;2;3;4', 1, 1, 4, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En una tabla de frutas favoritas, si 5 niños prefieren manzana y 3 prefieren pera, ¿cuántos niños hay en total?', 'Recolección de datos - Nivel 1', '2;5;8;15', 2, 1, 4, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si lanzas un dado, ¿cuántos números diferentes pueden salir?', 'Recolección de datos - Nivel 1', '4;5;6;7', 2, 1, 4, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En una encuesta, 10 niños prefieren fútbol, 7 básquet y 3 natación. ¿Cuántos niños fueron encuestados?', 'Recolección de datos - Nivel 1', '10;17;20;30', 2, 1, 4, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Cuál deporte fue el más popular si: fútbol 12, básquet 8, natación 5?', 'Recolección de datos - Nivel 1', 'Fútbol;Básquet;Natación;Todos igual', 0, 1, 4, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En una tabla: Lunes 3, Martes 5, Miércoles 2. ¿Qué día tuvo más?', 'Recolección de datos - Nivel 1', 'Lunes;Martes;Miércoles;Todos igual', 1, 1, 4, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si hay 8 perros, 5 gatos y 3 pájaros, ¿cuántos animales hay en total?', 'Recolección de datos - Nivel 1', '13;16;18;20', 1, 1, 4, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si hay el doble de niñas que niños y hay 6 niños, ¿cuántas niñas hay?', 'Recolección de datos - Nivel 1', '3;6;12;18', 2, 1, 4, 2);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (2, 'Probabilidad básica - Nivel 2', 4);
-- Dimensión 4, Nivel 2: Probabilidad básica - Nivel 2 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En una bolsa con 3 bolas rojas y 1 azul, ¿de qué color es más probable sacar una?', 'Probabilidad básica - Nivel 2', 'Roja;Azul;Igual probabilidad;Verde', 0, 2, 4, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si lanzas una moneda, ¿es más probable que salga cara o cruz?', 'Probabilidad básica - Nivel 2', 'Cara;Cruz;Igual probabilidad;Depende de la moneda', 2, 2, 4, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si un dado tiene 6 caras numeradas del 1 al 6, ¿cuál es imposible que salga?', 'Probabilidad básica - Nivel 2', '3;6;7;1', 2, 2, 4, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En una ruleta con 4 secciones iguales (rojo, azul, verde, amarillo), ¿cuál color tiene más probabilidad?', 'Probabilidad básica - Nivel 2', 'Rojo;Azul;Todos igual;Verde', 2, 2, 4, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si tienes las calificaciones 8, 9 y 10, ¿cuál es el promedio?', 'Probabilidad básica - Nivel 2', '8;9;10;27', 1, 2, 4, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En el grupo hay edades: 7, 8, 7, 9, 7. ¿Cuál edad se repite más?', 'Probabilidad básica - Nivel 2', '6;7;8;9', 1, 2, 4, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si Mario tiene 5 dulces, Ana 3 y Luis 4, ¿cuántos dulces tienen en promedio?', 'Probabilidad básica - Nivel 2', '3;4;5;12', 1, 2, 4, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En una serie de números: 2, 5, 2, 8, 2, 3, ¿cuál es la moda (el más repetido)?', 'Probabilidad básica - Nivel 2', '2;3;5;8', 0, 2, 4, 2);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (3, 'Patrones numéricos - Nivel 3', 4);
-- Dimensión 4, Nivel 3: Patrones numéricos - Nivel 3 (7 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si el patrón es: 2, 4, 6, 8, ¿qué número sigue?', 'Patrones numéricos - Nivel 3', '9;10;12;14', 1, 3, 4, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué número sigue en: 5, 10, 15, 20, ___?', 'Patrones numéricos - Nivel 3', '21;25;30;35', 1, 3, 4, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En la secuencia: 1, 3, 5, 7, ¿qué patrón hay?', 'Patrones numéricos - Nivel 3', 'Suman 1;Suman 2;Multiplican por 2;Restan 1', 1, 3, 4, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si cada día ahorras $2 más, y el lunes ahorraste $3, ¿cuánto ahorrarás el miércoles?', 'Patrones numéricos - Nivel 3', '$5;$6;$7;$9', 2, 3, 4, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si Pedro mide 1.20 m y Ana 1.15 m, ¿quién es más alto?', 'Patrones numéricos - Nivel 3', 'Pedro;Ana;Miden igual;No se puede saber', 0, 3, 4, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si Equipo A anotó 15 puntos y Equipo B anotó 12, ¿cuántos puntos más tiene A?', 'Patrones numéricos - Nivel 3', '2;3;4;27', 1, 3, 4, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si la temperatura es de 25°C al mediodía y 18°C en la noche, ¿cuántos grados bajó?', 'Patrones numéricos - Nivel 3', '3;5;7;43', 2, 3, 4, 2);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (1, 'Operaciones básicas - Nivel 1', 5);
-- Dimensión 5, Nivel 1: Operaciones básicas - Nivel 1 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Ana tenía 15 dulces y le dieron 8 más. ¿Cuántos tiene ahora?', 'Operaciones básicas - Nivel 1', '7;15;23;120', 2, 1, 5, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En una caja hay 20 lápices. Si sacas 7, ¿cuántos quedan?', 'Operaciones básicas - Nivel 1', '7;13;20;27', 1, 1, 5, 1);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Pedro tiene 12 canicas, Juan tiene 5 más que Pedro. ¿Cuántas tiene Juan?', 'Operaciones básicas - Nivel 1', '5;7;12;17', 3, 1, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('María ahorró $25 y gastó $18 en un libro. ¿Cuánto le quedó?', 'Operaciones básicas - Nivel 1', '$7;$15;$18;$43', 0, 1, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En un autobús viajan 18 personas. Suben 7 y bajan 5. ¿Cuántas personas hay ahora?', 'Operaciones básicas - Nivel 1', '16;18;20;30', 2, 1, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si compras 4 cuadernos a $3 cada uno, ¿cuánto pagas en total?', 'Operaciones básicas - Nivel 1', '$7;$9;$12;$15', 2, 1, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Hay 5 cajas con 6 galletas cada una. ¿Cuántas galletas hay en total?', 'Operaciones básicas - Nivel 1', '11;25;30;36', 2, 1, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Un libro tiene 8 páginas con 5 dibujos en cada página. ¿Cuántos dibujos hay?', 'Operaciones básicas - Nivel 1', '13;35;40;45', 2, 1, 5, 2);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (2, 'Operaciones básicas - Nivel 2', 5);
-- Dimensión 5, Nivel 2: Operaciones básicas - Nivel 2 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si una semana tiene 7 días, ¿cuántos días hay en 3 semanas?', 'Operaciones básicas - Nivel 2', '10;14;21;24', 2, 2, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Tienes 12 galletas para repartir entre 3 amigos. ¿Cuántas le tocan a cada uno?', 'Operaciones básicas - Nivel 2', '3;4;9;36', 1, 2, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si 20 estudiantes se dividen en grupos de 5, ¿cuántos grupos se forman?', 'Operaciones básicas - Nivel 2', '4;5;15;25', 0, 2, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Una caja de 24 chocolates se reparte entre 6 niños. ¿Cuántos recibe cada uno?', 'Operaciones básicas - Nivel 2', '4;6;18;30', 0, 2, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si un paquete de 30 hojas se divide en 5 partes iguales, ¿cuántas hojas tiene cada parte?', 'Operaciones básicas - Nivel 2', '5;6;10;25', 1, 2, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Luis tenía 20 pesos, gastó 8 en dulces y luego le dieron 5 más. ¿Cuánto tiene?', 'Operaciones básicas - Nivel 2', '$12;$13;$17;$33', 2, 2, 5, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('En una tienda había 30 juguetes. Vendieron 12 y luego trajeron 8 más. ¿Cuántos hay ahora?', 'Operaciones básicas - Nivel 2', '$18;$26;$38;$50', 1, 2, 5, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Ana compró 3 paquetes de 4 colores. Si regaló 5 colores, ¿cuántos le quedan?', 'Operaciones básicas - Nivel 2', '2;7;12;17', 1, 2, 5, 3);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (3, 'Problemas de dos pasos - Nivel 3', 5);
-- Dimensión 5, Nivel 3: Problemas de dos pasos - Nivel 3 (8 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Pedro tenía $50, compró 2 libros de $15 cada uno. ¿Cuánto le sobró?', 'Problemas de dos pasos - Nivel 3', '$20;$30;$35;$80', 0, 3, 5, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si cada día lees 5 páginas, ¿cuántas páginas leerás en 4 días?', 'Problemas de dos pasos - Nivel 3', '9;15;20;25', 2, 3, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Un caracol sube 3 metros cada hora. ¿Cuánto habrá subido en 5 horas?', 'Problemas de dos pasos - Nivel 3', '8 m;12 m;15 m;18 m', 2, 3, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si plantas 2 flores por maceta y tienes 7 macetas, ¿cuántas flores plantaste?', 'Problemas de dos pasos - Nivel 3', '9;12;14;16', 2, 3, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Carlos tiene 18 años y su hermano 12. ¿Cuántos años más tiene Carlos?', 'Problemas de dos pasos - Nivel 3', '6;12;18;30', 0, 3, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si un árbol mide 8 metros y otro 12 metros, ¿cuál es la diferencia?', 'Problemas de dos pasos - Nivel 3', '2 m;4 m;8 m;20 m', 1, 3, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('María tiene 15 cromos y Pedro tiene el triple. ¿Cuántos cromos tiene Pedro?', 'Problemas de dos pasos - Nivel 3', '3;18;30;45', 3, 3, 5, 3);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Si todos los gatos son animales, ¿un perro es un gato?', 'Problemas de dos pasos - Nivel 3', 'Sí;No;A veces;Depende', 1, 3, 5, 2);

INSERT INTO niveles (id_nivel, nombre, dimension_id) VALUES (4, 'Razonamiento lógico - Nivel 4', 5);
-- Dimensión 5, Nivel 4: Razonamiento lógico - Nivel 4 (2 ejercicios)
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('Tienes 2 manzanas y compras el doble. ¿Cuántas manzanas tienes ahora?', 'Razonamiento lógico - Nivel 4', '2;4;6;8', 2, 4, 5, 2);
INSERT INTO ejercicios (pregunta, descripcion, opciones_respuestas, num_respuesta, id_nivel, id_dimension, dificultad) VALUES ('¿Qué número falta? 5 + ___ = 8 + 2', 'Razonamiento lógico - Nivel 4', '3;5;10;15', 1, 4, 5, 3);

