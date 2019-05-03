package algorithm_string;
// �ָԱ����� ����� �̿��� ���ڿ� Ž��
public class BruteForce {

//	���ڿ� text���� ���ڿ� pattern�� Ž���Ѵ�(�ָԱ����� ���)
//	
//	@param text �ؽ�Ʈ(Ž�� ����� �Ǵ� ���ڿ�)
//	@param pattern ����(ã�� ���ڿ�)
//	@return �߰��� ��ġ�� ��ȯ. �߰����� ���ߴٸ� -1�� ��ȯ
	public static int search(String text, String pattern) {
		
		int i = 0;// �ؽ�Ʈ�� �� ��ġ�� ��Ÿ���� ������
		int j = 0;// ������ �� ��ġ�� ��Ÿ���� ������
		
		//�ؽ�Ʈ�� �������� �����ϴ��� ������ �߰��� ������ �ݺ�
		while(i < text.length() && j < pattern.length()) {
			
			// �ؽ�Ʈ�� ������ �� ���ھ� ���Ѵ�
			if(text.charAt(i) == pattern.charAt(j)) {
				
				// ��ġ�ߴ�. �ؽ�Ʈ�� ������ �����͸� �����Ų��
				i++;
				j++;
			} else {
				
				// ��ġ���� �ʾҴ�
				i = i - j + 1;// �ؽ�Ʈ�� �����͸� ���� ��ġ���� �� ĭ �����Ų��
				j = 0;// ������ �����͸� ó������ �ǵ�����
			}
		}
		
		// ���� Ž���� �����ߴٸ� ������ ã�� ��ġ�� ��ȯ. �����ߴٸ� -1�� ��ȯ
		return(j == pattern.length()) ? (i - j) : -1;
	}
}
