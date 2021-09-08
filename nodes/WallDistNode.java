import java.util.Scanner;

public class WallDistNode implements RobotExpressionNode{

	@Override
	public int evaluate(Robot robot) {
		return robot.getDistanceToWall();
	}

	@Override
	public RobotExpressionNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.WALLDIST, s)){
			Parser.fail("WallDistNode Fail, expected:\n"+Parser.WALLDIST.toString(), s);
		}
		return this;
	}
	
	public String toString(){
		return Parser.WALLDIST.toString();
	}
}
