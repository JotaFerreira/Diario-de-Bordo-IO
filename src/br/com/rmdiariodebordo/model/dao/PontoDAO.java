package br.com.rmdiariodebordo.model.dao;

import br.com.rmdiariodebordo.model.vo.Ponto;
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
public class PontoDAO {

    public ArrayList<Ponto> getNomesPerfis() {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            ResultSet var = stm.executeQuery("SELECT perfil FROM horarios ORDER BY 1 DESC");

            ArrayList<Ponto> perfis = new ArrayList<>();

            while (var.next()) {

                Ponto perfil = new Ponto();
                perfil.setNome(var.getString(1));
                perfis.add(perfil);

            }

            return perfis;

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

    public ArrayList<Ponto> getHorariosPorPerfil(String nmPerfil) {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            ResultSet var = stm.executeQuery("SELECT horario1,horario2,horario3,horario4,horario5,horario6,horario7,"
                    + "horario8 FROM horarios WHERE perfil='" + nmPerfil + "'");

            ArrayList<Ponto> perfis = new ArrayList<>();

            while (var.next()) {

                Ponto perfil = new Ponto();
                perfil.setHorario1(var.getString(1));
                perfil.setHorario2(var.getString(2));
                perfil.setHorario3(var.getString(3));
                perfil.setHorario4(var.getString(4));
                perfil.setHorario5(var.getString(5));
                perfil.setHorario6(var.getString(6));
                perfil.setHorario7(var.getString(7));
                perfil.setHorario8(var.getString(8));
                perfis.add(perfil);

            }

            return perfis;

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

    public boolean inserirPerfil(Ponto perfil) {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            stm.executeUpdate("INSERT INTO horarios values('" + perfil.getNome() + "','" + perfil.getHorario1()
                    + "','" + perfil.getHorario2() + "','" + perfil.getHorario3() + "','" + perfil.getHorario4() + "','"
                    + perfil.getHorario5() + "','" + perfil.getHorario6() + "','" + perfil.getHorario7() + "','"
                    + perfil.getHorario8() + "')");

            return true;

        } catch (SQLException | ClassNotFoundException ex) {

            if (ex.toString().contains("UNIQUE constraint failed")) {

                JOptionPane.showMessageDialog(null, "Erro: O nome do perfil já existe!", "Erro", JOptionPane.ERROR_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Erro:" + ex, "Erro", JOptionPane.ERROR_MESSAGE);

            }
            return false;

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
