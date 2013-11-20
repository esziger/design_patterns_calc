package calculator;

import java.lang.Math;

public class SqrtExpression extends IExpression{

	public SqrtExpression(IExpression left, IExpression right)
	{
		leftExpression = left;
		rightExpression = right;
		operator="1/^";
	}

	public int Interpret()
	{
		return (int) Math.pow(leftExpression.Interpret(),1.0/ rightExpression.Interpret());
	}

	public String getNodeValue() {
		return Integer.toString(this.Interpret());
	}
}
