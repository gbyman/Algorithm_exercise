package algorithm_tree;

import javax.sound.midi.Synthesizer;

// ���� Ʈ��
public class BinaryTreeNode {
	
	String label;	// �� ����� ��
	BinaryTreeNode left;	//���� ���� Ʈ��
	BinaryTreeNode right;	//������ ���� Ʈ��
	
//	���� Ʈ���� ��带 �����Ѵ�
//	
//	@param aLabel	��
//	@param leftTree	���� ���� Ʈ��
//	@param rightTree	������ ���� Ʈ��
	BinaryTreeNode(String aLabel, BinaryTreeNode leftTree, BinaryTreeNode rightTree){
		left = leftTree;
		right = rightTree;
		label = aLabel;
	}
	
//	���� Ʈ���� ���� ��ȸ�Ѵ�
//	
//	@param p ��ȸ�� ���� Ʈ��
	static void traversePreorder(BinaryTreeNode p) {
		if(p == null) //Ʈ���� ����ִٸ� �ƹ��͵� ���� �ʴ´�
			return;
		System.out.println("��� " + p.label + "�� �湮�Ͽ���.");
		traversePreorder(p.left);
		traversePreorder(p.right);
	}
	
//	���� Ʈ���� ���� ��ȸ�Ѵ�
//	
//	@param p ��ȸ�� ���� Ʈ��
	static void traverseInorder(BinaryTreeNode p) {
		if(p == null) //Ʈ���� ����ִٸ� �ƹ��͵� ���� �ʴ´�
			return;
		traverseInorder(p.left);
		System.out.println("��� " + p.label + "�� �湮�Ͽ���.");
		traverseInorder(p.right);
	}
	
//	���� Ʈ���� ���� ��ȸ�Ѵ�
//	
//	@param p ��ȸ�� ���� Ʈ��
	static void traversePostorder(BinaryTreeNode p) {
		if(p == null) // Ʈ���� ����ִٸ� �ƹ��͵� ���� �ʴ´�
			return;
		traversePostorder(p.left);
		traversePostorder(p.right);
		System.out.println("��� " + p.label + "�� �湮�Ͽ���. ");
	}
	
//	�׽�Ʈ�� ���� ��ƾ
//	
//	���� Ʈ���� ���� ��, ����/����/���� ��ȸ�Ѵ�
	public static void main(String[] args) {
		
		//���� Ʈ���� �����
		BinaryTreeNode tree = new BinaryTreeNode("a", new BinaryTreeNode("b", 
				new BinaryTreeNode("c", null, null), null), new BinaryTreeNode("d", null, null));
		
		//���� ��ȸ�Ѵ�
		System.out.println("���� ��ȸ");
		traversePreorder(tree);
		
		//���� ��ȸ�Ѵ�
		System.out.println("���� ��ȸ");
		traverseInorder(tree);
		
		//���� ��ȸ�Ѵ�
		System.out.println("���� ��ȸ");
		traversePostorder(tree);
	}
}
