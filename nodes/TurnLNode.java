

import java.util.Scanner;


public class TurnLNode implements RobotProgramNode {
	
	@Override
	public void execute(Robot robot) {
		robot.turnLeft();
	}
	
	@Override
	public RobotProgramNode parse(Scanner s) {
		if (!Parser.checkFor(Parser.TURNL, s)) {
			Parser.fail("TurnLNode Fail, expected:\n" + Parser.TURNL.toString(), s);
		}
		return this;
	}
	
	public String toString(){
		return "turnL";
	}

}
