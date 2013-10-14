package calculator;

import java.awt.Color;

import javax.swing.JLabel;

public class ConcreteNode implements INode {

	private int value;
	private String operator=null;
	private boolean isNumber=false;
	
	public static int x=250;
	public static int y=250;
	
	public ConcreteNode(IExpression exp){
		
		value=exp.Interpret();
		
		if(exp.getClass()==NumberExpression.class){
			isNumber=true;
		}
		else if(exp.getClass()==MultiplyExpression.class){
			operator="*";
		}
		else if(exp.getClass()==DivideExpression.class){
			operator="\\";
		}
		else if(exp.getClass()==SqrtExpression.class){
			operator="1/^";
		}
		else if(exp.getClass()==PowerExpression.class){
			operator="^";
		}
		else if(exp.getClass()==AddExpression.class){
			operator="+";
		}
		else if(exp.getClass()==SubtractExpression.class){
			operator="-";
		}
	}
	
	@Override
	public JLabel drawNode(ImageContext image) {
		// TODO Auto-generated method stub
		JLabel lbl = null;
		if(isNumber){
			x=x+40;
			lbl = new JLabel(Integer.toString(value),image.getNumIcon(),JLabel.CENTER);
			lbl.setForeground(Color.BLACK);
			lbl.setBounds(x, y, 82, 52);
			lbl.setVerticalTextPosition(JLabel.CENTER);
			lbl.setHorizontalTextPosition(JLabel.CENTER);
		}
		else{
			x=x-20;
			y=y-35;
			lbl = new JLabel("("+operator+")" + " " + Integer.toString(value),image.getExpIcon(),JLabel.CENTER);
			lbl.setForeground(Color.BLACK);
			lbl.setBounds(x, y, 82, 52);
			lbl.setVerticalTextPosition(JLabel.CENTER);
			lbl.setHorizontalTextPosition(JLabel.CENTER);
		}
		return lbl;
	}
	
	public static void reSetXY(){
		x=250;
		y=250;
	}

}
