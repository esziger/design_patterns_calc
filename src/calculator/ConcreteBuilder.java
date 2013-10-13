package calculator;

public class ConcreteBuilder implements IExpressionBuilder{

	IExpression expression;
	
	public ConcreteBuilder(){}
	
	@Override
	public IExpression numExpression(int num) {
		expression = new NumberExpression(num);
		return expression;
	}

	@Override
	public IExpression addExpression(IExpression left, IExpression right) {	
		expression= new AddExpression(left,right);
		return expression;
	}

	@Override
	public IExpression subtractExpression(IExpression left, IExpression right) {
		expression= new SubtractExpression(left,right);
		return expression;
	}

	@Override
	public IExpression multiplyExpression(IExpression left, IExpression right) {
		expression= new MultiplyExpression(left,right);
		return expression;
	}

	@Override
	public IExpression divideExpression(IExpression left, IExpression right) {
		expression= new DivideExpression(left,right);
		return expression;
	}

	@Override
	public IExpression powerExpression(IExpression left, IExpression right) {
		expression= new PowerExpression(left,right);
		return expression;
	}

	@Override
	public IExpression sqrtExpression(IExpression left, IExpression right) {
		expression= new SqrtExpression(left,right);
		return expression;
	}

}
