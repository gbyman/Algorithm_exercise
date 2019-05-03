package algorithm_hash;
//오픈 어드레스 법을 이용한 해쉬 표
public class HashOA {
	
//	해쉬 표의 요소(버킷)
	private class Bucket{
		MyKey key; //키
		Object data; //키에 대응하는 데이터
		
//		버킷을 생성한다
//		
//		@param k 키
//		@param d 데이터
		private Bucket(MyKey k, Object d) {
			key = k;
			data = d;
		}
	}
	
	Bucket[] table; //해시 표의 역할을 하는 배열
	int bucketSize; //버킷의 개수
	int nElements; //등록되어 있는 데이터의 개수
	
	//삭제가 완료되었다는 것을 나타내는 특별한 키 값
	static final MyKey DELETED = new MyKey(null);
	
	//삭제가 완료되었다는 것을 나타내는 특별한 키 값
	static final MyKey EMPTY = new MyKey(null);
	
	//해시 표의 기본 크기(소수로 하는 것이 좋다)
	static final int DEFAULT_BUCKET_SIZE = 53;
	
//	해시 표를 생성한다(크기는 DEFAULT_BUCKET_SIZE)
	public HashOA() {
		this(DEFAULT_BUCKET_SIZE);
	}
	
//	해시 표를 생성한다
//	
//	@param bucketSize 해시 표의 크기
	public HashOA(int bucketSize) {
//		해시 표의 역할을 하는 배열을 할당하고 모든 요소의 키를 EMPTY로 초기화 시켜 둔다
		table = new Bucket[bucketSize];
		for(int i = 0; i < bucketSize; i++) {
			table[i] = new Bucket(EMPTY, null);
		}
		
		//해시 표의 버킷 개수를 기록해 둔다
		this.bucketSize = bucketSize;
		
		//요소의 개수를 0으로 해 둔다
		nElements = 0;
	}
	
//	해시 함수
//	키로 이용되는 객체의 hashCode 메소드가 반환한 값을 버킷의 개수로 나눈 나머지를 반환
//	
//	@param key 키
//	@return 주어진 키에 대한 해시 값
	private int hash(MyKey key) {
		return key.hashCode() % bucketSize;
	}
	
//	재해싱을 한다
//	
//	@param h 해시 값
//	@return 재해싱을 구한 해시 값
	private int rehash(int h) {
		return (h + 1) % bucketSize;
	}
	
//	해시 표를 탐색한다
//	
//	@param key 찾을 키
//	@return 데이터를 발견하면 그것을 반환, 발견하지 못했으면 null을 반환
	public Object find(MyKey key) {
		int count = 0;
		int h = hash(key);
		
		MyKey k;
		while((k = table[h].key) != EMPTY) {
			if(k != DELETED && key.equals(k)) {
				return table[h].data;
			}
			if(++count > bucketSize) {
				return null;
			}
			h = rehash(h);
		}
		return null;
	}
	
//	해시 표에 데이터를 삽입한다
//	
//	@param key 키
//	@param data 등록할 데이터
//	@return 등록에 성공하면 true, 실패하면(이미 같은 키를 가지는 데이터가 있으면) false를 반환
	public boolean insert(MyKey key, Object data) {
		int count = 0;
		int h = hash(key);
		
		MyKey k;
		while((k = table[h].key) != EMPTY && k != DELETED) {
			if(key.equals(k)) {
				return false;
			}
			if(++count > bucketSize) {
				System.err.println("더 이상 해시 표에 데이터를 등록할 수 없습니다.");
				System.exit(1);
			}
			h = rehash(h);
		}
		table[h].key = key;
		table[h].data = data;
		nElements++;
		return true;
	}
	
//	해시 표에서 데이터를 삭제한다 
//	
//	@param key 삭제할 데이터의 키
//	@return 삭제에 성공했다면 true, 실패했다면 false를 반환
	public boolean delete(MyKey key) {
		int count = 0;
		int h = hash(key);
		
		MyKey k;
		while((k = table[h].key) != EMPTY) {
			if(k != DELETED && key.equals(k)) {
				table[h].key = DELETED;
				table[h].data = null;
				nElements--;
				return true;
			}
			if(++count > bucketSize) {
				return false;
			}
			h = rehash(h);
		}
		return false;
	}
	
//	해시 표의 내용을 문자열로 반환
//	
//	@return 해시 표의 내용
	public String toString() {
		String s = "";
		for(int i = 0; i <table.length; i++) {
			s += "버킷" + i + ": ";
			MyKey k = table[i].key;
			if(k == EMPTY) {
				s += "비어있음\n";
			} else if(k == DELETED) {
				s += "삭제 되었음\n";
			} else {
				s += "key = [" + k + "] data = [" + table[i].data + "]\n";
			}
		}
		//등록되어 있는 요소의 개수를 추가한다
		s += "요소의 개수 : " + nElements + "\n";
		return s;
	}
	
	//테스트용 메인 루틴
	public static void main(String[] args) {
		String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"one", //이것은 등록에 실패할 것이다
				};
		//해시 표를 생성한다(테스트를 위해 버킷을 15개로 설정한다)
		HashOA hash = new HashOA(15);
		
		//배열 words에 들어있는 단어를 순서대로 등록한다
		System.out.println("----<< 1 단계 >>---[등록]--------");
		for(int i = 0; i < words.length; i++) {
			boolean stat = hash.insert(new MyKey(words[i]), "순서 = " + (i + 1));
			if(stat == false) {
				System.out.println(words[i] + "의 등록에 실해아였다. (중복됨)");
			}
		}
		System.out.println(hash); //해시 표의 내용을 표시
		
		//배열 keys에 들어있는 단어를 탐색한다
		System.out.println("----<< 2 단계 >>---[탐색]--------");
		String[] keys = {"ten", "one", "ones", "five"};
		for(int i = 0; i < keys.length; i++) {
			Object result = hash.find(new MyKey(keys[i]));
			if(result != null) {
				System.out.println("키 [" + keys[i] + "]의 값은 [" + result + "]이다." );
			} else {
				System.out.println("키 [" + keys[i] + "]을 발견하지 못하였다.");
			}
		}
		
		//배열 keys에 들어있는 단어를 삭제한다
		System.out.println("----<< 3 단계 >>---[삭제]--------");
		for(int i = 0; i < keys.length; i++) {
			if(hash.delete(new MyKey(keys[i]))) {
				System.out.println("키 [" + keys[i] + "]을 삭제하였다.");
			} else {
				System.out.println("키 [" + keys[i] + "]의 삭제에 실패아였다. (등록되어 있지 않음)");
			}
		}
		
		//배열 keys에 들어있는 단어를 다시 탐색한다
		//모두 실패할 것이다
		System.out.println("----<< 4 단계 >>---[탐색: 모두 실패한다]--------");
		for(int i = 0; i < keys.length; i++) {
			Object result = hash.find(new MyKey(keys[i]));
			if(result != null) {
				System.out.println("키 [" + keys[i] + "]의 값은 [" + result + "]이다");
			} else {
				System.out.println("키 [" + keys[i] + "]을 발견하지 못하였다.");
			}
		}
		
		//해시 표의 내용을 표시한다
		System.out.println("----<< 5 단계 >>---------");
		System.out.println(hash);
		
	}
}
