package algorithm_binaryseachtree;
//���� Ž�� Ʈ���� ���
public class Node {
	
	Comparable data; //�� ����� ��
	Node left; //���� ���� Ʈ��
	Node right; //������ ��	�� Ʈ��
	
//	���� Ʈ���� ��带 �����Ѵ�
//	
//	@param aLabel �� ����� ��
	Node(Comparable aLabel){
		left = null;
		right = null;
		data = aLabel;
	}
}
