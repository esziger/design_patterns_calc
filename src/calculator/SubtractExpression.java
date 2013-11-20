package calculator;

//nonterminal expression, contains left and right expressions below it
public class SubtractExpression extends IExpression
{
	public SubtractExpression(IExpression left, IExpression right)
	{
		leftExpression = left;
		rightExpression = right;
		operator="-";
	}

	public int Interpret()
	{
		return leftExpression.Interpret() - rightExpression.Interpret();
	}

	public String getNodeValue() {
		return Integer.toString(this.Interpret());
	}
}