package algorithm_linkedlist;
// ���� ����Ʈ�� ��
public class Cell {
	
	Cell next; //���� ������ ��ũ
	Object data; //�� ���� ������
	
//	���� �����Ѵ�
//	
//	@param aData �� ���� ������
	Cell(Object aData){
		next = null;
		data = aData;
	}
	
//	����Ʈ�� ó���� ��Ҹ� ������ ���
//	x = header;  //��� �� �� List 5.2�� ó�� ����
//	
//	���� ����Ʈ�� ����(�߰��� �����ϴ� ���) List 5.2
//	���� x�� ����Ű�� �ִ� ���� �ٷ� ������ ���ο� ���� �����Ѵ�
//	Cell x; //�� ������ ����Ű�� ���� �ٷ� ������ �����Ѵ�
//	Object data; //���ο� ���� ������ ��
	
//	Cell p = new Cell(data); 
//	p.next = x.next;
//	x.next = p;
	
//	���� ����Ʈ�� ����(���ο� �����ϴ� ���) List 5.3
//	���� header�� ����Ű�� �ִ� ó�� ����� �տ� ���ο� ���� �����Ѵ�
//	Cell header; //ó�� ��ҷ��� ��ũ
//	Object data; //���ο� ���� ������ ��
	
//	Cell p = new Cell(data);
//	p.next = header;
//	header = p;
	
//	���� ����Ʈ�� ������ ��Ҵ� header�� �ƴ� header.next�� �ȴ�
//	���� �ϳ��� ������� �湮�ϴ� ó��
//	for(Cell p = header.next; p!= null; p = p.next) {
//		System.out.println(p.data);
//	}
	
//	����Ʈ�� ó�� �� ����
//	x = header; ��� ���� List 5.4 ���ा
//	
//	List 5.4 ���Ḯ��Ʈ���� ����(2��° ���� ��Ҹ� ������ ���)
//	���� x�� ����Ű�� �ִ� ���� �ٷ� ���� ��Ҹ� �����Ѵ� 
//	Cell x;
//	Object data;
//	
//	if(x.next == null) {
//		fatalError("���� ���� ���� ������ ������ �� �����ϴ�.");
//	}
//	Cell p = x.next;
//	x.next = p.next;
//	data = p.data;	//������ ���� �����͸� ���� data�� �����Ѵ�
//	
//	List 5.5 ���� ����Ʈ���� ����(ó�� ��Ҹ� �����ϴ� ���)
//	
//	Cell header;	//�� ��ũ�� ����Ű�� �ִ� ��(ó�� ���)�� �����Ѵ�
//	Object data;	//�� ��ҿ� �� ���� �����Ѵ�
//	
//	if(header == null) {
//		fatalError("����Ʈ�� ����־� ������ �� �����ϴ�.");
//	}
//	Cell p = header;
//	header = p.next;
//	data = p.data;	//������ ���� �����͸� ���� data�� �����Ѵ�
}
