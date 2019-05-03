package algorithm_binaryseachtree;
//이진 탐색 트리의 노드
public class Node {
	
	Comparable data; //이 노드의 라벨
	Node left; //왼쪽 서브 트리
	Node right; //오른쪽 서	브 트리
	
//	이진 트리의 노드를 생성한다
//	
//	@param aLabel 이 노드의 라벨
	Node(Comparable aLabel){
		left = null;
		right = null;
		data = aLabel;
	}
}
