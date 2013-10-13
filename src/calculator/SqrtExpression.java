package calculator;

import java.lang.Math;

public class SqrtExpression implements IExpression{
	  IExpression leftExpression;
	  IExpression rightExpression;

	  public SqrtExpression(IExpression left, IExpression right)
	  {
	      leftExpression = left;
	      rightExpression = right;
	  }

	  public int Interpret()
	  {
	      return (int) Math.pow(leftExpression.Interpret(),1.0/ rightExpression.Interpret());
	  }
}
