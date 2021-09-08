import java.util.Scanner;

public class TurnRNode implements RobotProgramNode {
	
	@Override
	public void execute(Robot robot) {
		robot.turnRight();
	}

	@Override
	public RobotProgramNode parse(Scanner s) {
		if (!Parser.checkFor(Parser.TURNR, s)) {
			Parser.fail("TurnRNode Fail, expected:\n" + Parser.TURNR.toString(), s);
		}
		return this;
	}
	
	public String toString(){
		return "turnR";
	}

}