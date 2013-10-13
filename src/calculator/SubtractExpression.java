package calculator;

//nonterminal expression, contains left and right expressions below it
public class SubtractExpression implements IExpression
{
  IExpression leftExpression;
  IExpression rightExpression;

  public SubtractExpression(IExpression left, IExpression right)
  {
      leftExpression = left;
      rightExpression = right;
  }

  public int Interpret()
  {
      return leftExpression.Interpret() - rightExpression.Interpret();
  }
}

//http://sourcemaking.com/design_patterns/builder/java/2