package algorithm_backtracking;
// N �� ������ Ǭ��
public class NQueen {
	
	final private int FREE = 1;// ���� �� �ִ�
	final private int NOT_FREE = 0;// ���� �� ����
	
	private final int N;// ���� ��
	private int[] pos;// �� �࿡ ������ ���� ��ġ
	private int[] col;// ���� ������ ���踦 ��Ÿ���� �迭
	private int[] down;// �밢�� ���� ���踦 ��Ÿ���� �迭
	private int[] up;// �밢�� ���� ���踦 ��Ÿ���� �迭
	
//	N �� ������ Ǯ������ ��ü�� �����Ѵ�
//	
//	@param numberOfQueens ���� ����
	public NQueen(int numberOfQueens) {
		
		// �迭�� �Ҵ��Ѵ�
		N = numberOfQueens;
		pos = new int[N];
		col = new int[N];
		down = new int[2*N - 1];
		up = new int[2*N - 1];
		
		// ���� ��ġ�� ������ ���� ������ �ʱ�ȭ�Ѵ�
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
	
//	�� a������ ��� �࿡ ���� ���´�
//	 
//	@param a �� �� ���Ŀ� ���� ���´�
//	@return ���� ���� �� �־��ٸ� true, �׷��� ���ߴٸ� false�� ��ȯ
	public boolean tryQueen(int a) {
		
		// ���ʿ��� ���������� ���� ������� ���� ���� �� �ִ����� �����Ѵ�
		for(int b = 0; b < N; b++) {
			
			// �� a�� b���翡 ���� �� �ִ����� �����Ѵ�
			if(col[b] == FREE && up[a + b] == FREE && down[a - b + (N-1)] == FREE) {
				
				// ���� �� �־���. ��Ҹ� ����ϰ� ������ ������ �����Ѵ�
				pos[a] = b;
				col[b] = NOT_FREE;
				up[a + b] = NOT_FREE;
				down[a - b + (N-1)] = NOT_FREE;
				
				// N���� ���� ��� ���� �� �־��ٸ� �����̴�
				if(a + 1 >= N) {
					return true;
				} else {
					// �� a+1 ������ ��� �࿡ ���� �� �־��ٸ� �����̴�
					if(tryQueen(a+1)) {
						return true;
					} else {
						// �����ߴ�. ���� �����Ѵ�
						pos[a] = -1;
						col[b] = FREE;
						up[a + b] = FREE;
						down[a - b + (N-1)] = FREE;
					}
				}
			}
		}
		// �ᱹ �� �࿡�� ���� ��Ұ� ������
		return false;
	}
	
//	���� ��ġ�� ����Ѵ�
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
	
//	�� a ������ ��� �࿡ ���� ���� ����(��� ���� ǥ��)
//	
//	@param a �� �� ���Ŀ� ���� ���´�
	public void tryQueenAll(int a) {
		
		// ���ʿ��� �������� ���� ������� ���� ���� �� �ִ��� �����Ѵ�
		for(int b = 0; b < N; b++) {
			
			// �� a�� b��°�� ���� �� �ִ°��� �����Ѵ�
			if(col[b] == FREE && up[a + b] == FREE && down[a - b + (N-1)] == FREE) {
				
				// ���� �� �־���. ��Ҹ� ����ϰ� ������ ������ �����Ѵ�
				pos[a] = b;
				col[b] = NOT_FREE;
				up[a + b] = NOT_FREE;
				down[a - b + (N-1)] = NOT_FREE;
				
				// N���� ���� ��� ���� �� �־��ٸ� �����̴�
				if(a + 1 >= N) {
					print();
				} else {
					tryQueenAll(a+1);
				}
				
				// ���� �����Ѵ�
				pos[a] = -1;
				col[b] = FREE;
				up[a+b] = FREE;
				down[a - b + (N-1)] = FREE;
			}
		}
	}
}
