package movieInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsertTest2{

	private DBClient dbClient;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private InsertPanel insertPanel;

	public InsertTest2() {
		dbClient = DBClient.getInstance();
		connection = dbClient.getConnection();
		preparedStatement = null;
		insertPanel = new InsertPanel();
	}

	
	public void insert(String data1, String data2, String data3, String data4, String data5) {
		String insertQuery = "INSERT INTO test11 VALUES(?, ?, ?, ?, ?)";

		try {
			preparedStatement = connection.prepareStatement(insertQuery);
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
		InsertTest2 dataTest = new InsertTest2();
	}
}
