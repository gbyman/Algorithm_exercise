package algorithm;
// �迭�� ������ ����
public class MyStack {
	
	Object[] stack;	//������ ��ü
	int stackSize;	//������ ũ��
	int sp;	//���� ������
	
	static int DEFAULT_STACK_SIZE = 100;	//�⺻ ���� ũ��
	
//	������ �����Ѵ�(ũ��� DEFAULT_STACK_SIZE)
	public MyStack() {
		this(DEFAULT_STACK_SIZE);
	}

//	ũ�⸦ �����Ͽ� ���� ����
//	
//	@param size	������ ũ��
	public MyStack(int size) {
		stack = new Object[size];
		stackSize = size;
		sp = 0;
	}

//	���� ó��
//	�޽��� s�� ǥ���ϰ� ���α׷��� �����Ų��
//	
//	@param s �޽���
	private void error(String s) {
		System.err.println(s);
		System.exit(1);
	}
	
//	������ ������ ��� ������
	public void clear() {
		sp = 0;	//���� �����͸� 0���� �Ѵ�.
	}
	
//	���ÿ� �����͸� �״´�
//	
//	@param x ���� ������
	public void push(Object x) {
		if(sp >= stackSize) {
			error("Stack overflow");
		}
		stack[sp++] = x;
	}
	
//	���ÿ��� �����͸� ������
//	
//	@return ���ÿ��� ���� ������
	public Object pop() {
		if(sp <= 0) {
			error("Stack underflow");
		}
		return stack[--sp];
	}
	
//	������ ����ִ��� �����Ѵ�
//	
//	@return ����ִٸ� true, ������� �ʴٸ� false�� ��ȯ
	public boolean isEmpty() {
		return sp == 0;
	}
	
//	������ ������ ���ڿ��� ��ȯ
//	
//	@return ������ ����
	public String toString() {
		String s;
		
		s = "MyStack = [";
		for(int i = 0; i < sp; i++) {
			s = s + stack[i];
			if(i < sp - 1) {
				s = s + ", ";
			}
		}
		s = s + "]";
		return s;
	}
	
//	�׽�Ʈ�� ���� ��ƾ
	public static void main(String[] args) {
		
		MyStack stack = new MyStack();
		
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		System.out.println(stack);
		System.out.println("pop : " + stack.pop());
		System.out.println(stack);
		
		stack.push("d");
		stack.push("e");
		stack.push("f");
		
		System.out.println(stack);
		while(!stack.isEmpty()) {
			System.out.println("pop : " + stack.pop());
		}
		System.out.println("DONE! " + stack);
	}
}
