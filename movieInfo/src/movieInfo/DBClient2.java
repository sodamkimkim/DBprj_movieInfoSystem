package movieInfo;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DBClient2 {

	private static final String DB_HOST = "localhost";
	private static final int DB_PORT = 3306;
	private final String DB_DATABASE_NAME; 
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "asd123";

	// 초기화를 해주지 않아도 기본값은 null
	private Connection conn = null;

	// 싱글톤 처리
	private static DBClient2 dbClient;

	private DBClient2(String dbName) {
		DB_DATABASE_NAME = dbName;
	}

	public static DBClient2 getInstance(String dbName) {
		if (dbClient == null) {
			dbClient = new DBClient2(dbName);
		}
		return dbClient;
	}

	public Connection getConnection() {

		if (conn == null) {
			// "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
			String urlFormat = "jdbc:mysql://%s:%d/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			
			String url = String.format(urlFormat, DB_HOST, DB_PORT, DB_DATABASE_NAME, DB_CHARSET);

			// MYYSQL JDBC 드라이버 클래스를 로딩해서 DriverManager 클래스에 등록한다.
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				// DriverManager 객체를 사용하여 DB에 접근
				conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
				System.out.println(">>> Connection Success <<<");

			} catch (Exception e) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		conn = null;

	}

}
