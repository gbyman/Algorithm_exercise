package algorithm;
//배열로 구현한 큐
public class MyQueue {
	
	Object[] queue;	//큐
	int queueSize;	//큐 크기
	int front;	//큐의 프론트
	int rear;	//큐의 리어(정확하게 얘기하면, 리어 다음 요소를 가리킴)
	
	//큐의 기본 크기
	static int DEFAULT_QUEUE_SIZE = 100;
	
	//큐를 생성한다(크기는 DEFAULT_QUEUE_SIZE)
	public MyQueue() {
		this(DEFAULT_QUEUE_SIZE);
	}
	
//	크기를 지정하여 큐를 생성한다
//	
//	@param size 큐의 크기
	public MyQueue(int size) {
		queueSize = size;
		queue = new Object[size];
		front = rear = 0;
	}
	
//	에러 처리
//	메시지 s를 표시하고 프로그램을 종료시킨다
//	
//	@param s 메시지
	private void error(String s) {
		System.err.println(s);
		System.exit(1);
	}
	
//	다음 요소의 첨자를 구한다
//	
//	@param a 현재 요소의 첨자
	private int next(int a) {
		return (a + 1) % queueSize;
	}
	
//	큐를 비운다
	public void clear() {
		front = rear = 0;
	}
	
//	큐에 데이터를 넣는다
//	
//	@param x 큐에 넣을 데이터
	public void enqueue(Object x) {
		if(next(rear) == front) {
			error("이 이상 큐에 요소를 추가할 수 없습니다.");
		}
		queue[rear] = x;
		rear = next(rear);
	}
	
//	큐에서 데이터를 꺼낸다
//	
//	@return 큐에서 꺼낸 데이터
	public Object dequeue() {
		if(front == rear) {
			error("큐가 비어있기 때문에 요소를 꺼낼 수 없습니다.");
		}
		Object x = queue[front];
		front = next(front);
		return x;
	}
	
//	큐가 비어있는지 조사한다
//	
//	@return 비어있다면 true, 비어있지 않다면 false를 반환
	public boolean insEmpty() {
		return front == rear;
	}
	
//	큐의 내용을 문자열로 표시
//	
//	@return 큐의 내용
	public String toString() {
		String s;
		
		s = "MyQueue = [";
		for (int i = front; i != rear; i = next(i)) {
			s += queue[i] + " ";
		}
		s += "] front = " + front + " rear = " + rear;
		return s;
	}
	
//	테스트 용 메인 루틴
	public static void main(String[] args) {
		MyQueue q = new MyQueue(5);
		
		q.enqueue("a");
		System.out.println("a를 넣었다");
		
		q.enqueue("b");
		System.out.println("b를 넣었다");
		
		q.enqueue("c");
		System.out.println("c를 넣었다");
		
		System.out.println(q);
		System.out.println(q.dequeue() + "를 꺼냈다");
		System.out.println(q.dequeue() + "를 꺼냈다");
		System.out.println(q);
		
		q.enqueue("d");
		System.out.println("d를 넣었다");
		
		q.enqueue("e");
		System.out.println("e를 넣었다");
		
		System.out.println(q.dequeue() + "를 꺼냈다");
		System.out.println(q);
		
		q.enqueue("f");
		System.out.println("f를 넣었다");
		
		System.out.println(q.dequeue() + "를 꺼냈다");
		System.out.println(q.dequeue() + "를 꺼냈다");
		System.out.println(q);
		q.clear();
		System.out.println(q);
		
		q.enqueue("g");
		System.out.println("g를 넣엏다");
		
		q.enqueue("h");
		System.out.println("h를 넣었다");
		System.out.println(q);
	}
}
