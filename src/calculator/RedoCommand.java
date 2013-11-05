package calculator;

//This is one of the concrete command in the Command pattern 
public class RedoCommand implements Command{

	RedoUndoActor receiver;
	
	public RedoCommand(RedoUndoActor rec){
		receiver=rec;
	}
	
	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		receiver.Redo();
	}

}
