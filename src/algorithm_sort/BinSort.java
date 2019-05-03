package algorithm_sort;
// �� ��Ʈ�� �����Ѵ�
public class BinSort {

//	�� ��Ʈ�� �����Ѵ�. ���� ���� �迭 a�� ������ �����Ѵ�
//	
//	@param a ������ �迭
	public static void sort(BinSortData[] a) {
		
		final int N = a.length; //�迭�� ��� ��
		final int M = BinSortData.M; //Ű�� 0���� M����
				
//		���� �Ҵ��Ѵ�
//		�Ҵ��� �Ŀ��� ��� �� ����ִٴ� ���� ��Ÿ���� null�� ����ȴ�
		BinSortData[] bin = new BinSortData[M + 1];
		
		//�迭 a�� �����͸� ������� �� �ִ´�
		for(int i = 0; i < N; i++) {
			bin[a[i].getKey()] = a[i];
		}
		
		//�����͸� �󿡼� (������������) ���� �迭 a�� �ǵ�����
		int j = 0;
		for(int i = 0; i <= M; i++) {
			if(bin[i] != null) {
				a[j++] = bin[i];
			}
		}
	}
}
