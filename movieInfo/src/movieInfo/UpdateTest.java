package movieInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest implements CallBack {

	private DBClient dbClient;
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	private UpdatePanel updatePanel;
	
	public UpdateTest() {
		dbClient = DBClient.getInstance();
		connection = dbClient.getConnection();
		preparedStatement = null;
		
		updatePanel = new UpdatePanel(this);
	}

	@Override
	public void update(String data1, String data2, String data3, String data4, String data5) {
		String updateQuery = "UPDATE test11 SET name = ?, age = ?, address = ?, gender = ?, birth_year = ? WHERE name = 2 ";

		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, data1);
			preparedStatement.setString(2, data2);
			preparedStatement.setString(3, data3);
			preparedStatement.setString(4, data4);
			preparedStatement.setString(5, data5);
			int result = preparedStatement.executeUpdate();
			
			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new UpdateTest();
	}
}
