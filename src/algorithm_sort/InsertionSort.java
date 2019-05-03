package algorithm_sort;
//삽입 소트
public class InsertionSort {

//	삽입 소트를 이용하여 배열을 정렬한다
//	
//	@param a 정렬할 배열
	public static void sort(int[] a) {
		
		int n = a.length;//배열의 요소 수
		
		for(int i = 1; i < n; i++) {
			int j = i;
			while(j >= 1 && a[j-1] > a[j]) {
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
				j--;
			}
		}
	}
}
