package data.access.object;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.OcorrenciaCoordenador;
import model.OcorrenciaSupervisor;

/**
 *
 * @author joao.oliveira
 */
public class DAOOcorrencia {

    public List getOcorrencias() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            data.access.object.DAOUtil Util = new data.access.object.DAOUtil();
            ResultSet rs = stm.executeQuery("SELECT OCORRENCIA AS OCORRENCIA FROM OCORRENCIAS ORDER BY 1");
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

    public List getOcorrenciasGestao() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            data.access.object.DAOUtil Util = new data.access.object.DAOUtil();
            ResultSet rs = stm.executeQuery("SELECT ocorrencia AS OCORRENCIA FROM ocorrencias_sup ORDER BY 1");
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

    public List getOcorrenciaPorControlador(String user) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            String d = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            DAOUtil Util = new DAOUtil();
            ResultSet var = stm.executeQuery("SELECT DIARIO.UF,DIARIO.ATENDENTE,DIARIO.DATA_ATT,DIARIO.PERIODO,"
                    + "TECNICOS.NOME AS TECNICO,DIARIO.SETOR_GRA_AREA,DIARIO.OCORRENCIAS,DIARIO.RECORRENCIA_SUP,"
                    + "DIARIO.RECORRENCIA_COORD,DIARIO.RECORRENCIA_GERENCIA,DIARIO.OBSERVACOES,DIARIO.GRAVE,"
                    + "DIARIO.USERNAME FROM DIARIO,TECNICOS WHERE DIARIO.TECNICO = TECNICOS.MAT AND DATE(DATA_ATT) ='" + d
                    + "' AND USERNAME='" + user + "' ORDER BY 2");
            List ocorrencias = Util.resultSetToArrayList(var);

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
