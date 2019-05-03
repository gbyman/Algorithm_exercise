package algorithm_sort;
//버블 소트
public class BubbleSort {
	
//	버블 소트를 이용하여 배열을 정렬한다
//	
//	@param a 정렬할 배열
	public static void sort(int[] a) {
		int n = a.length;//배열의 요소 수
		
		for(int i = 0; i < n; i++) {
			for(int j = n-1; j > i; j--) {
				if(a[j-1] < a[j]) {
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
	}
}
