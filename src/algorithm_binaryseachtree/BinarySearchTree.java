package algorithm_binaryseachtree;
//이진 탐색 트리
public class BinarySearchTree {
	
	private Node root; //이진 탐색 트리의 루트
	
	//-----------------------------
	//여기에 Node 클래스를 내부 클래스로 선언한다
	//-----------------------------
	public class Node {
		
		Comparable data; //이 노드의 라벨
		Node left; //왼쪽 서브 트리
		Node right; //오른쪽 서	브 트리
		
//		이진 트리의 노드를 생성한다
	//	
//		@param aLabel 이 노드의 라벨
		Node(Comparable aLabel){
			left = null;
			right = null;
			data = aLabel;
		}
	}
	
//	이진 탐색 트리를 생성한다
	public BinarySearchTree() {
		
		root = null;
	}
	
	//-----------------------------
	//여기에 메서드를 정의한다
	//-----------------------------
//	이진 탐색 트리에서 키 값이 key인 노드를 탐색한다
//	
//	@param key 찾을 키
//	@return 키 값이 key인 노드를 발견하면 그것을 반환하고, 발견하지 못했으면 null을 반환
	public Node search(Comparable key) {
		
		Node p = root; //먼저 루트를 조사한다
		while(p != null) { //현재 조사한고 있는 노드가 존재하는 한 계속한다
			int result = key.compareTo(p.data); // 현재 노드와 키를 비교한다
			if(result == 0) { //노드와 키가 같다면
				return p;		//발견했다
			} else if(result < 0) { //키가 작다면
				p = p.left;			//왼쪽 서브 트리로 이동
			} else { //키가 더 크다면	
				p = p.right; //오른쪽 서브 트리로 이동
			}
		}
		return null; //탐색에 실패했다.
	}
	
//	이진 탐색 트리에 키 값이 key인 노드를 삽입한다
//	
//	@param key 삽입할 키
//	@return 삽입할 키를 가지는 노드로의 링크를 반환, 이미 등록되어 있다면 null을 반환
	public Node insert(Comparable key) {
		
		Node p = root; //먼저 루트를 처리
		Node parent = null; //parent는 현재 처리 중인 노드의 부모를 가리킨다
		boolean isLeftChild = false; //p가 parent의 왼쪽 자식이라면 true, 오른쪽 자식이라면 false
		
		while(p != null) { //조사할 노드가 있는 한 계속한다
			int result = key.compareTo(p.data); //현재 노드와 키를 비교한다
			if(result == 0) { //노드와 키가 같다면
				return p;     //이미 등록되어 있다
			} else if(result < 0) { //키가 작다면
				parent = p;         //왼쪽 서브 트리로 이동
				isLeftChild = true;
				p = p.left;
			} else { //키가 더 크다면
				parent = p;//오른쪽 서브 트리로 이동
				isLeftChild = false;
				p = p.right;
			}
		}
		
		//새로운 노드를 적절한 위치에 삽입한다
		Node newNode = new Node(key); //새로운 노드를 할당한다
		if(parent == null) {
			root = newNode; //새로운 노드는 루트가 된다
		} else if (isLeftChild) {
			parent.left = newNode; //노드 parent의 왼쪽 자식이 된다
		} else {
			parent.right = newNode; //노드 parent의 오른쪽 자식이 된다
		}
		
		return newNode;
	}
	
//	이진 트리에서 키 값이 key인 노드를 삭제한다
//	
//	@param key 삭제할 키
//	@return 삭제에 성공하면 true, 요소가 존재하지 않으면 false를 반환
	public boolean delete(Comparable key) {
		Node p = root; //우선 루트를 처리한다
		Node parent = null; //parent는 현재 처리 중인 노드 부모를 가리킨다
		boolean isLeftChild = false; //p가 parent의 왼쪽 자식이라면 true, 오른쪽 자식이라면 false
		
		while(p != null) { //삭제 대상을 찾는다
			//현재 노드와 키를 비교한다
			int result = key.compareTo(p.data);
			if(result == 0) { //발견했다
				if(p.left == null && p.right == null) { //리프이다
					//리프를 삭제한다
					if(parent == null) {
						root = null;
					} else if(isLeftChild) {
						parent.left = null;
					} else {
						parent.right = null;
					}
				} else if(p.left == null) { //오른쪽 자식만 가지고 있다
					//오른쪽 자식을 부모의 자식으로 한다
					if(parent == null) {
						root = p.right;
					} else if(isLeftChild) {
						parent.left = p.right;
					} else {
						parent.right = p.right;
					}
				} else if(p.right == null) { //왼쪽 자식만 가지고 있다
					//왼쪽 자식을 부모의 자식으로 한다
					if(parent == null) {
						root = p.left;
					} else if(isLeftChild) {
						parent.left = p.left;
					} else {
						parent.right = p.left;
					}
				} else { //좌우 2개의 자식을 가지고 있다
					//오른쪽 서브 트리의 가장 작은 요소를 제거한 뒤 변수 x에 넣는다
					Node x = deleteMin(p, p.right);
					
					//현재 처리 중인 노드에 가장 작은 요소 x를 넣는다
					if(parent == null) {
						root = x; //1
					} else if(isLeftChild) {
						parent.left = x; //1
					} else {
						parent.right = x; //1
					}
					
					x.right = p.right; //2
					x.left = p.left; //3
				}
				return true; //삭제에 성공
			} else if(result < 0) { //키가 작다면
				parent = p; //왼쪽 서브 트리로 이동
				isLeftChild = true;
				p = p.left;
			} else { //키가 더 크다면
				parent = p; //오른쪽 서브 트리로 이동
				isLeftChild = false;
				p = p.right;
			}
		}
		//삭제 대상을 발견하지 못했다
		return false;
	}
	
//	이진 탐색 트리에서 가장 작은 요소를 삭제한다
//	
//	@param p 이진 탐색 트리
//	@param parent p의 부모 노드
//	@return 삭제한 노드
	private Node deleteMin(Node parent, Node p) {
		boolean isLeftChild = false; //p가 parent의 왼쪽 자식이라면 true, 오른쪽 자식이라면 false
									//메소드가 호출된 시점에서는 p가 parent의 오른쪽 자식이기 때문에, 초기값은 false이다
		while(p.left != null) { //가장 작은 요소를 찾는다
			parent = p;
			isLeftChild = true;
			p = p.left;
		}
		if(isLeftChild) { //가장 작은 요소를 제거한다.
			parent.left = p.right;
		} else {
			parent.right = p.right;
		}
		return p; //가장 작은 요소를 반환
	}
	
	//이진 탐색 트리를 중위 순회 한다
	private void inorder(Node p) {
		if(p == null) {
			return;
		} else {
			inorder(p.left);
			System.out.println(p.data);
			inorder(p.right);
		}
	}
	
	//이진 탐색 트리의 모든 요소를 오름차순으로 표시한다
	public void showAll() {
		inorder(root);
	}
}
