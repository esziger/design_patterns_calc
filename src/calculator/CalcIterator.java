package calculator;

import java.util.Stack;

public interface CalcIterator {

	public boolean hasNext();
	
	public void next();
	
	public String currentItem();
	
	public void iteratePreOrder(IExpression expr, Stack<ConcreteNode> cNodeLabel);
	
	public void iterateInOrder(IExpression expr, Stack<ConcreteNode> cNodeLabel);
	
	public void iteratePostOrder(IExpression expr, Stack<ConcreteNode> cNodeLabel);
}
