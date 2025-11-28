package com.panaderiamatemagica.core.dao;

import com.panaderiamatemagica.core.ConexionBDT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Equipo Dell
 */
public class NivelDAO {

    public ArrayList<Integer> obtenerIdsNivelesPorDimension(int idDimension) {
        ArrayList<Integer> idsNiveles = new ArrayList<>();
        String sql = "SELECT id_nivel FROM niveles WHERE dimension_id = ? ORDER BY id_nivel ASC";

        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idDimension);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    idsNiveles.add(rs.getInt("id_nivel"));
                }
            }
        } catch (SQLException e) {
            System.err.println("ERROR al obtener niveles por dimensión: " + e.getMessage());
        }
        return idsNiveles;
    }
}
