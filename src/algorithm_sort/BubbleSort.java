package algorithm_sort;
//���� ��Ʈ
public class BubbleSort {
	
//	���� ��Ʈ�� �̿��Ͽ� �迭�� �����Ѵ�
//	
//	@param a ������ �迭
	public static void sort(int[] a) {
		int n = a.length;//�迭�� ��� ��
		
		for(int i = 0; i < n; i++) {
			for(int j = n-1; j > i; j--) {
				if(a[j-1] < a[j]) {
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
	}
}
