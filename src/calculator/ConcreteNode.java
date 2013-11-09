package calculator;

import java.awt.Color;
import javax.swing.JLabel;


public class ConcreteNode implements INode, Cloneable {

	private int value;
	private String operator=null;
	private boolean isNumber=false;
	
	public static int x=250;
	public static int y=250;
	
	public ConcreteNode(){}
	
	 public ConcreteNode clone()
	 {
	   ConcreteNode clonedItem = null;
	   try {  
	          //use default object clone.
	          clonedItem = (ConcreteNode) super.clone(); 
	    } catch (CloneNotSupportedException e) {
	        e.printStackTrace();   
	     } // catch 
	  return clonedItem ;
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

	public void setvalue(int interpretValue) {
		value=interpretValue;
	}
	
	public void setOperator(String op){
		operator=op;
	}
	
	public String getOperator(){
		return operator;
	}
	
	public void setNum(){
		isNumber=true;
	}
}
