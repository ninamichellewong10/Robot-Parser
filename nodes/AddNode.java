import java.util.Scanner;

public class AddNode implements RobotExpressionNode{
	
	private ExpressionNode node1 = null;
	private ExpressionNode node2 = null;
	private int value1 = -1;
	private int value2 = -1;

	@Override
	public int evaluate(Robot robot) {
		value1 = node1.evaluate(robot);
		value2 = node2.evaluate(robot);
		return (value1 + value2);
	}

	@Override
	public RobotExpressionNode parse(Scanner s) {
		if (!Parser.checkFor(Parser.ADD, s)) {
			Parser.fail("AddNode Fail, expected:\n " + Parser.ADD.toString(), s);
		}

		if (!Parser.checkFor(Parser.OPENPAREN, s)) {
			Parser.fail("AddNode - OpenParen Fail, expected:\n " + Parser.OPENPAREN.toString(), s);
		}
	
		node1 = new ExpressionNode();
		node1.parse(s);
	
		if (!Parser.checkFor(Parser.COMMA, s)) {
			Parser.fail("AddNode - Comma Fail, expected:\n", s);
		}
	
		node2 = new ExpressionNode();
		node2.parse(s);
	
		if (!Parser.checkFor(Parser.CLOSEPAREN, s)) {
			Parser.fail("AddNode - CloseParen Fail, expected:\n" + Parser.CLOSEPAREN.toString(), s);
		}
		return this;
	}
	
	public String toString() {
		return String.format("add(%s, %s)", node1.toString(), node2.toString());
	}

}
