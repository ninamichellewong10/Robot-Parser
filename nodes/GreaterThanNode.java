import java.util.Scanner;

public class GreaterThanNode implements RobotConditionNode{
	
	public RobotExpressionNode nodeA = null;
	public RobotExpressionNode nodeB = null;

	@Override
	public boolean evaluate(Robot robot) {
		if(nodeA.evaluate(robot)>nodeB.evaluate(robot)){
			return true;
		}
		return false;
	}

	@Override
	public RobotConditionNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.GREATERTHAN, s)){
			Parser.fail("GreaterThanNode Fail, expected:\n"+Parser.LESSTHAN.toString(), s);
		}
		
		if(!Parser.checkFor(Parser.OPENPAREN, s)){
			Parser.fail("GreaterThanNode OpenParen Fail, expected:\n"+Parser.OPENPAREN.toString(), s);
		}
		
		nodeA = new ExpressionNode();
		nodeA.parse(s);	
		
		if (s.hasNext(Parser.COMMA)) {
			Parser.checkFor(Parser.COMMA, s);
		}
		
		nodeB = new ExpressionNode();
		nodeB.parse(s);
		
		if (!Parser.checkFor(Parser.CLOSEPAREN, s)) {
			Parser.fail("GreaterThanNode - CloseParen Fail, expected:\n" + Parser.CLOSEPAREN.toString(), s);
		}
		
		return this;
	}
	
	@Override
	public String toString(){
		return "gt("+nodeA+", "+nodeB+")";
	}

}
