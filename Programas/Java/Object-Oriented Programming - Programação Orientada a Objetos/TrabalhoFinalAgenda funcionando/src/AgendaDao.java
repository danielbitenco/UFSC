import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class AgendaDao {

	public boolean insertAgenda(agendaClass agenda) {
		
		boolean ok = true;
		try {
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "INSERT INTO agenda (id, name, address, birth, phone, email) " + 
						 "VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setInt(1, agenda.getId());
			comando.setString(2, agenda.getName());
			comando.setString(3, agenda.getAddress());
			comando.setString(4, agenda.getBirth());
			comando.setString(5, agenda.getPhone());
			comando.setString(6, agenda.getEmail());

			comando.execute();
			conexao.close();		
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}
	
//	public boolean updateAgenda(agendaClass agenda) {
//		
//		boolean ok = true;
//		try {
//			Connection conexao = ConnectionFactory.createConnection();
//			String sql = "UPDATE agenda name = ?, address = ?, birth = ?, phone = ?, email = ?" + 
//						 "WHERE id = ?;";
//			PreparedStatement comando = conexao.prepareStatement(sql);
//
//			comando.setInt(1, agenda.getId());
//			comando.setString(2, agenda.getName());
//			comando.setString(3, agenda.getAddress());
//			comando.setString(4, agenda.getBirth());
//			comando.setString(5, agenda.getPhone());
//			comando.setString(6, agenda.getEmail());
////			ByteArrayOutputStream baos = new ByteArrayOutputStream();
////			if (livro.getImagem() != null) { 
////				ImageIO.write(livro.getImagem(), "jpg", baos);
////				baos.flush();			
////				comando.setBytes(8, baos.toByteArray());
////				baos.close();
////			} else {
////				comando.setBytes(8, null);
////			}			
////			comando.setInt(9, agenda.getId());
//			
//			comando.execute();
//			conexao.close();		
//		} catch (Exception e) {
//			ok = false;
//		}
//		return ok;
//	}	
	
	public boolean deleteAgenda(agendaClass agenda) {
		
		boolean ok = true;
		try {
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "DELETE FROM agenda WHERE id = ?;";
			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setInt(1, agenda.getId());
			
			comando.execute();
			conexao.close();		
		} catch (Exception e) {
			ok = false;
		}
		return ok;
	}	
	
    public List<agendaClass> list() {
		ResultSet resultado = null;
		List<agendaClass> lista = new LinkedList<agendaClass>();
		try {
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM agenda ORDER BY id;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			resultado = comando.executeQuery();
			try {
				while (resultado.next()) {
					
					lista.add(new agendaClass(resultado.getInt("id"), resultado.getString("name"),
										resultado.getString("address"), resultado.getString("birth"),
										resultado.getString("phone"), resultado.getString("email")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}					
			conexao.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}        
        return lista;
    }	
    
    public agendaClass findById(int id) {
		ResultSet resultado = null;
		agendaClass ag = new agendaClass();
		try {
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM agenda WHERE id = ?;";

			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setInt(1, id);
			resultado = comando.executeQuery();
			try {
				if (resultado.next()) {

					
					ag.setId(resultado.getInt("id"));
					ag.setName(resultado.getString("name"));
					ag.setAddress(resultado.getString("address"));
					ag.setBirth(resultado.getString("birth"));
					ag.setPhone(resultado.getString("phone"));
					ag.setEmail(resultado.getString("email"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}					
			conexao.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}        
        return ag;
    }
    
   ;
}