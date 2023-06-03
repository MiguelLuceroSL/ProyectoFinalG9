package AccesoADatos;

import Entidades.Comentario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ComentarioData {

    private Connection con = null;
    private Conexion conexion;

    public ComentarioData() {
        con = Conexion.getConexion();
    }

    public void guardarComentario(Comentario comentario) {
        try {
            String sql = "INSERT INTO comentarios(comentario, fechaAvance, idTarea) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comentario.getComentario());
            ps.setDate(2, Date.valueOf(comentario.getFechaAvance()));
            ps.setInt(3, comentario.getTareaId().getIdTarea());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Comentario cargado exitosamente");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                comentario.setIdCometario(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla Comentario "+ex.getMessage());
        }
    }
}
