package algorithm_sort;
// 기수 소트에 사용할 데이터 형
public class RadixSortData {
	
	final static int KEY_MAX = 0xffff; //키 최대값
	private int key;// 정렬 키
					// 0 ~ 65535(0xffff)의 범위 내에 있어야 한다
	private Object data;// 그 외의 정보
	
//	정렬할 데이터를 생성한다
//	
//	@param key 키
//	@param data 그 외의 정보
	RadixSortData(int key, Object data){
		
		// 키가 범위 내에 있는 지 체크한다
		if(key < 0 || key > KEY_MAX	) {
			throw new IllegalArgumentException("키 " + key + "가 지정된 범위 밖에 있다.");
		}
		
		this.key = key;
		this.data = data;
	}
	
//	키를 얻는다
//	
//	@return 키 값을 반환
	public int getKey() {
		return key;
	}
	
//	그 외의 정보를 얻는다
//	
//	@return 그 외의 정보를 반환
	public Object getData() {
		return data;
	}
}
