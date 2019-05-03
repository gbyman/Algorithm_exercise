package algorithm_sort;
//힙을 이용한 소트
public class HeapSort0 {
	
//	힙을 이용하여 배열을 정렬한다
//	
//	@param a 정렬할 배열
	public static void sort(int[] a) {
		
		int n = a.length; //배열의 요소 수
		
		//작업용 힙을 생성한다
		Heap heap = new Heap(n);
		
		//배열의 모든 요소를 힙에 삽입한다
		for(int i = 0; i < n; i++) {
			heap.insert(a[i]);
		}
		
		//키가 작은 것부터 순서대로 꺼내 배열에 되돌린다
		for(int i = 0; i < n; i++) {
			a[i] = heap.deleteMin();
		}
	}
}
