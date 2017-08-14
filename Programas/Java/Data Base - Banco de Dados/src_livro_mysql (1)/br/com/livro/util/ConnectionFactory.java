
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection createConnection() {		
		String stringDeConexao = "jdbc:mysql://localhost:3306/agenda";
		String usuario = "root";
		String senha = "1234";

		Connection conexao = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conexao;
	}	    
}
