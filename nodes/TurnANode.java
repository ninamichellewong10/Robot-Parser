import java.util.Scanner;

public class TurnANode implements RobotProgramNode {

	@Override
	public void execute(Robot robot) {
		robot.turnAround();		
	}

	@Override
	public RobotProgramNode parse(Scanner s) {
		if (!Parser.checkFor(Parser.TURNAROUND, s)) {
			Parser.fail("TurnAroundNode Fail, expected:\n" + Parser.TURNAROUND.toString(), s);
		}
		return this;
	}
	
	public String toString() {
		return "turnAround";
	}

}
