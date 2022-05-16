package movieInfo;

import java.util.Vector;

public interface IStaffService {
	//감독이름으로 staff정보 검색
	Vector<StaffInfoDto> selectDirectorName(String searchWord);
	//모든 staff정보 검색
	Vector<StaffInfoDto> selectAllStaffInfo();
	//staff정보 insert
	void insertStaffInfo(StaffInfoDto dto);
	//staff정보 update
	int updateStaffInfo(int staffInfoNum, StaffInfoDto dto);
	// 중복체크
	boolean selectStaffInfoDoubleCheck(String directorName, int birthYear);
	//staff정보 삭제
	int deleteStaffInfo(int staffInfoNum);

}