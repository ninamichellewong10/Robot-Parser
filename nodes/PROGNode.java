import java.util.ArrayList;
import java.util.Scanner;

public class PROGNode implements RobotProgramNode{	
	private ArrayList<RobotProgramNode> statements = new ArrayList<RobotProgramNode>();

	@Override
	public void execute(Robot robot) {
		for(RobotProgramNode r : statements){
			r.execute(robot);
		}		
	}

	@Override
	public RobotProgramNode parse(Scanner s) {
		STMTNode ns = null;
		while(s.hasNext()){
			ns = new STMTNode();
			statements.add(ns.parse(s));
		}
		return this;
	}
	
	public String toString(){
		String result = "";
		for (RobotProgramNode r : statements){
			result += r.toString()+";\n";
		}
		return result;
	}

}
