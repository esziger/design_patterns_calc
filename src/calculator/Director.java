package calculator;

import java.util.Stack;


//it contains the logic
public class Director {
	
	private IExpression syntaxTree;
	private IExpressionBuilder builder;
	
	public Director(IExpressionBuilder exprBuilder){
		builder=exprBuilder;
	}
	
	public IExpression evaluate(String expression){
		Stack<IExpression> expressionStack = new Stack<IExpression>();
		
		for (String token : expression.split("(\\s|,)")) {
            if  (token.equals("+")) {
                expressionStack.push(builder.addExpression(expressionStack.pop(), expressionStack.pop()));
            }
            else if (token.equals("-")) {
                // it's necessary remove first the right operand from the stack
                IExpression right = expressionStack.pop();
                IExpression left = expressionStack.pop();
                expressionStack.push(builder.subtractExpression(left, right));
            }
            else if(token.equals("*")){
                expressionStack.push(builder.multiplyExpression(expressionStack.pop(), expressionStack.pop()));    	
            }
            else if(token.equals("\\")){
            	IExpression right = expressionStack.pop();
            	IExpression left  = expressionStack.pop();
                expressionStack.push(builder.divideExpression(left, right));
            }
            else if(token.equals("^")){
            	IExpression right = expressionStack.pop();
            	IExpression left  = expressionStack.pop();
	            expressionStack.push(builder.powerExpression(left, right));
           	
            }
             else if(token.equals("1/^")){
           		IExpression right = expressionStack.pop();
           		IExpression left  = expressionStack.pop();
                expressionStack.push(builder.sqrtExpression(left, right));
           	
            }
             else                        
                expressionStack.push(builder.numExpression(Integer.parseInt(token)));
        }
        syntaxTree = expressionStack.pop();
		return syntaxTree;
	}
}
