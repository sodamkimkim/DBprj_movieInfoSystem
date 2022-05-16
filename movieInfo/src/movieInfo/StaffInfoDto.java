package movieInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffInfoDto {
	private int staffNum;
	private int personNum;
	private String directorName;
	private String representativeWork;
	private String gender;
	private int birthYear;
	private String marriagePartner;

	@Override
	public String toString() {
		return "감독이름 : " + directorName + ", 대표작 : " + representativeWork + ", 성별 : " + gender + ", 출생년도: " + birthYear
				+ ", 배우자 : " + marriagePartner;
	}

}