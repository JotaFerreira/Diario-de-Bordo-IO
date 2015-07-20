package seguranca;

import data.access.object.Conexao;
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
public class Autenticacao {

    public boolean autorizado(String username, String senha) throws SQLException, ClassNotFoundException, Exception {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            data.access.object.DAOUtil Util = new data.access.object.DAOUtil();
            ResultSet var = stm.executeQuery("SELECT SENHA AS SENHA FROM USUARIOS WHERE USERNAME='" + username + "'");
            List var2 = Util.resultSetToArrayList(var);

            if (var2.isEmpty() | var == null) {

                return false;

            }

            Map obj = (Map) var2.get(0);
            Object objSenha = obj.get("SENHA");

            if (objSenha == null) {

                return false;

            } else {

                String encriptSenha = objSenha.toString();
                return Cypher.encrypt(senha).equals(encriptSenha);

            }

        } catch (SQLException | ClassNotFoundException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro:" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;

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
