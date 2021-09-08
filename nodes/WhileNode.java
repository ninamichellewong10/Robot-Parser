import java.util.Scanner;

public class WhileNode implements RobotProgramNode {
	public ConditionNode nodeC = null;
	public BlockNode nodeB = null;

	@Override
	public void execute(Robot robot) {
		while(true){
			if(nodeC.evaluate(robot)){
				nodeB.execute(robot);
			}
			else{
				return;
			}
		}
	}

	@Override
	public RobotProgramNode parse(Scanner s) {
		if (!Parser.checkFor(Parser.WHILE, s)) {
			Parser.fail("WhileNode Fail, expected:\n" + Parser.WHILE.toString(), s);
		}
		
		if (s.hasNext(Parser.OPENPAREN)) {
			Parser.checkFor(Parser.OPENPAREN, s);
			
			if (s.hasNext(Parser.CONDITION)) {
				nodeC = new ConditionNode();
				nodeC.parse(s);
			} else {
				Parser.fail("WhileNode - Condition Fail, expected:\n" + Parser.CONDITION, s);
			}

			if (s.hasNext(Parser.CLOSEPAREN)) {
				Parser.checkFor(Parser.CLOSEPAREN, s);
			}	
			
			nodeB = new BlockNode();
			nodeB.parse(s);
		}
		
		return this;
	}
	
	public String toString(){
		return "while(" + nodeC.toString() + ")" + nodeB.toString();
	}
}
