package algorithm_doublelinkedlist;
// 이중 연결 리스트를 이용하여 구현한 스택
public class MyStack2 {
	
	MyDoublyLinkedList stack; // 스택의 역할을 하는 이중 연결 리스트
	int nElements; // 스택에 들어있는 요소의 개수
	
//	스택을 생성한다
	public MyStack2() {
		//스택의 역할을 하는 이중 연결 리스트를 할당한다
		stack = new MyDoublyLinkedList();
		
		//요소의 개수를 0으로 한다
		nElements = 0;
	}
	
//	스택의 내용을 비우고 빈 상태로 한다
	public void clear() {
		//이중 연결 리스트를 다시 만든다
		stack = new MyDoublyLinkedList();
		
		//요소의 개수를 0으로 한다
		nElements = 0;
	}
	
//	스택에 데이터를 쌓는다
//	
//	@param x 쌓을 데이터
	public void push(Object x) {
		stack.insertLast(x);
		nElements++;
	}
	
//	스택에서 데이터를 꺼낸다
//	
//	@return 스택에서 꺼낸 데이터
	public Object pop() {
		Object x = stack.removeLast();
		if(x == null) {
			System.err.println("stack underflow");
			System.exit(1);
		}
		nElements--;
		return x;
	}
	
//	스택이 비어있는지 조사한다
//	
//	@return 비어있다면 return, 비어있지 않다면 false를 반환
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
//	스택의 내용을 문자열로 반환
//	
//	@return 스택의 내용
	public String toString() {
		
		return "요소의 수 = " + nElements + " " + stack.toString();
	}
	
//	테스트용 메인 루틴
	public static void main(String args[]) {
		
		MyStack2 stack = new MyStack2();
		
		stack.push("a");
		System.out.println("a를 쌓았다 ");
		System.out.println(stack);
		
		stack.push("b");
		System.out.println("b를 쌓았다");
		System.out.println(stack);
		
		stack.push("c");
		System.out.println("c를 쌓았다");
		System.out.println(stack);
		
		System.out.println(stack.pop() + "을 꺼냈다 ");
		
		stack.push("d");
		System.out.println("d를 쌓았다");
		System.out.println(stack);
		
		stack.push("e");
		System.out.println("e를 쌓았다");
		System.out.println(stack);
		
		stack.push("f");
		System.out.println("f를 쌓았다");
		System.out.println(stack);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + "를 꺼냈다 ");
			System.out.println(stack);
		}
		System.out.println("비어있다 " + stack);
	}
}
