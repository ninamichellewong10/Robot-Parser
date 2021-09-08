import java.util.Scanner;

public class ShieldOnNode implements RobotProgramNode {

	@Override
	public void execute(Robot robot) {
		robot.setShield(true);
	}

	@Override
	public RobotProgramNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.SHIELDON, s)){
			Parser.fail("ShieldOn Fail, expected:\n"+Parser.SHIELDON.toString(), s);
		}
		return this;
	}
	
	public String toString(){
		return "shieldOn;";
	}

}
