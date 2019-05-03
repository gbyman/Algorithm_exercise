package algorithm_linkedlist;
// 연결 리스트의 셀
public class Cell {
	
	Cell next; //다음 셀로의 링크
	Object data; //이 셀의 데이터
	
//	셀을 생성한다
//	
//	@param aData 이 셀의 데이터
	Cell(Object aData){
		next = null;
		data = aData;
	}
	
//	리스트의 처음에 요소를 삽입할 경우
//	x = header;  //라고 한 후 List 5.2의 처리 적용
//	
//	연결 리스트에 삽입(중간에 삽입하는 경우) List 5.2
//	변수 x가 가리키고 있는 셀의 바로 다음에 새로운 셀을 삽입한다
//	Cell x; //이 변수가 가리키는 셀의 바로 다음에 삽입한다
//	Object data; //새로운 셀에 저장할 값
	
//	Cell p = new Cell(data); 
//	p.next = x.next;
//	x.next = p;
	
//	연결 리스트에 삽입(선두에 삽입하는 경우) List 5.3
//	변수 header가 가리키고 있는 처음 요소의 앞에 새로운 셀을 삽입한다
//	Cell header; //처음 요소로의 링크
//	Object data; //새로운 셀에 저장할 값
	
//	Cell p = new Cell(data);
//	p.next = header;
//	header = p;
	
//	연결 리스트의 최초의 요소는 header가 아닌 header.next가 된다
//	셀을 하나씩 순서대로 방문하는 처리
//	for(Cell p = header.next; p!= null; p = p.next) {
//		System.out.println(p.data);
//	}
	
//	리스트의 처음 셀 삭제
//	x = header; 라고 한후 List 5.4 실행ㅎ
//	
//	List 5.4 연결리스트에서 삭제(2번째 이후 요소를 삭제할 경우)
//	변수 x가 가리키고 있는 셀의 바로 다음 요소를 삭제한다 
//	Cell x;
//	Object data;
//	
//	if(x.next == null) {
//		fatalError("다음 셀이 없기 때문에 삭제할 수 없습니다.");
//	}
//	Cell p = x.next;
//	x.next = p.next;
//	data = p.data;	//삭제된 셀의 데이터를 변수 data에 보관한다
//	
//	List 5.5 연결 리스트에서 삭제(처음 요소를 삭제하는 경우)
//	
//	Cell header;	//이 링크가 가리키고 있는 셀(처음 요소)를 삭제한다
//	Object data;	//이 요소에 셀 값을 저장한다
//	
//	if(header == null) {
//		fatalError("리스트가 비어있어 삭제할 수 없습니다.");
//	}
//	Cell p = header;
//	header = p.next;
//	data = p.data;	//삭제된 셀의 데이터를 변수 data에 보관한다
}
