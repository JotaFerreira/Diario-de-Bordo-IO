package br.com.rmdiariodebordo.model.dao;

import br.com.rmdiariodebordo.model.vo.Setor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joao.oliveira
 */
public class SetorDAO {

    public ArrayList<Setor> getSetores() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("SELECT setor FROM setores ORDER BY 1");
            ArrayList<Setor> setores = new ArrayList<>();

            while(rs.next()){
                Setor s = new Setor();
                s.setNomeSetor(rs.getString(1));
                setores.add(s);
            }
            return setores;

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

    public ArrayList<Setor> getSetoresPorUF(String uf) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("SELECT setor FROM setores WHERE uf='" + uf + "' ORDER BY 1");
            ArrayList<Setor> setores = new ArrayList<>();
            
            while(rs.next()){
                Setor s = new Setor();
                s.setNomeSetor(rs.getString(1));
                setores.add(s);
            }
            
            return setores;

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
