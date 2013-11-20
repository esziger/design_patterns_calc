package calculator;

import java.lang.Math;

public class PowerExpression extends IExpression{

	public PowerExpression(IExpression left, IExpression right)
	{
		leftExpression = left;
		rightExpression = right;
		operator="^";
	}

	public int Interpret()
	{
		return (int) Math.pow(leftExpression.Interpret(),rightExpression.Interpret());
	}
	
	public String getNodeValue() {
		return Integer.toString(this.Interpret());
	}
}
