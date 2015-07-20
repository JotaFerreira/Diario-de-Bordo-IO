package data.access.object;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Coordenador;
import model.OcorrenciaCoordenador;

/**
 *
 * @author joao.oliveira
 */
public class DAOCoordenador {

    public ArrayList<Coordenador> getLista() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            String query = "SELECT UPPER(nome) AS SUPERVISOR FROM usuarios WHERE cargo = 'SUPERVISOR'";
            ResultSet rs = stm.executeQuery(query);
            ArrayList<Coordenador> coordenadores = new ArrayList<>();

            while (rs.next()) {
                Coordenador Coordenador = new Coordenador();
                Coordenador.setNome(rs.getString(1));
                coordenadores.add(Coordenador);
            }

            return coordenadores;

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

    public String getNome(String username) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            DAOUtil Util = new DAOUtil();
            ResultSet var = stm.executeQuery("SELECT nome AS NOME FROM usuarios WHERE username='" + username + "'");
            List var2 = Util.resultSetToArrayList(var);
            Map obj = (Map) var2.get(0);
            Object objNome = obj.get("NOME");

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

    public void registrarOcorrencia(OcorrenciaCoordenador Ocorrencia) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            stm.executeUpdate("INSERT INTO diario_coo(data_att,coordenador,uf,segmento,supervisor,ocorrencia,periodo,"
                    + "observacao,username) VALUES('" + Ocorrencia.getData_att() + "','" + Ocorrencia.getSupervisor() + "','"
                    + Ocorrencia.getUf() + "','" + Ocorrencia.getSegmento() + "','" + Ocorrencia.getSupervisor() + "','"
                    + Ocorrencia.getOcorrencia() + "','" + Ocorrencia.getPeriodo() + "','" + Ocorrencia.getObservacao()
                    + "','" + Ocorrencia.getUsername() + "')");
        } catch (SQLException | ClassNotFoundException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro:" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            
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
