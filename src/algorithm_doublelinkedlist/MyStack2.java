package algorithm_doublelinkedlist;
// ���� ���� ����Ʈ�� �̿��Ͽ� ������ ����
public class MyStack2 {
	
	MyDoublyLinkedList stack; // ������ ������ �ϴ� ���� ���� ����Ʈ
	int nElements; // ���ÿ� ����ִ� ����� ����
	
//	������ �����Ѵ�
	public MyStack2() {
		//������ ������ �ϴ� ���� ���� ����Ʈ�� �Ҵ��Ѵ�
		stack = new MyDoublyLinkedList();
		
		//����� ������ 0���� �Ѵ�
		nElements = 0;
	}
	
//	������ ������ ���� �� ���·� �Ѵ�
	public void clear() {
		//���� ���� ����Ʈ�� �ٽ� �����
		stack = new MyDoublyLinkedList();
		
		//����� ������ 0���� �Ѵ�
		nElements = 0;
	}
	
//	���ÿ� �����͸� �״´�
//	
//	@param x ���� ������
	public void push(Object x) {
		stack.insertLast(x);
		nElements++;
	}
	
//	���ÿ��� �����͸� ������
//	
//	@return ���ÿ��� ���� ������
	public Object pop() {
		Object x = stack.removeLast();
		if(x == null) {
			System.err.println("stack underflow");
			System.exit(1);
		}
		nElements--;
		return x;
	}
	
//	������ ����ִ��� �����Ѵ�
//	
//	@return ����ִٸ� return, ������� �ʴٸ� false�� ��ȯ
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
//	������ ������ ���ڿ��� ��ȯ
//	
//	@return ������ ����
	public String toString() {
		
		return "����� �� = " + nElements + " " + stack.toString();
	}
	
//	�׽�Ʈ�� ���� ��ƾ
	public static void main(String args[]) {
		
		MyStack2 stack = new MyStack2();
		
		stack.push("a");
		System.out.println("a�� �׾Ҵ� ");
		System.out.println(stack);
		
		stack.push("b");
		System.out.println("b�� �׾Ҵ�");
		System.out.println(stack);
		
		stack.push("c");
		System.out.println("c�� �׾Ҵ�");
		System.out.println(stack);
		
		System.out.println(stack.pop() + "�� ���´� ");
		
		stack.push("d");
		System.out.println("d�� �׾Ҵ�");
		System.out.println(stack);
		
		stack.push("e");
		System.out.println("e�� �׾Ҵ�");
		System.out.println(stack);
		
		stack.push("f");
		System.out.println("f�� �׾Ҵ�");
		System.out.println(stack);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + "�� ���´� ");
			System.out.println(stack);
		}
		System.out.println("����ִ� " + stack);
	}
}
