package algorithm_doublelinkedlist;
// ���� ���� ����Ʈ�� ��
public class CellDouble {
	
	CellDouble prev;	//���� ������ ��ũ
	CellDouble next;	//���� ������ ��ũ
	Object data;	//�� ���� ������
	
//	���� �����Ѵ�
//	
//	@param aData �� ���� ������
	CellDouble(Object aData){
		
		prev = next = null;
		data = aData;
	}
}
