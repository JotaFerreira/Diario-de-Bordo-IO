package data.access.object;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author joao.oliveira
 */
public class Conexao {


    public static Connection getConexao() throws SQLException, ClassNotFoundException {

        FileSystemView fs = FileSystemView.getFileSystemView();
        File[] roots = File.listRoots();
        String arquivo = "";
       // String caminho = "c:\\diariodebordoLOCAL.db";

        for (File file : roots) {

             Path path = Paths.get(file + "\\CONTROLE LOCAL DIR_CE\\APPS\\App_Data\\Data\\diariodebordo.db");
           // Path path = Paths.get(caminho);

            if (Files.exists(path)) {

                   arquivo = file + "\\CONTROLE LOCAL DIR_CE\\APPS\\App_Data\\Data\\diariodebordo.db";
              //  arquivo = caminho;

            }

        }
        // System.out.println(file + "  " + fs.getSystemTypeDescription(file));

        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection("jdbc:sqlite:" + arquivo);

    }

}
