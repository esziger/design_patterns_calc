package calculator;

public class NumberExpression extends IExpression{

	private int number;
	
	public NumberExpression(int i)
    {
        number = i;
    }
	
	@Override
	public int Interpret() {
		return number;
	}

	@Override
	public String getNodeValue() {
		return Integer.toString(number);
	}
	
	@Override
	public IExpression leftNode(){
    	return null;
	}
	
	@Override
	public IExpression rightNode(){
		return null;
	}
}
