package calculator;

import java.util.Stack;

//Stores the Mementos
public class MementoCareTaker {

	Stack<CalculatorMemento> mementos = new Stack<CalculatorMemento>(); //Stack for storeing states
	
	Stack<CalculatorMemento> redoMementos = new Stack<CalculatorMemento>();	
	
	public void saveState(String state){
		calculatorOriginator orig = new calculatorOriginator();
		orig.SetState(state);
		mementos.push(orig.save());
	}
	
	public String returnUndoState(){
		if(!mementos.isEmpty()){
			CalculatorMemento calcM = mementos.pop();
			redoMementos.push(calcM);
			calcM = mementos.pop();
			String result=calcM.getSavedState();
			redoMementos.push(calcM);
			return result;
		}
		else{
			return null;
		}		
	}
	
	public String returnRedoState(){
		if(!redoMementos.isEmpty()){
			CalculatorMemento calcM = redoMementos.pop();
			mementos.push(calcM);
			calcM = redoMementos.pop();	//not necessary, this is a workaround
			
			String result=calcM.getSavedState();
			mementos.push(calcM);		//not necessary, this is a workaround
			return result;
		}
		else{
			return null;
		}
	}	
}
