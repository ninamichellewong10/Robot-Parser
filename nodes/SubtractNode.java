import java.util.Scanner;

public class SubtractNode implements RobotExpressionNode{
	
	private ExpressionNode node1 = null;
	private ExpressionNode node2 = null;
	private int value1 = -1;
	private int value2 = -1;

	@Override
	public int evaluate(Robot robot) {
		value1 = node1.evaluate(robot);
		value2 = node2.evaluate(robot);
		return (value1 - value2);
	}

	@Override
	public RobotExpressionNode parse(Scanner s) {
		if (!Parser.checkFor(Parser.SUB, s)) {
			Parser.fail("SubtractNode Fail, expected:\n" + Parser.SUB.toString(), s);
		}

		if (!Parser.checkFor(Parser.OPENPAREN, s)) {
			Parser.fail("SubtractNode - OpenParen Fail, expected:\n" + Parser.OPENPAREN.toString(), s);
		}
	
		node1 = new ExpressionNode();
		node1.parse(s);
	
		if (!Parser.checkFor(Parser.COMMA, s)) {
			Parser.fail("SubtractNode - Comma Fail, expected:\n", s);
		}
	
		node2 = new ExpressionNode();
		node2.parse(s);
	
		if (!Parser.checkFor(Parser.CLOSEPAREN, s)) {
			Parser.fail("SubtractNode - CloseParen Fail, expected:\n" + Parser.CLOSEPAREN.toString(), s);
		}
		return this;
	}
	
	public String toString() {
		return String.format("sub (%s, %s)", node1.toString(), node2.toString());
	}

}
