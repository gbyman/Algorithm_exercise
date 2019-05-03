package algorithm_sort;
//빈 소트와 분포수세기 소트에서 사용하는 데이터 형
public class BinSortData {

	// 키는 0부터 M까지의 정수
	static final int M = 100;
	
	private int key; // 정렬키, 0부터 M까지의 범위 내에 있어야 한다
	private Object data; // 그 외의 정보
	
//	정렬할 데이터를 생성한다
//	
//	@param key 키
//	@param data 그 외의 정보
	BinSortData(int key, Object data){
		//키가 범위내에 있는지 체크한다
		if(key < 0 || key > M) {
			throw new IllegalArgumentException("키 " + key + " 가 지정된 범위 밖에 있다");
		}
		this.key = key;
		this.data = data;
	}
	
//	키를 얻는다
//	
//	@return 키 값을 반환
	public final int getKey() {
		return key;
	}
	
//	그 외의 정보를 얻는다
//	
//	@return 그 외의 정보를 반환
	public final Object getData() {
		return data;
	}
}
