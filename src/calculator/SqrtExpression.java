package calculator;

import java.lang.Math;

public class SqrtExpression extends IExpression{

	public SqrtExpression(IExpression left, IExpression right)
	{
		leftExpression = left;
		rightExpression = right;
	}

	public int Interpret()
	{
		return (int) Math.pow(leftExpression.Interpret(),1.0/ rightExpression.Interpret());
	}

	@Override
	/*public String getNodeValue() {
		return "1/^";
	}*/
	
	public String getNodeValue() {
		//return "*";
		return Integer.toString(this.Interpret());
	}
}
