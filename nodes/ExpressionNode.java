import java.util.HashMap;
import java.util.Scanner;

public class ExpressionNode implements RobotExpressionNode {
	
	private RobotExpressionNode node = null;
	public static HashMap<String, Integer> variables = new HashMap<String, Integer>(); 
	public static boolean var = false;

	@Override
	public int evaluate(Robot robot) {
		return node.evaluate(robot);
	}

	@Override
	public RobotExpressionNode parse(Scanner s) {
		if (s.hasNext(Parser.SENSOR)) {
			node = new SensorNode();
			node.parse(s);
		}
		else if (s.hasNext(Parser.NUMPAT)) { 
			node = new NumberNode(); 
			node.parse(s);
		}
		else if (s.hasNext(Parser.OPERATION)) {
			node = new OperationNode();
			node.parse(s);
		}
		else if (s.hasNext(Parser.VARIABLE)) {
		    String variableName = s.next();

		    if (variables.containsKey(variableName)) {
		    	node = new VariableNode(variableName);
		    	node.parse(s);
		    }
		    else {
		    	variables.put(variableName, 0);
		    	node = new VariableNode(variableName);
		    	node.parse(s);
		    }
		}
		else {
			Parser.fail("ExpressionNode Fail, : expected\n", s);
		}
		return node;
	}
	
	public String toString() {
		return node.toString();
	}

}
