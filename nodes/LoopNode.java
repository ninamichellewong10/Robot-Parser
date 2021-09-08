
import java.util.Scanner;


public class LoopNode implements RobotProgramNode {

	RobotProgramNode node = null;
	
	@Override
	public void execute(Robot robot) {
		while(true){
			node.execute(robot);
		}
	}

	@Override
	public RobotProgramNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.LOOP, s)){
			Parser.fail("LoopNode Fail, expected:\n"+Parser.LOOP.toString(), s);
		}	
		node = new BlockNode();
		node.parse(s);
		return node;
	}
		
	public String toString() {
		String s = node.toString();
		return String.format("loop %s",s);
	}

}
