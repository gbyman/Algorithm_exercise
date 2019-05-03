package algorithm_tree;

import javax.sound.midi.Synthesizer;

// 이진 트리
public class BinaryTreeNode {
	
	String label;	// 이 노드의 라벨
	BinaryTreeNode left;	//왼쪽 서브 트리
	BinaryTreeNode right;	//오른쪽 서브 트리
	
//	이진 트리의 노드를 생성한다
//	
//	@param aLabel	라벨
//	@param leftTree	왼쪽 서브 트리
//	@param rightTree	오른쪽 서브 트리
	BinaryTreeNode(String aLabel, BinaryTreeNode leftTree, BinaryTreeNode rightTree){
		left = leftTree;
		right = rightTree;
		label = aLabel;
	}
	
//	이진 트리를 전위 순회한다
//	
//	@param p 순회할 이진 트리
	static void traversePreorder(BinaryTreeNode p) {
		if(p == null) //트리가 비어있다면 아무것도 하지 않는다
			return;
		System.out.println("노드 " + p.label + "을 방문하였다.");
		traversePreorder(p.left);
		traversePreorder(p.right);
	}
	
//	이진 트리를 중위 순회한다
//	
//	@param p 순회할 이진 트리
	static void traverseInorder(BinaryTreeNode p) {
		if(p == null) //트리가 비어있다면 아무것도 하지 않는다
			return;
		traverseInorder(p.left);
		System.out.println("노드 " + p.label + "을 방문하였다.");
		traverseInorder(p.right);
	}
	
//	이진 트리를 후위 순회한다
//	
//	@param p 순회할 이진 트리
	static void traversePostorder(BinaryTreeNode p) {
		if(p == null) // 트리가 비어있다면 아무것도 하지 않는다
			return;
		traversePostorder(p.left);
		traversePostorder(p.right);
		System.out.println("노드 " + p.label + "을 방문하였다. ");
	}
	
//	테스트용 메인 루틴
//	
//	이진 트리를 만든 후, 전위/중위/후위 순회한다
	public static void main(String[] args) {
		
		//이진 트리를 만든다
		BinaryTreeNode tree = new BinaryTreeNode("a", new BinaryTreeNode("b", 
				new BinaryTreeNode("c", null, null), null), new BinaryTreeNode("d", null, null));
		
		//전위 순회한다
		System.out.println("전위 순회");
		traversePreorder(tree);
		
		//중위 순회한다
		System.out.println("중위 순회");
		traverseInorder(tree);
		
		//후위 순회한다
		System.out.println("후위 순회");
		traversePostorder(tree);
	}
}
