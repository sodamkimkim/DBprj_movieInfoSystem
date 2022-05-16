package movieInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StaffInfoDao implements IStaffService {

	private DBClient dbClient;
	private Connection connection;
	private PreparedStatement preparedStatement;

	StaffInfoDao() {
		dbClient = DBClient.getInstance("movieinfo");
		connection = dbClient.getConnection();
	}

	/**
	 * select - staff이름으로 정보조회
	 */
	@Override
	public Vector<StaffInfoDto> selectDirectorName(String searchWord) {
		Vector<StaffInfoDto> selectDirectorNameDtos = new Vector<>();
		String selectDirectorNameQuery = "select * from view_staffInfoAll where 이름 = ? ";
		try {
			preparedStatement = connection.prepareStatement(selectDirectorNameQuery);
			preparedStatement.setString(1, searchWord);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				StaffInfoDto dto = new StaffInfoDto();
				dto.setDirectorName(resultSet.getString("이름"));
				dto.setBirthYear(resultSet.getInt("출생년도"));
				dto.setGender(resultSet.getString("주민등록성별"));
				dto.setMarriagePartner(resultSet.getString("배우자"));
				dto.setPersonNum(resultSet.getInt("personNum"));
				dto.setRepresentativeWork(resultSet.getString("대표작품"));
				dto.setStaffNum(resultSet.getInt("staffNum"));

				selectDirectorNameDtos.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectDirectorNameDtos;
	}

	@Override
	public Vector<StaffInfoDto> selectAllStaffInfo() {
		Vector<StaffInfoDto> staffInfoDtos = new Vector<>();
		String selectAllStaffInfoQuery = "SELECT * FROM view_staffinfoall ";
		try {
			preparedStatement = connection.prepareStatement(selectAllStaffInfoQuery);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				StaffInfoDto dto = new StaffInfoDto();
				dto.setDirectorName(resultSet.getString("이름"));
				dto.setBirthYear(resultSet.getInt("출생년도"));
				dto.setGender(resultSet.getString("주민등록성별"));
				dto.setMarriagePartner(resultSet.getString("배우자"));
				dto.setPersonNum(resultSet.getInt("personNum"));
				dto.setRepresentativeWork(resultSet.getString("대표작품"));
				dto.setStaffNum(resultSet.getInt("staffNum"));
				staffInfoDtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staffInfoDtos;

	}

	@Override
	public int insertStaffInfo(StaffInfoDto dto) {
		
		String insertQuery = "insert into personInfo(이름, 주민등록성별, 출생년도, 키, 몸무게, 배우자)" + " values(?,?,?,?,?,?)";
		int result = -1;
		
		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1,dto.getDirectorName());
			preparedStatement.setString(2, dto.getGender());
			preparedStatement.setInt(3, dto.getBirthYear());
			preparedStatement.setString(4, null);
			preparedStatement.setString(5, null);
			preparedStatement.setString(6, dto.getMarriagePartner());
			result = preparedStatement.executeUpdate();
			
			
			// SELECT
			// movieinfoNum을 조회하기 위함.
			String selectQuery = "SELECT * FROM personInfo WHERE 이름 = ? AND 출생년도 = ?";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, dto.getDirectorName());
			preparedStatement.setInt(2, dto.getBirthYear());
			ResultSet resultSet = preparedStatement.executeQuery();
			int personNum = 0;
			while (resultSet.next()) {
				personNum = resultSet.getInt("personNum");
			}
	
			insertQuery = "insert into staffInfo(personNum,대표작품) values(?,?) ";
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1,personNum);
			preparedStatement.setString(2,dto.getRepresentativeWork());
			result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateStaffInfo(int staffInfoNum, StaffInfoDto dto) {
		System.out.println("staffInfoNum : "+staffInfoNum);
		String updateQuery = "UPDATE personinfo SET 이름 = ? , 주민등록성별 = ?, 출생년도=?, 배우자=? WHERE personNum = ? ";
		int result=-1;
		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, dto.getDirectorName());
			preparedStatement.setString(2,dto.getGender());
			preparedStatement.setInt(3, dto.getBirthYear());
			preparedStatement.setString(4, dto.getMarriagePartner());
			preparedStatement.setInt(5, dto.getPersonNum());
			result = preparedStatement.executeUpdate();
			System.out.println("result : "+result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		updateQuery = "UPDATE staffinfo SET 대표작품 = ? where staffNum = ? ";
		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, dto.getRepresentativeWork());
			preparedStatement.setInt(2, staffInfoNum);
			result = preparedStatement.executeUpdate();
		System.out.println("result : "+result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("result: " + result);
		return result;

	}

			

	/**
	 * SELECT staff 중복검사 INSERT, DELETE 기능 수행하기전 중복을 검사한다.
	 */
	@Override
	public boolean selectStaffInfoDoubleCheck(String directorName, int birthYear) {

		// 중복 체크변수
		boolean doubleCheck = false;

		try {
			// 중복검사
			String selectCheckQuery = "SELECT * FROM view_staffinfoall WHERE 이름 = ? and 출생년도 = ?";
			preparedStatement = connection.prepareStatement(selectCheckQuery);
			preparedStatement.setString(1, directorName);
			preparedStatement.setInt(2, birthYear);

			ResultSet checkRs = preparedStatement.executeQuery();
			String staffInfoNumCheck = "";
			while (checkRs.next()) {

			 staffInfoNumCheck = checkRs.getString("staffNum");
			}
			System.out.println("test");
			
			// 중복이 아니라면 INSERT
			if (staffInfoNumCheck == "") {
				doubleCheck = true; //
				System.out.println(doubleCheck);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(doubleCheck); //false뜨네
		return doubleCheck;
	}
	
	@Override
	public int deleteStaffInfo(int staffInfoNum) {
		
		int staffNum = -1;
		int result = -1;
		try {
			
//			// SELECT
//			// 선택한 staff가 몇번인지 
//			String selectQuery = "SELECT * FROM staffinfo WHERE staffNum = ? ";
//			preparedStatement = connection.prepareStatement(selectQuery);
//			preparedStatement.setInt(1, staffInfoNum);
//			ResultSet rs = preparedStatement.executeQuery();
//
//			while (rs.next()) {
//				staffNum = rs.getInt("staffNum");
//			}
			
			// DELETE
			String deleteQuery = "DELETE FROM staffinfo WHERE staffNum = ? ";
			System.out.println(staffInfoNum);
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, staffNum);
			result = preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	



}