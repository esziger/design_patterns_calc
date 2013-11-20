package calculator;


public abstract class IExpression
{
	//variables
	protected IExpression  leftExpression;
	protected IExpression  rightExpression;
	protected CalcIterator iterator = new ConcreteIterator();
	//protected CalcIterator iterator;
	
	//abstract functions 
    public abstract int Interpret();
    public abstract String getNodeValue();
    
    //none abstract functions
    public CalcIterator getIterator(){
    	return iterator;
    }
    
    public IExpression leftNode(){
    	return leftExpression;
	}
	  
	public IExpression rightNode(){
		return rightExpression;
	}
}