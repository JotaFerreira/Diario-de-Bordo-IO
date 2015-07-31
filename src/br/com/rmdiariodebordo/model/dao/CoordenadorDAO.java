package br.com.rmdiariodebordo.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.com.rmdiariodebordo.model.vo.Coordenador;
import br.com.rmdiariodebordo.model.vo.OcorrenciaCoordenador;

/**
 *
 * @author joao.oliveira
 */
public class CoordenadorDAO {

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
