package calculator;

public class AddExpression extends IExpression
{
	
	@Override
	public int Interpret() {
		// TODO Auto-generated method stub
		return leftExpression.Interpret() + rightExpression.Interpret();
	}

	public AddExpression(IExpression left, IExpression right)
	{
		leftExpression = left;
		rightExpression = right;
		operator="+";
	}

	@Override
	public String getNodeValue() {
		return Integer.toString(this.Interpret());
	}

}