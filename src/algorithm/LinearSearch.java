package algorithm;

public class LinearSearch {
	
	//���̺��� ��Ʈ��
	class Entry{
		
		int key;	//�� ����� �Ǵ� Ű
		Object data;	// �� ���� ����
		
		//��Ʈ���� �����Ѵ�
		//@param key Ű
		//@param data key�� �����ϴ� ������
		
		public Entry(int key, Object data) {
			this.key = key;
			this.data = data;
		}
		
	}
	
	final static int MAX = 100;	//�������� �ִ� ����
	Entry[] table = new Entry[MAX];	//�����͸� ������ �迭
	int n = 0;	//tqble�� ��ϵǾ� �ִ� �������� ����
	
	//�����͸� ����Ѵ�
	//@param key Ű
	//@param data key�� �����ϴ� ������
	
	public void add(int key, Object data) {
		
		if (n >= MAX) {
			System.err.println("�������� ������ �ʹ� �����ϴ�.");
			System.exit(1);	//���� �ڵ� 1�� �̻� ���Ḧ �ǹ�
		}
		table[n++] = new Entry(key, data);
	}
	
	//key�� �����ϴ� �����͸� ã�´�
	//@param key Ű
	//@return Ű�� �����ϴ� ������, Ű�� �߰ߵ��� �ʾ����� null�� ��ȯ
	
	public Object search(int key) {
		int i;
		
		i = 0;	//(1)
		while(i < n) {	//(2)
			if(table[i].key == key) {	//(3)
				return (table[i].data);	//(4) �߰��ߴ�
			}
			i++;	//(5)
		}
		return null;	//(6) �߰����� ���ߴ�.
	}
	
	public static void main(String[] args) {
		
		LinearSearch table = new LinearSearch();	//�����͸� �����Ѵ�.
		
		table.add(1, "one");	//�����͸� ����Ѵ�.
		table.add(10, "ten");
		table.add(2, "two");
		
		String x;	//Ž���Ѵ�.
		x = (String)table.search(10);
		if (x != null) {
			System.out.println("value = "+ x );
		} else {
			System.out.println("Not found!");
		}
	}

}
