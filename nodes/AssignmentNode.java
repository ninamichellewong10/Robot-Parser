import java.util.Scanner;

public class AssignmentNode implements RobotProgramNode{
	
    private String variableName = "";
    private ExpressionNode expression = null;
    
	@Override
	public void execute(Robot robot) {
		ExpressionNode.variables.put(this.variableName, this.expression.evaluate(robot));	
	}

	@Override
	public RobotProgramNode parse(Scanner s) {
		if (s.hasNext(Parser.VARIABLE)) {
			variableName = s.next();
		}

		if(s.hasNext("=")) {
			s.next();
		    expression = new ExpressionNode();
		    expression.parse(s);
		}
		
		if(s.hasNext(";")) {
			s.next();
		}
		
		return this;
	}
	
	public void setExpression(ExpressionNode expression){
		this.expression = expression;
	}
	
	public void setName(String name){
		this.variableName = name;
	}
	
    public String toString() {
    	return variableName.toString() + " = "+ expression.toString();
    }
}