package calculator;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public abstract class IExpression implements Cloneable
{
	//variables
	protected IExpression  leftExpression;
	protected IExpression  rightExpression;
	protected CalcIterator iterator = new ConcreteIterator();
	protected JLabel 	   label=null;
	protected String	   operator = null;
	protected int	  	   value;
	
	//abstract functions 
    public abstract int Interpret();
    public abstract String getNodeValue();
    
    //none abstract functions
    public CalcIterator getIterator(){
    	return iterator;
    }
    
    public IExpression getLeftNode(){
    	return leftExpression;
	}
	  
	public IExpression getRightNode(){
		return rightExpression;
	}
	
	public void  setLeftNode(IExpression exp){
	    leftExpression=exp;
	}
		  
	public  void  setRightNode(IExpression exp){
		rightExpression=exp;
	}
	
	public  void  setValue(int val){}
	
	public String getOperator(){
		return operator;
	}


	public IExpression clone()
	{
		IExpression clonedItem = null;
		try {  
			//use default object clone.
			clonedItem = (IExpression) super.clone(); 
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();   
		} // catch 
		return clonedItem ;
	}

	public void drawNode(int x, int y, ImageContext image, JPanel contentPane)
	{	
		label = new JLabel("("+operator+")" + " " + Integer.toString(this.Interpret()),image.getExpIcon(),JLabel.CENTER);
		label.setForeground(Color.BLACK);
		label.setBounds(x, y, 82, 52);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalTextPosition(JLabel.CENTER);
		
		contentPane.add(label);
		
		x=x-20;
		y=y+40;
		leftExpression.drawNode(x, y, image, contentPane);
		
		x=x+40;
		rightExpression.drawNode(x, y, image, contentPane);
	}
	
	public JLabel getLabel(){
		return label;
	}
	
	public void setLabel(int x ,int y){
		label.setBounds(x, y, 82, 52);
	}
	
	public void removeLabel(JPanel contentPane){
		contentPane.remove(label);
		if(leftExpression!=null){leftExpression.removeLabel(contentPane);}
		if(rightExpression!=null){rightExpression.removeLabel(contentPane);}	
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