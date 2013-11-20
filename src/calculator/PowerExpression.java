package calculator;

import java.lang.Math;

public class PowerExpression extends IExpression{

	public PowerExpression(IExpression left, IExpression right)
	{
		leftExpression = left;
		rightExpression = right;
	}

	public int Interpret()
	{
		return (int) Math.pow(leftExpression.Interpret(),rightExpression.Interpret());
	}

	@Override
	/*public String getNodeValue() {
		// TODO Auto-generated method stub
		return "^";
	}*/
	
	public String getNodeValue() {
		//return "*";
		return Integer.toString(this.Interpret());
	}
}
