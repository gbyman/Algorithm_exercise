package algorithm_string;

import java.util.*;

// Boyer-Moore 알고리즘을 이용한 문자열 탐색
public class BoyerMoore {
	
//	문자열 text에서 문자열 pattern을 탐색한다(BM 법)
//	
//	@param text 텍스트(탐색 대상이 되는 문자열)
//	@param pattern 패턴(찾을 문자열)
//	@return 발견한 위치를 반환, 발견하지 못했다면 -1을 반환
	public static int search(String text, String pattern) {
		
		int patLen = pattern.length();// 패턴의 길이
		int textLen = text.length();// 텍스트의 길이
		
		// 텍스트와 패턴이 일치하지 않았을 때에 어느 만큼 이동해야 할지 나타내는 표
		int[] skip = new int[65536];
		
		int i;// 텍스트의 비교 위치를 나타내는 포인터
		int j;// 패턴의 비교 위치를 나타내는 포인터
		
		// 표 skip을 작성한다
		Arrays.fill(skip, patLen);
		for(int x = 0; x < patLen -1; x++) {
			skip[pattern.charAt(x)] = patLen - x - 1;
		}
		
		// 포인터를 초기화한다. 패턴을 뒤에서부터 비교하기 때문에 "패턴의 길이 - 1"로 초기화한다
		i = patLen - 1;
		
		// 텍스트의 가장 마지막에 도달할 때까지 반복한다
		while(i < textLen) {
			
			// 포인터 j가 패턴의 마지막 문자를 가리키도록 한다
			j = patLen - 1;
			
			// 텍스트와 패턴이 일치하는 동안 반복한다
			while(text.charAt(i) == pattern.charAt(j)) {
				
				// 처음 문자가지 일치했다면 탐색은 성공이다
				if(j == 0) {
					return i;
				}
				
				// 포인터 i와 j를 각각 1 문자만큼 되돌린다
				i--;
				j--;
			}
			
			// 일치하지 않았기 때문에 패턴을 이동시킨다
			i = i + Math.max(skip[text.charAt(i)], patLen - j);
		}
		
		// 결국 발견하지 못했다
		return -1;
	}
}
