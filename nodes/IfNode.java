
import java.util.ArrayList;
import java.util.Scanner;

public class IfNode implements RobotProgramNode {
	
	private ConditionNode condition = null;
	private RobotProgramNode action = null;
	private RobotProgramNode block = null;
	private RobotProgramNode elseNode = null;
	
	private ArrayList<RobotConditionNode> conditionNodes = new ArrayList<RobotConditionNode>();
	private ArrayList<RobotProgramNode> blockNodes = new ArrayList<RobotProgramNode>();

	@Override
	public void execute(Robot robot) {
		int size = conditionNodes.size();
		for(int i = 0; i <= conditionNodes.size(); i++){
			if(i == size){
				if(elseNode != null)
					elseNode.execute(robot);
				else {
					break;
				}
			}
			else if(conditionNodes.get(i).evaluate(robot)){
				blockNodes.get(i).execute(robot);
				break;
			}
		}
	}

	@Override
	public RobotProgramNode parse(Scanner s) {		
		if(!Parser.checkFor(Parser.IF, s)){
			Parser.fail("IfNode Fail, expected: "+Parser.IF.toString(), s);
		}
		
		if (!Parser.checkFor(Parser.OPENPAREN, s)) {
			Parser.fail("IfNode - OpenParen Fail, expected: " + Parser.OPENPAREN.toString(), s);
		}
		
		if (s.hasNext(Parser.ACTION)) {
			action = new ACTNode();
			action.parse(s);			
		}
		
		if (s.hasNext(Parser.CONDITION)) {
			condition = new ConditionNode();
			conditionNodes.add((condition).parse(s));
		}	
		
		if (s.hasNext(Parser.CLOSEPAREN)) {
			Parser.checkFor(Parser.CLOSEPAREN, s);
		}

		block = new BlockNode();
		blockNodes.add(block.parse(s));
		
		while(s.hasNext("elif")){
			if(!Parser.checkFor("elif", s)){ 
				Parser.fail("expected elif", s); 
			}
			
			if(!Parser.checkFor(Parser.OPENPAREN, s)){ 
				Parser.fail("expected ( after elif", s); 
			}
			
			if (s.hasNext(Parser.CONDITION)) {
				condition = new ConditionNode();
				conditionNodes.add((condition).parse(s));
			}	
			
			if(!Parser.checkFor(Parser.CLOSEPAREN, s)){ 
				Parser.fail("ElifNode Fail, expected: ", s); 
			}	
			
			block = new BlockNode();
			blockNodes.add(block.parse(s));
		}
			
		if (s.hasNext(Parser.ELSE)) {
			if (!Parser.checkFor(Parser.ELSE, s)) {
				Parser.fail("ElseNode Fail, expected: " + Parser.ELSE.toString(), s);
			}

			elseNode = new BlockNode();
			elseNode.parse(s);
		}		
	
		return this;
	}

	public String toString(){
		StringBuilder result = new StringBuilder();

		int n = conditionNodes.size();
		result.append("if(");
		result.append(conditionNodes.get(0).toString() + ")");
		result.append(blockNodes.get(0).toString());

		for(int i = 1; i < n; i++){
			result.append("elif(");
			result.append(conditionNodes.get(i).toString() + ")");
			result.append(blockNodes.get(i).toString());
		}

		if(elseNode!=null){
			result.append("else");
			result.append(elseNode.toString());
		}
		return result.toString();
	}

}
