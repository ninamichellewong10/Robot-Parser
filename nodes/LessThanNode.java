import java.util.Scanner;

public class LessThanNode implements RobotConditionNode{
	
	public RobotExpressionNode nodeA = null;
	public RobotExpressionNode nodeB = null;

	@Override
	public boolean evaluate(Robot robot) {
		if(nodeA.evaluate(robot)<nodeB.evaluate(robot)){
			return true;
		}
		return false;
	}

	@Override
	public RobotConditionNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.LESSTHAN, s)){
			Parser.fail("LessThanNode Fail, expected:\n"+Parser.LESSTHAN.toString(), s);
		}
		
		if(!Parser.checkFor(Parser.OPENPAREN, s)){
			Parser.fail("LessThanNode OpenParen Fail, expected:\n"+Parser.OPENPAREN.toString(), s);
		}
		
		nodeA = new ExpressionNode();
		nodeA.parse(s);
		
		if (!Parser.checkFor(Parser.COMMA,s)){
			Parser.fail("LessThanNode - Comma Fail, expected:\n"+Parser.COMMA.toString(), s);
		}
		
		nodeB = new ExpressionNode();
		nodeB.parse(s);
		
		if (!Parser.checkFor(Parser.CLOSEPAREN, s)) {
			Parser.fail("LessThanNode - CloseParen Fail, expected:\n" + Parser.CLOSEPAREN.toString(), s);
		}

		return this;
	}
	
	@Override
	public String toString(){
		return "lt("+nodeA+", "+nodeB+")";
	}

}
