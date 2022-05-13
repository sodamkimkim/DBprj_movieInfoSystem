package movieInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DBClient {

	private static final String DB_HOST = "localhost";
	private static final int DB_PORT = 3306;
	private final String DB_DATABASE_NAME;
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "asd123";

	private Connection conn = null;

	private static DBClient dbClient;

	private DBClient(String dbName) {
		DB_DATABASE_NAME = dbName;
	}

	public static DBClient getInstance(String dbName) {
		if (dbClient == null) {
			dbClient = new DBClient(dbName);
		}
		return dbClient;
	}

	public Connection getConnection() {

		if (conn == null) {
			String urlFormat = "jdbc:mysql://%s:%d/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST, DB_PORT, DB_DATABASE_NAME, DB_CHARSET);

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
				System.out.println(">>> Connection Success <<<");

			} catch (Exception e) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		return conn;
	}

	public void connectionClose() {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		conn = null;
	}
}
