package algorithm_sort;
// ��� ��Ʈ�� �����Ѵ�
public class RadixSort {
	
	// ���� Ű�� 0���� 15������ ����(4��Ʈ)
	static final int M = 15;
	
	// ���� Ű�� ��� ���� ����ϴ� ����ũ(2���� 1111)
	static final int MASK = 0xf;
	
//	��� ��Ʈ�� �����Ѵ�. ���޵� �迭 a�� ������ �����Ѵ�
//	
//	@param a ������ �迭
	static void sort(RadixSortData[] a) {
		
		final int N = a.length;// �迭�� ��� ��
		int pass = 1;// �� ��° �����ΰ�?
		
		// �۾��� �迭
		RadixSortData[] b = new RadixSortData[N];
		
		// Ű�� ������ �������� �迭
		int[] count = new int[M + 1];
		
		// ���� �ڸ����� ���� �ڸ��� ���� 4��Ʈ �� 4�� ������ �����Ѵ�
		for(int bit = 0; bit < 16; bit += 4) {
			
			// ī���͸� ��� 0���� �Ѵ�
			for(int i = 0; i <= M; i++) {
				count[i] = 0;
			}
			
			// Ű�� ����
			for(int i = 0; i < N; i++) {
				count[(a[i].getKey() >>bit) & MASK]++;
			}
			
			// Ű�� ���� ���� ������ ���Ѵ�
			for(int i = 0; i < M; i++) {
				count[i+1] += count[i];
			}
			
			// ���� ������ ���� �����͸� �迭 a���� �۾��� �迭 b�� �����Ѵ�
			for(int i = N - 1; i >= 0; i--) {
				b[--count[(a[i].getKey() >> bit) & MASK]] = a[i];
			}
			
			// �����͸� �۾��� �迭 b���� �迭 a�� �����Ѵ�
			System.arraycopy(b, 0, a, 0, N);
			
			// �迭�� ������ ǥ���Ѵ�
			System.out.println("Pass" + pass++ + "-----------------");
			dumpArray(a);
		}
	}
	
//	RadixSortData ���� �迭 ������ 16������ ǥ���Ѵ�
//	
//	@param a ǥ���� �迭
	public static void dumpArray(RadixSortData a[]) {
		
		for(int i = 0; i < a.length; i++) {
			String hexStr = " " + Integer.toHexString(a[i].getKey());
			hexStr = hexStr.substring(hexStr.length() - 4, hexStr.length());
			System.out.println("key = " + hexStr + " data = " + a[i].getData());
		}
	}
}
 