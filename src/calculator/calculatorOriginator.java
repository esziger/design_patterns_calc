package calculator;

public class calculatorOriginator {

	private String result;
	
	public void SetState(String input){
			result=input;
	}
	
	public CalculatorMemento save(){
		return new CalculatorMemento(result);	
	}
	
	public void restoreToState(CalculatorMemento calcM){	
		result=calcM.getSavedState();
	}
}
