import java.util.Scanner;

public class OperationNode implements RobotExpressionNode{
	
	RobotExpressionNode node = null;

	@Override
	public int evaluate(Robot robot) {
		return node.evaluate(robot);
	}

	@Override
	public RobotExpressionNode parse(Scanner s) {
		if (s.hasNext(Parser.ADD)){
			node = new AddNode();
		} else if (s.hasNext(Parser.SUB)){
			node = new SubtractNode();
		} else if (s.hasNext(Parser.MUL)){
			node = new TimesNode();
		} else if (s.hasNext(Parser.DIV)){
			node = new DivideNode();
		} 
		node.parse(s);
		return node;
	}
	
	@Override
	public String toString() {
		return node.toString();
	}

}
