package algorithm_hash;

// ü��ȭ�� �̿��� �ؽ� ǥ

public class HashC {

	//���� ����Ʈ�� ��
	private class Cell{
		MyKey key;	//Ű
		Object data; //������
		Cell next; //���� ������ ��ũ
		
//		���� �����Ѵ�
//		
//		@param aKey Ű
//		@param aData ������
		private Cell(MyKey aKey, Object aData) {
			key = aKey;
			data = aData;
		}
	}
	
	Cell[] table; //�ؽ� ǥ
	int bucketSize; //��Ŷ�� ����
	int nElements; //��ϵǾ� �ִ� �������� ����
	
	//�ؽ� ǥ�� ũ��(�⺻��)
	static final int DEFAULT_BUCKET_SIZE = 50;
	
	//�ؽ� ǥ�� �����Ѵ�(ũ��� DEFAULT_BUCKET_SIZE)
	public HashC() {
		this(DEFAULT_BUCKET_SIZE);
	}
	
//	�ؽ� ǥ�� �����Ѵ�
//	
//	@param bucketSize �ؽ� ǥ�� ũ��
	public HashC(int bucketSize) {
		//�ؽ� ǥ�� ������ �ϴ� �迭�� �Ҵ��Ѵ�
		table = new Cell[bucketSize];
		
		//�ؽ� ǥ�� ��Ŷ ������ ����� �д�
		this.bucketSize = bucketSize;
		
		//����� ������ 0���� �صд�. �ʱ�ȭ
		nElements = 0;
	}
	
//	�ؽ� �Լ�
//	Ű�� �Ǵ� ��ü�� hashCode �޼ҵ尡 ��ȯ�� ����, ��Ŷ�� ������ ���� �������� ��ȯ
//	
//	@param key Ű
//	@return �־��� Ű�� ���� �ؽ� ��
	private int hash(MyKey key) {
		
		return key.hashCode() % bucketSize;
	}
	
//	�ؽ� ǥ�� Ž���Ѵ�
//	
//	@param key Ž���� Ű
//	@return Ű�� �߰ߵǸ� �װ��� ��ȯ, �߰ߵ��� �ʾ����� null�� ��ȯ
	public Object find(MyKey key) {
		for(Cell p = table[hash(key)]; p != null; p = p.next) {
			if(key.equals(p.key)) {
				return p.data;
			}
		}
		return null;
	}
	
//	ü��ȭ�� �����ϱ� ���ؼ��� ����, Ž��, ���� 3���� ����� �ʿ��ϴ� ��
//	�ؽ� ǥ�� �����͸� �����Ѵ�
//	
//	@param key Ű
//	@param data ����� ������
//	@return ��Ͽ� �����ϸ� true, �����ϸ�(�̹� Ű ���� ���� �����Ͱ� ������) false�� ��ȯ
	public boolean insert(MyKey key, Object data) {
		if(find(key) != null) {
			return false;
		}
		Cell p = new Cell(key, data);
		int h = hash(key);
		p.next = table[h];
		table[h] = p;
		
		nElements++; //����� ������ 1 ����
		return true;
	}
	
//	�ؽ� ǥ���� �����͸� �����Ѵ�
//	
//	@param key ������ �������� Ű
//	@return ������ �����ϸ� true, �����͸� ã�� ���ϸ� false�� ��ȯ
	public boolean delete(MyKey key) {
		int h = hash(key);
		
		//��Ŷ�� ����ִ°�?
		if(table[h] == null) {
			return false;
		}
		
		//����Ʈ�� ���� ���� ������ �������ΰ�?
		if(key.equals(table[h].key)) {
			Cell p = table[h];
			table[h] = p.next;
			nElements--; //����� ������ 1 ����
			return true;
		}
		
		//����Ʈ�� �� ��° �� ���ĺ��� ������� üũ�Ѵ�
		Cell p;
		Cell q;
		for(q = table[h], p = q.next; p != null; q = p, p = p.next) {
			if(key.equals(p.key)) {
				q.next = p.next;
				nElements--; //����� ������ 1 ����
				return true;
			}
		}
		return false;
	}
	
//	�ؽ� ǥ�� ������ ���ڿ��� ��ȯ
//	
//	@return �ؽ� ǥ�� ����
	public String toString() {
		String s = "";
		
		//��� ��Ŷ�� ������� ó���Ѵ�
		for(int i = 0; i < table.length; i++) {
			s += "��Ŷ" + i + " : ";
			
			//�� ��Ŷ�� ������ ���ڿ� s�� �߰��Ѵ�
			for(Cell p = table[i]; p != null; p = p.next) {
				s += "[" + p.key + " : " + p.data + "] ";
			}
			s += "\n";
		}
		//��ϵǾ� �ִ� ����� ������ �߰��Ѵ�
		s += "����� ���� : " + nElements + "\n";
		return s;
	}
	
	//�׽�Ʈ�� ���� ��ƾ
	public static void main(String[] args) {
		String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"one", //�̰��� ����� �� ������ ���̴�
				"eleven", "twelve", "thirteen", "fourteen", "fifteen",
				"sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
		
		//�ؽ� ǥ�� �����Ѵ�(�׽�Ʈ�� ���� ��Ŷ ������ 15���� �����Ѵ�)
		HashC hash = new HashC(15);
		
		//�迭 words�� ����ִ� �ܾ ������� ����Ѵ�
		System.out.println("----<< 1 �ܰ� >>---[���]--------");
		for(int i = 0; i < words.length; i++) {
			boolean stat = hash.insert(new MyKey(words[i]), "���� = " + (i + 1));
			if(stat == false) {
				System.out.println(words[i] + "�� ��Ͽ� �����Ͽ���. (�ߺ���)");
			}
		}
		System.out.println(hash); //�ؽ� ǥ�� ������ ����Ѵ�
		
//		�迭 keys�� ����ִ� �ܾ Ž���Ѵ�
		System.out.println("---- << 2 �ܰ� >>---[Ž��]--------");
		String[] keys = {"ten", "thirteen", "one", "ones", "five"};
		for(int i = 0; i < keys.length; i++) {
			Object result = hash.find(new MyKey(keys[i]));
			if(result != null) {
				System.out.println("Ű [" + keys[i] + "]�� ���� [" + result + "]�̴�.");
			} else {
				System.out.println("Ű [" + keys[i] + "]�� �߰����� ���Ͽ���.");
			}
		}
		
//		�迭 keys�� ����ִ� �ܾ �����Ѵ�
		System.out.println("----<< 3 �ܰ�>>---[����]--------");
		for(int i = 0; i < keys.length; i++) {
			if(hash.delete(new MyKey(keys[i]))) {
				System.out.println("Ű [" + keys[i] + "]�� �����Ͽ���.");
			} else {
				System.out.println("Ű [" + keys[i] + "]�� ������ �����Ͽ���. (��ϵǾ����� ����)");
			}
		}
		
//		�迭 keys�� ����ִ� �ܾ �ٽ� Ž���Ѵ�
//		��� ������ ���̴�
		System.out.println("----<< 4 �ܰ� >>----[Ž�� : ��� �����Ѵ�]--------");
		for(int i = 0; i < keys.length; i++) {
			Object result = hash.find(new MyKey(keys[i]));
			if(result != null) {
				System.out.println("Ű [" + keys[i] + "]�� ���� [" + result + "]�̴�.");
			} else {
				System.out.println("Ű [" + keys[i] + "]�� �߰����� ���Ͽ���.");
			}
		}
		
//		�ؽ� ǥ�� ������ ǥ���Ѵ�
		System.out.println("----<< 5 �ܰ� >>------------");
		System.out.println(hash);
	}
}
