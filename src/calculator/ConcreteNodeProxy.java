package calculator;

import javax.swing.JLabel;


public class ConcreteNodeProxy extends ConcreteNode{
	
	private ConcreteNode cNode;
	
	//private static int variables for tracking refCount 
	private static int numRef, plusRef, minusRef, multiRef, divRef, sqrtRef, rootRef;
	
	private static String value = "Input variables: " + numRef + ", Additions: " + plusRef +", Substractions: " + minusRef + ", Muliplications: " + multiRef + ", Rivisions: " + divRef +", Roots: " + rootRef + ", Powers: " + sqrtRef;
	
	public ConcreteNodeProxy(){
		setValueToZero();
		cNode = new ConcreteNode();
	}
	
	public ConcreteNode clone()
	{
		cNode = cNode.clone();
		RefCount();		
		return cNode;
	}
	 
	public void setvalue(int interpretValue) {
		cNode.setvalue(interpretValue);
	}
		
	public void setOperator(String op){
		cNode.setOperator(op);
	}
		
	public void setNum(){
		cNode.setNum();
	}
	
	//Count the reference based on operator
	public void RefCount(){
		switch(cNode.getOperator()){	
		case "num": numRef=numRef+1;
					break;
		case "+":	plusRef=plusRef+1;
					break;
		case "-": 	minusRef=minusRef+1;
					break;
		case "*": 	multiRef=multiRef+1;
					break;
		case "\\": 	divRef=divRef+1;
					break;
		case "1/^": rootRef=rootRef+1;
					break;
		case "^": 	sqrtRef=sqrtRef+1;
					break;
		}
	}
	
	//gives back the Statistics label
	public static JLabel getStatisticsLabel() {
		JLabel lbl = new JLabel(value,JLabel.CENTER);
		lbl.setBounds(10, 300, 600, 52);
		lbl.setVerticalTextPosition(JLabel.CENTER);
		lbl.setHorizontalTextPosition(JLabel.CENTER);
		return lbl;	
	}
	
	public static String getValue(){
		value = "Input variables: " + numRef + ", Additions: " + plusRef +", Substractions: " + minusRef + ", Muliplications: " + multiRef + ", Rivisions: " + divRef +", Roots: " + rootRef + ", Powers: " + sqrtRef;
		return value;
	}

	public static void setValueToZero() {
		numRef=0;
		plusRef=0;
		minusRef=0;
		multiRef=0;
		divRef=0;
		sqrtRef=0;
		rootRef=0;	
	}
}
