package calculator;

public interface IExpressionBuilder {
	 
	 public abstract IExpression numExpression(int num);
	 public abstract IExpression addExpression(IExpression left,IExpression right);
	 public abstract IExpression subtractExpression(IExpression left,IExpression right);
	 public abstract IExpression multiplyExpression(IExpression left,IExpression right);
	 public abstract IExpression divideExpression(IExpression left,IExpression right);
	 public abstract IExpression powerExpression(IExpression left,IExpression right);
	 public abstract IExpression sqrtExpression(IExpression left,IExpression right);
}
