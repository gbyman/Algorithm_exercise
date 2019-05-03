package algorithm_hash;
//���� ��巹�� ���� �̿��� �ؽ� ǥ
public class HashOA {
	
//	�ؽ� ǥ�� ���(��Ŷ)
	private class Bucket{
		MyKey key; //Ű
		Object data; //Ű�� �����ϴ� ������
		
//		��Ŷ�� �����Ѵ�
//		
//		@param k Ű
//		@param d ������
		private Bucket(MyKey k, Object d) {
			key = k;
			data = d;
		}
	}
	
	Bucket[] table; //�ؽ� ǥ�� ������ �ϴ� �迭
	int bucketSize; //��Ŷ�� ����
	int nElements; //��ϵǾ� �ִ� �������� ����
	
	//������ �Ϸ�Ǿ��ٴ� ���� ��Ÿ���� Ư���� Ű ��
	static final MyKey DELETED = new MyKey(null);
	
	//������ �Ϸ�Ǿ��ٴ� ���� ��Ÿ���� Ư���� Ű ��
	static final MyKey EMPTY = new MyKey(null);
	
	//�ؽ� ǥ�� �⺻ ũ��(�Ҽ��� �ϴ� ���� ����)
	static final int DEFAULT_BUCKET_SIZE = 53;
	
//	�ؽ� ǥ�� �����Ѵ�(ũ��� DEFAULT_BUCKET_SIZE)
	public HashOA() {
		this(DEFAULT_BUCKET_SIZE);
	}
	
//	�ؽ� ǥ�� �����Ѵ�
//	
//	@param bucketSize �ؽ� ǥ�� ũ��
	public HashOA(int bucketSize) {
//		�ؽ� ǥ�� ������ �ϴ� �迭�� �Ҵ��ϰ� ��� ����� Ű�� EMPTY�� �ʱ�ȭ ���� �д�
		table = new Bucket[bucketSize];
		for(int i = 0; i < bucketSize; i++) {
			table[i] = new Bucket(EMPTY, null);
		}
		
		//�ؽ� ǥ�� ��Ŷ ������ ����� �д�
		this.bucketSize = bucketSize;
		
		//����� ������ 0���� �� �д�
		nElements = 0;
	}
	
//	�ؽ� �Լ�
//	Ű�� �̿�Ǵ� ��ü�� hashCode �޼ҵ尡 ��ȯ�� ���� ��Ŷ�� ������ ���� �������� ��ȯ
//	
//	@param key Ű
//	@return �־��� Ű�� ���� �ؽ� ��
	private int hash(MyKey key) {
		return key.hashCode() % bucketSize;
	}
	
//	���ؽ��� �Ѵ�
//	
//	@param h �ؽ� ��
//	@return ���ؽ��� ���� �ؽ� ��
	private int rehash(int h) {
		return (h + 1) % bucketSize;
	}
	
//	�ؽ� ǥ�� Ž���Ѵ�
//	
//	@param key ã�� Ű
//	@return �����͸� �߰��ϸ� �װ��� ��ȯ, �߰����� �������� null�� ��ȯ
	public Object find(MyKey key) {
		int count = 0;
		int h = hash(key);
		
		MyKey k;
		while((k = table[h].key) != EMPTY) {
			if(k != DELETED && key.equals(k)) {
				return table[h].data;
			}
			if(++count > bucketSize) {
				return null;
			}
			h = rehash(h);
		}
		return null;
	}
	
//	�ؽ� ǥ�� �����͸� �����Ѵ�
//	
//	@param key Ű
//	@param data ����� ������
//	@return ��Ͽ� �����ϸ� true, �����ϸ�(�̹� ���� Ű�� ������ �����Ͱ� ������) false�� ��ȯ
	public boolean insert(MyKey key, Object data) {
		int count = 0;
		int h = hash(key);
		
		MyKey k;
		while((k = table[h].key) != EMPTY && k != DELETED) {
			if(key.equals(k)) {
				return false;
			}
			if(++count > bucketSize) {
				System.err.println("�� �̻� �ؽ� ǥ�� �����͸� ����� �� �����ϴ�.");
				System.exit(1);
			}
			h = rehash(h);
		}
		table[h].key = key;
		table[h].data = data;
		nElements++;
		return true;
	}
	
//	�ؽ� ǥ���� �����͸� �����Ѵ� 
//	
//	@param key ������ �������� Ű
//	@return ������ �����ߴٸ� true, �����ߴٸ� false�� ��ȯ
	public boolean delete(MyKey key) {
		int count = 0;
		int h = hash(key);
		
		MyKey k;
		while((k = table[h].key) != EMPTY) {
			if(k != DELETED && key.equals(k)) {
				table[h].key = DELETED;
				table[h].data = null;
				nElements--;
				return true;
			}
			if(++count > bucketSize) {
				return false;
			}
			h = rehash(h);
		}
		return false;
	}
	
//	�ؽ� ǥ�� ������ ���ڿ��� ��ȯ
//	
//	@return �ؽ� ǥ�� ����
	public String toString() {
		String s = "";
		for(int i = 0; i <table.length; i++) {
			s += "��Ŷ" + i + ": ";
			MyKey k = table[i].key;
			if(k == EMPTY) {
				s += "�������\n";
			} else if(k == DELETED) {
				s += "���� �Ǿ���\n";
			} else {
				s += "key = [" + k + "] data = [" + table[i].data + "]\n";
			}
		}
		//��ϵǾ� �ִ� ����� ������ �߰��Ѵ�
		s += "����� ���� : " + nElements + "\n";
		return s;
	}
	
	//�׽�Ʈ�� ���� ��ƾ
	public static void main(String[] args) {
		String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"one", //�̰��� ��Ͽ� ������ ���̴�
				};
		//�ؽ� ǥ�� �����Ѵ�(�׽�Ʈ�� ���� ��Ŷ�� 15���� �����Ѵ�)
		HashOA hash = new HashOA(15);
		
		//�迭 words�� ����ִ� �ܾ ������� ����Ѵ�
		System.out.println("----<< 1 �ܰ� >>---[���]--------");
		for(int i = 0; i < words.length; i++) {
			boolean stat = hash.insert(new MyKey(words[i]), "���� = " + (i + 1));
			if(stat == false) {
				System.out.println(words[i] + "�� ��Ͽ� ���ؾƿ���. (�ߺ���)");
			}
		}
		System.out.println(hash); //�ؽ� ǥ�� ������ ǥ��
		
		//�迭 keys�� ����ִ� �ܾ Ž���Ѵ�
		System.out.println("----<< 2 �ܰ� >>---[Ž��]--------");
		String[] keys = {"ten", "one", "ones", "five"};
		for(int i = 0; i < keys.length; i++) {
			Object result = hash.find(new MyKey(keys[i]));
			if(result != null) {
				System.out.println("Ű [" + keys[i] + "]�� ���� [" + result + "]�̴�." );
			} else {
				System.out.println("Ű [" + keys[i] + "]�� �߰����� ���Ͽ���.");
			}
		}
		
		//�迭 keys�� ����ִ� �ܾ �����Ѵ�
		System.out.println("----<< 3 �ܰ� >>---[����]--------");
		for(int i = 0; i < keys.length; i++) {
			if(hash.delete(new MyKey(keys[i]))) {
				System.out.println("Ű [" + keys[i] + "]�� �����Ͽ���.");
			} else {
				System.out.println("Ű [" + keys[i] + "]�� ������ ���оƿ���. (��ϵǾ� ���� ����)");
			}
		}
		
		//�迭 keys�� ����ִ� �ܾ �ٽ� Ž���Ѵ�
		//��� ������ ���̴�
		System.out.println("----<< 4 �ܰ� >>---[Ž��: ��� �����Ѵ�]--------");
		for(int i = 0; i < keys.length; i++) {
			Object result = hash.find(new MyKey(keys[i]));
			if(result != null) {
				System.out.println("Ű [" + keys[i] + "]�� ���� [" + result + "]�̴�");
			} else {
				System.out.println("Ű [" + keys[i] + "]�� �߰����� ���Ͽ���.");
			}
		}
		
		//�ؽ� ǥ�� ������ ǥ���Ѵ�
		System.out.println("----<< 5 �ܰ� >>---------");
		System.out.println(hash);
		
	}
}
