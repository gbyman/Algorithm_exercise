package algorithm_sort;
//연결 리스트 버전 머지 소트
public class MergeSortList {
	
//	2개의 연결 리스트 a와 b를 머지한다
//	머지된 연결 리스트의 선두 요소로의 링크를 반환
//	
//	@param a 머지할 연결 리스트
//	@param b 머지할 연결 리스트
//	@return 머지하여 얻어진 연결 리스트의 선두 요소로의 링크
	private static Cell mergeList(Cell a, Cell b) {
		
		//변수 head는 머지 완료된 연결 리스트의 처음 요소(더미 셀)를 가리킨다
		Cell head = new Cell(null);
		//변수 p는 머지 완료 연결 리스트의 마지막 요소를 가리킨다
		Cell p = head;
		
		//연결 리스트 a, b 중 어느 한 쪽이 비게 될 때까지 반복한다
		while(a != null && b != null) {
			
			//연결 리스트 a와 b의 처음 요소를 비교한다
			if(a.data.compareTo(b.data) <= 0) { // a.data <= b.data
				
				//연결 리스트 a의 처음 요소를 제거하여 머지 완료 연결 리스트의 마지막에 연결한다
				p.next = a;
				p = a;
				a = a.next;
			} else {
				//연결 리스트 b의 처음 요소를 제거하여 머지 완료 연결 리스트의 마지막에 연결한다
				p.next = b;
				p = b;
				b = b.next;
			}
		}
		
		//남아있는 요소를 머지로 연결 리스트의 마지막에 연결한다
		if(a == null) {
			p.next = b;
		} else {
			p.next = a;
		}
		
		//머지 완료 연결 리스트를 반환
		return head.next;
	}
	
//	연결 리스트 버전 머지 소트
//	연결 리스트 x를 정렬한다
//	
//	@param x 정렬할 연결 리스트
//	@return 정렬된 연결 리스트의 처음 요소로의 링크를 반환
	public static Cell mergeSortList(Cell x) {
		
		//연결 리스트의 요소가 전혀 없거나 하나밖에 없을 때에는 그대로 돌아간다
		if(x == null || x.next == null) {
			return x;
		}
		
		//연결 리스트를 스캔한 변수를 초기화 한다
		
		// a는 첫 번째 요소를 가리킨다
		Cell a = x;
		
		// b는 세 번째 요소(만약 연결 리스트의 길이가 2일 때에는 두 번째 요소)를 가리킨다
		Cell b = x.next;
		if(b != null) {
			b = b.next;
		}
		
		//변수 b가 연결 리스트의 마지막에 도달할 때까지 변수 a를 1씩 이동, 변수 b를 2씩 이동시킨다
		//변수 b가 마지막에 도달했을 때, 변수 a는 연결 리스트의 거의 정 중앙 요소를 가리키고 있을 것이다
		while(b != null) {
			a = a.next;
			b = b.next;
			if(b != null) {
				b = b.next;
			}
		}
		
		//연결 리스트를 변수 a가 가리키는 요소의 바로 다음에서 둘로 분할한다
		//변수 p는 뒤쪽 연결 리스트의 처음 요소를 가리킨다
		Cell p = a.next;
		a.next = null;
		
		//분할한 연결 리스트를 각각 개별적으로 정렬하여, 그 결과를 머지한다
		return mergeList(mergeSortList(x), mergeSortList(p));
	}
}
