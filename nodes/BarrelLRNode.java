import java.util.Scanner;

public class BarrelLRNode implements RobotExpressionNode{
	
	RobotExpressionNode node = null;
	
	@Override
	public int evaluate(Robot robot) {
		if (node != null) {
			return robot.getBarrelLR(node.evaluate(robot));
		}
		return robot.getClosestBarrelLR();
	}

	@Override
	public RobotExpressionNode parse(Scanner s) {
		if (!Parser.checkFor(Parser.BARRELLR, s)) {
			Parser.fail("BarrelLR Fail, expected:\n" + Parser.BARRELLR.toString(), s);
		}
		
		if (s.hasNext(Parser.OPENPAREN)) {
			Parser.checkFor(Parser.OPENPAREN, s); 
			
		}
		
		if (s.hasNext(Parser.SENSOR) || s.hasNext(Parser.NUMPAT) ||
				s.hasNext(Parser.OPERATION) || s.hasNext(Parser.VARIABLE)) {
			node = new ExpressionNode();
			node.parse(s);
		}

		if (s.hasNext(Parser.CLOSEPAREN)) {
			Parser.checkFor(Parser.CLOSEPAREN, s);
		}
		
		return this;
	}
	
	@Override
	public String toString(){
		if (node == null) {
			return "barrelLR";
		}
		else {
			return "barrelLR("+node+")";
		}
	}

}
