package calculator;

public class CalculatorMemento {
	private final String result;
	
	public CalculatorMemento(String input){
			result=input;
	}
	
	public String getSavedState(){
		return result;
	}
}
