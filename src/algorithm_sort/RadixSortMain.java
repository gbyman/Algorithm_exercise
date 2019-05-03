package algorithm_sort;
// ��� ��Ʈ ���� ���α׷�
public class RadixSortMain {
	
	// ��� ��Ʈ ������ �����ش�
	public static void main(String[] args) {
		
		// ��Ʈ�� �迭�� �ʱ�ȭ�Ѵ�
		RadixSortData[] array = new RadixSortData[] {
			new RadixSortData(0x2f38, "��� 0"),
			new RadixSortData(0x2fb7, "��� 1"),
			new RadixSortData(0x9328, "��� 2"),
			new RadixSortData(0xa400, "��� 3"),
			new RadixSortData(0x000f, "��� 4"),
			new RadixSortData(0x0002, "��� 5"),
			new RadixSortData(0x0844, "��� 6"),
			new RadixSortData(0xef85, "��� 7"),
			new RadixSortData(0x289a, "��� 8"),
			new RadixSortData(0x2f30, "��� 9"),
		};
		
		// �迭 array�� ������ ǥ���Ѵ�
		System.out.println("�����ϱ� ��");
		RadixSort.dumpArray(array);
		
		// �迭 array�� ��� ��Ʈ�Ѵ�
		RadixSort.sort(array);
	}
}
