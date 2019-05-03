package algorithm_sort;
// 퀵 소트 (비재귀 버전, 스택 오버플로우 대책 적용됨)
public class QuickSort3 {
//partition 메소드는 QuickSort1과 같다
//	배열 a[1] ~ a[r]을 분할한다. 추축의 첨자를 반환
	private static int partition(int[] a, int l, int r) {
		//포인터 i와 j를 초기화한다
		int i = l - 1;
		int j = r;
		
		//오른쪽 끝 요소를 추축으로 한다
		int pivot = a[r];
		
		//포인터 i와 j가 충돌할 때까지 반복한다
		for(;;) {
			//포인터 i를 오른쪽으로 이동시킨다
			while(a[++i] < pivot);
			
			//포인터 j를 왼쪽으로 이동시킨다
			while(i < --j && pivot < a[j]);
			
			//포인터 i와 j가 충돌하면 루프를 빠져나간다
			if(i >= j) {
				break;
			}
			//i가 가리키는 요소와 j가 가리키는 요소를 교환한다
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		//a[i]와 추축을 교환한다
		int temp = a[i];
		a[i] = a[j];
		a[r] = temp;
		return i;
	}
	
//	퀵 소트를 이용하여 배열을 정렬한다
//	
//	@param a 정렬할 배열
	public static void sort(int[] a) {
		
		int n = a.length;
		int[] low = new int[30];
		int[] high = new int[30];
		int sp;
		
		//스택을 초기화 한다
		low[0] = 0;
		high[0] = n - 1;
		sp = 1;
		
		//스택이 빌 때까지 반복한다
		while(sp > 0) {
			//스택에서 정렬할 범위를 꺼낸다
			int l = low[--sp];
			int r = high[sp];
			
			//정렬할 요소가 하나라면 아무것도 하지 않는다
			//(다시 while 문을 실행한다)
			if(l >= r) {
				//아무것도 하지 않는다
			} else {
				//추축 v를 기준으로 분할한다
				int v = partition(a, l, r);
				
				//좌우 부분 배열 중 짧은 쪽을 먼저 처리한다
				if(v - 1 < r - v) {
					//왼쪽 부분 배열을 먼저 정렬한다
					//(스택이기 때문에 오른쪽 -> 왼쪽 순으로 쌓는 것에 주의)
					low[sp] = v + 1;
					high[sp++] = r;
					low[sp] = l;
					high[sp++] = v - 1;
				} else {
					//오른쪽 부분 배열을 먼저 정렬한다
					//(스택이기 때문에 왼쪽 -> 오른쪽 순으로 쌓는 것에 주의)
					low[sp] = l;
					high[sp++] = v - 1;
					low[sp] = v + 1;
					high[sp++] = r;
				}
			}
		}
	}
}
