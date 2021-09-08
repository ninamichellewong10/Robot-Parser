import java.util.Scanner;

public class WaitNode implements RobotProgramNode{
	
	private ExpressionNode node = null;

	@Override
	public void execute(Robot robot) {
		robot.idleWait();		
	}

	@Override
	public RobotProgramNode parse(Scanner s) {
		if (!Parser.checkFor(Parser.WAIT, s)) {
			Parser.fail("WaitNode Fail, expected:\n" + Parser.WAIT.toString(), s);
		}
		
		if (s.hasNext(Parser.OPENPAREN)) {
			Parser.checkFor(Parser.OPENPAREN, s);	
		}
		
		if (s.hasNext(Parser.SENSOR) || s.hasNext(Parser.NUMPAT) ||
				s.hasNext(Parser.OPERATION)) {
			node = new ExpressionNode();
			node.parse(s);
		}
		
		if (s.hasNext(Parser.CLOSEPAREN)) {
			Parser.checkFor(Parser.CLOSEPAREN, s);
		}	
	
		return this;
	}
	
	public String toString(){
		if (node == null) {
			return ("wait");
		}
		else {
			return "wait (" + node.toString() + ")";
		}
	}

}
