package robot_position;
//�κ�
public class Robot {
	
	private	Position position;	//���� ��ǥ
	private String name;	//�̸�
	
//	�κ��� �����Ѵ�
//	
//	@param pos	�κ��� �ִ� ��ġ
//	@param nickName	�κ��� �̸�
	public Robot(Position pos, String nickName) {
		position = pos;
		name = nickName;
	}
	
//	X�������� xDelta ��ŭ �̵��Ѵ�
//	
//	@param xDelta	X������ �̵� �Ÿ�
	public void moveX(int xDelta) {
		position.moveX(xDelta);
	}
	
//	Y�������� yDelta ��ŭ �̵��Ѵ�
//	
//	@param yDelta	Y������ �̵��Ÿ�
	public void moveY(int yDelta) {
		position.moveY(yDelta);
	}
	
//	X�������� xDelta, Y�������� yDelta��ŭ �̵��Ѵ�
//	
//	@param xDelta X������ �̵� �Ÿ�
//	@param yDelta Y������ �̵� �Ÿ�
	public void moveXY(int xDelta, int yDelta) {
		position.moveXY(xDelta, yDelta);
	}
	
//	�κ��� �̸��� ��´�
//	
//	@return �κ��� �̸�
	public String getName() {
		return name;
	}
	
//	�κ��� ���� ��ġ�� ��´�
//	
//	@return �κ��� ��ġ
	public Position getPosition() {
		return position;
	}
	
//	�κ��� ������ ��Ÿ���� ���ڿ��� ��ȯ
//	
//	@return �κ��� ����
	public String toString() {
		return "name : " + name + " position : " + position;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot robita = new Robot(new Position(10, 20), "�κ�Ÿ");
		Robot robitaMK2 = robita;
		Robot robitaMK3	= robita.makeClone1();
		Robot robitaMK4 = robita.makeClone2();
		
		System.out.println("�̵� ���� �κ�Ÿ = " + robita);
		robita.moveX(10);
		System.out.println("�̵� ���� �κ�Ÿ = " + robita);
		System.out.println("robitaMK2 : " + robitaMK2);
		System.out.println("robitaMK3 : " + robitaMK3);
		System.out.println("robitaMK4 : " + robitaMK4);
	}
	
	//�κ��� Ŭ���� �����
	//��ġ�� ��Ÿ���� �ʵ� position�� �����ϰ� �Ǿ� �ùٸ��� �������� �ʴ´�
	//@return �κ��� Ŭ��
	public Robot makeClone1() {
		return new Robot(position, name + " Ŭ��");
	}
	
	
	//�κ��� Ŭ���� �����
	//
	//@return �κ��� Ŭ��
	public Robot makeClone2() {
		return new Robot(new Position(position.getX(), position.getY()), name + " Ŭ��");
	}
	
}
