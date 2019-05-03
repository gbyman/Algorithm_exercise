package algorithm_binaryseachtree;
//���� Ž�� Ʈ��
public class BinarySearchTree {
	
	private Node root; //���� Ž�� Ʈ���� ��Ʈ
	
	//-----------------------------
	//���⿡ Node Ŭ������ ���� Ŭ������ �����Ѵ�
	//-----------------------------
	public class Node {
		
		Comparable data; //�� ����� ��
		Node left; //���� ���� Ʈ��
		Node right; //������ ��	�� Ʈ��
		
//		���� Ʈ���� ��带 �����Ѵ�
	//	
//		@param aLabel �� ����� ��
		Node(Comparable aLabel){
			left = null;
			right = null;
			data = aLabel;
		}
	}
	
//	���� Ž�� Ʈ���� �����Ѵ�
	public BinarySearchTree() {
		
		root = null;
	}
	
	//-----------------------------
	//���⿡ �޼��带 �����Ѵ�
	//-----------------------------
//	���� Ž�� Ʈ������ Ű ���� key�� ��带 Ž���Ѵ�
//	
//	@param key ã�� Ű
//	@return Ű ���� key�� ��带 �߰��ϸ� �װ��� ��ȯ�ϰ�, �߰����� �������� null�� ��ȯ
	public Node search(Comparable key) {
		
		Node p = root; //���� ��Ʈ�� �����Ѵ�
		while(p != null) { //���� �����Ѱ� �ִ� ��尡 �����ϴ� �� ����Ѵ�
			int result = key.compareTo(p.data); // ���� ���� Ű�� ���Ѵ�
			if(result == 0) { //���� Ű�� ���ٸ�
				return p;		//�߰��ߴ�
			} else if(result < 0) { //Ű�� �۴ٸ�
				p = p.left;			//���� ���� Ʈ���� �̵�
			} else { //Ű�� �� ũ�ٸ�	
				p = p.right; //������ ���� Ʈ���� �̵�
			}
		}
		return null; //Ž���� �����ߴ�.
	}
	
//	���� Ž�� Ʈ���� Ű ���� key�� ��带 �����Ѵ�
//	
//	@param key ������ Ű
//	@return ������ Ű�� ������ ������ ��ũ�� ��ȯ, �̹� ��ϵǾ� �ִٸ� null�� ��ȯ
	public Node insert(Comparable key) {
		
		Node p = root; //���� ��Ʈ�� ó��
		Node parent = null; //parent�� ���� ó�� ���� ����� �θ� ����Ų��
		boolean isLeftChild = false; //p�� parent�� ���� �ڽ��̶�� true, ������ �ڽ��̶�� false
		
		while(p != null) { //������ ��尡 �ִ� �� ����Ѵ�
			int result = key.compareTo(p.data); //���� ���� Ű�� ���Ѵ�
			if(result == 0) { //���� Ű�� ���ٸ�
				return p;     //�̹� ��ϵǾ� �ִ�
			} else if(result < 0) { //Ű�� �۴ٸ�
				parent = p;         //���� ���� Ʈ���� �̵�
				isLeftChild = true;
				p = p.left;
			} else { //Ű�� �� ũ�ٸ�
				parent = p;//������ ���� Ʈ���� �̵�
				isLeftChild = false;
				p = p.right;
			}
		}
		
		//���ο� ��带 ������ ��ġ�� �����Ѵ�
		Node newNode = new Node(key); //���ο� ��带 �Ҵ��Ѵ�
		if(parent == null) {
			root = newNode; //���ο� ���� ��Ʈ�� �ȴ�
		} else if (isLeftChild) {
			parent.left = newNode; //��� parent�� ���� �ڽ��� �ȴ�
		} else {
			parent.right = newNode; //��� parent�� ������ �ڽ��� �ȴ�
		}
		
		return newNode;
	}
	
//	���� Ʈ������ Ű ���� key�� ��带 �����Ѵ�
//	
//	@param key ������ Ű
//	@return ������ �����ϸ� true, ��Ұ� �������� ������ false�� ��ȯ
	public boolean delete(Comparable key) {
		Node p = root; //�켱 ��Ʈ�� ó���Ѵ�
		Node parent = null; //parent�� ���� ó�� ���� ��� �θ� ����Ų��
		boolean isLeftChild = false; //p�� parent�� ���� �ڽ��̶�� true, ������ �ڽ��̶�� false
		
		while(p != null) { //���� ����� ã�´�
			//���� ���� Ű�� ���Ѵ�
			int result = key.compareTo(p.data);
			if(result == 0) { //�߰��ߴ�
				if(p.left == null && p.right == null) { //�����̴�
					//������ �����Ѵ�
					if(parent == null) {
						root = null;
					} else if(isLeftChild) {
						parent.left = null;
					} else {
						parent.right = null;
					}
				} else if(p.left == null) { //������ �ڽĸ� ������ �ִ�
					//������ �ڽ��� �θ��� �ڽ����� �Ѵ�
					if(parent == null) {
						root = p.right;
					} else if(isLeftChild) {
						parent.left = p.right;
					} else {
						parent.right = p.right;
					}
				} else if(p.right == null) { //���� �ڽĸ� ������ �ִ�
					//���� �ڽ��� �θ��� �ڽ����� �Ѵ�
					if(parent == null) {
						root = p.left;
					} else if(isLeftChild) {
						parent.left = p.left;
					} else {
						parent.right = p.left;
					}
				} else { //�¿� 2���� �ڽ��� ������ �ִ�
					//������ ���� Ʈ���� ���� ���� ��Ҹ� ������ �� ���� x�� �ִ´�
					Node x = deleteMin(p, p.right);
					
					//���� ó�� ���� ��忡 ���� ���� ��� x�� �ִ´�
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
				return true; //������ ����
			} else if(result < 0) { //Ű�� �۴ٸ�
				parent = p; //���� ���� Ʈ���� �̵�
				isLeftChild = true;
				p = p.left;
			} else { //Ű�� �� ũ�ٸ�
				parent = p; //������ ���� Ʈ���� �̵�
				isLeftChild = false;
				p = p.right;
			}
		}
		//���� ����� �߰����� ���ߴ�
		return false;
	}
	
//	���� Ž�� Ʈ������ ���� ���� ��Ҹ� �����Ѵ�
//	
//	@param p ���� Ž�� Ʈ��
//	@param parent p�� �θ� ���
//	@return ������ ���
	private Node deleteMin(Node parent, Node p) {
		boolean isLeftChild = false; //p�� parent�� ���� �ڽ��̶�� true, ������ �ڽ��̶�� false
									//�޼ҵ尡 ȣ��� ���������� p�� parent�� ������ �ڽ��̱� ������, �ʱⰪ�� false�̴�
		while(p.left != null) { //���� ���� ��Ҹ� ã�´�
			parent = p;
			isLeftChild = true;
			p = p.left;
		}
		if(isLeftChild) { //���� ���� ��Ҹ� �����Ѵ�.
			parent.left = p.right;
		} else {
			parent.right = p.right;
		}
		return p; //���� ���� ��Ҹ� ��ȯ
	}
	
	//���� Ž�� Ʈ���� ���� ��ȸ �Ѵ�
	private void inorder(Node p) {
		if(p == null) {
			return;
		} else {
			inorder(p.left);
			System.out.println(p.data);
			inorder(p.right);
		}
	}
	
	//���� Ž�� Ʈ���� ��� ��Ҹ� ������������ ǥ���Ѵ�
	public void showAll() {
		inorder(root);
	}
}
