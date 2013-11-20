package calculator;

//nonterminal expression, contains left and right expressions below it
public class SubtractExpression extends IExpression
{
	public SubtractExpression(IExpression left, IExpression right)
	{
		leftExpression = left;
		rightExpression = right;
	}

	public int Interpret()
	{
		return leftExpression.Interpret() - rightExpression.Interpret();
	}

	@Override
	/*public String getNodeValue() {
		return "-";
	}*/
	
	public String getNodeValue() {
		//return "*";
		return Integer.toString(this.Interpret());
	}
}

//http://sourcemaking.com/design_patterns/builder/java/2