import java.util.Scanner;

public class FuelLeftNode implements RobotExpressionNode{

	@Override
	public int evaluate(Robot robot) {
		return robot.getFuel();
	}

	@Override
	public RobotExpressionNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.FUELLEFT, s)){
			Parser.fail("FuelLeftNode Fail, expected:\n "+Parser.FUELLEFT, s);
		}
		return this;
	}
	
	public String toString() {
		return Parser.FUELLEFT.toString();
	}

}
