package algorithm;

public class BinarySearch {
	
	//테이블의 요소
	class Entry{
		
		int key;	//비교 대상이 되는 키
		Object data;	//그 외의 정보
		
		//요소를 생성한다
		//@param key	키
		//@param data	key에 대응하는 데이터
		
		public Entry(int key, Object data) {
			
			this.key = key;
			this.data = data;
		}
		
	}
	
	final static int MAX = 100;	//데이터의 최대 개수
	Entry[] table = new Entry[MAX];	//데이터를 저장할 배열
	int n = 0;	//table에 등록되어있는 데이터의 개수
	
	//add 메서드 생략된 상태
	
	
	//키 key에 대응하는 데이터를 찾는다.
	//@param key 키
	//@param key에 대응하는 데이터. 키를 찾지 못하면 null을 반환
	public Object search(int key) {
		
		int low, high, middle;
		
		low = 0;	//(1)
		high = n - 1;	//(2)
		
		while(low <= high) {	//(3)
			middle = (low + high) / 2;	//(4)
			if(key == table[middle].key) {	//(5)
				return table[middle].data;	//(6) 찾았다
			} else if(key < table[middle].key) {	//(7)
				high = middle - 1;	//(8)
			} else {	// key > table[middle].key이다.
				low = middle + 1;	//(9)
			}
		}
		return null;	//(10) 찾지 못했다.
	}

}
