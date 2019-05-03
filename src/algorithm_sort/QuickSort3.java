package algorithm_sort;
// �� ��Ʈ (����� ����, ���� �����÷ο� ��å �����)
public class QuickSort3 {
//partition �޼ҵ�� QuickSort1�� ����
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
	
//	�� ��Ʈ�� �̿��Ͽ� �迭�� �����Ѵ�
//	
//	@param a ������ �迭
	public static void sort(int[] a) {
		
		int n = a.length;
		int[] low = new int[30];
		int[] high = new int[30];
		int sp;
		
		//������ �ʱ�ȭ �Ѵ�
		low[0] = 0;
		high[0] = n - 1;
		sp = 1;
		
		//������ �� ������ �ݺ��Ѵ�
		while(sp > 0) {
			//���ÿ��� ������ ������ ������
			int l = low[--sp];
			int r = high[sp];
			
			//������ ��Ұ� �ϳ���� �ƹ��͵� ���� �ʴ´�
			//(�ٽ� while ���� �����Ѵ�)
			if(l >= r) {
				//�ƹ��͵� ���� �ʴ´�
			} else {
				//���� v�� �������� �����Ѵ�
				int v = partition(a, l, r);
				
				//�¿� �κ� �迭 �� ª�� ���� ���� ó���Ѵ�
				if(v - 1 < r - v) {
					//���� �κ� �迭�� ���� �����Ѵ�
					//(�����̱� ������ ������ -> ���� ������ �״� �Ϳ� ����)
					low[sp] = v + 1;
					high[sp++] = r;
					low[sp] = l;
					high[sp++] = v - 1;
				} else {
					//������ �κ� �迭�� ���� �����Ѵ�
					//(�����̱� ������ ���� -> ������ ������ �״� �Ϳ� ����)
					low[sp] = l;
					high[sp++] = v - 1;
					low[sp] = v + 1;
					high[sp++] = r;
				}
			}
		}
	}
}
