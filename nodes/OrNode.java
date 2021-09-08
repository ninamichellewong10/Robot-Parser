import java.util.Scanner;

public class OrNode implements RobotConditionNode{
	
    ConditionNode nodeA;
    ConditionNode nodeB;
    
	@Override
	public boolean evaluate(Robot robot) {
		return (nodeA.evaluate(robot) || nodeB.evaluate(robot));
	}

	@Override
	public RobotConditionNode parse(Scanner s) {
		if(!Parser.checkFor(Parser.OR, s)){
			Parser.fail("ORNode Fail, expected\n: "+Parser.OR.toString(), s);
		}

		if (!Parser.checkFor(Parser.OPENPAREN, s)) {
			Parser.fail("ORNode - OpenParen Fail, expected:\n" + Parser.OPENPAREN.toString(), s);
		}
		
		nodeA = new ConditionNode();
		nodeA.parse(s);
		
		if (s.hasNext(Parser.CLOSEPAREN)) {
			Parser.checkFor(Parser.CLOSEPAREN, s);
		}
		
		if (s.hasNext(Parser.COMMA)) {
			Parser.checkFor(Parser.COMMA, s);
		}

		nodeB = new ConditionNode();
		nodeB.parse(s);
		
		if (!Parser.checkFor(Parser.CLOSEPAREN, s)) {
			Parser.fail("ORNode - CloseParen Fail, expected:\n" + Parser.CLOSEPAREN.toString(), s);
		}

		return this;

	}
	
    public String toString() {
    	return nodeA.toString() + " or " + nodeB.toString();
    }	
}
