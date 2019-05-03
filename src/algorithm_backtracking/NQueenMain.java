package algorithm_backtracking;
// N �� ���� ���α׷�(������ �丸 ǥ��)
// 
// 	���� ��� : java NQueenMain ���� ��
// 	
public class NQueenMain {
	
//	���� ����� �޽��� message�� ǥ���ϰ� ���α׷��� �����Ų��
	private static void abort(String message) {
		
		System.err.println("���� ��� : java NQueenMain ���� ��");
		System.err.println(message);
		System.exit(1);// ���� �ڵ� 1�� �̻� ���Ḧ �ǹ�
	}
	
//	���� ���α׷�. N ���� ó�� ���� ǥ���Ѵ�
//	���� ������ Ŀ�ǵ� ���� �μ��� �����Ѵ�
	public static void main(String[] args) {
		
		// �Ű� ������ ������ �ݵ�� �ϳ����� �Ѵ�
		if(args.length != 1) {
			abort("�Ű� ������ ������ �ùٸ��� �ʽ��ϴ�.");
		}
		
		// �Ű� ������ ������ ���� ������ n�� �����Ѵ�
		int n = 0;
		try {
			n = Integer.parseInt(args[0]);
		} catch(NumberFormatException e) {
			abort("���� ���� ���� ������ ������ �ֽʽÿ� : " + args[0]);
		} 
		
		if(n <= 0) {
			abort("���� ���� ���� ������ ������ �ֽʽÿ� : " + args[0]);
		}
		
		// N �� ������ Ǯ�� �����ߴٸ� ���� ǥ���Ѵ�
		NQueen nq = new NQueen(n);
		if(nq.tryQueen(0)) {
			// �����߱� ������ ���� ǥ���Ѵ�
			nq.print();
		} else {
			// ���� �޽����� ǥ���Ѵ�
			System.out.println("�ƽ��Ե� ���� �������� �ʽ��ϴ�.");
		}
	}
}
