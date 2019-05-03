package algorithm_sort;
//�迭 ���� ���� ��Ʈ
public class MergeSortArray {

//	�迭�� ���� ��Ʈ�Ѵ�
//	a[low] ~ a[high] ��Ҹ� �����Ѵ�
//	
//	@param a ������ �迭
//	@param low ������ ������ ����
//	@param high ������ ������ ����
	private static void mergeSortArray(int[] a, int low, int high) {
		//���� ��Ұ� �ϳ����̶�� �ٷ� ���ư���
		if(low >= high) {
			return;
		}
		
		//���� 2���� ������ ��� mid�� ���Ѵ�
		int mid = (low + high) / 2;
		
		//���� �� ��� a[low]~a[mid]�� �����Ѵ�
		mergeSortArray(a, low, mid);
		
		//���� �� ��� a[mid]~a[high]�� �����Ѵ�
		mergeSortArray(a, mid + 1, high);
		
		//���� �� ��Ҹ� �״�� �۾��� �迭 b�� �����Ѵ�
		int[] b = new int[a.length];
		for(int i = low; i <= mid; i++) {
			b[i] = a[i];
		}
		
		//���� �� ��Ҹ� �ݴ� ������ �۾��� �迭 b�� �����Ѵ�
		for(int i = mid + 1, j = high; i <= high; i++, j--) {
			b[i] = a[i];
		}
		
		//�۾��� �迭 b�� �糡���� ���� �����͸� �����Ͽ� �迭 a�� �ִ´�
		int i = low;
		int j = high;
		for(int k = low; k <= high; k++) {
			if(b[i] <= b[j]) {
				a[k] = b[i++];
			} else {
				a[k] = b[j--];
			}
		}
	}
	
//	���� ��Ʈ�� �̿��Ͽ� �迭�� �����Ѵ�
//	
//	@param a ������ �迭
	public static void sort(int[] a) {
		mergeSortArray(a, 0, a.length - 1);
	}
}
