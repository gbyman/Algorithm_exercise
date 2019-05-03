package algorithm_string;
// 주먹구구식 방법을 이용한 문자열 탐색
public class BruteForce {

//	문자열 text에서 문자열 pattern을 탐색한다(주먹구구식 방법)
//	
//	@param text 텍스트(탐색 대상이 되는 문자열)
//	@param pattern 패턴(찾을 문자열)
//	@return 발견한 위치를 반환. 발견하지 못했다면 -1을 반환
	public static int search(String text, String pattern) {
		
		int i = 0;// 텍스트의 비교 위치를 나타내는 포인터
		int j = 0;// 패턴의 비교 위치를 나타내는 포인터
		
		//텍스트의 마지막에 도달하던지 패턴을 발견할 때까지 반복
		while(i < text.length() && j < pattern.length()) {
			
			// 텍스트와 패턴을 한 문자씩 비교한다
			if(text.charAt(i) == pattern.charAt(j)) {
				
				// 일치했다. 텍스트와 패턴의 포인터를 진행시킨다
				i++;
				j++;
			} else {
				
				// 일치하지 않았다
				i = i - j + 1;// 텍스트의 포인터를 현재 위치에서 한 칸 진행시킨다
				j = 0;// 패턴의 포인터를 처음으로 되돌린다
			}
		}
		
		// 만약 탐색에 성공했다면 패턴을 찾은 위치를 반환. 실패했다면 -1을 반환
		return(j == pattern.length()) ? (i - j) : -1;
	}
}
