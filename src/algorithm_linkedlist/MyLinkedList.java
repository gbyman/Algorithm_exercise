package algorithm_linkedlist;
//
//연결리스트
//항상 요소(정수)가 오름차순이 되도록 한다

public class MyLinkedList {
	
	Cell header;	//리스트의 헤드로의 링크
//	
//	연결 리스트를 생성한다
//	생성된 연결 리스트는 비어있다
	MyLinkedList(){
		header = new Cell("**List Head**");	//리스트의 헤드를 작성한다
	}
	
//	연결 리스트에 요소 num을 삽입한다.
//	요소는 연결 리스트가 오름차순이 되는 장소에 삽입된다
//	
//	@param num 삽입할 요소(정수)
	public void insert(int num) {
		//삽입할 장소를 찾는다
		Cell p = header.next;
		Cell q = header;
		while(p != null && num > ((Integer)p.data).intValue()) {
			q = p;
			p = p.next;
		}
		
		//셀을 삽입한다
		Cell newCell = new Cell(new Integer(num));
		newCell.next = p;
		q.next = newCell;
	}
	
//	iterator를 얻는다
//	
//	@return 이 연결 리스트에 대한 iterator
	public MyLinkedListIterator iterator() {
		return new MyLinkedListIterator(this);
	}
	
//	연결 리스트의 내용을 문자열로 반한
//	
//	@return 연결 리스트의 내용
	public String toString() {
		String s;
		
		s = "[ ";
		for(Cell p = header.next; p != null; p = p.next) {
			s += p.data + " ";
		}
		s += " ]";
		return s;
	}
	
//	테스트용 메인 루틴
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
