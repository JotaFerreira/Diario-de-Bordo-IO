package br.com.rmdiariodebordo.model.dao;

import br.com.rmdiariodebordo.model.vo.OcorrenciaSupervisor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.com.rmdiariodebordo.model.vo.Supervisor;

/**
 *
 * @author joao.oliveira
 */
public class SupervisorDAO {

    public ArrayList<Supervisor> getListaSupervisores() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            String query = "SELECT UPPER(nome) AS SUPERVISOR FROM usuarios WHERE cargo = 'SUPERVISOR'";
            ResultSet rs = stm.executeQuery(query);
            ArrayList<Supervisor> supervisores = new ArrayList<>();

            while (rs.next()) {
                Supervisor Supervisor = new Supervisor();
                Supervisor.setNome(rs.getString(1));
                supervisores.add(Supervisor);
            }

            return supervisores;

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

            ResultSet var = stm.executeQuery("SELECT nome AS NOME FROM usuarios WHERE username='" + username + "'");
            String nm = "";
            
            while(var.next()){
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

    public void registrarOcorrencia(OcorrenciaSupervisor Ocorrencia) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            stm.executeUpdate("INSERT INTO diario_sup(data_att,supervisor,uf,segmento,controlador,ocorrencia,periodo,"
                    + "observacao,username) VALUES('" + Ocorrencia.getData_att() + "','" + Ocorrencia.getSupervisor() + "','"
                    + Ocorrencia.getUf() + "','" + Ocorrencia.getSegmento() + "','" + Ocorrencia.getControlador() + "','"
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
