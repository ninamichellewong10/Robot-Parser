import java.util.Scanner;

public class OpponentLRNode implements RobotExpressionNode{
	
	RobotExpressionNode nodeOpp = null;
	
	@Override
	public int evaluate(Robot robot) {
		return robot.getOpponentLR();
	}

	@Override
	public RobotExpressionNode parse(Scanner s) {
		if (!Parser.checkFor(Parser.OPPLR, s)) {
			Parser.fail("OpponentLR Fail, expected:\n" + Parser.OPPLR.toString(), s);
		}
	
		return this;
	}
	
	public String toString() {
		return Parser.OPPLR.toString();
	}

}
