package br.com.rmdiariodebordo.model.dao;

import br.com.rmdiariodebordo.model.vo.Periodo;
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
public class PeriodoDAO {

    public ArrayList<Periodo> getPeriodos() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("SELECT periodo FROM periodos ORDER BY 1");
            ArrayList<Periodo> periodos = new ArrayList<>();
            
            while(rs.next()){
                Periodo p = new Periodo();
                p.setValorPeriodo(rs.getString(1));
                periodos.add(p);
            }

            return periodos;

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
