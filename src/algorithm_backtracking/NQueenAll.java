package algorithm_backtracking;
//N 퀸 메인 프로그램(모든 답을 표시)
//
// 실행 방법 : java NQueenAll 퀸의수
public class NQueenAll {

	// 실행 방법과 메시지 message를 표시하고 프로그램을 종료시킨다
	private static void abort(String message) {
		
		System.err.println("실행 방법 : java NQueenAll 퀸의수");
		System.err.println(message);
		System.exit(1);// 상세 코드 1은 이상 종료를 의미
	}
	
//	메인 프로그램. N 문제의 모든 답을 표시한다
//	퀸의 개수는 커맨드 라인 인수로 지정한다
	public static void main(String args[]) {
		
		// 매개 변수는 반드시 하나여야 한다
		if(args.length != 1) {
			abort("매개 변수의 개수가 올바르지 않습니다.");
		}
		
		// 매개 변수로 지정된 퀸의 개수를 n에 저장한다
		int n = 0;
		try {
			n = Integer.parseInt(args[0]);
		} catch(NumberFormatException e) {
			abort("퀸의 수는 정수로 지정해 주십시오. " + args[0]);
		}
		if(n <= 0) {
			abort("퀸의 수는 양의 정수로 지정해 주십시오. " + args[0]);
		}
		
		// N 퀸의 모든 답을 표시한다
		NQueen nq = new NQueen(n);
		nq.tryQueenAll(0);
	}
}
