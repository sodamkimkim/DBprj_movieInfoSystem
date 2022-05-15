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
	public void insertStaffInfo(StaffInfoDto dto) {
		String insertQuery = "insert into personInfo(이름, 주민등록성별, 출생년도, 키, 몸무게, 배우자)" + " values(?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1,dto.getDirectorName());
			preparedStatement.setString(2, dto.getGender());
			preparedStatement.setInt(3, dto.getBirthYear());
			preparedStatement.setString(4, null);
			preparedStatement.setString(5, null);
			preparedStatement.setString(6, dto.getMarriagePartner());
			int result = preparedStatement.executeUpdate();
			System.out.println(result);
			
			insertQuery = "insert into staffInfo(personNum, 대표작품) values(?,?) ";
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, dto.getPersonNum());
			preparedStatement.setString(2,dto.getRepresentativeWork());
			 result = preparedStatement.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int updateStaffInfo(int staffInfoNum, StaffInfoDto dto) {
		String updateQuery = "UPDATE personinfo SET 이름 = ? , 주민등록성별 = ?, 출생년도=?, 배우자=? WHERE staffInfoNum = ? ";
		int result=-1;
		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, dto.getDirectorName());
			preparedStatement.setString(2,dto.getGender());
			preparedStatement.setInt(3, dto.getBirthYear());
			preparedStatement.setString(4, dto.getMarriagePartner());
			preparedStatement.setInt(5, staffInfoNum);
			result = preparedStatement.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		updateQuery = "UPDATE staffinfo SET 대표작품 = ? where staffInfoNum = ?";
		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, dto.getRepresentativeWork());
			preparedStatement.setInt(2, staffInfoNum);
			result = preparedStatement.executeUpdate();
		System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

			

	/**
	 * SELECT staff 중복검사 INSERT, DELETE 기능 수행하기전 중복을 검사한다.
	 */
	@Override
	public boolean selectStaffInfoDoubleCheck(String name) {

		// 중복 체크변수
		boolean doubleCheck = false;

		try {
			// 중복검사
			String selectCheckQuery = "SELECT * FROM view_staffinfoall WHERE 이름 = ? ";
			preparedStatement = connection.prepareStatement(selectCheckQuery);
			preparedStatement.setString(1, name);

			ResultSet checkRs = preparedStatement.executeQuery();
			while (checkRs.next()) {

				String staffInfoNumCheck = checkRs.getString("staffNum");

				// 중복이 아니라면 INSERT
				if (staffInfoNumCheck == null) {
					doubleCheck = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doubleCheck;
	}
	
	@Override
	public int deleteStaffInfo(int personNum) {
		
		int staffNum = -1;
		int result = -1;
		try {
			
			// SELECT
			// 선택한 staff가 몇번인지 
			String selectQuery = "SELECT * FROM staffinfo WHERE personNum = ? ";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, personNum);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				staffNum = rs.getInt("staffNum");
			}
			
			// DELETE
			String deleteQuery = "DELETE FROM staffinfo WHERE staffNum = ? ";
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, staffNum);
			result = preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	



}
