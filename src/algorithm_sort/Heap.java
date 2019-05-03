package algorithm_sort;
// 힙
public class Heap {

	int[] a;// 힙의 역할을 하는 배열
	int n;// 힙에 들어있는 요소의 개수
	
//	힙을 생성한다
//	
//	@param size 힙에 등록할 수 있는 요소의 최대 개수
	public Heap(int size) {
		// 배열 a에서 a[1] ~ a[size+1]을 사용한다
		// a[0]은 사용하지 않으므로 size+1개의 요소를 확보할 필요가 있다
		a = new int[size+1];
		n = 0;
	}
	
//	힙의 x번째 요소를 필요한 장소까지 끌어올린다
//	
//	@param x 끌어올릴 요소의 첨자
	private void upHeap(int x) {
		//끌어올릴 요소의 값을 value에 넣어둔다
		int value = a[x];
		
		//요소가 루트까지 올라오지 않았으며
		//'부모가 자식보다 크다'라는 조건을 만족할 때까지 반복한다
		while(x > 1 && a[x/2] > value) {
			
			//부모 값을 자식으로 옮긴다
			a[x] = a[x/2];
			
			//처리할 노드를 부모로 한다
			x /= 2;
		}
		
		//최종적으로 옮겨져야 할 장소가 정해졌다
		a[x] = value;
	} 
	
//	힙에 요소를 등록한다
//	
//	@param elem 등록할 요소
	public void insert(int elem) {
		
		//힙에 등록할 수 있는 여유가 있는지 확인한다
		if(n >= a.length) {
			System.err.println("더 이상 힙에 요소를 등록할 수 없다.");
			System.exit(1);
		}
		
		//요소를 일단 힙의 마지막에 넣는다
		a[++n] = elem;
		
		//추가한 요소를 끌어올린다
		upHeap(n);
	}
	
//	힙의 처음 요소 a[1]을 필요한 곳까지 내려 보낸다
	private void downHeap() {
		
		//내려보낼 요소의 값을 value에 저장해 둔다
		int value = a[1];
		
		//루트에서 시작하여 노드 i가 자식을 가지고 있는 한 반복한다
		int i = 1;
		while(i < n/2) {
			
			//노드 i의 자식 중 작은 쪽을 노드 j로 한다
			int j = i * 2;
			if(j + 1 <= n && a[j] > a[j + 1]) {
				j++;
			}
			
			//만약 부모가 자식보다 크지 않다는 관계가 성립하면,
			//이 이상 내려보낼 필요가 없다
			if(value <= a[j]) {
				break;
			}
			
			//노드 i에 노드 j의 값을 넣고, 다음은 노드 j를 처리하도록 한다
			a[i] = a[j];
			i = j;
		}
		
		//원래 처음 요소의 값을 노드 i에 넣는다
		a[i] = value;
	}
	
//	힙에서 가장 작은 요소를 삭제한다
//	요소의 값을 반환
//	
//	@return 삭제한 요소의 값
	int deleteMin() {
		
		//힙이 비어있는지 확인한다
		if(n < 1) {
			System.err.println("힙이 비어있다");
			System.exit(1);
		}
		
		//루트 요소를 리턴 값으로 한다
		//(힙의 처음 요소가 루트에 해당)
		int value = a[1];
		
		//힙의 마지막 요소를 제일 처음으로 이동한다
		a[1] = a[n--];
		
		//앞으로 이동한 요소를 적절한 위치까지 내려보낸다
		downHeap();
		
		return value;
	}
}
