package calculator;

import java.util.Stack;


//it contains the logic
public class Director {

	private IExpression syntaxTree;
	private IExpressionBuilder builder;

	public Director(IExpressionBuilder exprBuilder){
		builder=exprBuilder;
	}

	public IExpression evaluate(String expression, Stack<ConcreteNode> nodeLabelStack){

		Stack<IExpression> expressionStack = new Stack<IExpression>();
		NodeFactory nodeF = new NodeFactory();
		ConcreteNode nodeLabel;
		IExpression expr;

		for (String token : expression.split("(\\s|,)")) {
			if  (token.equals("+")) {
				IExpression right = expressionStack.pop();
				IExpression left = expressionStack.pop();
				
				expr = builder.addExpression(left, right);
				
				expressionStack.push(expr);
				
				nodeLabel=nodeF.getNode("+");
				nodeLabel.setvalue(expr.Interpret());
				nodeLabelStack.push(nodeLabel);			
			}
			else if (token.equals("-")) {
				// it's necessary remove first the right operand from the stack
				IExpression right = expressionStack.pop();
				IExpression left = expressionStack.pop();
				
				expr = builder.subtractExpression(left, right);
				
				expressionStack.push(expr);
				
				nodeLabel=nodeF.getNode("-");
				nodeLabel.setvalue(expr.Interpret());
				nodeLabelStack.push(nodeLabel);		
			}
			else if(token.equals("*")){
				IExpression right = expressionStack.pop();
				IExpression left = expressionStack.pop();
				
				expr = builder.multiplyExpression(left,right);
				
				expressionStack.push(expr);
				
				nodeLabel=nodeF.getNode("*");
				nodeLabel.setvalue(expr.Interpret());
				nodeLabelStack.push(nodeLabel);			
			}
			else if(token.equals("\\")){
				IExpression right = expressionStack.pop();
				IExpression left  = expressionStack.pop();
				
				expr = builder.divideExpression(left, right);
				
				expressionStack.push(expr);

				nodeLabel=nodeF.getNode("\\");
				nodeLabel.setvalue(expr.Interpret());
				nodeLabelStack.push(nodeLabel);
			}
			else if(token.equals("^")){
				IExpression right = expressionStack.pop();
				IExpression left  = expressionStack.pop();
				
				expr = builder.powerExpression(left, right);
				
				expressionStack.push(expr);
				
				nodeLabel=nodeF.getNode("^");
				nodeLabel.setvalue(expr.Interpret());
				nodeLabelStack.push(nodeLabel);
			}
			else if(token.equals("1/^")){
				IExpression right = expressionStack.pop();
				IExpression left  = expressionStack.pop();
				
				expr = builder.sqrtExpression(left, right);
				expressionStack.push(expr);

				nodeLabel=nodeF.getNode("1/^");
				nodeLabel.setvalue(expr.Interpret());
				nodeLabelStack.push(nodeLabel);
			}
			else
			{
				expr = builder.numExpression(Integer.parseInt(token));
				expressionStack.push(expr);			
				nodeLabel=nodeF.getNode("num");
				nodeLabel.setvalue(expr.Interpret());
				nodeLabelStack.push(nodeLabel);
			}
		}
		syntaxTree = expressionStack.pop();
		return syntaxTree;
	}
}
