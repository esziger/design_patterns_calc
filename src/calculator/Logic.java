package calculator;

import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Logic {
	
	static private Logic instance =null;
	
	//private constructor
	private Logic(){}
	
	//creates instance if it was null
	static public Logic getInstance(){	
		if(instance==null)
			instance =new Logic();
		
		return instance;
	}
	
	public float add(float a, float b){
		return a+b;
	}
	
	public float substract(float a, float b){
		return b-a;
	}
	
	public float divide(float a, float b){
		return b/a;
	}
	
	public float multiply(float a, float b){
		return a*b;
	}
}
