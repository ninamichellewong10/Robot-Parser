import java.util.Scanner;

public class NotNode implements RobotConditionNode{

	ConditionNode node = null;
	
	@Override
	public boolean evaluate(Robot robot) {
		return false;
	}

	@Override
	public RobotConditionNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.NOT, s)){
			Parser.fail("NotNode Fail, expected:\n"+Parser.NOT.toString(), s);
		}
		
		if (!Parser.checkFor(Parser.OPENPAREN, s)) {
			Parser.fail("NotNode - OpenParen Fail, expected:\n" + Parser.OPENPAREN.toString(), s);
		}

		node = new ConditionNode();
		node.parse(s);

		if (!Parser.checkFor(Parser.CLOSEPAREN, s)) {
			Parser.fail("NotNode - CloseParen Fail, expected:\n"+ Parser.CLOSEPAREN.toString(), s);
		}
		return this;
	}
	
	public String toString() {
		return "not("+node.toString()+")";
	}

}
