package data.access.object;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Controlador;

/**
 *
 * @author joao.oliveira
 */
public class DAOControlador {

    public void cadastrar_se(model.Controlador Controlador) {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();
            stm.executeUpdate("insert into usuarios(nome,mat,cargo,username,senha) values('"
                    + Controlador.getNome() + "','" + Controlador.getMatricula() + "','CONTROLADOR','"
                    + Controlador.getUsername() + "','" + Controlador.getSenha() + "')");
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

    public String getNome(String username) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {
            conn = Conexao.getConexao();
            stm = conn.createStatement();

            data.access.object.DAOUtil Util = new data.access.object.DAOUtil();
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

    public ArrayList<Controlador> getListaControladores() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            String query = "SELECT UPPER(nome) AS CONTROLADOR FROM usuarios WHERE cargo = 'CONTROLADOR' ORDER BY 1";
            ResultSet rs = stm.executeQuery(query);
            ArrayList<Controlador> controladores = new ArrayList<>();

            while (rs.next()) {
                Controlador Controlador = new Controlador();
                Controlador.setNome(rs.getString(1));
                controladores.add(Controlador);
            }

            return controladores;

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

    public ArrayList<Controlador> getListaControladoresCompleta() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            String query = "SELECT UPPER(nome),mat,senha FROM usuarios WHERE cargo = 'CONTROLADOR' ORDER BY 1";
            ResultSet rs = stm.executeQuery(query);
            ArrayList<Controlador> controladores = new ArrayList<>();

            while (rs.next()) {
                Controlador Controlador = new Controlador();
                Controlador.setNome(rs.getString(1));
                Controlador.setMatricula(rs.getInt(2));
                Controlador.setSenha(rs.getString(3));
                controladores.add(Controlador);
            }

            return controladores;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOControlador.class.getName()).log(Level.SEVERE, null, ex);
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

    public void registrarOcorrencia(model.OcorrenciaControlador Ocorrencia) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            stm.executeUpdate("INSERT INTO DIARIO(UF,ATENDENTE,DATA_ATT,PERIODO,TECNICO,SETOR_GRA_AREA,OCORRENCIAS,"
                    + "RECORRENCIA_SUP,RECORRENCIA_COORD,RECORRENCIA_GERENCIA,OBSERVACOES,GRAVE,USERNAME) VALUES('"
                    + Ocorrencia.getUf() + "','" + Ocorrencia.getAtendente() + "','" + Ocorrencia.getData() + "','" + Ocorrencia.getPeriodo()
                    + "','" + Ocorrencia.getTecnico() + "','" + Ocorrencia.getSetor() + "','" + Ocorrencia.getOcorrencia()
                    + "','" + Ocorrencia.getRecorrenciaSupervisor() + "','" + Ocorrencia.getRecorrenciaCoordenador()
                    + "','" + Ocorrencia.getRecorrenciaGerente() + "','" + Ocorrencia.getObservacao() + "','"
                    + Ocorrencia.getGrave() + "','" + Ocorrencia.getUsername() + "')");

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
