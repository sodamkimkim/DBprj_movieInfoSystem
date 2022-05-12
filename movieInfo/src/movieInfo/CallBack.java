package movieInfo;

public interface CallBack {
	default void insert(String data1, String data2, String data3, String data4, String data5) {};
	default void update(String data1, String data2, String data3, String data4, String data5) {};
	
}
