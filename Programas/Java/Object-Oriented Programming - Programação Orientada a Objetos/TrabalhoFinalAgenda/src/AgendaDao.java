import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AgendaDao {

	public boolean insertAgenda(agendaClass agenda) {

		boolean ok = true;
		try {
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "INSERT INTO agenda (id, name, address, birth, phone, email) "
					+ "VALUES (null, ?, ?, ?, ?, ?);";
			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, agenda.getName());
			comando.setString(2, agenda.getAddress());
			comando.setString(3, agenda.getBirth());
			comando.setString(4, agenda.getPhone());
			comando.setString(5, agenda.getEmail());

			comando.execute();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}

	public boolean updateAgenda(agendaClass agenda) {

		boolean ok = true;
		try {

			Connection conexao = ConnectionFactory.createConnection();
			String sql = "UPDATE agenda SET name = ?, address = ?, birth = ?, phone = ?, email = ? WHERE id = ?;";
			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, agenda.getName());
			comando.setString(2, agenda.getAddress());
			comando.setString(3, agenda.getBirth());
			comando.setString(4, agenda.getPhone());
			comando.setString(5, agenda.getEmail());
			comando.setString(6, String.valueOf(agenda.getId()));

			comando.execute();
			conexao.close();
		} catch (Exception e) {
			ok = false;
		}
		return ok;
	}

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

	public ArrayList list() {
		ResultSet resultado = null;
		ArrayList<Object[]> lista = new ArrayList();
		try {
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM agenda ORDER BY id;";

			PreparedStatement comando = conexao.prepareStatement(sql);
			resultado = comando.executeQuery();
			try {
				while (resultado.next()) {

					lista.add(new Object[] { resultado.getInt("id"), resultado.getString("name"),
							resultado.getString("phone") });

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

	public ArrayList<Integer> findJustIds() {
		ResultSet resultado = null;
		ArrayList<Integer> lista = new ArrayList<Integer>();
		try {
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM agenda ORDER BY id;";
			agendaClass ag = new agendaClass();

			PreparedStatement comando = conexao.prepareStatement(sql);
			resultado = comando.executeQuery();
			try {
				while (resultado.next()) {
					ag.setId(resultado.getInt("id"));

					lista.add(ag.getId());

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