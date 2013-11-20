package calculator;


import java.util.Stack;


public class ConcreteIterator implements CalcIterator{

	public ConcreteIterator(){
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public void next() {
	}

	@Override
	public String currentItem() {
		return null;
	}

	public void iteratePreOrder(IExpression expr, Stack<ConcreteNode> cNodeLabel){
		if(expr == null) return;

		System.out.print(expr.getNodeValue()+", ");
		
		for(final ConcreteNode cnode: cNodeLabel){
			if(cnode.getvalue().equals(expr.getNodeValue())){
				cnode.changeColor();
			}	
		}
		

		iteratePreOrder( expr.leftNode(), cNodeLabel );
		iteratePreOrder( expr.rightNode(), cNodeLabel ); 
	}

	@Override
	public void iterateInOrder(IExpression expr, Stack<ConcreteNode> cNodeLabel) {
		// TODO Auto-generated method stub
		if(expr == null) return;
		
		for(final ConcreteNode cnode: cNodeLabel){
			if(cnode.getvalue().equals(expr.getNodeValue())){
				cnode.changeColor();
			}	
		}
		
		iterateInOrder( expr.leftNode(), cNodeLabel );
		
		System.out.print(expr.getNodeValue()+", ");
		
		iterateInOrder( expr.rightNode(), cNodeLabel ); 

	}

	@Override
	public void iteratePostOrder(IExpression expr, Stack<ConcreteNode> cNodeLabel) {
		// TODO Auto-generated method stub
		if(expr == null) return;
		
		for(final ConcreteNode cnode: cNodeLabel){
			if(cnode.getvalue().equals(expr.getNodeValue())){
				cnode.changeColor();
			}	
		}
		
		iteratePostOrder( expr.leftNode(), cNodeLabel );
		iteratePostOrder( expr.rightNode(), cNodeLabel ); 
		
		System.out.print(expr.getNodeValue()+", ");	
	}

}
