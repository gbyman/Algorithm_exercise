package algorithm_backtracking;
//N �� ���� ���α׷�(��� ���� ǥ��)
//
// ���� ��� : java NQueenAll ���Ǽ�
public class NQueenAll {

	// ���� ����� �޽��� message�� ǥ���ϰ� ���α׷��� �����Ų��
	private static void abort(String message) {
		
		System.err.println("���� ��� : java NQueenAll ���Ǽ�");
		System.err.println(message);
		System.exit(1);// �� �ڵ� 1�� �̻� ���Ḧ �ǹ�
	}
	
//	���� ���α׷�. N ������ ��� ���� ǥ���Ѵ�
//	���� ������ Ŀ�ǵ� ���� �μ��� �����Ѵ�
	public static void main(String args[]) {
		
		// �Ű� ������ �ݵ�� �ϳ����� �Ѵ�
		if(args.length != 1) {
			abort("�Ű� ������ ������ �ùٸ��� �ʽ��ϴ�.");
		}
		
		// �Ű� ������ ������ ���� ������ n�� �����Ѵ�
		int n = 0;
		try {
			n = Integer.parseInt(args[0]);
		} catch(NumberFormatException e) {
			abort("���� ���� ������ ������ �ֽʽÿ�. " + args[0]);
		}
		if(n <= 0) {
			abort("���� ���� ���� ������ ������ �ֽʽÿ�. " + args[0]);
		}
		
		// N ���� ��� ���� ǥ���Ѵ�
		NQueen nq = new NQueen(n);
		nq.tryQueenAll(0);
	}
}
