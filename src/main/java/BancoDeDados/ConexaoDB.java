package BancoDeDados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    /*

   Digite aqui as informações referentes ao SEU banco de dados.
   Os valores “seu_banco”, “seu_usuario” e “sua_senha” devem ser substituídos, respectivamente,
   pelo nome do seu banco, seu usuário e sua senha do MySQL Workbench

    */
    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "bd_UBS";
    private static String usuario = "root";
    private static String senha = "1234";

    public static Connection obtemConexao (){
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + db + "?useTimezone=true&serverTimezone=UTC", usuario,senha);
            System.out.println("Banco conectado com sucesso!");
            return c;
        }
        catch (SQLException e){
            System.out.println("Banco não conectado!");
            e.getStackTrace();
            return null;
        }
    }

}
