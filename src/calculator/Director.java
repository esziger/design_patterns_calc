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

		for (String token : expression.split("(\\s|,)")) {
			if  (token.equals("+")) {
				IExpression left = expressionStack.pop();
				IExpression right = expressionStack.pop();

				expressionStack.push(builder.addExpression(left, right));
				nodeStack.push(new ConcreteNode(builder.addExpression(left, right)));
			}
			else if (token.equals("-")) {
				// it's necessary remove first the right operand from the stack
				IExpression right = expressionStack.pop();
				IExpression left = expressionStack.pop();
				expressionStack.push(builder.subtractExpression(left, right));
				nodeStack.push(new ConcreteNode(builder.subtractExpression(left, right)));
			}
			else if(token.equals("*")){
				IExpression left = expressionStack.pop();
				IExpression right = expressionStack.pop();
				expressionStack.push(builder.multiplyExpression(left,right));    	
				nodeStack.push(new ConcreteNode(builder.multiplyExpression(left, right)));
			}
			else if(token.equals("\\")){
				IExpression right = expressionStack.pop();
				IExpression left  = expressionStack.pop();
				expressionStack.push(builder.divideExpression(left, right));
				nodeStack.push(new ConcreteNode(builder.divideExpression(left, right)));
			}
			else if(token.equals("^")){
				IExpression right = expressionStack.pop();
				IExpression left  = expressionStack.pop();
				expressionStack.push(builder.powerExpression(left, right));
				nodeStack.push(new ConcreteNode(builder.powerExpression(left, right)));
			}
			else if(token.equals("1/^")){
				IExpression right = expressionStack.pop();
				IExpression left  = expressionStack.pop();
				expressionStack.push(builder.sqrtExpression(left, right));
				nodeStack.push(new ConcreteNode(builder.sqrtExpression(left, right)));
			}
			else
			{
				expressionStack.push(builder.numExpression(Integer.parseInt(token)));
				nodeStack.push(new ConcreteNode(builder.numExpression(Integer.parseInt(token))));
			}
		}
		syntaxTree = expressionStack.pop();
		return syntaxTree;
	}
}
