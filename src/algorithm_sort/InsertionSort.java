package algorithm_sort;
//���� ��Ʈ
public class InsertionSort {

//	���� ��Ʈ�� �̿��Ͽ� �迭�� �����Ѵ�
//	
//	@param a ������ �迭
	public static void sort(int[] a) {
		
		int n = a.length;//�迭�� ��� ��
		
		for(int i = 1; i < n; i++) {
			int j = i;
			while(j >= 1 && a[j-1] > a[j]) {
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
				j--;
			}
		}
	}
}
