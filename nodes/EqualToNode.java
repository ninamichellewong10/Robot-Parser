import java.util.Scanner;

public class EqualToNode implements RobotConditionNode{
	
	public RobotExpressionNode node1 = null;
	public RobotExpressionNode node2 = null;

	@Override
	public boolean evaluate(Robot robot) {
		if(node1.evaluate(robot) == node2.evaluate(robot)){
			return true;
		}
		return false;
	}

	@Override
	public RobotConditionNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.EQUAL, s)){
			Parser.fail("EqualToNode Fail, expected:\n"+Parser.EQUAL.toString(), s);
		}
		
		if(!Parser.checkFor(Parser.OPENPAREN, s)){
			Parser.fail("EqualToNode - OpenParen Fail, expected:\n"+Parser.OPENPAREN.toString(), s);
		}
		
		node1 = new ExpressionNode();
		node1.parse(s);
		
		if (s.hasNext(Parser.COMMA)) {
			Parser.checkFor(Parser.COMMA, s);
		}
		
		node2 = new ExpressionNode();
		node2.parse(s);
		
		if (!Parser.checkFor(Parser.CLOSEPAREN, s)) {
			Parser.fail("EqualToNode - CloseParen Fail, expected:\n" + Parser.CLOSEPAREN.toString(), s);
		}
		
		return this;
	}
	
	public String toString(){
		return "eq(" + node1.toString() + ", " + node2.toString() + ")";
	}

}
