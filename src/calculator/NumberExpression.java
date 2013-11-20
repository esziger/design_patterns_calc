package calculator;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NumberExpression extends IExpression{

	private int number;
	
	public NumberExpression(int i)
    {
        number = i;
        operator="num";
    }
	
	@Override
	public int Interpret() {
		return number;
	}

	@Override
	public String getNodeValue() {
		return Integer.toString(number);
	}
	
	@Override
	public IExpression getLeftNode(){
    	return null;
	}
	
	@Override
	public IExpression getRightNode(){
		return null;
	}
	
	public  void  setValue(int val){
		number = val;
	}
	
	@Override
	public void drawNode(int x, int y, ImageContext image, JPanel contentPane) {	
		label = new JLabel(Integer.toString(this.Interpret()),image.getNumIcon(),JLabel.CENTER);
		label.setForeground(Color.BLACK);
		label.setBounds(x, y, 82, 52);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalTextPosition(JLabel.CENTER);
		
		contentPane.add(label);
		return;
	}
	

}
