package algorithm_doublelinkedlist;
// ���� ���� ����Ʈ
public class MyDoublyLinkedList {
	
	CellDouble head;	//����Ʈ�� ������ ��ũ
	
//	���� ���� ����Ʈ�� �����Ѵ�
//	������ ���� ���� ����Ʈ�� ����ִ�
	public MyDoublyLinkedList() {
		
		// ����Ʈ�� ����� �Ҵ��Ѵ�
		head = new CellDouble("** List Head ");
		
		// ����Ʈ�� ����� prev�� next�� �ڱ� �ڽ��� ����Ű���� �Ѵ�
		head.prev = head.next = head;
	}
	
//	���� ���� ����Ʈ�� �� p�� �ٷ� ������ ������ data�� �����Ѵ�
//	
//	@param p �� ���� �ٷ� ������ �����͸� �����Ѵ�
//	@param data ������ ������
	private void insertAfter(CellDouble p, Object data) {
		CellDouble x = new CellDouble(data);
		x.prev = p;
		x.next = p.next;
		p.next.prev = x;
		p.next = x;
	}
	
//	���� ���� ����Ʈ�� ó���� ������ data�� �����Ѵ�
//	
//	@param data ������ ������
	public void insertFirst(Object data) {
		//����Ʈ�� ��� ������ �����Ѵ�
		insertAfter(head, data);
	}
	
//	���� ���� ����Ʈ�� �������� ������ x�� �����Ѵ�
//	
//	@param data ������ ������
	public void insertLast(Object data) {
		//������ ��� ������ �����Ѵ�
		insertAfter(head.prev, data);
	}
	
//	������ ���� �����Ѵ�
	private void removeCell(CellDouble p) {
		p.prev.next = p.next;
		p.next.prev = p.prev;
	}
	
//	���� ���� ����Ʈ�� ó�� �����͸� �����Ѵ�
//	
//	@return ������ ��Ҹ� ��ȯ. ��, ��Ұ� ���ٸ� null�� ��ȯ
	public Object removeFirst() {
		//��Ұ� ���ٸ� null�� ��ȯ
		if(isEmpty()) {
			return null;
		}
		
		//ó�� ���� �����ϰ� ����ִ� ���� ��ȯ
		CellDouble cell = head.next;
		removeCell(cell);
		return cell.data;
	}
	
//	���� ���� ����Ʈ�� ������ �����͸� �����Ѵ�
//	
//	@return ������ ��Ҹ� ��ȯ. ��, ��Ұ� ���ٸ� null�� ��ȯ
	public Object removeLast() {
		//��Ұ� ���ٸ� null�� ��ȯ
		if(isEmpty()) {
			return null;
		}
		//������ ��Ҹ� �����ϰ� ����ִ� ���� ��ȯ
		CellDouble cell = head.prev;
		removeCell(cell);
		return cell.data;
	}

//	���� ���� ����Ʈ�� ����ִ����� üũ�Ѵ�
//	
//	@return ����ִٸ� true, ������� �ʴٸ� false�� ��ȯ
	public boolean isEmpty() {
		
		return head.next == head;
	}
	
//	���� ���� ����Ʈ�� ������ ���ڿ��� ��ȯ
//	
//	@return �� ���� ���� ����Ʈ�� ����
	public String toString() {
		String s;
		
		s = "[ ";
		for (CellDouble p = head.next; p != head; p = p.next) {
			s += p.data + " ";
		}
		s += "]";
		return s;
	}
	
//	�׽�Ʈ�� ���� ��ƾ
	public static void main(String args[]) {
		
		MyDoublyLinkedList list = new MyDoublyLinkedList();
		
		//��Ҹ� �����Ѵ�
		System.out.println("ó�� ����(�� ����Ʈ)");
		System.out.println(list);
		
		list.insertFirst("a");
		System.out.println("a�� ó���� ����");
		System.out.println(list);
		
		list.insertFirst("b");
		System.out.println("b�� �������� ����");
		System.out.println(list);
		
		list.insertFirst("c");
		System.out.println("c�� ó���� ����");
		System.out.println(list);
		
		list.insertFirst("d");
		System.out.println("d�� ó���� ����");
		System.out.println(list);
		
		list.insertFirst("e");
		System.out.println("e�� �������� ����");
		System.out.println(list);
		
		//��Ҹ� �����Ѵ�
		//���� i�� �̿��Ͽ� ����Ʈ�� ó���� ���������� ����� ��Ҹ� �����Ѵ�
		int i = 0;
		while(!list.isEmpty()) {
			if(i++ % 2 == 0) {
				System.out.println(list.removeFirst() + "�� ����(ó��) ");
			} else {
				System.out.println(list.removeLast() + "�� ����(������) ");
			} 
			System.out.println(list);
		}
	}
}
