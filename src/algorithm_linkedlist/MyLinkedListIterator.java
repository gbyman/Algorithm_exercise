package algorithm_linkedlist;

import java.util.*;
// ���� ����Ʈ(MyLinkedList Ŭ����)�� ���ͷ�����
public class MyLinkedListIterator implements Iterator{

	Cell p; //���� ��
	
//	���ͷ����͸� �����Ѵ�
//	
//	@param list ���ͷ������� ����� �Ǵ� MyLinkedList ��ü
	MyLinkedListIterator(MyLinkedList list){
		// ���� ���� ����Ʈ ó���� ���̼��� �����Ѵ�
		p = list.header;
	}
	
//	���� ��Ұ� �ִٸ� true�� ��ȯ�Ѵ�
//	
//	@return ���� ��Ұ� �ִٸ� true, ���ٸ� false�� ��ȯ
	public boolean hasNext() {
		return p.next != null;
	}
	
//	���� ��Ҹ� ��ȯ�Ѵ�
//	
//	@return ���� ����� ��
	public Object next() {
		//���� ��Ұ� �������� �ʴ´ٸ� ���� NoSuchElementException�� ���ο��Ѵ�
		if(p.next == null) {
			throw new NoSuchElementException();
		}
		
		//���� ���� ���� ��ҷ� �̵��ϰ� �� �����͸� ��ȯ
		p = p.next;
		return p.data;
	}
	
//	�ٷ����� next�� ��ȯ�� ��Ҹ� �����Ѵ�
	public void remove() {
		
//		�� �޼ҵ�� �������� �ʾҴ�
//		���� UnsupportedOperationException�� ���ο��Ѵ�
		throw new UnsupportedOperationException();
	}
		
//	�׽�Ʈ�� ���� ��ƾ
	public static void main(String[] args) {
		//���� ����Ʈ list�� �ۼ��ϰ� ��� 20, 15, 18, 37, 3�� �߰��Ѵ�
		MyLinkedList list = new MyLinkedList();
		list.insert(20);
		list.insert(15);
		list.insert(18);
		list.insert(37);
		list.insert(3);
		System.out.println(list);
		System.out.println("===============");
		
		//���ͷ����� iter�� �����Ѵ�
		Iterator iter = list.iterator();
		
		//���ͷ����� iter�� �̿��Ͽ� ��� ��Ҹ� ǥ���Ѵ�
		int count = 1;
		while(iter.hasNext()) {
			System.out.println(count++ + "��° ��� : " + iter.next());
		}
	}
}
