package movieInfo_final;

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
		return directorName;
	}

}