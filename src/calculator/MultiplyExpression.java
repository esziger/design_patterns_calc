package calculator;

public class MultiplyExpression implements IExpression{
	  IExpression leftExpression;
	  IExpression rightExpression;

	  public MultiplyExpression(IExpression left, IExpression right)
	  {
	      leftExpression = left;
	      rightExpression = right;
	  }

	  public int Interpret()
	  {
	      return leftExpression.Interpret() * rightExpression.Interpret();
	  }
}
