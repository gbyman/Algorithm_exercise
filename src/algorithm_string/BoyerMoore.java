package algorithm_string;

import java.util.*;

// Boyer-Moore �˰����� �̿��� ���ڿ� Ž��
public class BoyerMoore {
	
//	���ڿ� text���� ���ڿ� pattern�� Ž���Ѵ�(BM ��)
//	
//	@param text �ؽ�Ʈ(Ž�� ����� �Ǵ� ���ڿ�)
//	@param pattern ����(ã�� ���ڿ�)
//	@return �߰��� ��ġ�� ��ȯ, �߰����� ���ߴٸ� -1�� ��ȯ
	public static int search(String text, String pattern) {
		
		int patLen = pattern.length();// ������ ����
		int textLen = text.length();// �ؽ�Ʈ�� ����
		
		// �ؽ�Ʈ�� ������ ��ġ���� �ʾ��� ���� ��� ��ŭ �̵��ؾ� ���� ��Ÿ���� ǥ
		int[] skip = new int[65536];
		
		int i;// �ؽ�Ʈ�� �� ��ġ�� ��Ÿ���� ������
		int j;// ������ �� ��ġ�� ��Ÿ���� ������
		
		// ǥ skip�� �ۼ��Ѵ�
		Arrays.fill(skip, patLen);
		for(int x = 0; x < patLen -1; x++) {
			skip[pattern.charAt(x)] = patLen - x - 1;
		}
		
		// �����͸� �ʱ�ȭ�Ѵ�. ������ �ڿ������� ���ϱ� ������ "������ ���� - 1"�� �ʱ�ȭ�Ѵ�
		i = patLen - 1;
		
		// �ؽ�Ʈ�� ���� �������� ������ ������ �ݺ��Ѵ�
		while(i < textLen) {
			
			// ������ j�� ������ ������ ���ڸ� ����Ű���� �Ѵ�
			j = patLen - 1;
			
			// �ؽ�Ʈ�� ������ ��ġ�ϴ� ���� �ݺ��Ѵ�
			while(text.charAt(i) == pattern.charAt(j)) {
				
				// ó�� ���ڰ��� ��ġ�ߴٸ� Ž���� �����̴�
				if(j == 0) {
					return i;
				}
				
				// ������ i�� j�� ���� 1 ���ڸ�ŭ �ǵ�����
				i--;
				j--;
			}
			
			// ��ġ���� �ʾұ� ������ ������ �̵���Ų��
			i = i + Math.max(skip[text.charAt(i)], patLen - j);
		}
		
		// �ᱹ �߰����� ���ߴ�
		return -1;
	}
}
