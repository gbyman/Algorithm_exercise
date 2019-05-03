package algorithm;

public class BinarySearch {
	
	//���̺��� ���
	class Entry{
		
		int key;	//�� ����� �Ǵ� Ű
		Object data;	//�� ���� ����
		
		//��Ҹ� �����Ѵ�
		//@param key	Ű
		//@param data	key�� �����ϴ� ������
		
		public Entry(int key, Object data) {
			
			this.key = key;
			this.data = data;
		}
		
	}
	
	final static int MAX = 100;	//�������� �ִ� ����
	Entry[] table = new Entry[MAX];	//�����͸� ������ �迭
	int n = 0;	//table�� ��ϵǾ��ִ� �������� ����
	
	//add �޼��� ������ ����
	
	
	//Ű key�� �����ϴ� �����͸� ã�´�.
	//@param key Ű
	//@param key�� �����ϴ� ������. Ű�� ã�� ���ϸ� null�� ��ȯ
	public Object search(int key) {
		
		int low, high, middle;
		
		low = 0;	//(1)
		high = n - 1;	//(2)
		
		while(low <= high) {	//(3)
			middle = (low + high) / 2;	//(4)
			if(key == table[middle].key) {	//(5)
				return table[middle].data;	//(6) ã�Ҵ�
			} else if(key < table[middle].key) {	//(7)
				high = middle - 1;	//(8)
			} else {	// key > table[middle].key�̴�.
				low = middle + 1;	//(9)
			}
		}
		return null;	//(10) ã�� ���ߴ�.
	}

}
