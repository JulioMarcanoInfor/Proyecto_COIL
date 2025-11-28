# IMPLEMENTACIÓN DE GAMIFICACIÓN - GUÍA DE INTEGRACIÓN

## ✅ ARCHIVOS CREADOS

### 1. ProgresoNivelModelo.java
**Ubicación:** `src/com/panaderiamatemagica/progreso/modelo/ProgresoNivelModelo.java`

**Funcionalidad:**
- Gestiona el progreso del alumno en un nivel
- Controla vidas (inicia con 5)
- Calcula estrellas basándose en vidas restantes:
  - 5 vidas = 3 estrellas
  - 3-4 vidas = 2 estrellas
  - 1-2 vidas = 1 estrella
  - 0 vidas = 0 estrellas
- Calcula galletas: `estrellas * dificultad * 10`
- Rastrea aciertos y desaciertos

### 2. ProgresoNivelDAO.java
**Ubicación:** `src/com/panaderiamatemagica/progreso/dao/ProgresoNivelDAO.java`

**Métodos principales:**
- `obtenerProgreso(alumnoId, dimensionId, nivelId)` - Obtiene progreso guardado
- `guardarProgreso(progreso)` - Guarda/actualiza progreso
- `puedeAccederNivel(alumnoId, dimensionId, nivelId)` - Valida progresión lineal
- `obtenerProgresosDimension(alumnoId, dimensionId)` - Lista todos los progresos
- `obtenerTotalEstrellasDimension(alumnoId, dimensionId)` - Total de estrellas

### 3. AlumnoDAO.java (Actualizado)
**Métodos agregados:**
- `sumarGalletas(alumnoId, galletasGanadas)` - Suma galletas al alumno
- `actualizarEstadisticas(alumnoId, porcentajeAciertos, porcentajeDesaciertos)` - Actualiza promedios

---

## 📋 PASOS PARA COMPLETAR LA INTEGRACIÓN

### PASO 1: Actualizar EjercicioControladorVista

**Archivo:** `src/com/panaderiamatemagica/ejercicios/controlador/EjercicioControladorVista.java`

**Cambios necesarios:**

1. Agregar campo `ProgresoNivelModelo`:
```java
private ProgresoNivelModelo progresoNivel;
```

2. En el constructor, inicializar el progreso:
```java
this.progresoNivel = new ProgresoNivelModelo();
this.progresoNivel.setTotalEjercicios(listaEjercicios.size());
```

3. Modificar `validarRespuesta()`:
```java
public void validarRespuesta(String respuestaUsuario) {
    if (ejercicioActual == null) {
        System.err.println("Error: No hay ejercicio cargado para validar.");
        return;
    }
    
    String respuestaCorrecta = ejercicioActual.getOpcionesRespuestas()
        .get(ejercicioActual.getNumRespuesta());
    
    if (respuestaUsuario.equals(respuestaCorrecta)) {
        progresoNivel.registrarAcierto();
        JOptionPane.showMessageDialog(null, "¡Correcto!", "Respuesta", 
            JOptionPane.INFORMATION_MESSAGE);
        avanzarYMostrarSiguienteEjercicio();
    } else {
        progresoNivel.registrarError();
        
        if (progresoNivel.getVidasRestantes() <= 0) {
            JOptionPane.showMessageDialog(null, 
                "¡Game Over! Te quedaste sin vidas.", 
                "Fin del Nivel", JOptionPane.ERROR_MESSAGE);
            finalizarNivel();
        } else {
            JOptionPane.showMessageDialog(null, 
                "Incorrecto. Vidas restantes: " + progresoNivel.getVidasRestantes(), 
                "Respuesta", JOptionPane.ERROR_MESSAGE);
        }
    }
}
```

4. Modificar `avanzarYMostrarSiguienteEjercicio()`:
```java
public void avanzarYMostrarSiguienteEjercicio() {  
    if (listaEjercicios == null) return;
    
    if (indice < listaEjercicios.size()) {
        EjercicioModelo siguienteEjercicio = listaEjercicios.get(indice);
        this.ejercicioActual = siguienteEjercicio;
        
        vista.cargarEjercicio(siguienteEjercicio);
        router.mostrarEjercicioVista();
        
        indice++; 
    } else {
        // Nivel completado
        finalizarNivel();
    }
}
```

5. Agregar método `finalizarNivel()`:
```java
private void finalizarNivel() {
    // Calcular resultados
    int estrellasObtenidas = progresoNivel.calcularEstrellas();
    int galletasGanadas = progresoNivel.calcularGalletas(1); // dificultad = 1 por ahora
    
    // Mostrar pantalla de resultados
    router.mostrarResultadoVista();
    
    // Guardar progreso en BD
    guardarProgresoEnBD(estrellasObtenidas, galletasGanadas);
}

private void guardarProgresoEnBD(int estrellas, int galletas) {
    try {
        AlumnoModelo alumno = router.getAlumnoActual();
        if (alumno == null) {
            System.err.println("No hay alumno autenticado");
            return;
        }
        
        // Guardar progreso del nivel
        ProgresoNivelDAO progresoDAO = new ProgresoNivelDAO();
        progresoNivel.setAlumnoId(alumno.getId_Alumno());
        progresoNivel.setDimensionId(1); // Obtener de contexto
        progresoNivel.setNivelId(1); // Obtener de contexto
        progresoNivel.setEstrellas(estrellas);
        progresoNivel.setCompletado(estrellas > 0);
        
        progresoDAO.guardarProgreso(progresoNivel);
        
        // Sumar galletas
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumnoDAO.sumarGalletas(alumno.getId_Alumno(), galletas);
        
        // Actualizar estadísticas
        double porcentajeAciertos = progresoNivel.calcularPorcentajeAciertos();
        double porcentajeDesaciertos = 100 - porcentajeAciertos;
        alumnoDAO.actualizarEstadisticas(alumno.getId_Alumno(), 
            porcentajeAciertos, porcentajeDesaciertos);
        
    } catch (Exception e) {
        System.err.println("Error al guardar progreso: " + e.getMessage());
        e.printStackTrace();
    }
}
```

---

### PASO 2: Actualizar ResultadoVista

**Archivo:** `src/com/panaderiamatemagica/juego/vista/ResultadoVista.java`

**Agregar método para mostrar resultados:**
```java
public void mostrarResultados(ProgresoNivelModelo progreso, int galletas) {
    int estrellas = progreso.calcularEstrellas();
    int aciertos = progreso.getAciertos();
    int desaciertos = progreso.getDesaciertos();
    int vidasRestantes = progreso.getVidasRestantes();
    
    // Actualizar labels en la vista
    labelEstrellas.setText("Estrellas: " + estrellas + "/3");
    labelGalletas.setText("Galletas ganadas: " + galletas);
    labelAciertos.setText("Aciertos: " + aciertos);
    labelDesaciertos.setText("Errores: " + desaciertos);
    labelVidas.setText("Vidas restantes: " + vidasRestantes);
    
    // Mostrar mensaje de felicitación o ánimo
    if (estrellas == 3) {
        labelMensaje.setText("¡PERFECTO! ¡Eres un maestro panadero!");
    } else if (estrellas == 2) {
        labelMensaje.setText("¡MUY BIEN! Sigue así.");
    } else if (estrellas == 1) {
        labelMensaje.setText("¡BUEN INTENTO! Puedes mejorar.");
    } else {
        labelMensaje.setText("Inténtalo de nuevo. ¡Tú puedes!");
    }
}
```

---

### PASO 3: Implementar Bloqueo de Niveles en DimensionVista

**Archivos:** `Dimension1Vista.java`, `Dimension2Vista.java`, etc.

**En el método `inicializarDimension()`:**
```java
public void inicializarDimension(RouterControlador router, DimensionModelo modelo, 
                                 ArrayList<ArrayList<EjercicioModelo>> niveles) {
    this.controlador = new DimensionControlador(router, modelo, this, niveles);
    this.router = router;
    
    // Verificar qué niveles están desbloqueados
    verificarNivelesDesbloqueados();
}

private void verificarNivelesDesbloqueados() {
    try {
        AlumnoModelo alumno = router.getAlumnoActual();
        if (alumno == null) return;
        
        ProgresoNivelDAO progresoDAO = new ProgresoNivelDAO();
        int dimensionId = 1; // Cambiar según la dimensión
        
        // Verificar cada botón de nivel
        boolean puedeNivel2 = progresoDAO.puedeAccederNivel(alumno.getId_Alumno(), dimensionId, 2);
        boolean puedeNivel3 = progresoDAO.puedeAccederNivel(alumno.getId_Alumno(), dimensionId, 3);
        
        // Deshabilitar botones bloqueados
        jButton2.setEnabled(puedeNivel2);
        jButton3.setEnabled(puedeNivel3);
        
        // Cambiar apariencia visual
        if (!puedeNivel2) {
            jButton2.setBackground(Color.GRAY);
            jButton2.setText("🔒 Nivel 2");
        }
        if (!puedeNivel3) {
            jButton3.setBackground(Color.GRAY);
            jButton3.setText("🔒 Nivel 3");
        }
        
    } catch (Exception e) {
        System.err.println("Error al verificar niveles: " + e.getMessage());
    }
}
```

---

### PASO 4: Actualizar RouterControlador

**Asegurar que `getAlumnoActual()` esté implementado:**
```java
private AlumnoModelo alumnoActual;

public AlumnoModelo getAlumnoActual() {
    return alumnoActual;
}

public void setAlumnoActual(AlumnoModelo alumno) {
    this.alumnoActual = alumno;
}
```

**En el login exitoso, establecer el alumno actual:**
```java
// En AlumnoControadorInicioSesion después de validar
AlumnoModelo alumno = alumnoDAO.obtenerAlumnoPorApodo(apodoIngresado);
router.setAlumnoActual(alumno);
```

---

## 🎯 RESUMEN DE FLUJO

1. **Inicio de Nivel:**
   - Se crea `ProgresoNivelModelo` con 5 vidas
   - Se carga la lista de ejercicios

2. **Durante el Juego:**
   - Respuesta correcta → `registrarAcierto()`
   - Respuesta incorrecta → `registrarError()` (resta 1 vida)
   - Si vidas = 0 → Fin del nivel

3. **Fin de Nivel:**
   - Calcular estrellas según vidas restantes
   - Calcular galletas: `estrellas * dificultad * 10`
   - Guardar en `progreso_niveles`
   - Sumar galletas al alumno
   - Actualizar estadísticas (promedios)
   - Mostrar `ResultadoVista`

4. **Progresión Lineal:**
   - Al entrar a una dimensión, verificar niveles desbloqueados
   - Deshabilitar botones de niveles bloqueados
   - Solo se puede jugar Nivel N si se completó Nivel N-1 con ≥1 estrella

---

## 📊 VALIDACIÓN

Para probar la implementación:

1. Jugar un nivel completo
2. Verificar en BD tabla `progreso_niveles` que se guardó el registro
3. Verificar que `numero_galletas` aumentó en tabla `alumnos`
4. Verificar que `promedio_aciertos` y `promedio_desaciertos` se actualizaron
5. Intentar acceder al Nivel 2 sin completar Nivel 1 → Debe estar bloqueado
6. Completar Nivel 1 con 1+ estrellas → Nivel 2 debe desbloquearse

---

## ⚠️ NOTAS IMPORTANTES

- La dificultad actualmente está hardcodeada a 1. Debes obtenerla de la tabla `niveles`
- Los IDs de dimensión y nivel deben pasarse como parámetros al iniciar el juego
- Asegúrate de que el alumno esté autenticado antes de guardar progreso
- Los errores de BD se loguean en consola para debugging
