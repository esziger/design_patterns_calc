package calculator;

public class DivideExpression implements IExpression{
	
	  IExpression leftExpression;
	  IExpression rightExpression;

	  public DivideExpression(IExpression left, IExpression right)
	  {
	      leftExpression = left;
	      rightExpression = right;
	  }

	  public int Interpret()
	  {
	      return leftExpression.Interpret() / rightExpression.Interpret();
	  }

}
