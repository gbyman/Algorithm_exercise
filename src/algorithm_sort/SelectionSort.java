package algorithm_sort;
//���� ��Ʈ
public class SelectionSort {
	
//	���� ��Ʈ�� �̿��Ͽ� �迭�� �����Ѵ�
//	
//	@param a ������ �迭
	public static void sort(int[] a) {
		int n = a.length;//�迭�� ��� ��
		
		for(int i = 0; i < n-1; i++) {
			int lowest = i;
			int lowkey = a[i];
			for(int j = i + 1; j < n; j++) {
				if(a[j] < lowkey) {
					lowest = j;
					lowkey = a[j];
				}
			}
			int temp = a[i];
			a[i] = a[lowest];
			a[lowest] = temp;
		}
	}
}
