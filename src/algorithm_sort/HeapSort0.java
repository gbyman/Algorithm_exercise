package algorithm_sort;
//���� �̿��� ��Ʈ
public class HeapSort0 {
	
//	���� �̿��Ͽ� �迭�� �����Ѵ�
//	
//	@param a ������ �迭
	public static void sort(int[] a) {
		
		int n = a.length; //�迭�� ��� ��
		
		//�۾��� ���� �����Ѵ�
		Heap heap = new Heap(n);
		
		//�迭�� ��� ��Ҹ� ���� �����Ѵ�
		for(int i = 0; i < n; i++) {
			heap.insert(a[i]);
		}
		
		//Ű�� ���� �ͺ��� ������� ���� �迭�� �ǵ�����
		for(int i = 0; i < n; i++) {
			a[i] = heap.deleteMin();
		}
	}
}
