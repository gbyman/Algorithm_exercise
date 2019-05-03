package algorithm_sort;
//�� ��Ʈ(��͹���)
public class QuickSort1 {
	
//	�迭 a[1] ~ a[r]�� �����Ѵ�. ������ ÷�ڸ� ��ȯ
	private static int partition(int[] a, int l, int r) {
		//������ i�� j�� �ʱ�ȭ�Ѵ�
		int i = l - 1;
		int j = r;
		
		//������ �� ��Ҹ� �������� �Ѵ�
		int pivot = a[r];
		
		//������ i�� j�� �浹�� ������ �ݺ��Ѵ�
		for(;;) {
			//������ i�� ���������� �̵���Ų��
			while(a[++i] < pivot);
			
			//������ j�� �������� �̵���Ų��
			while(i < --j && pivot < a[j]);
			
			//������ i�� j�� �浹�ϸ� ������ ����������
			if(i >= j) {
				break;
			}
			//i�� ����Ű�� ��ҿ� j�� ����Ű�� ��Ҹ� ��ȯ�Ѵ�
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		//a[i]�� ������ ��ȯ�Ѵ�
		int temp = a[i];
		a[i] = a[j];
		a[r] = temp;
		return i;
	}
	
	//������ �� ��Ʈ�� �����Ѵ�
	//�迭 a���� a[1] ~ a[r]�� �����Ѵ�
	private static void quickSort(int[] a, int l, int r) {
		//������ ��Ұ� �ϳ���� �ƹ��͵� ���� �ʰ� ���ư���
		if(l >= r) {
			return;
		}
		//���� v�� �������� �����Ѵ�
		int v = partition(a, l ,r);
		
		//���� �κ� �迭 a[l] ~ a[v-1]�� �����Ѵ�
		quickSort(a, l, v-1);
		
		//������ �κ� �迭 a[v+1] ~ a[r]�� �����Ѵ�
		quickSort(a, v+1, r);
	}
	
//	�� ��Ʈ�� �̿��Ͽ� �迭�� �����Ѵ�
//	
//	@param a ������ �迭
	public static void sort(int[] a) {
		quickSort(a, 0, a.length-1); 
	}
}
