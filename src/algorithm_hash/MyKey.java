package algorithm_hash;
//해쉬 표에서 사용하는 키
public class MyKey {
	
	String str; //키로 사용할 문자열
	
//	키를 생성한다
//	
//	@param s 키로 사용할 문자열
	public MyKey(String s) {
		str = s;
	}
	
//	키를 비교한다
//	
//	@param x 비교할 키
//	@return 이 키와 키 x가 같다면 true, 같지 않다면 false
	public boolean equals(MyKey x) {
		return str.equals(x.str);
	}
	
//	키의 해쉬 값을 반환
//	
//	@return 이 키의 해쉬 값
	public int hashCode() {
		int sum = 0;
		
		//문자열에 포함되어 있는 모든 문자 코드의 합을 구한다
		for(int i = 0; i < str.length(); i++) {
			sum += (int)str.charAt(i);
		}
		return sum;
	}
	
//	키를 문자열 형태로 반환(실은 키가 문자열이기 때문에 그대로 반환)
//	
//	@return 키를 문자열로 표시한 것
	public String toString() {
		return str;
	}
			
}
