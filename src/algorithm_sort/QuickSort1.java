package algorithm_sort;
//퀵 소트(재귀버전)
public class QuickSort1 {
	
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
	
	//실제로 퀵 소트를 수행한다
	//배열 a에서 a[1] ~ a[r]을 정렬한다
	private static void quickSort(int[] a, int l, int r) {
		//정렬한 요소가 하나라면 아무것도 하지 않고 돌아간다
		if(l >= r) {
			return;
		}
		//추축 v를 기준으로 분할한다
		int v = partition(a, l ,r);
		
		//왼쪽 부분 배열 a[l] ~ a[v-1]을 정렬한다
		quickSort(a, l, v-1);
		
		//오른쪽 부분 배열 a[v+1] ~ a[r]을 정렬한다
		quickSort(a, v+1, r);
	}
	
//	퀵 소트를 이용하여 배열을 정렬한다
//	
//	@param a 정렬할 배열
	public static void sort(int[] a) {
		quickSort(a, 0, a.length-1); 
	}
}
