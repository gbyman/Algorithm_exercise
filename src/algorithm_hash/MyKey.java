package algorithm_hash;
//�ؽ� ǥ���� ����ϴ� Ű
public class MyKey {
	
	String str; //Ű�� ����� ���ڿ�
	
//	Ű�� �����Ѵ�
//	
//	@param s Ű�� ����� ���ڿ�
	public MyKey(String s) {
		str = s;
	}
	
//	Ű�� ���Ѵ�
//	
//	@param x ���� Ű
//	@return �� Ű�� Ű x�� ���ٸ� true, ���� �ʴٸ� false
	public boolean equals(MyKey x) {
		return str.equals(x.str);
	}
	
//	Ű�� �ؽ� ���� ��ȯ
//	
//	@return �� Ű�� �ؽ� ��
	public int hashCode() {
		int sum = 0;
		
		//���ڿ��� ���ԵǾ� �ִ� ��� ���� �ڵ��� ���� ���Ѵ�
		for(int i = 0; i < str.length(); i++) {
			sum += (int)str.charAt(i);
		}
		return sum;
	}
	
//	Ű�� ���ڿ� ���·� ��ȯ(���� Ű�� ���ڿ��̱� ������ �״�� ��ȯ)
//	
//	@return Ű�� ���ڿ��� ǥ���� ��
	public String toString() {
		return str;
	}
			
}
