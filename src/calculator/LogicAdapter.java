package calculator;

public class LogicAdapter {
	public Logic logic;
	
	public LogicAdapter(){
		logic=Logic.getInstance();
	}
	
	public String add(String a, String b){
		//return ((Float)logic.add(Float.parseFloat(a), Float.parseFloat(b))).toString();
		return logic.add(Float.parseFloat(a), Float.parseFloat(b)) + "";
	}
	
	public String substract(String a, String b){
		return logic.substract(Float.parseFloat(a), Float.parseFloat(b)) + "";
	}
	
	public String divide(String a, String b){
		return logic.divide(Float.parseFloat(a), Float.parseFloat(b)) + "";
	}
	
	public String multiply(String a, String b){
		return logic.multiply(Float.parseFloat(a), Float.parseFloat(b)) + "";
	}
	

}
