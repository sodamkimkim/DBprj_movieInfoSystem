package movieInfo_final;

import java.util.Vector;

public interface IActorService {
	
	Vector<ActorInfoDto> selectActorInfor(String searchWord);
	
	Vector<ActorInfoDto> selectAllActorInfor();
	
	int insertActorInfo(ActorInfoDto dto);

	boolean selectActorDoubleCheck(String actorName);

	int deleteActorInfo(int personN);
	
	int updateActorInfo(int personNum, ActorInfoDto dto);
}