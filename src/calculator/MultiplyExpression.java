package calculator;

public class MultiplyExpression extends IExpression{

	public MultiplyExpression(IExpression left, IExpression right)
	{
		leftExpression = left;
		rightExpression = right;
		operator="*";
	}

	public int Interpret()
	{
		return leftExpression.Interpret() * rightExpression.Interpret();
	}

	@Override
	public String getNodeValue() {
		return Integer.toString(this.Interpret());
	}
}
