package algorithm_backtracking;
// N 퀸 문제를 푼다
public class NQueen {
	
	final private int FREE = 1;// 놓을 수 있다
	final private int NOT_FREE = 0;// 놓을 수 없다
	
	private final int N;// 퀸의 수
	private int[] pos;// 각 행에 놓여진 퀸의 위치
	private int[] col;// 수직 방향의 관계를 나타내는 배열
	private int[] down;// 대각선 상의 관계를 나타내는 배열
	private int[] up;// 대각선 상의 관계를 나타내는 배열
	
//	N 퀸 문제를 풀기위한 객체를 생성한다
//	
//	@param numberOfQueens 퀸의 개수
	public NQueen(int numberOfQueens) {
		
		// 배열을 할당한다
		N = numberOfQueens;
		pos = new int[N];
		col = new int[N];
		down = new int[2*N - 1];
		up = new int[2*N - 1];
		
		// 퀸의 위치와 잡히는 관계 정보를 초기화한다
		for(int i = 0; i < pos.length; i++) {
			pos[i] = -1;
		}
		for(int i = 0; i < col.length; i++) {
			col[i] = FREE;
		}
		for(int i = 0; i < down.length; i++) {
			down[i] = FREE;
		}
		for(int i = 0; i < up.length; i++) {
			up[i] = FREE;
		}
	}
	
//	행 a이후의 모든 행에 퀸을 놓는다
//	 
//	@param a 이 행 이후에 퀸을 놓는다
//	@return 퀸을 놓을 수 있었다면 true, 그렇지 못했다면 false를 반환
	public boolean tryQueen(int a) {
		
		// 왼쪽에서 오르쪽으로 향해 순서대로 퀸을 놓을 수 있는지를 조사한다
		for(int b = 0; b < N; b++) {
			
			// 행 a의 b번재에 놓을 수 있는지를 조사한다
			if(col[b] == FREE && up[a + b] == FREE && down[a - b + (N-1)] == FREE) {
				
				// 놓을 수 있었다. 장소를 기록하고 잡히는 정보를 저장한다
				pos[a] = b;
				col[b] = NOT_FREE;
				up[a + b] = NOT_FREE;
				down[a - b + (N-1)] = NOT_FREE;
				
				// N개의 퀸을 모두 놓을 수 있었다면 성공이다
				if(a + 1 >= N) {
					return true;
				} else {
					// 행 a+1 이후의 모든 행에 놓을 수 있었다면 성공이다
					if(tryQueen(a+1)) {
						return true;
					} else {
						// 실패했다. 퀸을 제거한다
						pos[a] = -1;
						col[b] = FREE;
						up[a + b] = FREE;
						down[a - b + (N-1)] = FREE;
					}
				}
			}
		}
		// 결국 이 행에는 놓을 장소가 없었다
		return false;
	}
	
//	퀸의 위치를 출력한다
	public void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(pos[i] == j) {
					System.out.print("Q ");
				} else {
					System.out.print(", ");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
//	행 a 이후의 모든 행에 퀸을 놓아 본다(모든 답을 표시)
//	
//	@param a 이 행 이후에 퀸을 놓는다
	public void tryQueenAll(int a) {
		
		// 왼쪽에서 오른쪽을 향해 순서대로 퀸을 놓을 수 있는지 조사한다
		for(int b = 0; b < N; b++) {
			
			// 행 a의 b번째에 놓을 수 있는가를 조사한다
			if(col[b] == FREE && up[a + b] == FREE && down[a - b + (N-1)] == FREE) {
				
				// 놓을 수 있었다. 장소를 기록하고 잡히는 정보를 저장한다
				pos[a] = b;
				col[b] = NOT_FREE;
				up[a + b] = NOT_FREE;
				down[a - b + (N-1)] = NOT_FREE;
				
				// N개의 퀸을 모두 놓을 수 있었다면 성공이다
				if(a + 1 >= N) {
					print();
				} else {
					tryQueenAll(a+1);
				}
				
				// 퀸을 제거한다
				pos[a] = -1;
				col[b] = FREE;
				up[a+b] = FREE;
				down[a - b + (N-1)] = FREE;
			}
		}
	}
}
