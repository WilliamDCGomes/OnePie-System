package controle;
import java.sql.*;
import javax.swing.JOptionPane;
public class ModuloConexao {
    public static Connection conector(){
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbprometheus?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password="";
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERRO AO SE CONECTAR COM O BANCO DE DADOS\nERRO:" + e);
            return null;
        }
    }
}
