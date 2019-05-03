package algorithm_sort;
//�� ��Ʈ�� ���������� ��Ʈ���� ����ϴ� ������ ��
public class BinSortData {

	// Ű�� 0���� M������ ����
	static final int M = 100;
	
	private int key; // ����Ű, 0���� M������ ���� ���� �־�� �Ѵ�
	private Object data; // �� ���� ����
	
//	������ �����͸� �����Ѵ�
//	
//	@param key Ű
//	@param data �� ���� ����
	BinSortData(int key, Object data){
		//Ű�� �������� �ִ��� üũ�Ѵ�
		if(key < 0 || key > M) {
			throw new IllegalArgumentException("Ű " + key + " �� ������ ���� �ۿ� �ִ�");
		}
		this.key = key;
		this.data = data;
	}
	
//	Ű�� ��´�
//	
//	@return Ű ���� ��ȯ
	public final int getKey() {
		return key;
	}
	
//	�� ���� ������ ��´�
//	
//	@return �� ���� ������ ��ȯ
	public final Object getData() {
		return data;
	}
}
