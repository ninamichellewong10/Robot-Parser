import java.util.ArrayList;
import java.util.Scanner;

public class BlockNode implements RobotProgramNode{

	public ArrayList<RobotProgramNode> blockNodes = new ArrayList<RobotProgramNode>();
	
	public void execute(Robot robot) {
		for(RobotProgramNode r : blockNodes){
			r.execute(robot);
		}
	}

	@Override
	public RobotProgramNode parse(Scanner s) {
		RobotProgramNode node = null;
		if(!Parser.checkFor(Parser.OPENBRACE, s)){
			Parser.fail("BlockNode - OpenBrace Fail, expected:\n"+Parser.OPENBRACE.toString(), s);
		}
		
		if(s.hasNext()){
			node = new STMTNode();
			node.parse(s);
			blockNodes.add(node);
		}
		
		while(!s.hasNext(Parser.CLOSEBRACE)){
			if(s.hasNext()){
				node = new STMTNode();
				node.parse(s);
				blockNodes.add(node);
			}
		}
		if (!Parser.checkFor(Parser.CLOSEBRACE, s)) {
			Parser.fail("BlockNode - CloseBrace Fail, expected:\n" + Parser.CLOSEBRACE.toString(), s);
		}
		
		return this;
	}
	
	public String toString() {
		String s = "{";
		for (RobotProgramNode r : blockNodes) {
			s += "" + r.toString();
		}
		return s + " }\n";
	}
}