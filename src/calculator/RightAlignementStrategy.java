package calculator;

public class RightAlignementStrategy implements AlignementStrategy{

	@Override
	public void AlignLabel(IExpression expression, int x, int y) {
		// TODO Auto-generated method stub
		if (expression==null){return;}
		
		expression.setLabel(x, y);

		AlignLabel(expression.getLeftNode(), x-40, y+40);

		AlignLabel(expression.getRightNode(), x, y+40);
	}
}
