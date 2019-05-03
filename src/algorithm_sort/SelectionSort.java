package algorithm_sort;
//선택 소트
public class SelectionSort {
	
//	선택 소트를 이용하여 배열을 정렬한다
//	
//	@param a 정렬할 배열
	public static void sort(int[] a) {
		int n = a.length;//배열의 요소 수
		
		for(int i = 0; i < n-1; i++) {
			int lowest = i;
			int lowkey = a[i];
			for(int j = i + 1; j < n; j++) {
				if(a[j] < lowkey) {
					lowest = j;
					lowkey = a[j];
				}
			}
			int temp = a[i];
			a[i] = a[lowest];
			a[lowest] = temp;
		}
	}
}
