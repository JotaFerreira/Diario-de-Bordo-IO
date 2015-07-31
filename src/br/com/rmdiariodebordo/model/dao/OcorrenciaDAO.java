package br.com.rmdiariodebordo.model.dao;

import br.com.rmdiariodebordo.model.vo.Ocorrencia;
import br.com.rmdiariodebordo.model.vo.OcorrenciaControlador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import br.com.rmdiariodebordo.model.vo.OcorrenciaCoordenador;
import br.com.rmdiariodebordo.model.vo.OcorrenciaSupervisor;

/**
 *
 * @author joao.oliveira
 */
public class OcorrenciaDAO {

    public ArrayList<Ocorrencia> getOcorrenciasControlador() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT ocorrencia FROM ocorrencias ORDER BY 1");
            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();

            while (rs.next()) {
                Ocorrencia o = new Ocorrencia();
                o.setNome(rs.getString(1));
                ocorrencias.add(o);
            }
            
            return ocorrencias;

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

    public ArrayList<Ocorrencia> getOcorrenciasGestao() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("SELECT ocorrencia AS OCORRENCIA FROM ocorrencias_sup ORDER BY 1");
            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
            
            while(rs.next()){
                Ocorrencia o = new Ocorrencia();
                o.setNome(rs.getString(1));
                ocorrencias.add(o);
            }

            return ocorrencias;

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

    public ArrayList<OcorrenciaControlador> getOcorrenciaPorControlador(String user) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            String d = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            ResultSet var = stm.executeQuery("SELECT DIARIO.UF,DIARIO.ATENDENTE,DIARIO.DATA_ATT,DIARIO.PERIODO,"
                    + "TECNICOS.NOME AS TECNICO,DIARIO.SETOR_GRA_AREA,DIARIO.OCORRENCIAS,DIARIO.RECORRENCIA_SUP,"
                    + "DIARIO.RECORRENCIA_COORD,DIARIO.RECORRENCIA_GERENCIA,DIARIO.OBSERVACOES,DIARIO.GRAVE,"
                    + "DIARIO.USERNAME FROM DIARIO,TECNICOS WHERE DIARIO.TECNICO = TECNICOS.MAT AND DATE(DATA_ATT) ='" + d
                    + "' AND USERNAME='" + user + "' ORDER BY 2");
            ArrayList<OcorrenciaControlador> ocorrencias = new  ArrayList<>();
            
            while(var.next()){
                OcorrenciaControlador o = new OcorrenciaControlador();
                o.setUf(var.getString(1));
                o.setAtendente(var.getString(2));
                o.setData(var.getString(3));
                o.setPeriodo(var.getString(4));
                o.setTecnico(var.getString(5));
                o.setSetor(var.getString(6));
                o.setOcorrencia(var.getString(7));
                o.setRecorrenciaSupervisor(var.getString(8));
                o.setRecorrenciaCoordenador(var.getString(9));
                o.setRecorrenciaGerente(var.getString(10));
                o.setObservacao(var.getString(11));
                o.setGrave(var.getString(12));
                o.setUsername(var.getString(13));
                ocorrencias.add(o);
            }

            return ocorrencias;

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

    public ArrayList<OcorrenciaSupervisor> getOcorrenciaPorSupervisor(String user) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            String d = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            ResultSet var = stm.executeQuery("SELECT data_att,uf,segmento,controlador,ocorrencia,periodo,observacao FROM "
                    + "diario_sup WHERE DATE(data_att) = '" + d + "' AND username ='" + user + "' ORDER BY 1 ASC");

            ArrayList<OcorrenciaSupervisor> ocorrencias = new ArrayList<>();

            while (var.next()) {

                OcorrenciaSupervisor ocorrencia = new OcorrenciaSupervisor();

                ocorrencia.setData_att(var.getString(1));
                ocorrencia.setUf(var.getString(2));
                ocorrencia.setSegmento(var.getString(3));
                ocorrencia.setControlador(var.getString(4));
                ocorrencia.setOcorrencia(var.getString(5));
                ocorrencia.setPeriodo(var.getString(6));
                ocorrencia.setObservacao(var.getString(7));

                ocorrencias.add(ocorrencia);

            }

            return ocorrencias;

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

    public ArrayList<OcorrenciaSupervisor> getOcorrenciaPorSupervisorFiltro(String user, String controlador, String data) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            String queryControlador = controlador.isEmpty() ? "" : " AND controlador ='" + controlador + "' ";
            String queryData = data.isEmpty() | data.equals("--") ? "" : "AND DATE(data_att) ='" + data + "'";
            ResultSet var = stm.executeQuery("SELECT data_att,uf,segmento,controlador,ocorrencia,periodo,observacao FROM "
                    + "diario_sup WHERE username ='" + user + "' " + queryData + queryControlador + " ORDER BY 1 ASC");

            ArrayList<OcorrenciaSupervisor> ocorrencias = new ArrayList<>();

            while (var.next()) {

                OcorrenciaSupervisor ocorrencia = new OcorrenciaSupervisor();

                ocorrencia.setData_att(var.getString(1));
                ocorrencia.setUf(var.getString(2));
                ocorrencia.setSegmento(var.getString(3));
                ocorrencia.setControlador(var.getString(4));
                ocorrencia.setOcorrencia(var.getString(5));
                ocorrencia.setPeriodo(var.getString(6));
                ocorrencia.setObservacao(var.getString(7));

                ocorrencias.add(ocorrencia);

            }

            return ocorrencias;

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

    public ArrayList<OcorrenciaCoordenador> getOcorrenciaPorCoordenador(String user) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            String d = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            ResultSet var = stm.executeQuery("SELECT data_att,uf,segmento,supervisor,ocorrencia,periodo,observacao FROM "
                    + "diario_coo WHERE DATE(data_att) ='" + d + "' AND username ='" + user + "' ORDER BY 1 ASC");

            ArrayList<OcorrenciaCoordenador> ocorrencias = new ArrayList<>();

            while (var.next()) {

                OcorrenciaCoordenador ocorrencia = new OcorrenciaCoordenador();
                ocorrencia.setData_att(var.getString(1));
                ocorrencia.setUf(var.getString(2));
                ocorrencia.setSegmento(var.getString(3));
                ocorrencia.setSupervisor(var.getString(4));
                ocorrencia.setOcorrencia(var.getString(5));
                ocorrencia.setPeriodo(var.getString(6));
                ocorrencia.setObservacao(var.getString(7));

                ocorrencias.add(ocorrencia);

            }

            return ocorrencias;

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

    public ArrayList<OcorrenciaCoordenador> getOcorrenciaPorCoordenadorFiltro(String user, String supervisor, String data) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            String querySupervisor = supervisor.isEmpty() ? "" : " AND supervisor ='" + supervisor + "' ";
            String queryData = data.isEmpty() | data.equals("--") ? "" : "AND DATE(data_att) ='" + data + "'";
            ResultSet var = stm.executeQuery("SELECT data_att,uf,segmento,supervisor,ocorrencia,periodo,observacao FROM "
                    + "diario_coo WHERE username ='" + user + "' " + queryData + querySupervisor + " ORDER BY 1 ASC");

            ArrayList<OcorrenciaCoordenador> ocorrencias = new ArrayList<>();

            while (var.next()) {

                OcorrenciaCoordenador ocorrencia = new OcorrenciaCoordenador();

                ocorrencia.setData_att(var.getString(1));
                ocorrencia.setUf(var.getString(2));
                ocorrencia.setSegmento(var.getString(3));
                ocorrencia.setSupervisor(var.getString(4));
                ocorrencia.setOcorrencia(var.getString(5));
                ocorrencia.setPeriodo(var.getString(6));
                ocorrencia.setObservacao(var.getString(7));

                ocorrencias.add(ocorrencia);

            }

            return ocorrencias;

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
