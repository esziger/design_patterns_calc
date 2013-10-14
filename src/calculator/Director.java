package calculator;

import java.util.Stack;


//it contains the logic
public class Director {

	private IExpression syntaxTree;
	private IExpressionBuilder builder;

	public Director(IExpressionBuilder exprBuilder){
		builder=exprBuilder;
	}

	public IExpression evaluate(String expression, Stack<ConcreteNode> nodeStack){

		Stack<IExpression> expressionStack = new Stack<IExpression>();
		NodeFactory nodeF = new NodeFactory();

		for (String token : expression.split("(\\s|,)")) {
			if  (token.equals("+")) {
				IExpression left = expressionStack.pop();
				IExpression right = expressionStack.pop();

				expressionStack.push(builder.addExpression(left, right));
				//nodeStack.push(new ConcreteNode(builder.addExpression(left, right)));
				nodeStack.push(nodeF.getNode(builder.addExpression(left, right)));
			}
			else if (token.equals("-")) {
				// it's necessary remove first the right operand from the stack
				IExpression right = expressionStack.pop();
				IExpression left = expressionStack.pop();
				expressionStack.push(builder.subtractExpression(left, right));
				nodeStack.push(nodeF.getNode(builder.subtractExpression(left, right)));
			}
			else if(token.equals("*")){
				IExpression left = expressionStack.pop();
				IExpression right = expressionStack.pop();
				expressionStack.push(builder.multiplyExpression(left,right));    	
				nodeStack.push(nodeF.getNode(builder.multiplyExpression(left, right)));
			}
			else if(token.equals("\\")){
				IExpression right = expressionStack.pop();
				IExpression left  = expressionStack.pop();
				expressionStack.push(builder.divideExpression(left, right));
				nodeStack.push(nodeF.getNode(builder.divideExpression(left, right)));
			}
			else if(token.equals("^")){
				IExpression right = expressionStack.pop();
				IExpression left  = expressionStack.pop();
				expressionStack.push(builder.powerExpression(left, right));
				nodeStack.push(nodeF.getNode(builder.powerExpression(left, right)));
			}
			else if(token.equals("1/^")){
				IExpression right = expressionStack.pop();
				IExpression left  = expressionStack.pop();
				expressionStack.push(builder.sqrtExpression(left, right));
				nodeStack.push(nodeF.getNode(builder.sqrtExpression(left, right)));
			}
			else
			{
				expressionStack.push(builder.numExpression(Integer.parseInt(token)));
				nodeStack.push(nodeF.getNode(builder.numExpression(Integer.parseInt(token))));
			}
		}
		syntaxTree = expressionStack.pop();
		return syntaxTree;
	}
}
