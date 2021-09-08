import java.util.Scanner;

public class TakeFuelNode implements RobotProgramNode{
	
	RobotProgramNode node = null;
	
	@Override
	public void execute(Robot robot) {
		robot.takeFuel();	
	}

	@Override
	public RobotProgramNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.TAKEFUEL, s)){			
			Parser.fail("TakeFuelNode Fail, expected:\n"+Parser.TAKEFUEL.toString(), s);
		}
		return this;
	}
	
	public String toString(){
		return "takeFuel";
	}

}
