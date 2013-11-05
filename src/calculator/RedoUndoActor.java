package calculator;


//This is the Actor in the Command pattern
public class RedoUndoActor {

	public MementoCareTaker mTaker;
	private String result=null;
	
	public RedoUndoActor(MementoCareTaker mCareT){
		mTaker=mCareT;
	}
	
	public void Undo(){
		result= mTaker.returnUndoState();
	}
	
	public void Redo(){		
		result= mTaker.returnRedoState();
	}
	
	public String getState(){
		return result;
	}
	
}
