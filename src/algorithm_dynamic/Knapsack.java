package algorithm_dynamic;

import java.util.*;
// ���� ��ȹ�� ����Ͽ� �賶 ������ Ǭ��
public class Knapsack {
	
	int[] size;// ������ ũ��
	int[] value;// ������ ����
	int N;// ������ ���� ��
	
//	�賶 ������ ǥ���ϴ� ��ü�� �����Ѵ�
//	
//	@param size ������ ũ�⸦ ��Ÿ���� �迭
//	@param value ������ ������ ��Ÿ���� �迭
	public Knapsack(int[] size, int[] value) {
		
		// �Ű� ���� size�� value�� ����� ������ ���� ���� Ȯ���Ѵ�
		if(size.length != value.length) {
			throw new IllegalArgumentException("'size'�� 'value'�� ��� ���� ��ġ���� �ʽ��ϴ�.");
		}
		
		// ������ ���� ���� �����Ѵ�
		this.N = size.length;
		
		// �迭 size�� ������ ����� �ʵ� size�� �����Ѵ�
		this.size = (int[])size.clone();
		
		// �迭 value�� ������ ����� �ʵ� value�� �����Ѵ�
		this.value = (int[])value.clone();
	}
	
//	ũ�� m�� �賶�� ���� �ع��� ���� ǥ���Ѵ�
//	
//	@param m �賶�� ũ��
	public void solve(int m) {
		
		// �� �������� �賶�� ���� ������ ������ �հ�
		int[] total = new int[m+1];// ��� ��Ұ� 0���� �ʱ�ȭ �ȴ�
		
		// ���������� �� ����
		int[] choice = new int[m+1];
		Arrays.fill(choice, -1);// ��� ��Ҹ� -1�� �ʱ�ȭ �Ѵ�
		
		// ���� i�� �־��� �� ������ �հ�
		int repackTotal;
		
		// �賶�� ũ�⸦ ǥ���Ѵ�
		System.out.println("�賶�� ũ��� " + m);
		
		// ���� 0~i������ ����� �ִ´�
		for(int i = 0; i < N; i++) {
			
			// ũ�� j�� �賶�� ���� ������ �־� ����
			for(int j = size[i]; j <= m; j++) {
				
				// ���� ���� i�� �־��ٰ� �ϸ�, ������ �հ谡 �󸶰� ���� ����Ͽ� ���� repackTotal�� �ִ´�
				repackTotal = total[j - size[i]] + value[i];
				
				// ���� ���� i�� �־ (���� �ʾ��� �� ����) ������ �ö󰣴ٸ� ���� i�� �ִ´�
				if(repackTotal > total[j]) {
					total[j] = repackTotal;
					choice[j] = i;
				}
			}
			
			// �迭 total, choic�� ������ ǥ���Ѵ�
			System.out.print("i = " + i + "\n");
			System.out.print("total = ");
			for(int j = 0; j <= m; j++) {
				System.out.print(pack(4, total[j]));
			}
			System.out.print("\n");
		}
		
		// ��� ������ �賶�� �־������� ǥ���Ѵ�
		for(int i = m; choice[i] >= 0; i -= size[choice[i]]) {
			System.out.println("���� " + choice[i] + "(���� " + value[choice[i]] + ") �� �־���");
		}
		System.out.println("������ �հ� = " + total[m]);
	}
	
//	���� �� value�� ���� ������ ���� len ���ڿ��� ��ȯ�Ѵ�
//	
//	@param value ��ȯ�� ���ڿ��� ����
//	@param value ��ȯ�� ��ġ ��
//	@return ��ȯ�� ���ڿ�
	private static String pack(int len, int value) {
		
		// len�� �ѱ�� ���� 10���Ϸ� �� ��(üũ�� ����!)
		String s = "          " + value;
		return s.substring(s.length() - len, s.length());
	}
	
	// ���� ����� �޽��� message�� ǥ���ϰ� ���α׷��� �����Ų��
	private static void abort(String message) {
		
		System.err.println("���� ��� : java Knapsack ũ��");
		System.err.println(message);
		System.exit(1);// ���� �ڵ� 1�� �̻� ���Ḧ �ǹ�
	}
	
//	�賶 ������ Ǫ�� ���� ���α׷�, Ŀ�ǵ� ���� �μ��� ���� �賶�� ũ�⸦ �����Ѵ�
	public static void main(String args[]) {
		
		// �賶 ������ Ǯ�� ���� ��ü�� �����Ѵ�
		Knapsack knapsack = new Knapsack(
				new int[] {2, 3, 5, 7, 9},// ������ ũ��
				new int[] {2, 4, 7, 11, 14});// ������ ����
		
		// Ŀ�ǵ� ���ο��� �賶�� ũ�⸦ ��´�
		int size = 0; // �賶�� ũ��
		if(args.length != 1) {
			abort("�Ű� ������ ������ �ùٸ��� �ʽ��ϴ�.");
		}
		try {
			size = Integer.parseInt(args[0]);
		} catch(Exception e) {
			abort("ũ��� ���� ������ ������ �ֽʽÿ�.");
		}
		if(size <= 0) {
			abort("ũ��� ���� ������ ������ �ֽʽÿ�.");
		}
		
		// �賶 ������ Ǭ��
		knapsack.solve(size);
	}
}
