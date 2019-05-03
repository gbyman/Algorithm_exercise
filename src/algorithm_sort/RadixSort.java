package algorithm_sort;
// 기수 소트를 수행한다
public class RadixSort {
	
	// 서브 키는 0부터 15까지의 정수(4비트)
	static final int M = 15;
	
	// 서브 키를 얻기 위해 사용하는 마스크(2진수 1111)
	static final int MASK = 0xf;
	
//	기수 소트를 수행한다. 전달된 배열 a의 내용을 정렬한다
//	
//	@param a 정렬할 배열
	static void sort(RadixSortData[] a) {
		
		final int N = a.length;// 배열의 요소 수
		int pass = 1;// 몇 번째 정렬인가?
		
		// 작업용 배열
		RadixSortData[] b = new RadixSortData[N];
		
		// 키의 분포를 세기위한 배열
		int[] count = new int[M + 1];
		
		// 낮은 자리에서 높은 자리로 향해 4비트 씩 4번 루프를 실행한다
		for(int bit = 0; bit < 16; bit += 4) {
			
			// 카운터를 모두 0으로 한다
			for(int i = 0; i <= M; i++) {
				count[i] = 0;
			}
			
			// 키를 센다
			for(int i = 0; i < N; i++) {
				count[(a[i].getKey() >>bit) & MASK]++;
			}
			
			// 키의 누적 도수 분포를 구한다
			for(int i = 0; i < M; i++) {
				count[i+1] += count[i];
			}
			
			// 도수 분포에 따라 데이터를 배열 a에서 작업용 배열 b로 복사한다
			for(int i = N - 1; i >= 0; i--) {
				b[--count[(a[i].getKey() >> bit) & MASK]] = a[i];
			}
			
			// 데이터를 작업용 배열 b에서 배열 a로 복사한다
			System.arraycopy(b, 0, a, 0, N);
			
			// 배열의 내용을 표시한다
			System.out.println("Pass" + pass++ + "-----------------");
			dumpArray(a);
		}
	}
	
//	RadixSortData 형의 배열 내용을 16진수로 표시한다
//	
//	@param a 표시할 배열
	public static void dumpArray(RadixSortData a[]) {
		
		for(int i = 0; i < a.length; i++) {
			String hexStr = " " + Integer.toHexString(a[i].getKey());
			hexStr = hexStr.substring(hexStr.length() - 4, hexStr.length());
			System.out.println("key = " + hexStr + " data = " + a[i].getData());
		}
	}
}
 