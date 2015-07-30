package data.access.object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joao.oliveira
 */
public class Conexao {

    public static final String ARQUIVO = "\\" + "\\cefsv001\\ARQUIVOS\\CONTROLE LOCAL DIR_CE\\APPS\\App_Data\\Data\\diariodebordo2.db";
    // public static final String ARQUIVO = "c:\\diariodebordoLOCAL.db";

    public static Connection getConexao() throws SQLException, ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection("jdbc:sqlite:" + ARQUIVO);

        //   FileSystemView fs = FileSystemView.getFileSystemView();
        // File[] roots = File.listRoots();
        // String caminho = "c:\\diariodebordoLOCAL.db";
//        for (File file : roots) {
//
//            Path path = Paths.get(file + "\\CONTROLE LOCAL DIR_CE\\APPS\\App_Data\\Data\\diariodebordo2.db");
//            //  Path path = Paths.get(caminho);
//
//            if (Files.exists(path)) {
//
//                arquivo = file + "\\CONTROLE LOCAL DIR_CE\\APPS\\App_Data\\Data\\diariodebordo2.db";
//                //      arquivo = caminho;
//
//            }
//
//        }
        // System.out.println(file + "  " + fs.getSystemTypeDescription(file));
    }

}
