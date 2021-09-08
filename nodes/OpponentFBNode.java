import java.util.Scanner;

public class OpponentFBNode implements RobotExpressionNode{

	@Override
	public int evaluate(Robot robot) {
		return robot.getOpponentFB();
	}

	@Override
	public RobotExpressionNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.OPPFB, s)){
			Parser.fail("OpponentFB Fail, expected:\n"+Parser.OPPFB.toString(), s);
		}
		return this;
	}
	
	public String toString(){
		return Parser.OPPFB.toString();
	}

}
