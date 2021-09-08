import java.util.Scanner;

public class TimesNode implements RobotExpressionNode{
	
	private ExpressionNode node1 = null;
	private ExpressionNode node2 = null;
	private int value1 = -1;
	private int value2 = -1;

	@Override
	public int evaluate(Robot robot) {
		value1 = node1.evaluate(robot);
		value2 = node2.evaluate(robot);
		return (value1 * value2);
	}

	@Override
	public RobotExpressionNode parse(Scanner s) {
		if (!Parser.checkFor(Parser.MUL, s)) {
			Parser.fail("Times Fail, expected:\n" + Parser.MUL.toString(), s);
		}

		if (!Parser.checkFor(Parser.OPENPAREN, s)) {
			Parser.fail("Times - OpenParen Fail, expected:\n" + Parser.OPENPAREN.toString(), s);
		}
	
		node1 = new ExpressionNode();
		node1.parse(s);
	
		if (!Parser.checkFor(Parser.COMMA, s)) {
			Parser.fail("Times - Comma Fail, expected:\n", s);
		}
	
		node2 = new ExpressionNode();
		node2.parse(s);
	
		if (!Parser.checkFor(Parser.CLOSEPAREN, s)) {
			Parser.fail("Times - CloseParen Fail, expected:\n" + Parser.CLOSEPAREN.toString(), s);
		}
		return this;
	}
	
	public String toString() {
		return String.format("mul (%s, %s)", node1.toString(), node2.toString());
	}

}
