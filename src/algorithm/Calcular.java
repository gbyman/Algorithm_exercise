package algorithm;

import java.io.*;
// 역 폴란드 전자 계산기
public class Calcular {
	
//	스택에 수치 값을 쌓는다
//	
//	@param stack 스택
//	@param value 쌓을 값
	private static void push(MyStack stack, long value) {
		stack.push(new Long(value));
	}
	
//	스택에서 수치 값을 꺼낸다
//	
//	@param stack 스택
//	@return 스택에서 꺼낸 값
	private static long pop(MyStack stack) {
		Long l = (Long)stack.pop();
		return l.longValue();
	}
	
//	역 폴란드 전자 계산기의 메인 프로그램
//	콘솔에서 입력한 식을 평가하고 결과를 표시한다
	public static void main(String[] args) throws IOException{
		//스택을 생성한다
		MyStack stack = new MyStack();
		
//		표준입력에서 1문자씩 읽어 들이기 위한 리더(reader)를 준비한다.
//		PushbackReader 클래스를 이용하여 지나간 문자를 반환할 수 있도록 하고 있는 것에 주의
		PushbackReader input = new PushbackReader(
				new BufferedReader(
						new InputStreamReader(System.in)));
		int c; //읽어들인 문자
		long a, b; //작업용 변수
		
		//EOF가 될 때까지 1문자씩 읽어 들여 처리한다
		while((c = input.read()) != -1 ) {
			char ch = (char)c;
			
			if(Character.isDigit(ch)) {
//				읽어 들인 문자가 숫자였다.
//				숫자가 아닌 값이 나올때까지 읽은 후, 십진수로 해석하여 long 값으로 변환한다.
//				얻어진 값을 스택에 쌓음
				long num = 0;
				while(Character.isDigit(ch)) {
					num = 10 * num + (ch - '0');
					c = input.read();
					ch = (char)c;
				}
				input.unread(ch); //숫자가 아닌 문자를 하나 읽었기 때문에 되돌림
				push(stack, num);
			} else {
				switch (ch) {
					case '+': //덧셈
						b = pop(stack);
						a = pop(stack);
						push(stack, a + b);
						break;
					case '-': //뺄셈	
						b = pop(stack);
						a = pop(stack);
						push(stack, a - b);
						break;
					case '*': //곱셈
						b = pop(stack);
						a = pop(stack);
						push(stack, a * b);
						break;
					case '/': //나눗셈
						b = pop(stack);
						a = pop(stack);
						push(stack, a / b);
						break;
					case '\n': //결과를 표시한다
						if(!stack.isEmpty()) {
							System.out.println("답은 " + pop(stack) + "입니다.");
						}
						stack.clear();//스택을 비운다
						break;
					case ' ': //공백 문자라면 아무것도 하지 않는다
					case '\t':
					case '\r':
						break;
					default: //그 외의 문자라면 에러
						System.out.println("올바르지 않은 문자 " + ch + " 가 있습니다.");
						System.out.println("다시 입력해 주십시오.");
						
						//개행 문자까지 지나친 후 스택을 비운다
						while((c = input.read()) != -1 & c != '\n');
						stack.clear();
						break;
				}
			}
		}
	}
}
