package algorithm_linkedlist;

import java.util.*;
// 연결 리스트(MyLinkedList 클래스)의 이터레이터
public class MyLinkedListIterator implements Iterator{

	Cell p; //현재 셀
	
//	이터레이터를 생성한다
//	
//	@param list 이터레이터의 대상이 되는 MyLinkedList 객체
	MyLinkedListIterator(MyLinkedList list){
		// 현재 셀을 리스트 처음의 더미셀로 설정한다
		p = list.header;
	}
	
//	다음 요소가 있다면 true를 반환한다
//	
//	@return 다음 요소가 있다면 true, 없다면 false를 반환
	public boolean hasNext() {
		return p.next != null;
	}
	
//	다음 요소를 반환한다
//	
//	@return 다음 요소의 값
	public Object next() {
		//다음 요소가 존재하지 않는다면 예외 NoSuchElementException을 스로우한다
		if(p.next == null) {
			throw new NoSuchElementException();
		}
		
		//현재 셀을 다음 요소로 이동하고 그 데이터를 반환
		p = p.next;
		return p.data;
	}
	
//	바로전에 next가 반환한 요소를 삭제한다
	public void remove() {
		
//		이 메소드는 구현하지 않았다
//		예외 UnsupportedOperationException을 스로우한다
		throw new UnsupportedOperationException();
	}
		
//	테스트용 메인 루틴
	public static void main(String[] args) {
		//연결 리스트 list를 작성하고 요소 20, 15, 18, 37, 3을 추가한다
		MyLinkedList list = new MyLinkedList();
		list.insert(20);
		list.insert(15);
		list.insert(18);
		list.insert(37);
		list.insert(3);
		System.out.println(list);
		System.out.println("===============");
		
		//이터레이터 iter를 생성한다
		Iterator iter = list.iterator();
		
		//이터레이터 iter를 이용하여 모든 요소를 표시한다
		int count = 1;
		while(iter.hasNext()) {
			System.out.println(count++ + "번째 요소 : " + iter.next());
		}
	}
}
