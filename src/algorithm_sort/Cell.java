package algorithm_sort;
//���� ����Ʈ�� ��
public class Cell {
	
	Cell next;//���� ������ ��ũ
	Comparable data;//�� ���� ������
	
//	���� �����Ѵ�
//	
//	@param aData�� ���� ������
	Cell(Comparable aData){
		
		next = null;
		data = aData;
	}
}
