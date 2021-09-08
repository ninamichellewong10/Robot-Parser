import java.util.Scanner;

public class VariableNode implements RobotExpressionNode{
	
    private String name = "";
    private ExpressionNode expression = null;
    
    public VariableNode(String name){
    	this.name = name;
    }

	@Override
	public int evaluate(Robot robot) {
		return expression.evaluate(robot);
	}

	@Override
	public RobotExpressionNode parse(Scanner s) {
	    String variableName = s.next();

	    if (ExpressionNode.variables.containsKey(variableName)) {
	    	return new VariableNode(variableName);	
	    }

	    if (ExpressionNode.var) {
	    	Parser.fail("Variable Node Fail - variable not declared before use, expected: \n", s);
	    } else {
	    	ExpressionNode.variables.put(variableName, 0);
	    	return new VariableNode(variableName);
	    }
	    
	    return this;
	}
	
    public String toString() {
    	return this.name;
    }
}
