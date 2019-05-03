package robot_position;
//�κ��� ��ġ
public class Position {
	
	private	int x;	//X��ǥ
	private	int	y;	//Y��ǥ
	
//	��ġ�� �����Ѵ�
//	
//	@param xPos	X��ǥ
//	@param yPos	Y��ǥ	
	
	public Position(int xPos, int yPos) {
		x = xPos;
		y = yPos;
	}
	
//	X�������� xDelta��ŭ �̵��Ѵ�
//	
//	@param xDelta	X������ �̵� �Ÿ�
//	
	public void moveX(int xDelta) {
		x += xDelta;
	}
	
//	Y�������� yDelta��ŭ �̵��Ѵ�
//	
//	@param yDelta	Y������ �̵��Ÿ�
	public void moveY(int yDelta) {
		y += yDelta;
	}
	
//	X�������� xDelta, Y�������� yDelta��ŭ �̵��Ѵ�
//	
//	@param xDelta	X������ �̵��Ÿ�
//	@param yDelta	Y������ �̵��Ÿ�
	public void moveXY(int xDelta, int yDelta) {
		x += xDelta;
		y += yDelta;
	}
	
//	X��ǥ�� ��´�
//	
//	@return	X��ǥ
	public int getX() {
		return x;
	}
	
//	Y��ǥ�� ��´�
//	
//	@return Y��ǥ
	public int getY() {
		return y;
	}
	
//	��ġ�� ��Ÿ���� ���ڿ��� ��ȯ
//	
//	@return ��ġ�� ��Ÿ���� ���ڿ�
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
//	��ġ�� ������, ���� ������
//	
//	@param pos	���� ���
//	@return ���ٸ� true, ���� �ʴٸ� false�� ��ȯ
	public boolean equals(Position pos) {
		return this.x == pos.x && this.y == pos.y;
	}
}
