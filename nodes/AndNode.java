import java.util.Scanner;

public class AndNode implements RobotConditionNode{
	
	ConditionNode node1 = null;
	ConditionNode node2 = null;
	@Override
	public boolean evaluate(Robot robot) {
		if (node1.evaluate(robot) && node2.evaluate(robot)) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public RobotConditionNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.AND, s)){
			Parser.fail("AndNode Fail, expected:\n"+Parser.AND.toString(), s);
		}
		
		if (!Parser.checkFor(Parser.OPENPAREN, s)) {
			Parser.fail("AndNode - OpenParen Fail, expected:\n" + Parser.OPENPAREN.toString(), s);
		}
		
		node1 = new ConditionNode();
		node1.parse(s);

		if (!Parser.checkFor(Parser.COMMA, s)) {
			Parser.fail("AndNode - Comma Fail, expected:\n", s);
		}

		node2 = new ConditionNode();
		node2.parse(s);

		if (!Parser.checkFor(Parser.CLOSEPAREN, s)) {
			Parser.fail("AndNode - CloseParen Fail, expected:\n"+ Parser.CLOSEPAREN.toString(), s);
		}
	
		return this;
	}
	
	public String toString() {
		return "and("+node1.toString()+", "+node2.toString()+")";
	}

}
