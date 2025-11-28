-- Script para insertar ejercicios de ejemplo para todas las dimensiones y niveles
-- Dimensión 1: Números y Operaciones (Suma, Resta, Multiplicación)
-- Dimensión 2: Geometría (Formas, Figuras)
-- Dimensión 3: Medidas (Peso, Longitud, Tiempo)
-- Dimensión 4: Fracciones y Decimales
-- Dimensión 5: Resolución de Problemas

-- =====================================================
-- DIMENSIÓN 1: NÚMEROS Y OPERACIONES
-- =====================================================

-- Nivel 1 (Dificultad: 1 - Fácil)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('¿Cuánto es 3 + 4?', 'Suma básica', '5', '7', '8', '6', 2, 1, 1, 1),
('¿Cuánto es 10 - 3?', 'Resta sencilla', '6', '7', '8', '5', 2, 1, 1, 1),
('¿Cuánto es 2 × 3?', 'Multiplicación simple', '5', '6', '7', '8', 2, 1, 1, 1);

-- Nivel 2 (Dificultad: 2 - Media)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('¿Cuánto es 15 + 28?', 'Suma con llevadas', '43', '45', '42', '41', 1, 2, 1, 2),
('¿Cuánto es 50 - 27?', 'Resta con prestadas', '22', '23', '24', '25', 2, 2, 1, 2),
('¿Cuánto es 8 × 7?', 'Tabla del 8', '54', '56', '58', '60', 2, 2, 1, 2);

-- Nivel 3 (Dificultad: 3 - Difícil)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('¿Cuánto es 125 + 378?', 'Suma de tres dígitos', '503', '505', '493', '483', 1, 3, 1, 3),
('¿Cuánto es 500 - 347?', 'Resta con múltiples prestadas', '153', '154', '163', '143', 1, 3, 1, 3),
('¿Cuánto es 12 × 11?', 'Multiplicación avanzada', '122', '132', '142', '152', 2, 3, 1, 3);

-- =====================================================
-- DIMENSIÓN 2: GEOMETRÍA
-- =====================================================

-- Nivel 1 (Dificultad: 1)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('¿Cuántos lados tiene un triángulo?', 'Figuras básicas', '2', '3', '4', '5', 2, 1, 2, 1),
('¿Cuántos lados tiene un cuadrado?', 'Cuadriláteros', '3', '4', '5', '6', 2, 1, 2, 1),
('¿Cómo se llama una figura de 5 lados?', 'Polígonos', 'Cuadrado', 'Pentágono', 'Hexágono', 'Triángulo', 2, 1, 2, 1);

-- Nivel 2 (Dificultad: 2)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('¿Cuál es el perímetro de un cuadrado de lado 5 cm?', 'Perímetros', '10 cm', '20 cm', '15 cm', '25 cm', 2, 2, 2, 2),
('¿Cuántos vértices tiene un cubo?', 'Figuras 3D', '6', '8', '10', '12', 2, 2, 2, 2),
('¿Cuál es el área de un rectángulo de 4×3?', 'Área', '7', '12', '14', '16', 2, 2, 2, 2);

-- Nivel 3 (Dificultad: 3)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('¿Cuál es el área de un círculo de radio 3? (π=3.14)', 'Círculos', '18.84', '28.26', '9.42', '12.56', 2, 3, 2, 3),
('¿Cuántas caras tiene una pirámide cuadrangular?', 'Poliedros', '4', '5', '6', '7', 2, 3, 2, 3),
('¿Cuál es el volumen de un cubo de lado 3?', 'Volumen', '9', '18', '27', '81', 3, 3, 2, 3);

-- =====================================================
-- DIMENSIÓN 3: MEDIDAS
-- =====================================================

-- Nivel 1 (Dificultad: 1)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('¿Cuántos centímetros hay en 1 metro?', 'Longitud', '10', '100', '1000', '50', 2, 1, 3, 1),
('¿Cuántos gramos hay en 1 kilogramo?', 'Peso', '10', '100', '1000', '500', 3, 1, 3, 1),
('¿Cuántos minutos hay en 1 hora?', 'Tiempo', '30', '60', '90', '120', 2, 1, 3, 1);

-- Nivel 2 (Dificultad: 2)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('¿Cuántos metros son 250 centímetros?', 'Conversión longitud', '2.5', '25', '0.25', '250', 1, 2, 3, 2),
('¿Cuántos kg son 3500 gramos?', 'Conversión peso', '0.35', '3.5', '35', '350', 2, 2, 3, 2),
('¿Cuántos segundos hay en 3 minutos?', 'Conversión tiempo', '90', '120', '180', '240', 3, 2, 3, 2);

-- Nivel 3 (Dificultad: 3)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('¿Cuántos litros caben en un recipiente de 2.5 m³?', 'Volumen', '250', '2500', '25000', '250000', 2, 3, 3, 3),
('¿Cuántos días hay en 5 semanas?', 'Tiempo compuesto', '30', '35', '40', '45', 2, 3, 3, 3),
('¿Cuántos mm son 7.5 cm?', 'Conversión precisa', '75', '750', '7.5', '0.75', 1, 3, 3, 3);

-- =====================================================
-- DIMENSIÓN 4: FRACCIONES Y DECIMALES
-- =====================================================

-- Nivel 1 (Dificultad: 1)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('¿Cuánto es 1/2 + 1/2?', 'Suma de fracciones', '1/4', '1', '2', '1/2', 2, 1, 4, 1),
('¿Cuánto es 0.5 + 0.5?', 'Suma de decimales', '0.10', '1.0', '1.5', '0.25', 2, 1, 4, 1),
('¿Qué fracción representa la mitad?', 'Fracciones básicas', '1/4', '1/2', '2/3', '3/4', 2, 1, 4, 1);

-- Nivel 2 (Dificultad: 2)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('¿Cuánto es 3/4 + 1/4?', 'Suma de fracciones iguales', '4/8', '1', '4/4', '1/2', 2, 2, 4, 2),
('¿Cuánto es 2.5 × 2?', 'Multiplicación decimal', '4.5', '5.0', '4.0', '5.5', 2, 2, 4, 2),
('¿Cuál es mayor: 0.7 o 0.5?', 'Comparación decimales', '0.5', '0.7', 'Son iguales', 'No se puede comparar', 2, 2, 4, 2);

-- Nivel 3 (Dificultad: 3)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('¿Cuánto es 2/3 + 1/6?', 'Suma fracciones diferentes', '3/9', '5/6', '3/6', '4/9', 2, 3, 4, 3),
('¿Cuánto es 3.75 × 4?', 'Multiplicación decimal avanzada', '12.5', '15.0', '14.5', '13.75', 2, 3, 4, 3),
('¿Cuánto es 5 ÷ 4 en decimal?', 'División a decimal', '1.25', '1.5', '1.75', '2.0', 1, 3, 4, 3);

-- =====================================================
-- DIMENSIÓN 5: RESOLUCIÓN DE PROBLEMAS
-- =====================================================

-- Nivel 1 (Dificultad: 1)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('Juan tiene 5 manzanas y compra 3 más. ¿Cuántas tiene?', 'Problema simple', '7', '8', '9', '10', 2, 1, 5, 1),
('En una caja hay 10 galletas. Si comes 4, ¿cuántas quedan?', 'Resta aplicada', '4', '5', '6', '7', 3, 1, 5, 1),
('María tiene 2 bolsas con 4 dulces cada una. ¿Cuántos dulces tiene?', 'Multiplicación aplicada', '6', '8', '10', '12', 2, 1, 5, 1);

-- Nivel 2 (Dificultad: 2)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('Un libro cuesta $15. Si tienes $50, ¿cuánto te sobra?', 'Problema con dinero', '$30', '$35', '$40', '$45', 2, 2, 5, 2),
('En una fiesta hay 24 niños. Si se van 9, ¿cuántos quedan?', 'Resta en contexto', '12', '13', '15', '16', 3, 2, 5, 2),
('Un pastel se divide en 8 pedazos. Si comes 3, ¿qué fracción queda?', 'Fracciones aplicadas', '3/8', '5/8', '4/8', '6/8', 2, 2, 5, 2);

-- Nivel 3 (Dificultad: 3)
INSERT INTO ejercicios (pregunta, descripcion, opcion_1, opcion_2, opcion_3, opcion_4, respuesta_correcta, nivel_id, dimension_id, dificultad)
VALUES 
('Un tren viaja a 60 km/h. ¿Cuánto recorre en 2.5 horas?', 'Velocidad-distancia', '120 km', '150 km', '180 km', '200 km', 2, 3, 5, 3),
('Si 3 lápices cuestan $6, ¿cuánto cuestan 7 lápices?', 'Proporcionalidad', '$12', '$14', '$16', '$18', 2, 3, 5, 3),
('Una receta para 4 personas usa 200g de harina. ¿Cuánto se necesita para 10 personas?', 'Proporciones en contexto', '400g', '500g', '600g', '800g', 2, 3, 5, 3);
