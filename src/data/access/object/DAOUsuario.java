package data.access.object;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author joao.oliveira
 */
public class DAOUsuario {

    public String getCargo(String username) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            data.access.object.DAOUtil Util = new data.access.object.DAOUtil();
            ResultSet var = stm.executeQuery("SELECT CARGO AS CARGO FROM usuarios WHERE USERNAME='" + username + "'");
            List var2 = Util.resultSetToArrayList(var);
            Map obj = (Map) var2.get(0);
            Object objNome = obj.get("CARGO");

            if (objNome != null) {

                return objNome.toString();

            } else {

                return "";

            }

        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex, "Erro", JOptionPane.ERROR_MESSAGE);

            return null;

        } finally {

            try {
                stm.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro:" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}
