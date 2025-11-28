# INSTRUCCIONES PARA CORREGIR ERRORES DE COMPILACIÓN

## Problema: Métodos Duplicados en Dimension2-5 Vistas

Los archivos de las vistas tienen métodos duplicados. Para cada archivo, elimina las primeras apariciones de estos métodos (líneas ~117-131):

### Archivos a corregir:
1. Dimension2Vista.java
2. Dimension3Vista.java  
3. Dimension4Vista.java
4. Dimension5Vista.java

### Eliminar ESTAS líneas (aparecen DOS veces, elimina la PRIMERA):

```java
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed
```

### MANTENER ESTAS líneas (segunda aparición con lógica):

```java
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
    controlador.iniciarNivel(0);
}// GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
    controlador.iniciarNivel(1);
}// GEN-LAST:event_jButton2ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
    controlador.iniciarNivel(2);
}// GEN-LAST:event_jButton3ActionPerformed
```

---

## Problema: Falta método getControlador()

Agregar a Dimension2Vista, Dimension3Vista, Dimension4Vista, Dimension5Vista:

```java
public DimensionControlador getControlador() {
    return controlador;
}
```

Insertar después del método `inicializarDimension()` en cada archivo.

---

## Problema: Dimension5Vista - Falta método para jButton5

Agregar en Dimension5Vista:

```java
private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
    // Implementar acción si es necesario
}
```

---

## Resumen de Pasos:

1. ✅ AlumnoDAO.obtenerAlumnoPorApodo() - YA CORREGIDO
2. ✅ EjercicioDAO.cargarEjerciciosPorDimensionYNivel() - YA CORREGIDO
3. ⚠️ Eliminar métodos duplicados en Dimension2-5 Vistas - MANUAL
4. ⚠️ Agregar getControlador() a Dimension2-5 Vistas - MANUAL
5. ⚠️ Agregar jButton5ActionPerformed a Dimension5Vista - MANUAL

Después de hacer estos cambios, ejecuta: Clean and Build (F11)
