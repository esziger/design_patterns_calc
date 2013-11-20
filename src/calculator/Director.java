package calculator;

import java.util.Stack;


//it contains the logic
public class Director {

	private IExpression syntaxTree;

	public Director(){}

	public IExpression evaluate(String expression){

		Stack<IExpression> expressionStack = new Stack<IExpression>();
		NodeFactory nodeF = new NodeFactory();
		IExpression expr;

		for (String token : expression.split("(\\s|,)")) {
			if  (token.equals("+")) {
				IExpression right = expressionStack.pop();
				IExpression left = expressionStack.pop();
				
				expr = nodeF.getNode("+");
				expr.setLeftNode(left);
				expr.setRightNode(right);
				expressionStack.push(expr);		
			}
			else if (token.equals("-")) {
				// it's necessary remove first the right operand from the stack
				IExpression right = expressionStack.pop();
				IExpression left = expressionStack.pop();
				
				expr = nodeF.getNode("-");
				expr.setLeftNode(left);
				expr.setRightNode(right);
				
				expressionStack.push(expr);
			}
			else if(token.equals("*")){
				IExpression right = expressionStack.pop();
				IExpression left = expressionStack.pop();
				
				expr = nodeF.getNode("*");
				expr.setLeftNode(left);
				expr.setRightNode(right);
				
				expressionStack.push(expr);
			}
			else if(token.equals("\\")){
				IExpression right = expressionStack.pop();
				IExpression left  = expressionStack.pop();
				
				expr = nodeF.getNode("\\");
				expr.setLeftNode(left);
				expr.setRightNode(right);
				
				expressionStack.push(expr);
			}
			else if(token.equals("^")){
				IExpression right = expressionStack.pop();
				IExpression left  = expressionStack.pop();
				
				expr = nodeF.getNode("^");
				expr.setLeftNode(left);
				expr.setRightNode(right);
				
				expressionStack.push(expr);
			}
			else if(token.equals("1/^")){
				IExpression right = expressionStack.pop();
				IExpression left  = expressionStack.pop();
				
				expr = nodeF.getNode("1/^");
				expr.setLeftNode(left);
				expr.setRightNode(right);
				
				expressionStack.push(expr);
			}
			else
			{
				expr = nodeF.getNode("num");
				expr.setValue(Integer.parseInt(token));
				expressionStack.push(expr);			
			}
		}
		syntaxTree = expressionStack.pop();
		return syntaxTree;
	}
}
