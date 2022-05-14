package movieInfo;

import java.util.Vector;

public interface IMovieService {
	Vector<MovieInfoDto> selectMovieTitle(String searchWord);
	Vector<MovieInfoDto> selectAllMovieInfo();
	void insertMovieInfo(MovieInfoDto dto);
	int updateMovieInfo(int movieinfoNum, MovieInfoDto dto);
	int deleteMovieInfo(String movieTitle, String direntorName);
	boolean selectMovieDoubleCheck(String movieTitle, String movieDirector);
}
