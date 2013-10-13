package calculator;

import java.lang.Math;

public class PowerExpression implements IExpression{
	  IExpression leftExpression;
	  IExpression rightExpression;

	  public PowerExpression(IExpression left, IExpression right)
	  {
	      leftExpression = left;
	      rightExpression = right;
	  }

	  public int Interpret()
	  {
	      return (int) Math.pow(leftExpression.Interpret(),rightExpression.Interpret());
	  }
}
