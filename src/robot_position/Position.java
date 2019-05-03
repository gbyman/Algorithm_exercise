package robot_position;
//로봇의 위치
public class Position {
	
	private	int x;	//X좌표
	private	int	y;	//Y좌표
	
//	위치를 생성한다
//	
//	@param xPos	X좌표
//	@param yPos	Y좌표	
	
	public Position(int xPos, int yPos) {
		x = xPos;
		y = yPos;
	}
	
//	X방향으로 xDelta만큼 이동한다
//	
//	@param xDelta	X방향의 이동 거리
//	
	public void moveX(int xDelta) {
		x += xDelta;
	}
	
//	Y방향으로 yDelta만큼 이동한다
//	
//	@param yDelta	Y방향의 이동거리
	public void moveY(int yDelta) {
		y += yDelta;
	}
	
//	X방향으로 xDelta, Y방향으로 yDelta만큼 이동한다
//	
//	@param xDelta	X방향의 이동거리
//	@param yDelta	Y방향의 이동거리
	public void moveXY(int xDelta, int yDelta) {
		x += xDelta;
		y += yDelta;
	}
	
//	X좌표를 얻는다
//	
//	@return	X좌표
	public int getX() {
		return x;
	}
	
//	Y좌표를 얻는다
//	
//	@return Y좌표
	public int getY() {
		return y;
	}
	
//	위치를 나타내는 문자열을 반환
//	
//	@return 위치를 나타내는 문자열
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
//	위치가 같은지, 같지 않은지
//	
//	@param pos	비교할 대상
//	@return 같다면 true, 같지 않다면 false를 반환
	public boolean equals(Position pos) {
		return this.x == pos.x && this.y == pos.y;
	}
}
