package calculator;

public class AddExpression implements IExpression
{
	IExpression leftExpression;
    IExpression rightExpression;

	@Override
	public int Interpret() {
		// TODO Auto-generated method stub
		 return leftExpression.Interpret() + rightExpression.Interpret();
	}
	
    public AddExpression(IExpression left, IExpression right)
    {
        leftExpression = left;
        rightExpression = right;
    }
	
}