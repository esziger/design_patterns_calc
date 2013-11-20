package calculator;

import javax.swing.JLabel;

public class IExpressionProxy extends IExpression{

	private IExpression expression;
	
	//private static int variables for tracking refCount 
	private static int numRef, plusRef, minusRef, multiRef, divRef, sqrtRef, rootRef;
		
	private static String value = "Input variables: " + numRef + ", Additions: " + plusRef +", Substractions: " + minusRef + ", Muliplications: " + multiRef + ", Rivisions: " + divRef +", Roots: " + rootRef + ", Powers: " + sqrtRef;
		
	public IExpressionProxy(String operator){
		setValueToZero();
			
		switch(operator){	
			case "num": expression = new NumberExpression(5);
			break;
			case "+":	expression = new AddExpression(null, null);
			break;
			case "-": 	expression = new SubtractExpression(null, null);
			break;
			case "*": 	expression = new MultiplyExpression(null, null);
			break;
			case "\\": 	expression = new DivideExpression(null, null);
			break;
			case "1/^": expression = new SqrtExpression(null, null);
			break;
			case "^": 	expression = new PowerExpression(null, null);
			break;
		}
	}
	
	public IExpression clone()
	{
		expression = expression.clone();
		RefCount();		
		return expression;
	}
	
	//Count the reference based on operator
	public void RefCount(){
		switch(expression.getOperator()){	
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

	public void setLeftchild(IExpression exp){
		expression.setLeftNode(exp);
	}
	
	public void setRightchild(IExpression exp){
		expression.setRightNode(exp);
	}
	
	
	//gives back the Statistics label
	public static JLabel getStatisticsLabel() {
		JLabel lbl = new JLabel(value,JLabel.CENTER);
		lbl.setBounds(10, 350, 600, 52);
		lbl.setVerticalTextPosition(JLabel.CENTER);
		lbl.setHorizontalTextPosition(JLabel.CENTER);
		return lbl;	
	}

	public static String getValue(){
		value = "Input variables: " + numRef + ", Additions: " + plusRef +", Substractions: " + minusRef + ", Muliplications: " + multiRef + ", Rivisions: " + divRef +", Roots: " + rootRef + ", Powers: " + sqrtRef;
		//System.out.println(value);
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
	
	@Override
	public int Interpret() {
		return (Integer) null;
	}

	@Override
	public String getNodeValue() {
		return null;
	}

}
