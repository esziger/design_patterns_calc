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
	}

	@Override
	/*public String getNodeValue() {
		// TODO Auto-generated method stub
		return "+";
	}*/
	public String getNodeValue() {
		//return "*";
		return Integer.toString(this.Interpret());
	}

}