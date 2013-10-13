package calculator;

public class NumberExpression implements IExpression{

	int number;
	
	public NumberExpression(int i)
    {
        number = i;
    }
	
	@Override
	public int Interpret() {
		return number;
	}

}
