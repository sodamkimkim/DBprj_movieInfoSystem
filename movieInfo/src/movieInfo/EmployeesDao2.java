package movieInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.security.auth.callback.Callback;

public class EmployeesDao2 implements IMoiveGUI, CallBack{
                                                                                                              
	private DBClient2 client2;
	private Connection connection;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement;
	
	
	public EmployeesDao2() {
		client2 = DBClient2.getInstance("employees");
		connection = client2.getConnection();
	
	}

	@Override
	public Vector <EmployeesDto2> empolyeesInfo() {
		
		Vector <EmployeesDto2> dto2 = new Vector<>();
		
		try {
			String empolyeesInfo = "SELECT * FROM employees LIMIT 2";
			preparedStatement = connection.prepareStatement(empolyeesInfo);
			resultSet = preparedStatement.executeQuery();


			while(resultSet.next()) {
				EmployeesDto2 dto3 = new EmployeesDto2();
			dto3.setEmp_no(resultSet.getInt("emp_no"));
			dto3.setBirth_date(resultSet.getString("birth_date"));
			dto3.setFirst_name(resultSet.getString("first_name"));
			dto3.setLast_name(resultSet.getString("last_name"));
			dto3.setGender(resultSet.getString("gender"));
			dto3.setHire_date(resultSet.getString("hire_date"));
			
			dto2.add(dto3);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return dto2;
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

	public void update(String data1, String data2, String data3, String data4, String data5) {
		String updateQuery = "UPDATE test11 SET name = ?, age = ?, address = ?, gender = ?, birth_year = ? WHERE name = '홍길이' ";

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
	

}
