import java.util.Scanner;

public class ACTNode implements RobotProgramNode{
	
	private RobotProgramNode node = null;

	@Override
	public void execute(Robot robot) {
		node.execute(robot);		
	}

	@Override
	public RobotProgramNode parse(Scanner s) {
		if (s.hasNext(Parser.MOVE)) {
			node = new MoveNode();
		} 
		else if (s.hasNext(Parser.TAKEFUEL)) {
			node = new TakeFuelNode();
		} 
		else if (s.hasNext(Parser.TURNL)) {
			node = new TurnLNode();
		} 
		else if (s.hasNext(Parser.TURNR)) {
			node = new TurnRNode();
		} 
		else if (s.hasNext(Parser.WAIT)) {
			node = new WaitNode();
		} 
		else if (s.hasNext(Parser.TURNAROUND)) {
			node = new TurnANode();
		}
		else if (s.hasNext(Parser.SHIELDON)) {
			node = new ShieldOnNode();
		} 
		else if (s.hasNext(Parser.SHIELDOFF)) {
			node = new ShieldOffNode();
		}
		else{
			Parser.fail("ACTNode Fail at", s);
		}	
		
		node.parse(s);
		
		if (!Parser.checkFor(Parser.SEMICOL, s)) {
			Parser.fail("ACTNode - SemiCol Fail, expected:\n", s);
		}
			
		return node;
	}
	
	public String toString(){
		return (node.toString());
	}

}
