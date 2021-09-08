import java.util.Scanner;

public class NumberNode implements RobotExpressionNode {
	
	private int number = 0;
	
	@Override
	public int evaluate(Robot robot) {
		return number;
	}

	@Override
	public RobotExpressionNode parse(Scanner s) {
		number = Parser.requireInt(Parser.NUMPAT, "NUMNode Fail, not a number.", s);
        return this;
	}
	
	public String toString() {
		return Integer.toString(number);
	}

}
