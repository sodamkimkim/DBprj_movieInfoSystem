package movieInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBClient {

	private static final String DB_HOST = "localhost";
	private static final int PORT = 3306;
	private static final String DB_DATABASE_NAME = "employees";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "asd123";

	private Connection connection;

	private static DBClient dbClient;

	private DBClient() {
	}

	public static DBClient getInstance() {
		if (dbClient == null) {
			dbClient = new DBClient();
		}
		return dbClient;
	}

	public Connection getConnection() {
		if (connection == null) {

			String urlFomat = "jdbc:mysql://%s:%d/%s?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
			String url = String.format(urlFomat, DB_HOST, PORT, DB_DATABASE_NAME);

			try {
				// 드라이버를 힙메모리에 올리는 작업
				Class.forName("com.mysql.cj.jdbc.Driver");

				// 소켓 통신과 같은 연결 작업
				connection = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);

			} catch (ClassNotFoundException e) {
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

}
