package algorithm_backtracking;
// N 퀸 메인 프로그램(최초의 답만 표시)
// 
// 	실행 방법 : java NQueenMain 퀸의 수
// 	
public class NQueenMain {
	
//	실행 방법과 메시지 message를 표시하고 프로그램을 종료시킨다
	private static void abort(String message) {
		
		System.err.println("실행 방법 : java NQueenMain 퀸의 수");
		System.err.println(message);
		System.exit(1);// 상태 코드 1은 이상 종료를 의미
	}
	
//	메인 프로그램. N 퀸의 처음 답을 표시한다
//	퀸의 개수는 커맨드 라인 인수로 지정한다
	public static void main(String[] args) {
		
		// 매개 변수의 개수는 반드시 하나여야 한다
		if(args.length != 1) {
			abort("매개 변수의 개수가 올바르지 않습니다.");
		}
		
		// 매개 변수로 지정된 퀸의 개수를 n에 저장한다
		int n = 0;
		try {
			n = Integer.parseInt(args[0]);
		} catch(NumberFormatException e) {
			abort("퀸의 수는 양의 정수로 지정해 주십시오 : " + args[0]);
		} 
		
		if(n <= 0) {
			abort("퀸의 수는 양의 정수로 지정해 주십시오 : " + args[0]);
		}
		
		// N 퀸 문제를 풀고 성공했다면 답을 표시한다
		NQueen nq = new NQueen(n);
		if(nq.tryQueen(0)) {
			// 성공했기 때문에 답을 표시한다
			nq.print();
		} else {
			// 실패 메시지를 표시한다
			System.out.println("아쉽게도 답이 존재하지 않습니다.");
		}
	}
}
