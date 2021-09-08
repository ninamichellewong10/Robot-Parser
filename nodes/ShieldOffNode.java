import java.util.Scanner;

public class ShieldOffNode implements RobotProgramNode {

	@Override
	public void execute(Robot robot) {
		robot.setShield(false);
		
	}

	@Override
	public RobotProgramNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.SHIELDOFF, s)){
			Parser.fail("ShieldOffNode Fail, expected:\n"+Parser.SHIELDOFF.toString(), s);
		}
		return this;
	}
	
	public String toString(){
		return "shieldOff";
	}
	
	

}
