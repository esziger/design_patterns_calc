package calculator;

public interface CalcIterator {

	public boolean hasNext();
	
	public void next();
	
	public String currentItem();
	
	public void iteratePreOrder(IExpression expr);
	
	public void iterateInOrder(IExpression expr);
	
	public void iteratePostOrder(IExpression expr);
}
