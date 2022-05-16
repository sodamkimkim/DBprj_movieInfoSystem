package movieInfo;

import java.util.Vector;

public interface IStaffService {
	Vector<StaffInfoDto> selectDirectorName(String searchWord);

	Vector<StaffInfoDto> selectAllStaffInfo();

	void insertStaffInfo(StaffInfoDto dto);

	int updateStaffInfo(int staffInfoNum, StaffInfoDto dto);


	boolean selectStaffInfoDoubleCheck(String directorName, int birthYear);

	int deleteStaffInfo(int staffInfoNum);

}