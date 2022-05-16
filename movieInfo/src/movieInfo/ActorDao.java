package movieInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ActorDao implements IActorService {

	private DBClient dbClient;
	private Connection connection;
	private PreparedStatement preparedStatement;

	ActorDao() {
		dbClient = DBClient.getInstance("movieinfo");
		connection = dbClient.getConnection();
	}

	@Override
	public Vector<ActorInfoDto> selectActorInfor(String searchWord) {

		Vector<ActorInfoDto> selectActorInfordto = new Vector<>();

		try {

			String selectActorInforQuery = "SELECT * FROM view_actorInfoAll WHERE 이름 = ? ";
			preparedStatement = connection.prepareStatement(selectActorInforQuery);
			preparedStatement.setString(1, searchWord);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				ActorInfoDto dto = new ActorInfoDto();

				dto.setRepresentativeMovie(resultSet.getString("대표작품"));
				dto.setRepresentativeRole(resultSet.getString("대표역할"));
				dto.setActorName(resultSet.getString("이름"));
				dto.setBirthYear(resultSet.getString("출생년도"));
				dto.setGender(resultSet.getString("주민등록성별"));
				dto.setActorTall(resultSet.getString("키"));
				dto.setActorWeight(resultSet.getString("몸무게"));
				dto.setMarriagePartner(resultSet.getString("배우자"));

				selectActorInfordto.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectActorInfordto;
	}

	@Override
	public Vector<ActorInfoDto> selectAllActorInfor() {

		Vector<ActorInfoDto> dto = new Vector<>();

		try {

			String actorAllInfo = "select * from view_actorInfoAll";
			preparedStatement = connection.prepareStatement(actorAllInfo);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				ActorInfoDto dto1 = new ActorInfoDto();
				dto1.setActorNum(resultSet.getInt("actorNum"));
				dto1.setRepresentativeMovie(resultSet.getString("대표작품"));
				dto1.setRepresentativeRole(resultSet.getString("대표역할"));
				dto1.setActorName(resultSet.getString("이름"));
				dto1.setBirthYear(resultSet.getString("출생년도"));
				dto1.setGender(resultSet.getString("주민등록성별"));
				dto1.setActorTall(resultSet.getString("키"));
				dto1.setActorWeight(resultSet.getString("몸무게"));
				dto1.setMarriagePartner(resultSet.getString("배우자"));
				dto1.setPersonNum(resultSet.getInt("personNum"));
				dto.add(dto1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insertActorInfo(ActorInfoDto dto) {
		
		String insertQuery = "insert into personInfo(이름, 주민등록성별, 출생년도, 키, 몸무게, 배우자) values(?,?,?,?,?,?)";
		int result = -1;
		
		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, dto.getActorName());
			preparedStatement.setString(2, dto.getGender());
			preparedStatement.setString(3, dto.getBirthYear());
			preparedStatement.setString(4, dto.getActorTall());
			preparedStatement.setString(5, dto.getActorWeight());
			preparedStatement.setString(6, dto.getMarriagePartner());
			result = preparedStatement.executeUpdate();
			System.out.println(result);

			insertQuery = "insert into actorInfo(personNum, 대표작품, 대표역할) values(?,?,?) ";
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, dto.getPersonNum());
			preparedStatement.setString(2, dto.getRepresentativeMovie());
			preparedStatement.setString(3, dto.getRepresentativeRole());
			result = preparedStatement.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public boolean selectActorDoubleCheck(String actorName) {

		// 중복 체크변수
		boolean doubleCheck = false;
		String actorInfoNumCheck = "";
		try {
			// 중복검사
			String selectCheckQuery = "SELECT * FROM view_actorInfoAll WHERE 이름 = ?";
			preparedStatement = connection.prepareStatement(selectCheckQuery);
			preparedStatement.setString(1, actorName);
			ResultSet checkRs = preparedStatement.executeQuery();

			while (checkRs.next()) {

				actorInfoNumCheck = checkRs.getString("actorNum");

			}
			
			if (actorInfoNumCheck == null) {
				doubleCheck = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doubleCheck;
	}

	@Override
	public int deleteActorInfo(int personNum) {

		int actorNum = -1;
		int result = -1;
		try {

			// SELECT
			// 선택한 영화가 몇번인지
			String selectQuery = "SELECT * FROM view_actorInfoAll WHERE personNum = ? ";
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, personNum);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				actorNum = rs.getInt("actorNum");

			}

			// DELETE
			String deleteQuery = "DELETE FROM actorInfo WHERE actorNum = ? ";
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, actorNum);
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateActorInfo(int personNum, ActorInfoDto dto) {

		int result = -1;

		try {
			// UPDATE
			// 테이블 - personInfo / 이름, 주민등록성별, 키, 몸무게, 배우자
			String updateQuery = "UPDATE personInfo SET 이름 = ? , 주민등록성별 = ? , 출생년도 = ? ,  키 = ? , 몸무게 = ?, 배우자 = ?WHERE personNum = ?";
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, dto.getActorName());
			preparedStatement.setString(2, dto.getGender());
			preparedStatement.setString(3, dto.getBirthYear());
			preparedStatement.setString(4, dto.getActorTall());
			preparedStatement.setString(5, dto.getActorWeight());
			preparedStatement.setString(6, dto.getMarriagePartner());
			preparedStatement.setInt(7, personNum);
			result = preparedStatement.executeUpdate();
			System.out.println(result);

			// UPDATE
			// 테이블 - actorInfo / 대표작품, 대표역할
			updateQuery = "UPDATE actorInfo SET 대표작품 = ? , 대표역할 = ? WHERE personNum = ? ";
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, dto.getRepresentativeMovie());
			preparedStatement.setString(2, dto.getRepresentativeRole());
			preparedStatement.setInt(3, personNum);
			result = preparedStatement.executeUpdate();
			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
