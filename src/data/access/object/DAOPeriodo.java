package data.access.object;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author joao.oliveira
 */
public class DAOPeriodo {

    public List getPeriodos() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            data.access.object.DAOUtil Util = new data.access.object.DAOUtil();
            ResultSet rs = stm.executeQuery("SELECT PERIODO AS PERIODO FROM PERIODOS ORDER BY 1");
            List var = Util.resultSetToArrayList(rs);

            return var;

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
