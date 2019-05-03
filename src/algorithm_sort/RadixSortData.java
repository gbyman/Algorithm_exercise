package algorithm_sort;
// ��� ��Ʈ�� ����� ������ ��
public class RadixSortData {
	
	final static int KEY_MAX = 0xffff; //Ű �ִ밪
	private int key;// ���� Ű
					// 0 ~ 65535(0xffff)�� ���� ���� �־�� �Ѵ�
	private Object data;// �� ���� ����
	
//	������ �����͸� �����Ѵ�
//	
//	@param key Ű
//	@param data �� ���� ����
	RadixSortData(int key, Object data){
		
		// Ű�� ���� ���� �ִ� �� üũ�Ѵ�
		if(key < 0 || key > KEY_MAX	) {
			throw new IllegalArgumentException("Ű " + key + "�� ������ ���� �ۿ� �ִ�.");
		}
		
		this.key = key;
		this.data = data;
	}
	
//	Ű�� ��´�
//	
//	@return Ű ���� ��ȯ
	public int getKey() {
		return key;
	}
	
//	�� ���� ������ ��´�
//	
//	@return �� ���� ������ ��ȯ
	public Object getData() {
		return data;
	}
}
