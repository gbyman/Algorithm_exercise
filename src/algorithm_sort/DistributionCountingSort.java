package algorithm_sort;
// 분포수세기 소트를 수행한다
public class DistributionCountingSort {

//	분포수세기 소트를 수행한다. 배열 a의 내용을 정렬한다
//	
//	@param a 정렬할 배열
	static void sort(BinSortData[] a) {
		
		final int N = a.length;	// 배열의 요소 수
		final int M = BinSortData.M; // 키는 0부터 M까지
		
		// 카운터로 사용할 배열을 할당한다(요소는 자동적으로 0으로 초기화 된다)
		int[] count = new int[M + 1];
		
		// 키를 센다
		for(int i = 0; i < N; i++) {
			count[a[i].getKey()]++;
		}
		
		// 키의 누적 도수 분포를 구한다
		for(int i = 0; i < M; i++) {
			count[i+1] += count[i];
		}
		
		// 도수 분포에 따라 데이터를 배열 a에서 작업용 배열 b로 복사한다
		BinSortData[] b = new BinSortData[N];
		for(int i = N - 1; i >= 0; i--) {
			b[--count[a[i].getKey()]] = a[i];
		}
		
		// 배열 b에 들어있는 정렬된 데이터를 배열 a로 복사한다
		System.arraycopy(b, 0, a, 0, N);
	}
}
