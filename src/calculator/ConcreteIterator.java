package calculator;


public class ConcreteIterator implements CalcIterator{

	public ConcreteIterator(){}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public void next() {}

	@Override
	public String currentItem() {
		return null;
	}

	public void iteratePreOrder(IExpression expr){
		if(expr == null) return;

		System.out.print(expr.getNodeValue()+", ");
				
		expr.changeColor();
	
		iteratePreOrder( expr.getLeftNode());
		iteratePreOrder( expr.getRightNode()); 
	}

	@Override
	public void iterateInOrder(IExpression expr) {
		// TODO Auto-generated method stub
		if(expr == null) return;
			
		iterateInOrder( expr.getLeftNode());
		
		expr.changeColor();
		System.out.print(expr.getNodeValue()+", ");
		
		iterateInOrder( expr.getRightNode()); 

	}

	@Override
	public void iteratePostOrder(IExpression expr) {
		// TODO Auto-generated method stub
		if(expr == null) return;
		
		iteratePostOrder( expr.getLeftNode() );
		iteratePostOrder( expr.getRightNode() ); 
		
		expr.changeColor();
		System.out.print(expr.getNodeValue()+", ");	
	}
}
