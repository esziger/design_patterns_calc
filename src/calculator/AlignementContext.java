package calculator;

public class AlignementContext {

	private AlignementStrategy strategy;
	
	public AlignementContext(){	}
	
	public void SetStrategy(AlignementStrategy strategy){
		this.strategy = strategy;
	}
	
	public void AligneLabels(IExpression expression, int x, int y) {
		strategy.AlignLabel(expression, x, y);
	}	
}
