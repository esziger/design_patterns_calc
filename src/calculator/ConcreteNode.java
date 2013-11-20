package calculator;

import java.awt.Color;
import java.util.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class ConcreteNode implements INode, Cloneable {

	private int value;
	private String operator=null;
	private boolean isNumber=false;
	//each instance contains the label
	private JLabel label=null;
	
	public static int x=250;
	public static int y=250;
	
	Timer timer = new Timer();
	//Timer timer;
	
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
	public void drawNode(ImageContext image, JPanel contentPane) {
		// TODO Auto-generated method stub
		if(isNumber){
			x=x+40;
			label = new JLabel(Integer.toString(value),image.getNumIcon(),JLabel.CENTER);
			label.setForeground(Color.BLACK);
			label.setBounds(x, y, 82, 52);
			label.setVerticalTextPosition(JLabel.CENTER);
			label.setHorizontalTextPosition(JLabel.CENTER);
		}
		else{
			x=x-20;
			y=y-35;
			label = new JLabel("("+operator+")" + " " + Integer.toString(value),image.getExpIcon(),JLabel.CENTER);
			label.setForeground(Color.BLACK);
			label.setBounds(x, y, 82, 52);
			label.setVerticalTextPosition(JLabel.CENTER);
			label.setHorizontalTextPosition(JLabel.CENTER);
		}
		//add the label to the GUI
		contentPane.add(label);
	}
	
	public JLabel getLabel(){
		return label;
	}
	
	public static void reSetXY(){
		x=250;
		y=250;
	}

	public void setvalue(int interpretValue) {
		value=interpretValue;
	}
	
	public String getvalue() {
		return Integer.toString(value);
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
	
	public void changeColor(){
		
		label.setForeground(Color.WHITE);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
		
            @Override
            public void run() {
	            	try {
	    				Thread.sleep(500);
	    			} catch (InterruptedException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
                    label.setForeground(Color.BLACK);
            }
        });
	}
}
