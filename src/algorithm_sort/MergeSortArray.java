package algorithm_sort;
//배열 버전 머지 소트
public class MergeSortArray {

//	배열을 머지 소트한다
//	a[low] ~ a[high] 요소를 정렬한다
//	
//	@param a 정렬할 배열
//	@param low 정렬할 범위의 하한
//	@param high 정렬할 범위의 상한
	private static void mergeSortArray(int[] a, int low, int high) {
		//만약 요소가 하나뿐이라면 바로 돌아간다
		if(low >= high) {
			return;
		}
		
		//열을 2개로 분할할 장소 mid을 구한다
		int mid = (low + high) / 2;
		
		//앞쪽 반 요소 a[low]~a[mid]을 정렬한다
		mergeSortArray(a, low, mid);
		
		//뒤쪽 반 요소 a[mid]~a[high]을 정렬한다
		mergeSortArray(a, mid + 1, high);
		
		//앞쪽 반 요소를 그대로 작업용 배열 b에 복사한다
		int[] b = new int[a.length];
		for(int i = low; i <= mid; i++) {
			b[i] = a[i];
		}
		
		//뒤쪽 반 요소를 반대 순서로 작업용 배열 b에 복사한다
		for(int i = mid + 1, j = high; i <= high; i++, j--) {
			b[i] = a[i];
		}
		
		//작업용 배열 b의 양끝에서 꺼낸 데이터를 머지하여 배열 a에 넣는다
		int i = low;
		int j = high;
		for(int k = low; k <= high; k++) {
			if(b[i] <= b[j]) {
				a[k] = b[i++];
			} else {
				a[k] = b[j--];
			}
		}
	}
	
//	머지 소트를 이용하여 배열을 정렬한다
//	
//	@param a 정렬할 배열
	public static void sort(int[] a) {
		mergeSortArray(a, 0, a.length - 1);
	}
}
