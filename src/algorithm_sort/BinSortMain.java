package algorithm_sort;
// �� ��Ʈ �׽�Ʈ ���α׷�
public class BinSortMain {
	
//	�� ��Ʈ ������ �����ش�
	public static void main(String[] args) {
		// ��Ʈ�� �迭�� �ʱ�ȭ �Ѵ�
		BinSortData[] array = new BinSortData[] {
				new BinSortData(13, "��� 0"),
				new BinSortData(24, "��� 1"),
				new BinSortData(15, "��� 2"),
				new BinSortData(5, "��� 3"),
				new BinSortData(98, "��� 4"),
				new BinSortData(44, "��� 5"),
				new BinSortData(35, "��� 6"),
				new BinSortData(96, "��� 7"),
				new BinSortData(82, "��� 8"),
				new BinSortData(73, "��� 9"),
		};
		
		//�迭 array�� ������ ǥ���Ѵ�
		System.out.println("�����ϱ� ��");
		for(int i = 0; i < array.length; i++) {
			System.out.println("key = " + array[i].getKey() + " data = " + array[i].getData());
		}
		
		//�迭 array�� �� ��Ʈ�Ѵ�
		BinSort.sort(array);
		
		//�迭 array�� ������ ǥ���Ѵ�
		System.out.println("������ ��");
		for(int i = 0; i < array.length; i++) {
			System.out.println("key = " + array[i].getKey() + " data = " + array[i].getData());
		}
	}
}
