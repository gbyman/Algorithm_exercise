package algorithm_sort;
//�� ��Ʈ
public class HeapSort {
	
//	���� ó�� ��Ҹ� �ʿ��� ������ ����������
//	��, a[from]�� ���� ó�� ���, a[to]�� ���� ������ ��ҷ� �Ѵ�
//	
//	@param a ���� ����ִ� �迭
//	@param from ���� ó�� ����� ÷��
//	@param to ���� ������ ����� ÷��
	private static void downHeap(int[] a, int from, int to) {
		
		//�������� ����� ���� value�� ������ �д�
		int value = a[from];
		
		//��Ʈ���� �����Ͽ� ��� i�� �ڽ��� ������ �ִ� �� �ݺ��Ѵ�
		int i = from;
		while(i <= to/2) {
			
			//��� i�� �ڽ� �� ���� ���� ��� j�� �Ѵ�
			int j = i * 2;
			if(j + 1 <= to && a[j] > a[j + 1]) {
				j++;
			}
			
			//���� �θ� �ڽĺ��� ũ���ʴٴ� ���谡 �����ϸ�
			//�� �̻� �������� �ʿ䰡 ����
			if(value < a[j]) {
				break;
			}
			
			//��� i�� ��� j�� ���� �ְ�, ������ ��� j�� ó���ϵ��� �Ѵ�
			a[i] = a[j];
			i = j;
		}
		
		//���� ó�� ��Ҹ� ��� i�� �ִ´�
		a[i] = value;
	}
	
//	�� ��Ʈ�� �̿��Ͽ� �迭�� �����Ѵ�
//	������ �迭 a���� a[1]qnxj a[n]���� ������������ �����Ѵ�
//	
//	@param a ������ �迭
//	@param n �����ؾ� �� ������ ����� ÷��
	public static void sort(int[] a, int n) {
		
		for(int i = n/2; i >= 1; i--) {
			downHeap(a, i, n);
		}
		
		for(int i = n; i >= 2; i--) {
			int tmp = a[1];
			a[1] = a[i];
			a[i] = tmp;
			downHeap(a, 1, i -1);
		}
	}
}
