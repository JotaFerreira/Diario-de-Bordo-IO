package data.access.object;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author joao.oliveira
 */
public class DAOTecnico {

    public List getTecnicosPorSetor(ArrayList setores) throws SQLException, ClassNotFoundException {

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

            data.access.object.DAOUtil Util = new data.access.object.DAOUtil();
            ResultSet rs = stm.executeQuery("SELECT NOME || ' - ' || MAT AS TECNICO FROM TECNICOS WHERE SETOR IN (" + strSetores
                    + ")  ORDER BY 1");
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

    public List getTecnicosPorUF(String uf) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            data.access.object.DAOUtil Util = new data.access.object.DAOUtil();
            ResultSet rs = stm.executeQuery("SELECT NOME || ' - ' || MAT AS TECNICO FROM TECNICOS WHERE UF ='" + uf
                    + "' ORDER BY 1");
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

    public String getSetor(model.Tecnico Tecnico) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            data.access.object.DAOUtil Util = new data.access.object.DAOUtil();
            ResultSet var = stm.executeQuery("SELECT SETOR AS SETOR FROM TECNICOS WHERE MAT='"
                    + Tecnico.getMatricula() + "'");
            List var2 = Util.resultSetToArrayList(var);
            Map obj = (Map) var2.get(0);
            Object objSegmento = obj.get("SETOR");

            if (objSegmento != null) {

                return objSegmento.toString();

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
