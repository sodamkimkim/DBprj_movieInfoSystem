package movieInfo;

import java.util.Vector;

public interface IMovieService {
	Vector<MovieInfoDto> selectMovieTitle(String searchWord);
	Vector<MovieInfoDto> selectAllMovieInfo();
	void insertMovieInfo(MovieInfoDto dto);
	void updateMovieInfo(int movieinfoNum, MovieInfoDto dto);
	void deleteMovieInfo();
}
