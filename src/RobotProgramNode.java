import java.util.Scanner;

/**
 * Interface for all nodes that can be executed,
 * including the top level program node
 */

interface RobotProgramNode {
	public void execute(Robot robot);
	
	public RobotProgramNode parse(Scanner s);

	public String toString();
}
