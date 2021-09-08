import java.util.Scanner;

public class ConditionNode implements RobotConditionNode{
	private RobotConditionNode node = null;
	
	public boolean evaluate(Robot robot) {
		return node.evaluate(robot);
	}

	@Override
	public RobotConditionNode parse(Scanner s) {
		if (s.hasNext(Parser.GREATERTHAN)) {
			node = new GreaterThanNode();
			node.parse(s);
		} 
		else if (s.hasNext(Parser.LESSTHAN)) {
			node = new LessThanNode();
			node.parse(s);
		} 
		else if (s.hasNext(Parser.EQUAL)) {
			node = new EqualToNode();
			node.parse(s);
		}
		else if (s.hasNext(Parser.AND)) {
			node = new AndNode();
			node.parse(s);
		}
		else if (s.hasNext(Parser.NOT)) {
			node = new NotNode();
			node.parse(s);
		}
		else if (s.hasNext(Parser.OR)) {
			node = new OrNode();
			node.parse(s);
		}
		return node;
	}
	
	public String toString(){
		return node.toString();
	}
}
