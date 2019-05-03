package robot_position;
//로봇
public class Robot {
	
	private	Position position;	//현재 좌표
	private String name;	//이름
	
//	로봇을 생성한다
//	
//	@param pos	로봇이 있는 위치
//	@param nickName	로봇의 이름
	public Robot(Position pos, String nickName) {
		position = pos;
		name = nickName;
	}
	
//	X방향으로 xDelta 만큼 이동한다
//	
//	@param xDelta	X방향의 이동 거리
	public void moveX(int xDelta) {
		position.moveX(xDelta);
	}
	
//	Y방향으로 yDelta 만큼 이동한다
//	
//	@param yDelta	Y방향의 이동거리
	public void moveY(int yDelta) {
		position.moveY(yDelta);
	}
	
//	X방향으로 xDelta, Y방향으로 yDelta만큼 이동한다
//	
//	@param xDelta X방향의 이동 거리
//	@param yDelta Y방향의 이동 거리
	public void moveXY(int xDelta, int yDelta) {
		position.moveXY(xDelta, yDelta);
	}
	
//	로봇의 이름을 얻는다
//	
//	@return 로봇의 이름
	public String getName() {
		return name;
	}
	
//	로봇의 현재 위치를 얻는다
//	
//	@return 로봇의 위치
	public Position getPosition() {
		return position;
	}
	
//	로봇의 정보를 나타내는 문자열을 반환
//	
//	@return 로봇의 정보
	public String toString() {
		return "name : " + name + " position : " + position;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot robita = new Robot(new Position(10, 20), "로비타");
		Robot robitaMK2 = robita;
		Robot robitaMK3	= robita.makeClone1();
		Robot robitaMK4 = robita.makeClone2();
		
		System.out.println("이동 전의 로비타 = " + robita);
		robita.moveX(10);
		System.out.println("이동 후의 로비타 = " + robita);
		System.out.println("robitaMK2 : " + robitaMK2);
		System.out.println("robitaMK3 : " + robitaMK3);
		System.out.println("robitaMK4 : " + robitaMK4);
	}
	
	//로봇의 클론을 만든다
	//위치를 나타내는 필드 position을 공유하게 되어 올바르게 동작하지 않는다
	//@return 로봇의 클론
	public Robot makeClone1() {
		return new Robot(position, name + " 클론");
	}
	
	
	//로봇의 클론을 만든다
	//
	//@return 로봇의 클론
	public Robot makeClone2() {
		return new Robot(new Position(position.getX(), position.getY()), name + " 클론");
	}
	
}
