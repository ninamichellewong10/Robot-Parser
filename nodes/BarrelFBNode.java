import java.util.Scanner;

public class BarrelFBNode implements RobotExpressionNode{
	
	RobotExpressionNode node = null;

	@Override
	public int evaluate(Robot robot) {
		if (node != null) {
			return robot.getBarrelFB(node.evaluate(robot));
		}
		return robot.getClosestBarrelFB();
	}

	@Override
	public RobotExpressionNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.BARRELFB, s)){
			Parser.fail("BarrelFB Fail, expected: " +Parser.BARRELFB.toString(), s);
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
			return "barrelFB";
		}
		else {
			return "barrelFB("+node+")";
		}
	}
}
