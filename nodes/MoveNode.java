import java.util.Scanner;

public class MoveNode implements RobotProgramNode{
	
	private ExpressionNode nodeExp = null;
	private OperationNode nodeOperate = null;
	
	@Override
	public void execute(Robot robot) {
		robot.move();	
	}

	@Override
	public RobotProgramNode parse(Scanner s) {
		if (!Parser.checkFor(Parser.MOVE, s)) {
			Parser.fail("MoveNode Fail, expected:\n" + Parser.MOVE.toString(), s);
		}
		
		if (s.hasNext(Parser.OPENPAREN)) {
			Parser.checkFor(Parser.OPENPAREN, s); 
		}
		
		if (s.hasNext(Parser.NUMPAT) || s.hasNext(Parser.SENSOR)) {
			nodeExp = new ExpressionNode();
			nodeExp.parse(s);
		}
		else if (s.hasNext(Parser.OPERATION)) {
			nodeOperate = new OperationNode();
			nodeOperate.parse(s);
		}
		
		if (s.hasNext(Parser.CLOSEPAREN)) {
			Parser.checkFor(Parser.CLOSEPAREN, s);
		}
		
		return this;
	}
	
	public String toString(){
		if (nodeExp != null) {
			return "move("+nodeExp+")";
		}
		else if (nodeOperate != null) {
			return "move("+nodeOperate+")";
		}
		else {
			return "move";
		}
	}

}
