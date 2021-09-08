import java.util.Scanner;

public class STMTNode implements RobotProgramNode{
	//stmt

	private RobotProgramNode node = null;
	
	@Override
	public void execute(Robot robot) {
		node.execute(robot);		
	}

	@Override
	public RobotProgramNode parse(Scanner s) {
		if (s.hasNext(Parser.ACTION)) {
			node = new ACTNode();
		} 
		else if (s.hasNext(Parser.LOOP)) {
			node = new LoopNode();
		} 
		else if (s.hasNext(Parser.IF)) {
			node = new IfNode();
		} 
		else if (s.hasNext(Parser.WHILE)) {
			node = new WhileNode();
		}
		else if (s.hasNext(Parser.VARIABLE)) {
			node = new AssignmentNode();
		}
		else {
			Parser.fail("STMTNode Fail, expected:\n", s);
		}
		node.parse(s);	
		return this;
	}
	
	public String toString(){
		return node.toString();
	}

}
