package algorithm_linkedlist;
//
//���Ḯ��Ʈ
//�׻� ���(����)�� ���������� �ǵ��� �Ѵ�

public class MyLinkedList {
	
	Cell header;	//����Ʈ�� ������ ��ũ
//	
//	���� ����Ʈ�� �����Ѵ�
//	������ ���� ����Ʈ�� ����ִ�
	MyLinkedList(){
		header = new Cell("**List Head**");	//����Ʈ�� ��带 �ۼ��Ѵ�
	}
	
//	���� ����Ʈ�� ��� num�� �����Ѵ�.
//	��Ҵ� ���� ����Ʈ�� ���������� �Ǵ� ��ҿ� ���Եȴ�
//	
//	@param num ������ ���(����)
	public void insert(int num) {
		//������ ��Ҹ� ã�´�
		Cell p = header.next;
		Cell q = header;
		while(p != null && num > ((Integer)p.data).intValue()) {
			q = p;
			p = p.next;
		}
		
		//���� �����Ѵ�
		Cell newCell = new Cell(new Integer(num));
		newCell.next = p;
		q.next = newCell;
	}
	
//	iterator�� ��´�
//	
//	@return �� ���� ����Ʈ�� ���� iterator
	public MyLinkedListIterator iterator() {
		return new MyLinkedListIterator(this);
	}
	
//	���� ����Ʈ�� ������ ���ڿ��� ����
//	
//	@return ���� ����Ʈ�� ����
	public String toString() {
		String s;
		
		s = "[ ";
		for(Cell p = header.next; p != null; p = p.next) {
			s += p.data + " ";
		}
		s += " ]";
		return s;
	}
	
//	�׽�Ʈ�� ���� ��ƾ
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		
		System.out.println(list);
		list.insert(5);
		
		System.out.println(list);
		list.insert(7);
		
		System.out.println(list);
		list.insert(2);
		
		System.out.println(list);
		list.insert(12);
		
		System.out.println(list);
		list.insert(4);
		
		System.out.println(list);
		
	}
}
