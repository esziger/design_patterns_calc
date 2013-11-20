package calculator;

public class DivideExpression extends IExpression{

	public DivideExpression(IExpression left, IExpression right)
	{
		leftExpression = left;
		rightExpression = right;
	}

	public int Interpret()
	{
		return leftExpression.Interpret() / rightExpression.Interpret();
	}

	@Override
	public String getNodeValue() {
		return "\\";
	}

}
