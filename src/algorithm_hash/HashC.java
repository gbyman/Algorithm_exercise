package algorithm_hash;

// 체인화를 이용한 해쉬 표

public class HashC {

	//연결 리스트의 셀
	private class Cell{
		MyKey key;	//키
		Object data; //데이터
		Cell next; //다음 셀로의 링크
		
//		셀을 생성한다
//		
//		@param aKey 키
//		@param aData 데이터
		private Cell(MyKey aKey, Object aData) {
			key = aKey;
			data = aData;
		}
	}
	
	Cell[] table; //해쉬 표
	int bucketSize; //버킷의 개수
	int nElements; //등록되어 있는 데이터의 개수
	
	//해쉬 표의 크기(기본값)
	static final int DEFAULT_BUCKET_SIZE = 50;
	
	//해쉬 표를 생성한다(크기는 DEFAULT_BUCKET_SIZE)
	public HashC() {
		this(DEFAULT_BUCKET_SIZE);
	}
	
//	해쉬 표를 생성한다
//	
//	@param bucketSize 해쉬 표의 크기
	public HashC(int bucketSize) {
		//해쉬 표의 역할을 하는 배열을 할당한다
		table = new Cell[bucketSize];
		
		//해쉬 표의 버킷 개수를 기록해 둔다
		this.bucketSize = bucketSize;
		
		//요소의 개수를 0으로 해둔다. 초기화
		nElements = 0;
	}
	
//	해쉬 함수
//	키가 되는 객체의 hashCode 메소드가 반환한 값을, 버킷의 개수로 나눈 나머지를 반환
//	
//	@param key 키
//	@return 주어진 키에 대한 해쉬 값
	private int hash(MyKey key) {
		
		return key.hashCode() % bucketSize;
	}
	
//	해쉬 표를 탐색한다
//	
//	@param key 탐색할 키
//	@return 키가 발견되면 그것을 반환, 발견되지 않았으면 null을 반환
	public Object find(MyKey key) {
		for(Cell p = table[hash(key)]; p != null; p = p.next) {
			if(key.equals(p.key)) {
				return p.data;
			}
		}
		return null;
	}
	
//	체인화를 구현하기 위해서는 삽입, 탐색, 삭제 3개의 기능이 필요하다 ㅠ
//	해쉬 표에 데이터를 삽입한다
//	
//	@param key 키
//	@param data 등록할 데이터
//	@return 등록에 성공하면 true, 실패하면(이미 키 값이 같은 데이터가 있으면) false를 반환
	public boolean insert(MyKey key, Object data) {
		if(find(key) != null) {
			return false;
		}
		Cell p = new Cell(key, data);
		int h = hash(key);
		p.next = table[h];
		table[h] = p;
		
		nElements++; //요소의 개수를 1 증가
		return true;
	}
	
//	해쉬 표에서 데이터를 삭제한다
//	
//	@param key 삭제할 데이터의 키
//	@return 삭제에 성공하면 true, 데이터를 찾지 못하면 false를 반환
	public boolean delete(MyKey key) {
		int h = hash(key);
		
		//버킷이 비어있는가?
		if(table[h] == null) {
			return false;
		}
		
		//리스트의 선두 셀이 삭제할 데이터인가?
		if(key.equals(table[h].key)) {
			Cell p = table[h];
			table[h] = p.next;
			nElements--; //요소의 개수를 1 감소
			return true;
		}
		
		//리스트의 두 번째 셀 이후부터 순서대로 체크한다
		Cell p;
		Cell q;
		for(q = table[h], p = q.next; p != null; q = p, p = p.next) {
			if(key.equals(p.key)) {
				q.next = p.next;
				nElements--; //요소의 개수를 1 감소
				return true;
			}
		}
		return false;
	}
	
//	해쉬 표의 내용을 문자열로 반환
//	
//	@return 해쉬 표의 내용
	public String toString() {
		String s = "";
		
		//모든 버킷을 순서대로 처리한다
		for(int i = 0; i < table.length; i++) {
			s += "버킷" + i + " : ";
			
			//이 버킷의 내용을 문자열 s에 추가한다
			for(Cell p = table[i]; p != null; p = p.next) {
				s += "[" + p.key + " : " + p.data + "] ";
			}
			s += "\n";
		}
		//등록되어 있는 요소의 개수를 추가한다
		s += "요소의 개수 : " + nElements + "\n";
		return s;
	}
	
	//테스트용 메인 루틴
	public static void main(String[] args) {
		String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"one", //이것은 등록할 때 실패할 것이다
				"eleven", "twelve", "thirteen", "fourteen", "fifteen",
				"sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
		
		//해쉬 표를 생성한다(테스트를 위해 버킷 개수를 15개로 설정한다)
		HashC hash = new HashC(15);
		
		//배열 words에 들어있는 단어를 순서대로 등록한다
		System.out.println("----<< 1 단계 >>---[등록]--------");
		for(int i = 0; i < words.length; i++) {
			boolean stat = hash.insert(new MyKey(words[i]), "순서 = " + (i + 1));
			if(stat == false) {
				System.out.println(words[i] + "의 등록에 실패하였다. (중복됨)");
			}
		}
		System.out.println(hash); //해쉬 표의 내용을 출력한다
		
//		배열 keys에 들어있는 단어를 탐색한다
		System.out.println("---- << 2 단계 >>---[탐색]--------");
		String[] keys = {"ten", "thirteen", "one", "ones", "five"};
		for(int i = 0; i < keys.length; i++) {
			Object result = hash.find(new MyKey(keys[i]));
			if(result != null) {
				System.out.println("키 [" + keys[i] + "]의 값은 [" + result + "]이다.");
			} else {
				System.out.println("키 [" + keys[i] + "]을 발견하지 못하였다.");
			}
		}
		
//		배열 keys에 들어있는 단어를 삭제한다
		System.out.println("----<< 3 단계>>---[삭제]--------");
		for(int i = 0; i < keys.length; i++) {
			if(hash.delete(new MyKey(keys[i]))) {
				System.out.println("키 [" + keys[i] + "]을 삭제하였다.");
			} else {
				System.out.println("키 [" + keys[i] + "]의 삭제에 실패하였다. (등록되어있지 않음)");
			}
		}
		
//		배열 keys에 들어있는 단어를 다시 탐색한다
//		모두 실패할 것이다
		System.out.println("----<< 4 단계 >>----[탐색 : 모두 실패한다]--------");
		for(int i = 0; i < keys.length; i++) {
			Object result = hash.find(new MyKey(keys[i]));
			if(result != null) {
				System.out.println("키 [" + keys[i] + "]의 값은 [" + result + "]이다.");
			} else {
				System.out.println("키 [" + keys[i] + "]을 발견하지 못하였다.");
			}
		}
		
//		해시 표의 내용을 표시한다
		System.out.println("----<< 5 단계 >>------------");
		System.out.println(hash);
	}
}
