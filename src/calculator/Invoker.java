package calculator;

public class Invoker {

	private Command command;
	
	public void SetCommand(Command commander){
		command=commander;
	}
	
	public void execute(){
		command.Execute();
	}
}
