package algorithm_tree;

import java.io.*;
//B Ʈ��
public class BTree {
	
	//B Ʈ���� ���
	private abstract class Node{
		int serial; //�Ϸ� ��ȣ(B Ʈ���� ó������ �ʿ� ���� ��������, toString���� Ʈ���� ������ ǥ���� �� �˾ƺ��� ������ �Ѵ�)
		
		//Node Ŭ������ �߻� Ŭ�����̴�
		//���� �ν��Ͻ��� ���� ���α׷��� InternalNode Ŭ����(���� ���),
		//�Ǵ� Leaf Ŭ����(����)�� �����Ѵ�
	}
	
	//B Ʈ���� ���� ���
	private class InternalNode extends Node{
		int nChilds; //�� ��尡 ������ �ִ� �ڽ��� ��
		Node[] child;//���� Ʈ��
		Comparable[] low;//�� ���� Ʈ���� �ּ� ���
		
		//������ : �� ���� ��带 �����Ѵ�
		private InternalNode() {
			serial = serialNumber++; //�Ϸ� ��ȣ�� ���δ�
			nChilds = 0;
			child = new Node[MAX_CHILD];
			low = new Comparable[MAX_CHILD];
		}
		
//		Ű ���� key�� �����ʹ� �� ��° ���� Ʈ���� ����ִ°��� �����Ѵ�
//		
//		@param key ������ Ű
//		@return key�� �� ��° ���� Ʈ���� ����ִ°��� ��ȯ
		private int locateSubtree(Comparable key) {
			for(int i = nChilds -1; i > 0; i--) {
				if(key.compareTo(low[i]) >= 0) {
					return i;
				}
			}
			return 0;
		}
	}
	
	//B Ʈ���� ����
	private class Leaf extends Node{
		Comparable key; //������ Ű
		Object data; //������ ������ ������
		
//		������ : ������ �����Ѵ�
//		
//		@param aKey �� ������ Ű
//		@param aData �� ������ ������
		private Leaf(Comparable aKey, Object aData) {
			serial = serialNumber++; //�Ϸ� ��ȣ�� ���δ�
			key = aKey;
			data = aData;
		}
	}
	
	private Node root; //���� Ž�� Ʈ���� ��Ʈ
	private int serialNumber = 0; //Node�� ���� �Ϸ� ��ȣ
	private Leaf currentLeaf; //search �޼ҵ�� Ž���� �����ϸ� �߰��� ������ currentLeaf �ʵ忡 �����Ѵ�
								//�߰��� ����Ʈ�� data �ʵ��� ���� ��� ���ؼ��� getData �޼ҵ带,
								//data �ʵ忡 ���� �ֱ� ���ؼ��� setData �޼ҵ带 ����Ѵ�
								//delete �޼ҵ�� insert �޼ҵ带 ȣ���ϸ� �� ������ �ʱ�ȭ �ȴ�
	final private static int MAX_CHILD = 5; //5�� B Ʈ��
	final private static int HALF_CHILD = ((MAX_CHILD+1)/2);
	
	//deleteAux �޼ҵ��� ��ȯ ��
	final private static int OK = 1;
	final private static int OK_REMOVED = 2;
	final private static int OK_NEED_REORG = 3;
	final private static int NOT_FOUND = 4;
	
	//������ : �� B Ʈ���� �����Ѵ�
	public BTree() {
		root = null;
	}
	
//	B Ʈ������ Ű key�� Ž���Ѵ�
//	Ű ���� key�� ������ �߰��ϸ� currentLeaf �ʵ忡 �����Ѵ�
//	
//	�� �޼ҵ�� Ž���� ���� ���θ��� ��ȯ�Ѵ�
//	������ key�� �����ϴ� ���� ��� ���ؼ��� search�� ������ �Ŀ�, getData �޼ҵ带 ȣ���� ��
//	��, setData �޼ҵ带 ȣ���ϸ�, Ű key�� �����ϴ� ���� ������ �� �ִ�
//	
//	@param key Ž���� Ű
//	@return Ű ���� key�� ������ �߰������� true, �߰����� �������� false�� ��ȯ
	public boolean search(Comparable key) {
		currentLeaf = null;//currentLeaf �ʵ带 null�� �Ѵ�
		
		//����ִ� Ʈ����� �ٷ� false�� ��ȯ
		if(root == null) {
			return false;
		} else { //��Ʈ���� �����Ͽ� ������ ������ ���� ���� ��带 ��ȸ�Ѵ�
			Node p = root;
			int i;
			while(p instanceof InternalNode) {
				InternalNode node = (InternalNode)p;
				i = node.locateSubtree(key);
				p = node.child[i];
			}
			//�־��� Ű�� ������ ����Ǿ� �ִ� Ű�� ���Ѵ�
			if(key.compareTo(((Leaf)p).key) == 0) {
				//Ž���� �����ߴ�. �� ������ currentLeaf �ʵ忡 �����ϰ� true�� ��ȯ
				currentLeaf = (Leaf)p;
				return true;
			} else {
				return false; //Ž���� �����Ͽ����Ƿ� false�� ��ȯ
			}
		}
	}
	
//	���������� ������ seach �޼ҵ尡 ã�� ����� �����͸� ��´�
//	
//	@return �ٷ� ���� search �� ����� ������(data �ʵ�)
//			�ٷ� ���� search �̿�(insert, delete)�� ����� ��쿡�� null�� ��ȯ
	public Object getData() {
		if(currentLeaf == null) {
			return null;
		} else {
			return currentLeaf.data;
		}
	}
	
//	���������� ������ search �޼ҵ尡 �߰��� ��ҿ� �����͸� �����Ѵ�
//	@param data ������ ��
//	@return ���忡 �����ߴٸ� true, �ٷ� ���� search �̿�(insert, delete)�� ����� ��쿡�� false�� ��ȯ
	public boolean setData(Object data) {
		if(currentLeaf == null) {
			return false;
		} else {
			currentLeaf.data = data;
			return true;
		}
	}
	
//	InsertAux �޼ҵ��� ���
	private class InsertAuxResult{
		Node newNode; //���ο� ��带 ���� ��쿡, �� ��尡 ����.
		Comparable lowest; //���ο� ��带 ���� ��쿡, newNode�� ����Ű�� ���� Ʈ���� �ּ� ��Ұ� ����
		
		private InsertAuxResult(Node aNewNode, Comparable theLowest) {
			newNode = aNewNode;
			lowest = theLowest;
		}
	}
	
//	������ ��忡 ���� Ű ���� key�� ��Ҹ� �����Ѵ�(insert�� ȣ��)
//	
//	@param pnode ���� ��� pnode�� nth��° �ڽĿ� ���� ���� ó���� �Ѵ�. pnode�� null�� ��쿡�� ��Ʈ�� ������� �Ѵ�
//	@param nth ���� ��� pnode�� nth��°�� �ڽĿ� ���� ���� ó���� �Ѵ�
//	@param key ������ ����� Ű
//	@param data ������ ����� ������
//	
//	@return ����� ǥ���ϴ� InsertAuxResult ���� ��ü, Ű key�� �̹� ��ϵǾ��ٸ� null
	private InsertAuxResult insertAux(InternalNode pnode, int nth, Comparable key, Object data) {
		InsertAuxResult result;
		int lowest;
		Node thisNode;
		
		//����� ���� ����� �Ǵ� ������ ��ũ�� ���� thisNode�� �ִ´�
		if(pnode == null) {
			thisNode = root;
		} else {
			thisNode = pnode.child[nth];
		}
		
		if(thisNode instanceof Leaf) {
			//�� ���� �����̴�
			
			//������ �� ��带 ���� leaf�� �����Ѵ�
			Leaf leaf = (Leaf)thisNode;
			
			//�̹� ��ϵǾ� �ִٸ� �ƹ��͵� ���� �ʰ� null�� ��ȯ
			if(leaf.key.compareTo(key) == 0) {
				return null;
			} else {
				//���ο� ���� newLeaf�� �Ҵ��Ѵ�
				Leaf newLeaf = new Leaf(key, data);
				
				//����, �Ҵ�� ���� newLeaf�� ���� leaf���� �۴ٸ�, newLeaf�� leaf�� ��ȯ�Ѵ�
				if(key.compareTo(leaf.key) < 0) {
					//���� ��忡�� ���Ӱ� �Ҵ�� newLeaf�� �ִ´�
					if(pnode == null) {
						root = newLeaf;
					} else {
						pnode.child[nth] = newLeaf;
					}
					
					//leaf�� ���Ӱ� �Ҵ�� ������� ���� �˸���
					result = new InsertAuxResult(leaf, leaf.key);
				} else {
					//newLeaf�� ���Ӱ� �Ҵ�� ������� ���� �˸���
					result = new InsertAuxResult(newLeaf, key);
				}
				return result;
			}
		} else {
			//�� ���� ���� ����̴�
			//������ �̳�带 ���� ��� node�� �����Ѵ�
			InternalNode node = (InternalNode)thisNode;
			
			int pos; //�� ��° ���� Ʈ���� ������ ���ΰ�?
			
			//��� ���� Ʈ���� ������ ���� ���Ѵ�
			pos = node.locateSubtree(key);
			
			//���� Ʈ���� ����, �ڱ� �ڽ��� ��� ȣ���Ѵ�
			result = insertAux(node, pos, key, data);
			
			//���� ������ �̷������ �ʾҴٸ� �״�� ���ư���
			if(result == null || result.newNode == null) {
				return result;
			}
			
			//������ �̷������ ������, ��� node�� �װ�(result.newNode)�� �����Ѵ�
			//��� node�� �߰��� �� �ִ°�?
			if(node.nChilds < MAX_CHILD) {
				//�߰��� �� �ִٸ� ������ ��ġ�� �����Ѵ�
				for(int i = node.nChilds - 1; i > pos; i--) {
					node.child[i+1] = node.child[i];
					node.low[i+1] = node.low[i];
				}
				node.child[pos+1] = result.newNode;
				node.low[pos+1] = result.lowest;
				node.nChilds++;
				return new InsertAuxResult(null, null);
			} else {
				//�߰��� �� ���� ������ ��� node�� 2���� �����ؾ� �Ѵ�
				//���ο� ��	�� ��� newNode�� �Ҵ��Ѵ�
				InternalNode newNode = new InternalNode();
				
				//��� result.newNode�� ��� �� ��忡 ���ԵǴ°��� ���� ���� ó���Ѵ�
				if(pos < HALF_CHILD - 1) {
					//��� result.newNode�� ��� node �ʿ� ���Եȴ�
						//�켱 HALF_CHILD-1 ~ MAX_CHILD-1��° ����Ʈ����, ��� node���� ��� newNode�� �ű��
					for(int i = HALF_CHILD-1,j=0; i<MAX_CHILD; i++, j++) {
						newNode.child[j] = node.child[i];
						newNode.low[j] = node.low[i];
					}
					//0~HALF_CHILD-2��° ���� Ʈ�� ������ ������ ��ġ�� ��� result.newNode�� �����Ѵ�
					for(int i = HALF_CHILD-2; i > pos; i--) {
						node.child[i+1] = node.child[i];
						node.low[i+1] = node.low[i];
					}
					node.child[pos+1] = result.newNode;
					node.low[pos+1] = result.lowest;
				} else {
					//��� result.newNode�� ��� newNode�ʿ� ���Եȴ�
					//HALF_CHILD ~ MAX_CHILD-1��° ���� Ʈ���� ��� newNode�� �̵��Ѵ�
					//���ÿ�, ��� result.newNode�� ������ ��ġ�� �����Ѵ�
					int j = MAX_CHILD - HALF_CHILD;
					for(int i = MAX_CHILD-1; i >= HALF_CHILD; i--) {
						if(i == pos) {
							newNode.child[j] = result.newNode;
							newNode.low[j--] = result.lowest;
						}
						newNode.child[j] = node.child[i];
						newNode.low[j--] = node.low[i];
					}
					if(pos < HALF_CHILD) {
						newNode.child[0] = result.newNode;
						newNode.low[0] = result.lowest;
					}
				}
				//�ڽ� �� nChild�� �����Ѵ�
				node.nChilds = HALF_CHILD;
				newNode.nChilds = (MAX_CHILD+1) - HALF_CHILD;
				
				//���Ҿƿ� ������� ��带 �ʵ� newNode��, �� �� �ּҰ��� lowest�ʵ忡 ��ȯ�Ѵ�
				return new InsertAuxResult(newNode, newNode.low[0]);
			}
		}
	}
	
//	B Ʈ���� ��Ҹ� �����Ѵ�
//	
//	@param key ������ ����� Ű
//	@param data ������ ����� ������
//	@return ����� ���Կ� �����Ͽ��ٸ� true, �̹� Ű ���� key�� ��Ұ� ��ϵǾ� �ִٸ�, �ƹ��͵� ���� �ʰ� false�� ��ȯ
	public boolean insert(Comparable key, Object data) {
		//currentLeaf �ʵ带 null�� �Ѵ�
		currentLeaf = null;
		
		//Ʈ���� ����ִ� ��쿡�� ������ ����� true�� ��ȯ�Ѵ�
		if(root == null) {
			root = new Leaf(key,data);
			return true;
		} else {
			//Ʈ���� ����ֱ� �ʴ� ��쿡�� insertAux �޼ҵ带 ȣ���Ͽ� ��Ҹ� �����Ѵ�
			InsertAuxResult result = insertAux(null, -1, key, data);
			
			//���� ����� null�̶��, �̹� Ű key�� ��ϵǾ� �ֱ� ������ �׳� false�� ��ȯ�Ѵ�
			if(result == null) {
				return false;
			}
			
			//���� ���ҵǾ��ٸ� Ʈ���� ���̸� 1�� ���δ�
			if(result.newNode != null) {
				InternalNode newNode = new InternalNode();
				newNode.nChilds = 2;
				newNode.child[0] = root;
				newNode.child[1] = result.newNode;
				newNode.low[1] = result.lowest;
				root = newNode;
			}
			return true;
		}
	}
	
//	���� ��� p�� x��°�� x+1��° ���� Ʈ���� �����Ѵ�
//	���� ������ �ʿ��ϴٸ� ��� ��Ҹ� x��° �κ� Ʈ���� ������ true�� ��ȯ�Ѵ�. 
//	������ �ʿ����� �ʴٸ� false�� ��ȯ�Ѵ�
//	@param p ���� ��� p
//	@param x ���� ��� p�� x��° x+1��° �κ� Ʈ���� �����Ѵ�
//	@return ������ �ʿ��ϴٸ� true, �ʿ����� �ʴٸ� false
	private boolean mergeNodes(InternalNode p, int x) {
		InternalNode a; //x��° ���� Ʈ��
		InternalNode b; //x+1��° ���� Ʈ��
		int an; //�κ� Ʈ�� a�� �ڽ� ��
		int bn; //�κ� Ʈ�� b�� �ڽ� ��
		
		a = (InternalNode)p.child[x];
		b = (InternalNode)p.child[x+1];
		b.low[0] = p.low[x+1];
		an = a.nChilds;
		bn = b.nChilds;
		
		if(an + bn <= MAX_CHILD) {
			//�κ� Ʈ�� a�� b�� �����ؾ� �Ѵ�
			//b�� �ڽ��� ��� a�� �̵��Ѵ�
			for(int i = 0; i < bn; i++) {
				a.child[i+an] = b.child[i];
				b.child[i] = null; //���ʿ��� ������ �����Ѵ�
				a.low[i + an] = b.low[i];
			}
			a.nChilds += bn;//�ڽ� ���� �����Ѵ�
			//###���⼭ b�� �����Ѵ� ###
			return true; //�����ߴٴ� ����� �˸���
		} else {
			//���� Ʈ�� a�� b�� ���� ��带 ��й��Ѵ�
			int move;//�̵��� ����� ����
			
			//���� Ʈ�� a�� �й��� �ڽ��� ���� ���Ѵ�
			int n = (an + bn)/2;
			if(an > n) {
				//���� Ʈ�� a���� ���� Ʈ�� b�� �̵��Ѵ�
				move = an - n;//move���� �ڽ��� a���� b�� �ű��
				//b�� ��Ҹ� ���������� ������
				for(int i = bn - 1; i >= 0; i--) {
					b.child[i+move] = b.child[i];
					b.low[i+move] = b.low[i];
				}
				//a���� b�� move���� �ڽ��� �̵��Ѵ�
				for(int i = 0; i < move; i++) {
					b.child[i] = a.child[i+n];
					a.child[i+n] = null;//���ʿ��� ������ �����Ѵ�
					b.low[i] = a.low[i+n];
				}
			} else {
				//���� Ʈ�� b���� ���� Ʈ�� a�� �̵��Ѵ�
				move = n - an; //move���� �ڽ��� b���� a�� �ű��
				//b���� a�� move���� �ڽ��� �̵��Ѵ�
				for(int i = 0; i < move; i++) {
					a.child[i+an] = b.child[i];
					a.low[i+an] = b.low[i];
				}
				//b�� ��Ҹ� �������� ������
				for(int i = 0; i < bn - move; i++) {
					b.child[i] = b.child[i+move];
					b.child[i+move] = null;//���ʿ��� ������ �����Ѵ�
					b.low[i] = b.low[i+move];
				}
			}
			//�ڽ� ������ �����Ѵ�
			a.nChilds = n;
			b.nChilds = an + bn - n;
			//���� Ʈ�� b�� �ּ� ���� ��� p�� �����Ѵ�
			p.low[x+1] = b.low[0];
			return false;
		}
	}
	
//	��� thisNode���� Ű ���� key�� ��Ҹ� �����Ѵ�(delete�� ȣ��)
//	
//	@param thisNode �� ���(�Ǵ� �� ���� Ʈ��)���� ��Ҹ� �����Ѵ�
//	@param key ������ ����� Ű
//	@return ������ ���� ��ȯ�Ѵ�
//			OK : ��������, thisNode���� �ƹ��� ��ȭ�� ����
//			OK_REMOVE : ���� ����, thisNode ��ü�� ������
//			OK_NEED_REORG : ���� ����, thisNode�� �ڽ��� �������� ������ (HALF_CHILD����) ������ �ʿ�������
//			NOT_FOUND : ���� ����, Ű ���� key�� �ڽ��� �߰����� ���ߴ�
	private int deleteAux(Node thisNode, Comparable key) {
		if(thisNode instanceof Leaf) {
			//�� ���� �����̴�
			//������ �� ��带 ���� leaf�� �����Ѵ�
			Leaf leaf = (Leaf)thisNode;
			
			//�� ������ Ű�� key�� ���ٸ� �����Ѵ�
			if(leaf.key.compareTo(key) == 0) {
				//###���⼭ leaf�� ��ü�Ѵ�###
				return OK_REMOVED;
			} else {
				//Ű�� ��ġ���� ����. ��, �־��� Ű�� ������ �ִ� ��Ұ� �������� ����
				return NOT_FOUND;
			}
		} else {
			//�� ���� ���� ����̴�
			//������ �� ��带 ���� ��� node�� �����Ѵ�
			InternalNode node = (InternalNode)thisNode;
			
			int pos;//�� ��° ���� Ʈ������ ������ ���ΰ�?
			boolean joined = false;//���� ��� ���� Ʈ���� ���յǾ��°�?
			
			//��� ���� Ʈ������ ������ ������ ���Ѵ�
			pos = node.locateSubtree(key);
			//�� ���� Ʈ���� ����, �ڱ� �ڽ��� ��� ȣ���Ѵ�
			int result = deleteAux(node.child[pos], key);
			//���� Ʈ���� �ƹ��� ��ȭ�� ���ٸ� �״�� ���ư���
			if(result == NOT_FOUND || result == OK) {
				return result;
			}
			
			//���� Ʈ�� pos�� ������ �ʿ䰡 �ִ°�?
			if(result == OK_NEED_REORG) {
				//���� Ʈ�� sub�� sub+1�� �����Ѵ�
				int sub = (pos == 0) ? 0 : pos-1;
				joined = mergeNodes(node, sub);
				//����, sub�� sub+1�� ���յǾ��ٸ� ���� Ʈ�� sub+1�� node���� ������ �ʿ䰡 �ִ�
				if(joined) {
					pos = sub + 1;
				}
			}
			int myResult = OK;//�� �޼ҵ尡 ��ȯ�� ��, �ϴ� OK�� �� �д�
			
			//���� Ʈ�� pos�� �����Ǿ���
			if(result == OK_REMOVED || joined) {
				//node�� ���� Ʈ���� ������
				for(int i = pos; i < node.nChilds - 1; i++) {
					node.child[i] = node.child[i+1];
					node.low[i] = node.low[i+1];
				}
				node.child[node.nChilds - 1] = null;//���ʿ��� ������ �����Ѵ�
				//����, node�� ���� Ʈ���� ���� HALF_CHILD���� ������ ������ �ʿ��ϴ�
				if(--node.nChilds < HALF_CHILD) {
					myResult = OK_NEED_REORG;
				}
			}
			return myResult;
		}
	}
	
//	B Ʈ������ ��Ҹ� �����Ѵ�
//	
//	@param key ������ ����� Ű
//	@return ������ �����ϸ� true, ��Ұ� �������� �ʴ´ٸ� false�� ��ȯ
	public boolean delete(Comparable key) {
		//currentLeaf �ʵ带 null�� �Ѵ�
		currentLeaf = null;
		
		//Ʈ���� ����ִٸ� �ƹ��͵� ���� �ʴ´�
		if(root == null) {
			return false;
		} else {
			//Ʈ���� ������� ������� deleteAux �޼ҵ带 ȣ���Ͽ� Ű ���� key�� ��Ҹ� �����Ѵ�
			int result = deleteAux(root, key);
			
			//�߰ߵ��� �ʾҴٸ� false�� ��ȯ�Ѵ�
			if(result == NOT_FOUND) {
				return false;
			}
			if(result == OK_REMOVED) {
				//��Ʈ�� �����Ǿ��� ������ root�� null�� �����Ѵ�(Ʈ���� �����)
				root = null;
			} else if(result == OK_NEED_REORG && ((InternalNode)root).nChilds == 1) {
				//��Ʈ�� ������ ���, ��Ʈ�� �ڽ��� �ϳ��� �Ǿ��ٸ� Ʈ���� ���̸� 1 �����
				//### Node p = root; ###
				root = ((InternalNode)root).child[0];
				//### ���⼭ p�� �����Ѵ� ###
			}
			return true;
		}
	}
	
//	B Ʈ���� ������ ���ڿ��� ��ȯ(toString�� ȣ��)
//	
//	@param p �� ��庸�� ���� �κ��� ������ ���ڿ��� ��ȯ
//	@return ��� p���� ���� �κ��� ��Ÿ���� ���ڿ�
	private String toStringAux(Node p) {
		//�������� ���� ��������� ���� �ٸ��� ó���Ѵ�
		if(p instanceof Leaf) {
			//�����̴�
			Leaf l = (Leaf)p;
			return "Leaf #" + l.serial + " key = " + l.key;
		} else {
			//���� ����̴�
			InternalNode n = (InternalNode)p;
			String s = "Node #" + n.serial + " (" + n.nChilds + " childs): ";
			s += "#" +n.child[0].serial + " ";
			for(int i = 1; i < n.nChilds; i++) {
				s += "[" + n.low[i] + "] #" + n.child[i].serial + " ";
			}
			s += "\n";
			for(int i = 0; i < n.nChilds; i++) {
				s += toStringAux(n.child[i]) + "\n";
			}
			return s;
		}
	}
	
//	B Ʈ���� ������ ���ڿ��� ��ȯ(���� ó���� toStringAux�� ���)
//	
//	@return B Ʈ���� ����
	public String toString() {
		if(root == null) {
			return "<Ʈ���� ����ִ�>";
		} else {
			return toStringAux(root);
		}
	}
	
//	�׽�Ʈ�� ���� ��ƾ
//	
//		">"��� ������Ʈ�� ǥ�õ� �� ��ɾ �Է��ϸ� ���� ����� ǥ�õȴ�.
//		
//		��ɾ� �϶�(n�� ����)
//			+n : n�� �����Ѵ�
//			-n : n�� �����Ѵ�
//			/n : n�� Ž���Ѵ�
//			=string : �ٷ� ���� ������ /��ɾ�� �߰��� ����� ���� string���� �Ѵ�
//			p : B Ʈ���� ������ ǥ���Ѵ�
//			q : �����Ѵ�
	public static void main(String[] args) throws IOException{
		BTree tree = new BTree();
		
		//B Ʈ���� �ʱ� �����͸� �����Ѵ�
		int[] data = {1, 100, 27, 45, 3, 135, 13};
		for(int i = 0; i < data.length; i++) {
			tree.insert(new Integer(data[i]), "[" + data[i] + "]");
		}
		//��ɾ �� �� �Է��ϰ� �װ��� �����Ѵ�
		//�� ó����, EOF�� �� ������ �ݺ��Ѵ�
		System.out.println(">");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		while((str = input.readLine()) != null) {
			if(str.length() == 0) {//������ �ǳʶڴ�
				System.out.print(">");
				continue;
			}
			
			//ó�� 1����(��ɾ�)�� command�� �ִ´�
			char command = str.charAt(0);
			
			//������ �ǳʶٰ� ���� �κ��� str�� �ִ´�
			int i = 1;
			while(i < str.length() && str.charAt(i) == ' ') {
				i++;
			}
			str = str.substring(i);
			
			//��ɾ ���� ó���Ѵ�
			if(command == 'q') {
				// q : �����Ѵ�
				break;
			} else if(command == 'p') {
				// p : B Ʈ���� ������ ǥ���Ѵ�
				System.out.println(tree);
			} else if(command == '=') {
				// = : �ٷ� ���� ������ /��ɾ��� ��ҿ� ���� �����Ѵ�
				if(tree.setData(str)) {
					System.out.println("��" + str + "�� �����Ͽ���.");
				} else {
					System.out.println("��" + str + "�� ������ �� ����.");
				}
			} else if(command == '+' || command == '-' || command == '/') {
				// +, -, / ��ɾ��� ��ɾ� ������ ������ ���ڸ� num�� �����Ѵ�
				int num = 0;
				try {
					num = Integer.parseInt(str);
				} catch(NumberFormatException e) {
					System.err.println("���� �̿��� ���� �����Ͽ��� : " + str);
					continue;
				}
				
				if(command == '+') {
					// + : ��Ҹ� �����Ѵ�
					if(tree.insert(new Integer(num), "[" + num + "]")) {
						System.out.println(num + "�� �����Ͽ���.");
					} else {
						System.out.println(num + "�� ������ �� ����.");
					}
				} else if(command == '-') {
					// - : ��Ҹ� �����Ѵ�
					if(tree.delete(new Integer(num))) {
						System.out.println(num + "�� �����Ͽ���.");
					} else {
						System.out.println(num + "�� ������ �� ����.");
					}
				} else if(command == '/') {
					// / : ��Ҹ� Ž���Ѵ�
					if(tree.search(new Integer(num))) {
						System.out.println(num + "�� �߰��Ͽ���. �� = " + tree.getData());
					} else {
						System.out.println(num + "�� �߰����� ���Ͽ���.");
					}
				}
			} else {
				System.out.println("��ɾ�" + command + "�� �������� �ʴ´�");
			}
			System.out.print(">");
		}
	}
}
