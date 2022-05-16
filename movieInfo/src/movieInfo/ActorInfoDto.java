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
		return actorName;
	}

}
