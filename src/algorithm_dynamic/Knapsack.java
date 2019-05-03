package algorithm_dynamic;

import java.util.*;
// 동적 계획을 사용하여 배낭 문제를 푼다
public class Knapsack {
	
	int[] size;// 물건의 크기
	int[] value;// 물건의 가격
	int N;// 물건의 가지 수
	
//	배낭 문제를 표현하는 객체를 생성한다
//	
//	@param size 물건의 크기를 나타내는 배열
//	@param value 물건의 가격을 나타내는 배열
	public Knapsack(int[] size, int[] value) {
		
		// 매개 변수 size와 value의 요소의 개수가 같은 것을 확인한다
		if(size.length != value.length) {
			throw new IllegalArgumentException("'size'와 'value'의 요소 수가 일치하지 않습니다.");
		}
		
		// 물건의 가지 수를 저장한다
		this.N = size.length;
		
		// 배열 size의 복제를 만들어 필드 size에 저장한다
		this.size = (int[])size.clone();
		
		// 배열 value의 복제를 만들어 필드 value에 저장한다
		this.value = (int[])value.clone();
	}
	
//	크기 m인 배낭에 대한 해법을 구해 표시한다
//	
//	@param m 배낭의 크기
	public void solve(int m) {
		
		// 현 시점에서 배낭에 넣은 물건의 가격의 합계
		int[] total = new int[m+1];// 모든 요소가 0으로 초기화 된다
		
		// 마지막으로 고른 물건
		int[] choice = new int[m+1];
		Arrays.fill(choice, -1);// 모든 요소를 -1로 초기화 한다
		
		// 물건 i를 넣었을 때 가격의 합계
		int repackTotal;
		
		// 배낭의 크기를 표시한다
		System.out.println("배낭의 크기는 " + m);
		
		// 물건 0~i까지를 고려해 넣는다
		for(int i = 0; i < N; i++) {
			
			// 크기 j인 배낭에 대해 물건을 넣어 본다
			for(int j = size[i]; j <= m; j++) {
				
				// 만약 물건 i를 넣었다고 하면, 가격의 합계가 얼마가 될지 계산하여 변수 repackTotal에 넣는다
				repackTotal = total[j - size[i]] + value[i];
				
				// 만약 물건 i를 넣어서 (넣지 않았을 때 보다) 가격이 올라간다면 물건 i를 넣는다
				if(repackTotal > total[j]) {
					total[j] = repackTotal;
					choice[j] = i;
				}
			}
			
			// 배열 total, choic의 내용을 표시한다
			System.out.print("i = " + i + "\n");
			System.out.print("total = ");
			for(int j = 0; j <= m; j++) {
				System.out.print(pack(4, total[j]));
			}
			System.out.print("\n");
		}
		
		// 어느 물건을 배낭에 넣었는지를 표시한다
		for(int i = m; choice[i] >= 0; i -= size[choice[i]]) {
			System.out.println("물건 " + choice[i] + "(가격 " + value[choice[i]] + ") 을 넣었다");
		}
		System.out.println("가격의 합계 = " + total[m]);
	}
	
//	정수 값 value를 왼쪽 정렬한 길이 len 문자열로 변환한다
//	
//	@param value 변환할 문자열의 길이
//	@param value 변환할 수치 값
//	@return 변환된 문자열
	private static String pack(int len, int value) {
		
		// len에 넘기는 값은 10이하로 할 것(체크는 생략!)
		String s = "          " + value;
		return s.substring(s.length() - len, s.length());
	}
	
	// 실행 방법과 메시지 message를 표시하고 프로그램을 종료시킨다
	private static void abort(String message) {
		
		System.err.println("실행 방법 : java Knapsack 크기");
		System.err.println(message);
		System.exit(1);// 상태 코드 1은 이상 종료를 의미
	}
	
//	배낭 문제를 푸는 메인 프로그램, 커맨드 라인 인수에 따라 배낭의 크기를 지정한다
	public static void main(String args[]) {
		
		// 배낭 문제를 풀기 위한 객체를 생성한다
		Knapsack knapsack = new Knapsack(
				new int[] {2, 3, 5, 7, 9},// 물건의 크기
				new int[] {2, 4, 7, 11, 14});// 물건의 가격
		
		// 커맨드 라인에서 배낭의 크기를 얻는다
		int size = 0; // 배낭의 크기
		if(args.length != 1) {
			abort("매개 변수의 개수가 올바르지 않습니다.");
		}
		try {
			size = Integer.parseInt(args[0]);
		} catch(Exception e) {
			abort("크기는 양의 정수로 지정해 주십시오.");
		}
		if(size <= 0) {
			abort("크기는 양의 정수로 지정해 주십시오.");
		}
		
		// 배낭 문제를 푼다
		knapsack.solve(size);
	}
}
