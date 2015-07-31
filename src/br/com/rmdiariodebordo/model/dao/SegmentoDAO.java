package br.com.rmdiariodebordo.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.com.rmdiariodebordo.model.vo.Segmento;

/**
 *
 * @author joao.oliveira
 */
public class SegmentoDAO {

    public ArrayList<Segmento> getListaSegmentos() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            String query = "SELECT segmento FROM SEGMENTOS ORDER BY 1";
            ResultSet rs = stm.executeQuery(query);
            ArrayList<Segmento> segmentos = new ArrayList<>();

            while (rs.next()) {
                Segmento Segmento = new Segmento();
                Segmento.setSegmento(rs.getString(1));
                segmentos.add(Segmento);
            }

            return segmentos;

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
