package algorithm;
//�迭�� ������ ť
public class MyQueue {
	
	Object[] queue;	//ť
	int queueSize;	//ť ũ��
	int front;	//ť�� ����Ʈ
	int rear;	//ť�� ����(��Ȯ�ϰ� ����ϸ�, ���� ���� ��Ҹ� ����Ŵ)
	
	//ť�� �⺻ ũ��
	static int DEFAULT_QUEUE_SIZE = 100;
	
	//ť�� �����Ѵ�(ũ��� DEFAULT_QUEUE_SIZE)
	public MyQueue() {
		this(DEFAULT_QUEUE_SIZE);
	}
	
//	ũ�⸦ �����Ͽ� ť�� �����Ѵ�
//	
//	@param size ť�� ũ��
	public MyQueue(int size) {
		queueSize = size;
		queue = new Object[size];
		front = rear = 0;
	}
	
//	���� ó��
//	�޽��� s�� ǥ���ϰ� ���α׷��� �����Ų��
//	
//	@param s �޽���
	private void error(String s) {
		System.err.println(s);
		System.exit(1);
	}
	
//	���� ����� ÷�ڸ� ���Ѵ�
//	
//	@param a ���� ����� ÷��
	private int next(int a) {
		return (a + 1) % queueSize;
	}
	
//	ť�� ����
	public void clear() {
		front = rear = 0;
	}
	
//	ť�� �����͸� �ִ´�
//	
//	@param x ť�� ���� ������
	public void enqueue(Object x) {
		if(next(rear) == front) {
			error("�� �̻� ť�� ��Ҹ� �߰��� �� �����ϴ�.");
		}
		queue[rear] = x;
		rear = next(rear);
	}
	
//	ť���� �����͸� ������
//	
//	@return ť���� ���� ������
	public Object dequeue() {
		if(front == rear) {
			error("ť�� ����ֱ� ������ ��Ҹ� ���� �� �����ϴ�.");
		}
		Object x = queue[front];
		front = next(front);
		return x;
	}
	
//	ť�� ����ִ��� �����Ѵ�
//	
//	@return ����ִٸ� true, ������� �ʴٸ� false�� ��ȯ
	public boolean insEmpty() {
		return front == rear;
	}
	
//	ť�� ������ ���ڿ��� ǥ��
//	
//	@return ť�� ����
	public String toString() {
		String s;
		
		s = "MyQueue = [";
		for (int i = front; i != rear; i = next(i)) {
			s += queue[i] + " ";
		}
		s += "] front = " + front + " rear = " + rear;
		return s;
	}
	
//	�׽�Ʈ �� ���� ��ƾ
	public static void main(String[] args) {
		MyQueue q = new MyQueue(5);
		
		q.enqueue("a");
		System.out.println("a�� �־���");
		
		q.enqueue("b");
		System.out.println("b�� �־���");
		
		q.enqueue("c");
		System.out.println("c�� �־���");
		
		System.out.println(q);
		System.out.println(q.dequeue() + "�� ���´�");
		System.out.println(q.dequeue() + "�� ���´�");
		System.out.println(q);
		
		q.enqueue("d");
		System.out.println("d�� �־���");
		
		q.enqueue("e");
		System.out.println("e�� �־���");
		
		System.out.println(q.dequeue() + "�� ���´�");
		System.out.println(q);
		
		q.enqueue("f");
		System.out.println("f�� �־���");
		
		System.out.println(q.dequeue() + "�� ���´�");
		System.out.println(q.dequeue() + "�� ���´�");
		System.out.println(q);
		q.clear();
		System.out.println(q);
		
		q.enqueue("g");
		System.out.println("g�� �֞j��");
		
		q.enqueue("h");
		System.out.println("h�� �־���");
		System.out.println(q);
	}
}
