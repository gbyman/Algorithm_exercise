package algorithm_tree;

import java.io.*;
//B 트리
public class BTree {
	
	//B 트리의 노드
	private abstract class Node{
		int serial; //일련 번호(B 트리의 처리에는 필요 없는 것이지만, toString으로 트리의 내용을 표시할 때 알아보기 쉽도록 한다)
		
		//Node 클래스는 추상 클래스이다
		//실제 인스턴스는 서브 프로그램인 InternalNode 클래스(내부 노드),
		//또는 Leaf 클래스(리프)로 생성한다
	}
	
	//B 트리의 내부 노드
	private class InternalNode extends Node{
		int nChilds; //이 노드가 가지고 있는 자식의 수
		Node[] child;//서브 트리
		Comparable[] low;//각 서브 트리의 최소 요소
		
		//생성자 : 빈 내부 노드를 생성한다
		private InternalNode() {
			serial = serialNumber++; //일련 번호를 붙인다
			nChilds = 0;
			child = new Node[MAX_CHILD];
			low = new Comparable[MAX_CHILD];
		}
		
//		키 값이 key인 데이터는 몇 번째 서브 트리에 들어있는가를 조사한다
//		
//		@param key 조사할 키
//		@return key가 몇 번째 서브 트리에 들어있는가를 반환
		private int locateSubtree(Comparable key) {
			for(int i = nChilds -1; i > 0; i--) {
				if(key.compareTo(low[i]) >= 0) {
					return i;
				}
			}
			return 0;
		}
	}
	
	//B 트리의 리프
	private class Leaf extends Node{
		Comparable key; //리프의 키
		Object data; //리프에 저장할 데이터
		
//		생성자 : 리프를 생성한다
//		
//		@param aKey 이 리프의 키
//		@param aData 이 리프의 데이터
		private Leaf(Comparable aKey, Object aData) {
			serial = serialNumber++; //일련 번호를 붙인다
			key = aKey;
			data = aData;
		}
	}
	
	private Node root; //이진 탐색 트리의 루트
	private int serialNumber = 0; //Node에 붙일 일련 번호
	private Leaf currentLeaf; //search 메소드는 탐색에 성공하면 발견한 리프를 currentLeaf 필드에 저장한다
								//발견한 리스트의 data 필드의 값을 얻기 위해서는 getData 메소드를,
								//data 필드에 값을 넣기 위해서는 setData 메소드를 사용한다
								//delete 메소드와 insert 메소드를 호출하면 이 변수는 초기화 된다
	final private static int MAX_CHILD = 5; //5단 B 트리
	final private static int HALF_CHILD = ((MAX_CHILD+1)/2);
	
	//deleteAux 메소드의 반환 값
	final private static int OK = 1;
	final private static int OK_REMOVED = 2;
	final private static int OK_NEED_REORG = 3;
	final private static int NOT_FOUND = 4;
	
	//생성자 : 빈 B 트리를 생성한다
	public BTree() {
		root = null;
	}
	
//	B 트리에서 키 key를 탐색한다
//	키 값이 key인 리프를 발견하면 currentLeaf 필드에 저장한다
//	
//	이 메소드는 탐색의 성공 여부만을 반환한다
//	실제로 key에 대응하는 값을 얻기 위해서는 search가 성공한 후에, getData 메소드를 호출할 것
//	또, setData 메소드를 호출하면, 키 key에 대응하는 값을 변경할 수 있다
//	
//	@param key 탐색할 키
//	@return 키 값이 key인 리프를 발견했으면 true, 발견하지 못했으면 false를 반환
	public boolean search(Comparable key) {
		currentLeaf = null;//currentLeaf 필드를 null로 한다
		
		//비어있는 트리라면 바로 false를 반환
		if(root == null) {
			return false;
		} else { //루트에서 시작하여 리프에 도달할 때깢 내부 노드를 순회한다
			Node p = root;
			int i;
			while(p instanceof InternalNode) {
				InternalNode node = (InternalNode)p;
				i = node.locateSubtree(key);
				p = node.child[i];
			}
			//주어진 키와 리프에 저장되어 있는 키를 비교한다
			if(key.compareTo(((Leaf)p).key) == 0) {
				//탐색에 성공했다. 이 리프를 currentLeaf 필드에 저장하고 true를 반환
				currentLeaf = (Leaf)p;
				return true;
			} else {
				return false; //탐색에 실패하였으므로 false를 반환
			}
		}
	}
	
//	마지막으로 성공한 seach 메소드가 찾은 요소의 데이터를 얻는다
//	
//	@return 바로 전에 search 된 요소의 데이터(data 필드)
//			바로 전에 search 이외(insert, delete)가 실행된 경우에는 null을 반환
	public Object getData() {
		if(currentLeaf == null) {
			return null;
		} else {
			return currentLeaf.data;
		}
	}
	
//	마지막으로 성공한 search 메소드가 발견한 요소에 데이터를 저장한다
//	@param data 저장할 값
//	@return 저장에 성공했다면 true, 바로 전에 search 이외(insert, delete)가 실행된 경우에는 false를 반환
	public boolean setData(Object data) {
		if(currentLeaf == null) {
			return false;
		} else {
			currentLeaf.data = data;
			return true;
		}
	}
	
//	InsertAux 메소드의 결과
	private class InsertAuxResult{
		Node newNode; //새로운 노드를 만든 경우에, 그 노드가 들어간다.
		Comparable lowest; //새로운 노드를 만든 경우에, newNode가 가리키는 서브 트리의 최소 요소가 들어간다
		
		private InsertAuxResult(Node aNewNode, Comparable theLowest) {
			newNode = aNewNode;
			lowest = theLowest;
		}
	}
	
//	지정된 노드에 대해 키 값이 key인 요소를 삽입한다(insert가 호출)
//	
//	@param pnode 내부 노드 pnode의 nth번째 자식에 대해 삽입 처리를 한다. pnode가 null인 경우에는 루트를 대상으로 한다
//	@param nth 내부 노드 pnode의 nth번째의 자식에 대해 삽입 처리를 한다
//	@param key 삽입할 요소의 키
//	@param data 삽입할 요소의 데이터
//	
//	@return 결과를 표시하는 InsertAuxResult 형의 객체, 키 key가 이미 등록되었다면 null
	private InsertAuxResult insertAux(InternalNode pnode, int nth, Comparable key, Object data) {
		InsertAuxResult result;
		int lowest;
		Node thisNode;
		
		//요소의 삽입 대상이 되는 노드로의 링크를 변수 thisNode에 넣는다
		if(pnode == null) {
			thisNode = root;
		} else {
			thisNode = pnode.child[nth];
		}
		
		if(thisNode instanceof Leaf) {
			//이 노드는 리프이다
			
			//앞으로 이 노드를 리프 leaf로 참조한다
			Leaf leaf = (Leaf)thisNode;
			
			//이미 등록되어 있다면 아무것도 하지 않고 null을 반환
			if(leaf.key.compareTo(key) == 0) {
				return null;
			} else {
				//새로운 리프 newLeaf를 할당한다
				Leaf newLeaf = new Leaf(key, data);
				
				//만약, 할당된 리프 newLeaf가 리프 leaf보다 작다면, newLeaf와 leaf를 교환한다
				if(key.compareTo(leaf.key) < 0) {
					//원래 노드에는 새롭게 할당된 newLeaf를 넣는다
					if(pnode == null) {
						root = newLeaf;
					} else {
						pnode.child[nth] = newLeaf;
					}
					
					//leaf가 새롭게 할당된 리프라는 것을 알린다
					result = new InsertAuxResult(leaf, leaf.key);
				} else {
					//newLeaf가 새롭게 할당된 리프라는 것을 알린다
					result = new InsertAuxResult(newLeaf, key);
				}
				return result;
			}
		} else {
			//이 노드는 내부 노드이다
			//앞으로 이노드를 내부 노드 node로 참조한다
			InternalNode node = (InternalNode)thisNode;
			
			int pos; //몇 번째 서브 트리에 삽입할 것인가?
			
			//어느 서브 트리에 삽입할 지를 구한다
			pos = node.locateSubtree(key);
			
			//서브 트리에 대해, 자기 자신을 재귀 호출한다
			result = insertAux(node, pos, key, data);
			
			//만약 분할이 이루어지지 않았다면 그대로 돌아간다
			if(result == null || result.newNode == null) {
				return result;
			}
			
			//분할이 이루어졌기 때문에, 노드 node에 그것(result.newNode)를 삽입한다
			//노드 node에 추가할 수 있는가?
			if(node.nChilds < MAX_CHILD) {
				//추가할 수 있다면 적절한 위치에 삽입한다
				for(int i = node.nChilds - 1; i > pos; i--) {
					node.child[i+1] = node.child[i];
					node.low[i+1] = node.low[i];
				}
				node.child[pos+1] = result.newNode;
				node.low[pos+1] = result.lowest;
				node.nChilds++;
				return new InsertAuxResult(null, null);
			} else {
				//추가할 수 없기 때문에 노드 node를 2개로 분할해야 한다
				//새로운 내	부 노드 newNode를 할당한다
				InternalNode newNode = new InternalNode();
				
				//노드 result.newNode가 어느 쪽 노드에 삽입되는가에 따라 개별 처리한다
				if(pos < HALF_CHILD - 1) {
					//노드 result.newNode는 노드 node 쪽에 삽입된다
						//우선 HALF_CHILD-1 ~ MAX_CHILD-1번째 서브트리를, 노드 node에서 노드 newNode로 옮긴다
					for(int i = HALF_CHILD-1,j=0; i<MAX_CHILD; i++, j++) {
						newNode.child[j] = node.child[i];
						newNode.low[j] = node.low[i];
					}
					//0~HALF_CHILD-2번째 서브 트리 사이의 적절한 위치에 노드 result.newNode를 삽입한다
					for(int i = HALF_CHILD-2; i > pos; i--) {
						node.child[i+1] = node.child[i];
						node.low[i+1] = node.low[i];
					}
					node.child[pos+1] = result.newNode;
					node.low[pos+1] = result.lowest;
				} else {
					//노드 result.newNode는 노드 newNode쪽에 삽입된다
					//HALF_CHILD ~ MAX_CHILD-1번째 서브 트리를 노드 newNode로 이동한다
					//동시에, 노드 result.newNode를 적절한 위치에 삽입한다
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
				//자식 수 nChild를 갱신한다
				node.nChilds = HALF_CHILD;
				newNode.nChilds = (MAX_CHILD+1) - HALF_CHILD;
				
				//분할아여 만들어진 노드를 필드 newNode에, 또 그 최소값을 lowest필드에 반환한다
				return new InsertAuxResult(newNode, newNode.low[0]);
			}
		}
	}
	
//	B 트리에 요소를 삽입한다
//	
//	@param key 삽입할 요소의 키
//	@param data 삽입할 요소의 데이터
//	@return 요소의 삽입에 성공하였다면 true, 이미 키 값이 key인 요소가 등록되어 있다면, 아무것도 하지 않고 false를 반환
	public boolean insert(Comparable key, Object data) {
		//currentLeaf 필드를 null로 한다
		currentLeaf = null;
		
		//트리가 비어있는 경우에는 리프를 만들고 true를 반환한다
		if(root == null) {
			root = new Leaf(key,data);
			return true;
		} else {
			//트리가 비어있기 않는 경우에는 insertAux 메소드를 호출하여 요소를 삽입한다
			InsertAuxResult result = insertAux(null, -1, key, data);
			
			//만약 결과가 null이라면, 이미 키 key는 등록되어 있기 때문에 그냥 false를 반환한다
			if(result == null) {
				return false;
			}
			
			//만약 분할되었다면 트리의 높이를 1단 높인다
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
	
//	내부 노드 p의 x번째와 x+1번째 서브 트리를 재편성한다
//	만약 병합이 필요하다면 모든 요소를 x번째 부분 트리에 모으고 true를 반환한다. 
//	병합이 필요하지 않다면 false를 반환한다
//	@param p 내부 노드 p
//	@param x 내부 노드 p의 x번째 x+1번째 부분 트리를 재편성한다
//	@return 병합이 필요하다면 true, 필요하지 않다면 false
	private boolean mergeNodes(InternalNode p, int x) {
		InternalNode a; //x번째 서브 트리
		InternalNode b; //x+1번째 서브 트리
		int an; //부분 트리 a의 자식 수
		int bn; //부분 트리 b의 자식 수
		
		a = (InternalNode)p.child[x];
		b = (InternalNode)p.child[x+1];
		b.low[0] = p.low[x+1];
		an = a.nChilds;
		bn = b.nChilds;
		
		if(an + bn <= MAX_CHILD) {
			//부분 트리 a와 b를 병합해야 한다
			//b의 자식을 모두 a로 이동한다
			for(int i = 0; i < bn; i++) {
				a.child[i+an] = b.child[i];
				b.child[i] = null; //불필요한 참조를 제거한다
				a.low[i + an] = b.low[i];
			}
			a.nChilds += bn;//자식 수를 갱신한다
			//###여기서 b를 해제한다 ###
			return true; //병합했다는 사실을 알린다
		} else {
			//서브 트리 a와 b에 대해 노드를 재분배한다
			int move;//이동할 요소의 개수
			
			//서브 트리 a에 분배할 자식의 수를 구한다
			int n = (an + bn)/2;
			if(an > n) {
				//서브 트리 a에서 서브 트리 b로 이동한다
				move = an - n;//move개의 자식을 a에서 b로 옮긴다
				//b의 요소를 오른쪽으로 모은다
				for(int i = bn - 1; i >= 0; i--) {
					b.child[i+move] = b.child[i];
					b.low[i+move] = b.low[i];
				}
				//a에서 b로 move개의 자식을 이동한다
				for(int i = 0; i < move; i++) {
					b.child[i] = a.child[i+n];
					a.child[i+n] = null;//불필요한 참조를 제거한다
					b.low[i] = a.low[i+n];
				}
			} else {
				//서브 트리 b에서 서브 트리 a로 이동한다
				move = n - an; //move개의 자식을 b에서 a로 옮긴다
				//b에서 a로 move개의 자식을 이동한다
				for(int i = 0; i < move; i++) {
					a.child[i+an] = b.child[i];
					a.low[i+an] = b.low[i];
				}
				//b의 요소를 왼쪽으로 모은다
				for(int i = 0; i < bn - move; i++) {
					b.child[i] = b.child[i+move];
					b.child[i+move] = null;//불필요한 참조를 제거한다
					b.low[i] = b.low[i+move];
				}
			}
			//자식 개수를 갱신한다
			a.nChilds = n;
			b.nChilds = an + bn - n;
			//서브 트리 b의 최소 값을 노드 p에 저장한다
			p.low[x+1] = b.low[0];
			return false;
		}
	}
	
//	노드 thisNode에서 키 값이 key인 요소를 삭제한다(delete가 호출)
//	
//	@param thisNode 이 노드(또는 그 서브 트리)에서 요소를 삭제한다
//	@param key 삭제할 요소의 키
//	@return 이하의 값을 반환한다
//			OK : 삭제성공, thisNode에는 아무런 변화도 없음
//			OK_REMOVE : 삭제 성공, thisNode 자체가 삭제됨
//			OK_NEED_REORG : 삭제 성공, thisNode의 자식이 없어졌기 때문에 (HALF_CHILD이하) 재편성이 필요해졌다
//			NOT_FOUND : 삭제 실패, 키 값이 key인 자식을 발견하지 못했다
	private int deleteAux(Node thisNode, Comparable key) {
		if(thisNode instanceof Leaf) {
			//이 노드는 리프이다
			//앞으로 이 노드를 리프 leaf로 참조한다
			Leaf leaf = (Leaf)thisNode;
			
			//이 리프의 키와 key가 같다면 삭제한다
			if(leaf.key.compareTo(key) == 0) {
				//###여기서 leaf를 해체한다###
				return OK_REMOVED;
			} else {
				//키가 일치하지 않음. 즉, 주어진 키를 가지고 있는 요소가 존재하지 않음
				return NOT_FOUND;
			}
		} else {
			//이 노드는 내부 노드이다
			//앞으로 이 노드를 내부 노드 node로 참조한다
			InternalNode node = (InternalNode)thisNode;
			
			int pos;//몇 번째 서브 트리에서 삭제할 것인가?
			boolean joined = false;//재편성 결과 서브 트리가 병합되었는가?
			
			//어느 서브 트리에서 삭제할 것인지 구한다
			pos = node.locateSubtree(key);
			//그 서브 트리에 대해, 자기 자신을 재귀 호출한다
			int result = deleteAux(node.child[pos], key);
			//서브 트리에 아무런 변화가 없다면 그대로 돌아간다
			if(result == NOT_FOUND || result == OK) {
				return result;
			}
			
			//서브 트리 pos를 재편성할 필요가 있는가?
			if(result == OK_NEED_REORG) {
				//서브 트리 sub와 sub+1을 재편성한다
				int sub = (pos == 0) ? 0 : pos-1;
				joined = mergeNodes(node, sub);
				//만약, sub와 sub+1이 병합되었다면 서브 트리 sub+1을 node에서 삭제할 필요가 있다
				if(joined) {
					pos = sub + 1;
				}
			}
			int myResult = OK;//이 메소드가 반환할 값, 일단 OK로 해 둔다
			
			//서브 트리 pos가 삭제되었다
			if(result == OK_REMOVED || joined) {
				//node의 서브 트리를 모은다
				for(int i = pos; i < node.nChilds - 1; i++) {
					node.child[i] = node.child[i+1];
					node.low[i] = node.low[i+1];
				}
				node.child[node.nChilds - 1] = null;//불필요한 참조를 제거한다
				//만약, node의 서브 트리의 수가 HALF_CHILD보다 작으면 재편성이 필요하다
				if(--node.nChilds < HALF_CHILD) {
					myResult = OK_NEED_REORG;
				}
			}
			return myResult;
		}
	}
	
//	B 트리에서 요소를 삭제한다
//	
//	@param key 삭제할 요소의 키
//	@return 삭제에 성공하면 true, 요소가 존재하지 않는다면 false를 반환
	public boolean delete(Comparable key) {
		//currentLeaf 필드를 null로 한다
		currentLeaf = null;
		
		//트리가 비어있다면 아무것도 하지 않는다
		if(root == null) {
			return false;
		} else {
			//트리가 비어있지 않은경우 deleteAux 메소드를 호출하여 키 값이 key인 요소를 삭제한다
			int result = deleteAux(root, key);
			
			//발견되지 않았다면 false를 반환한다
			if(result == NOT_FOUND) {
				return false;
			}
			if(result == OK_REMOVED) {
				//루트가 삭제되었기 때문에 root에 null을 대입한다(트리가 비었다)
				root = null;
			} else if(result == OK_NEED_REORG && ((InternalNode)root).nChilds == 1) {
				//루트가 재편성된 결과, 루트의 자식이 하나가 되었다면 트리의 높이를 1 낮춘다
				//### Node p = root; ###
				root = ((InternalNode)root).child[0];
				//### 여기서 p를 해제한다 ###
			}
			return true;
		}
	}
	
//	B 트리의 내용을 문자열로 반환(toString이 호출)
//	
//	@param p 이 노드보다 낮은 부분의 내용을 문자열로 반환
//	@return 노드 p보다 낮은 부분을 나타내는 문자열
	private String toStringAux(Node p) {
		//리프인지 내부 노드인지에 따라 다르게 처리한다
		if(p instanceof Leaf) {
			//리프이다
			Leaf l = (Leaf)p;
			return "Leaf #" + l.serial + " key = " + l.key;
		} else {
			//내부 노드이다
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
	
//	B 트리의 내용을 문자열로 반환(실제 처리는 toStringAux가 담당)
//	
//	@return B 트리의 내용
	public String toString() {
		if(root == null) {
			return "<트리는 비어있다>";
		} else {
			return toStringAux(root);
		}
	}
	
//	테스트용 메인 루틴
//	
//		">"라는 프롬프트가 표시된 후 명령어를 입력하면 실행 결과가 표시된다.
//		
//		명령어 일람(n은 정수)
//			+n : n을 삽입한다
//			-n : n을 삭제한다
//			/n : n을 탐색한다
//			=string : 바로 전에 성공한 /명령어로 발견한 노드의 값을 string으로 한다
//			p : B 트리의 내용을 표시한다
//			q : 종료한다
	public static void main(String[] args) throws IOException{
		BTree tree = new BTree();
		
		//B 트리에 초기 데이터를 삽입한다
		int[] data = {1, 100, 27, 45, 3, 135, 13};
		for(int i = 0; i < data.length; i++) {
			tree.insert(new Integer(data[i]), "[" + data[i] + "]");
		}
		//명령어를 한 줄 입력하고 그것을 실행한다
		//이 처리를, EOF가 될 때까지 반복한다
		System.out.println(">");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		while((str = input.readLine()) != null) {
			if(str.length() == 0) {//공백은 건너뛴다
				System.out.print(">");
				continue;
			}
			
			//처음 1문자(명령어)을 command에 넣는다
			char command = str.charAt(0);
			
			//공백을 건너뛰고 남은 부분을 str에 넣는다
			int i = 1;
			while(i < str.length() && str.charAt(i) == ' ') {
				i++;
			}
			str = str.substring(i);
			
			//명령어에 따라 처리한다
			if(command == 'q') {
				// q : 종료한다
				break;
			} else if(command == 'p') {
				// p : B 트리의 내용을 표시한다
				System.out.println(tree);
			} else if(command == '=') {
				// = : 바로 전에 성공한 /명령어의 요소에 값을 저장한다
				if(tree.setData(str)) {
					System.out.println("값" + str + "을 저장하였다.");
				} else {
					System.out.println("값" + str + "을 저장할 수 없다.");
				}
			} else if(command == '+' || command == '-' || command == '/') {
				// +, -, / 명령어라면 명령어 다음에 나오는 숫자를 num에 저장한다
				int num = 0;
				try {
					num = Integer.parseInt(str);
				} catch(NumberFormatException e) {
					System.err.println("정수 이외의 값을 설정하였다 : " + str);
					continue;
				}
				
				if(command == '+') {
					// + : 요소를 삽입한다
					if(tree.insert(new Integer(num), "[" + num + "]")) {
						System.out.println(num + "을 삽입하였다.");
					} else {
						System.out.println(num + "을 삽입할 수 없다.");
					}
				} else if(command == '-') {
					// - : 요소를 삭제한다
					if(tree.delete(new Integer(num))) {
						System.out.println(num + "을 삭제하였다.");
					} else {
						System.out.println(num + "을 삭제할 수 없다.");
					}
				} else if(command == '/') {
					// / : 요소를 탐색한다
					if(tree.search(new Integer(num))) {
						System.out.println(num + "을 발견하였다. 값 = " + tree.getData());
					} else {
						System.out.println(num + "을 발견하지 못하였다.");
					}
				}
			} else {
				System.out.println("명령어" + command + "는 지원하지 않는다");
			}
			System.out.print(">");
		}
	}
}
