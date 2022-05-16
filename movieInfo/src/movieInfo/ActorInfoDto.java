package movieInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorInfoDto {

	private int personNum;
	private int actorNum;
	private String representativeMovie;
	private String representativeRole;
	private String actorName;
	private String gender;
	private String birthYear;
	private String actorTall;
	private String actorWeight;
	private String marriagePartner;

	@Override
	public String toString() {
		return " 이름 : " + actorName + ", "
				+ " 출생연도 : " + birthYear
				+ " 성별 : " + gender
				+ " 대표작품 : " + representativeMovie 
				+ ", 대표역할 : " + representativeRole
				+  ", 키 : "+ actorTall + ", 몸무게 : "
				+ actorWeight + ", 배우자 : " 
				+ marriagePartner + "]";
	}

}
