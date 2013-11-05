package calculator;

//This is one of the concrete command in the Command pattern 
public class UndoCommand implements Command{

	RedoUndoActor receiver;
	
	public UndoCommand(RedoUndoActor rec){
		receiver=rec;
	}
	
	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		receiver.Undo();
	}

}
