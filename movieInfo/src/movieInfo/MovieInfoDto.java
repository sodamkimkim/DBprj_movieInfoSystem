package movieInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieInfoDto {

	private int movieInfoNum;
	private String movieTitle;
	private String directorName;
	private int releaseYear;
	private int releaseMonth;
	private String moviePlot;	// 줄거리
	private int totalIncome;	// 매출액
	private int audience;	// 관객수
	private float rating;	// 영화평점
	private String review1;
	private String review2;
	private String review3;
	
	@Override
	public String toString() {
		return "영화제목 : " + movieTitle + ", 감독이름 : " 
				+ directorName + ", 개봉연도 : " + releaseYear + ", 개봉월 : " + releaseMonth + ", 매출액 : " + totalIncome + ", 관객수 : " + audience
				+ ", 평점 : " + rating; 
	}
}
