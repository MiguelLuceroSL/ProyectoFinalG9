package AccesoADatos;

import Entidades.Proyecto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProyectoData {

    private Connection con = null;
    private Conexion conexion;

    public ProyectoData() {
        con = Conexion.getConexion();
    }

    public void guardarProyecto(Proyecto proyecto) {
        try {
            String sql = "INSERT INTO proyecto(nombreP, descripcion, fechaInicio, estado) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getDescripcion());
            ps.setDate(3, Date.valueOf(proyecto.getFechaInicio()));
            ps.setBoolean(4, proyecto.isEstado());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Proyecto creado con exito.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                proyecto.setIdProyecto(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla Proyecto" + ex.getMessage());
        }
    }
    
    public List<Proyecto> listarProyectos(){
        List<Proyecto> listaP = new ArrayList<>();
        try {
            String sql = "SELECT * FROM proyecto";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {            
                Proyecto proy = new Proyecto();
                proy.setIdProyecto(rs.getInt("idProyecto"));
                proy.setNombre(rs.getString("nombreP"));
                proy.setDescripcion(rs.getString("descripcion"));
                proy.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                proy.setEstado(rs.getBoolean("estado"));
                listaP.add(proy);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
        return listaP;
    }
}
