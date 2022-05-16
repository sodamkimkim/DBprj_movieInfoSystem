package movieInfo_final;

import java.util.Vector;

public interface IMovieService {
	// 영화정보 영화이름으로 검색하기
	Vector<MovieInfoDto> selectMovieTitle(String searchWord);
	// 영화정보 전체 조회하기
	Vector<MovieInfoDto> selectAllMovieInfo();
	// 영화정보 INSERT, DELEDTE할때 중복체크하기
	boolean selectMovieDoubleCheck(String movieTitle, String movieDirector);
	// 영화정보 추가하기
	int insertMovieInfo(MovieInfoDto dto);
	// 영화정보 수정하기
	int updateMovieInfo(int movieinfoNum, MovieInfoDto dto);
	// 영화정보 삭제하기
	int deleteMovieInfo(String movieTitle, String direntorName);
}
