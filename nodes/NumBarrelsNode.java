import java.util.Scanner;

public class NumBarrelsNode implements RobotExpressionNode{

	@Override
	public int evaluate(Robot robot) {
		return robot.numBarrels();
	}

	@Override
	public RobotExpressionNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.NUMBARRELS, s)){
			Parser.fail("NumBarrelNode Fail, expected:\n"+Parser.NUMBARRELS.toString(), s);
		}
		return this;
	}
	
	public String toString() {
		return Parser.NUMBARRELS.toString();
	}
}
