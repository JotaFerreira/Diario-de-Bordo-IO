package br.com.rmdiariodebordo.model.bo;

import br.com.rmdiariodebordo.model.dao.UsuarioDAO;
import br.com.rmdiariodebordo.model.vo.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author joao.oliveira
 */
public class Autenticacao {

    public boolean autorizado(Usuario user) throws SQLException, ClassNotFoundException, Exception {

        try {

            UsuarioDAO UserDAO = new UsuarioDAO();
            String senhaDB = UserDAO.getSenha(user.getLogin());

            if (senhaDB.equals("")) {

                return false;

            } else {

                return Cypher.encrypt(user.getSenha()).equals(senhaDB);

            }

        } catch (SQLException | ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "Erro:" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;

        } 

    }

}
