package algorithm;

import java.io.*;
// �� ������ ���� ����
public class Calcular {
	
//	���ÿ� ��ġ ���� �״´�
//	
//	@param stack ����
//	@param value ���� ��
	private static void push(MyStack stack, long value) {
		stack.push(new Long(value));
	}
	
//	���ÿ��� ��ġ ���� ������
//	
//	@param stack ����
//	@return ���ÿ��� ���� ��
	private static long pop(MyStack stack) {
		Long l = (Long)stack.pop();
		return l.longValue();
	}
	
//	�� ������ ���� ������ ���� ���α׷�
//	�ֿܼ��� �Է��� ���� ���ϰ� ����� ǥ���Ѵ�
	public static void main(String[] args) throws IOException{
		//������ �����Ѵ�
		MyStack stack = new MyStack();
		
//		ǥ���Է¿��� 1���ھ� �о� ���̱� ���� ����(reader)�� �غ��Ѵ�.
//		PushbackReader Ŭ������ �̿��Ͽ� ������ ���ڸ� ��ȯ�� �� �ֵ��� �ϰ� �ִ� �Ϳ� ����
		PushbackReader input = new PushbackReader(
				new BufferedReader(
						new InputStreamReader(System.in)));
		int c; //�о���� ����
		long a, b; //�۾��� ����
		
		//EOF�� �� ������ 1���ھ� �о� �鿩 ó���Ѵ�
		while((c = input.read()) != -1 ) {
			char ch = (char)c;
			
			if(Character.isDigit(ch)) {
//				�о� ���� ���ڰ� ���ڿ���.
//				���ڰ� �ƴ� ���� ���ö����� ���� ��, �������� �ؼ��Ͽ� long ������ ��ȯ�Ѵ�.
//				����� ���� ���ÿ� ����
				long num = 0;
				while(Character.isDigit(ch)) {
					num = 10 * num + (ch - '0');
					c = input.read();
					ch = (char)c;
				}
				input.unread(ch); //���ڰ� �ƴ� ���ڸ� �ϳ� �о��� ������ �ǵ���
				push(stack, num);
			} else {
				switch (ch) {
					case '+': //����
						b = pop(stack);
						a = pop(stack);
						push(stack, a + b);
						break;
					case '-': //����	
						b = pop(stack);
						a = pop(stack);
						push(stack, a - b);
						break;
					case '*': //����
						b = pop(stack);
						a = pop(stack);
						push(stack, a * b);
						break;
					case '/': //������
						b = pop(stack);
						a = pop(stack);
						push(stack, a / b);
						break;
					case '\n': //����� ǥ���Ѵ�
						if(!stack.isEmpty()) {
							System.out.println("���� " + pop(stack) + "�Դϴ�.");
						}
						stack.clear();//������ ����
						break;
					case ' ': //���� ���ڶ�� �ƹ��͵� ���� �ʴ´�
					case '\t':
					case '\r':
						break;
					default: //�� ���� ���ڶ�� ����
						System.out.println("�ùٸ��� ���� ���� " + ch + " �� �ֽ��ϴ�.");
						System.out.println("�ٽ� �Է��� �ֽʽÿ�.");
						
						//���� ���ڱ��� ����ģ �� ������ ����
						while((c = input.read()) != -1 & c != '\n');
						stack.clear();
						break;
				}
			}
		}
	}
}
