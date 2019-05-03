package algorithm_sort;
// ���������� ��Ʈ�� �����Ѵ�
public class DistributionCountingSort {

//	���������� ��Ʈ�� �����Ѵ�. �迭 a�� ������ �����Ѵ�
//	
//	@param a ������ �迭
	static void sort(BinSortData[] a) {
		
		final int N = a.length;	// �迭�� ��� ��
		final int M = BinSortData.M; // Ű�� 0���� M����
		
		// ī���ͷ� ����� �迭�� �Ҵ��Ѵ�(��Ҵ� �ڵ������� 0���� �ʱ�ȭ �ȴ�)
		int[] count = new int[M + 1];
		
		// Ű�� ����
		for(int i = 0; i < N; i++) {
			count[a[i].getKey()]++;
		}
		
		// Ű�� ���� ���� ������ ���Ѵ�
		for(int i = 0; i < M; i++) {
			count[i+1] += count[i];
		}
		
		// ���� ������ ���� �����͸� �迭 a���� �۾��� �迭 b�� �����Ѵ�
		BinSortData[] b = new BinSortData[N];
		for(int i = N - 1; i >= 0; i--) {
			b[--count[a[i].getKey()]] = a[i];
		}
		
		// �迭 b�� ����ִ� ���ĵ� �����͸� �迭 a�� �����Ѵ�
		System.arraycopy(b, 0, a, 0, N);
	}
}
