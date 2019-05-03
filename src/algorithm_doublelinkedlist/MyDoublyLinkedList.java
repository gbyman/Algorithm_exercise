package algorithm_doublelinkedlist;
// 이중 연결 리스트
public class MyDoublyLinkedList {
	
	CellDouble head;	//리스트의 헤드로의 링크
	
//	이중 연결 리스트를 생성한다
//	생성된 이중 연결 리스트는 비어있다
	public MyDoublyLinkedList() {
		
		// 리스트의 헤더를 할당한다
		head = new CellDouble("** List Head ");
		
		// 리스트의 헤더의 prev와 next가 자기 자신을 가리키도록 한다
		head.prev = head.next = head;
	}
	
//	이중 연결 리스트의 셀 p의 바로 다음에 데이터 data를 삽입한다
//	
//	@param p 이 셀의 바로 다음에 데이터를 삽입한다
//	@param data 삽입할 데이터
	private void insertAfter(CellDouble p, Object data) {
		CellDouble x = new CellDouble(data);
		x.prev = p;
		x.next = p.next;
		p.next.prev = x;
		p.next = x;
	}
	
//	이중 연결 리스트의 처음에 데이터 data를 삽입한다
//	
//	@param data 삽입할 데이터
	public void insertFirst(Object data) {
		//리스트의 헤드 다음에 삽입한다
		insertAfter(head, data);
	}
	
//	이중 연결 리스트의 마지막에 데이터 x를 삽입한다
//	
//	@param data 삽입할 데이터
	public void insertLast(Object data) {
		//마지막 요소 다음에 삽입한다
		insertAfter(head.prev, data);
	}
	
//	지정된 셀을 삭제한다
	private void removeCell(CellDouble p) {
		p.prev.next = p.next;
		p.next.prev = p.prev;
	}
	
//	이중 연결 리스트의 처음 데이터를 삭제한다
//	
//	@return 삭제한 요소를 반환. 단, 요소가 없다면 null을 반환
	public Object removeFirst() {
		//요소가 없다면 null을 반환
		if(isEmpty()) {
			return null;
		}
		
		//처음 셀을 삭제하고 들어있던 값을 반환
		CellDouble cell = head.next;
		removeCell(cell);
		return cell.data;
	}
	
//	이중 연결 리스트의 마지막 데이터를 삭제한다
//	
//	@return 삭제한 요소를 반환. 단, 요소가 없다면 null을 반환
	public Object removeLast() {
		//요소가 없다면 null을 반환
		if(isEmpty()) {
			return null;
		}
		//마지막 요소를 삭제하고 들어있던 값을 반환
		CellDouble cell = head.prev;
		removeCell(cell);
		return cell.data;
	}

//	이중 연결 리스트가 비어있는지를 체크한다
//	
//	@return 비어있다면 true, 비어있지 않다면 false를 반환
	public boolean isEmpty() {
		
		return head.next == head;
	}
	
//	이중 연결 리스트의 내용을 문자열로 반환
//	
//	@return 이 이중 연결 리스트의 내용
	public String toString() {
		String s;
		
		s = "[ ";
		for (CellDouble p = head.next; p != head; p = p.next) {
			s += p.data + " ";
		}
		s += "]";
		return s;
	}
	
//	테스트용 메인 루틴
	public static void main(String args[]) {
		
		MyDoublyLinkedList list = new MyDoublyLinkedList();
		
		//요소를 삽입한다
		System.out.println("처음 상태(빈 리스트)");
		System.out.println(list);
		
		list.insertFirst("a");
		System.out.println("a를 처음에 삽입");
		System.out.println(list);
		
		list.insertFirst("b");
		System.out.println("b를 마지막에 삽입");
		System.out.println(list);
		
		list.insertFirst("c");
		System.out.println("c를 처음에 삽입");
		System.out.println(list);
		
		list.insertFirst("d");
		System.out.println("d를 처음에 삽입");
		System.out.println(list);
		
		list.insertFirst("e");
		System.out.println("e를 마지막에 삽입");
		System.out.println(list);
		
		//요소를 삭제한다
		//변수 i를 이용하여 리스트의 처음과 마지막에서 교대로 요소를 삭제한다
		int i = 0;
		while(!list.isEmpty()) {
			if(i++ % 2 == 0) {
				System.out.println(list.removeFirst() + "을 제거(처음) ");
			} else {
				System.out.println(list.removeLast() + "을 제거(마지막) ");
			} 
			System.out.println(list);
		}
	}
}
