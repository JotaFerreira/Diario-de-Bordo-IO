package br.com.rmdiariodebordo.model.dao;

import br.com.rmdiariodebordo.model.vo.Tecnico;
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
public class TecnicoDAO {

    public ArrayList<Tecnico> getTecnicosPorSetor(ArrayList setores) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            String strSetores = "";

            for (int i = 0; i <= setores.size() - 1; i++) {

                strSetores += "'" + setores.get(i) + "'";

                if (i != setores.size() - 1) {

                    strSetores += ",";
                }

            }

            ResultSet rs = stm.executeQuery("SELECT NOME || ' - ' || MAT AS TECNICO FROM TECNICOS WHERE SETOR IN (" + strSetores
                    + ")  ORDER BY 1");
            ArrayList<Tecnico> tecnicos = new ArrayList<>();

            while (rs.next()) {
                Tecnico t = new Tecnico();
                t.setNome(rs.getString(1));
                tecnicos.add(t);
            }

            return tecnicos;

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

    public ArrayList<Tecnico> getTecnicosPorUF(String uf) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("SELECT nome || ' - ' || mat FROM tecnicos WHERE uf ='" + uf
                    + "' ORDER BY 1");
            ArrayList<Tecnico> tecnicos = new ArrayList<>();

            while (rs.next()) {
                Tecnico t = new Tecnico();
                t.setNome(rs.getString(1));
                tecnicos.add(t);
            }
            return tecnicos;

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

    public String getSetor(Tecnico Tecnico) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            ResultSet var = stm.executeQuery("SELECT setor FROM tecnicos WHERE mat='"
                    + Tecnico.getMatricula() + "'");
            String nm = "";

            while (var.next()) {

                nm = var.getString(1);

            }

            return nm;

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
