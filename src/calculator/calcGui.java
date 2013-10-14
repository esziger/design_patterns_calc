package calculator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Stack;


/**
 * The calculator works with RPN/Peverse polish notation
 * This means the calculator accepts commands in POSTFIX notation e.g.: 5,4 +  OR e.g: 67 90 * 15 +
 * Because of the postfix notation We don't need parenthesis
 */
public class calcGui extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JButton button_0;	//evaluate
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton button_16;
	private JButton button_17;
	private JButton button_18;

	private String result="";

	Stack<JLabel> labelStack = new Stack<JLabel>();	//helper stack for removing labels

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					calcGui frame = new calcGui();
					frame.setVisible(true);				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public calcGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		//contentPane.setLayout(new GridLayout(5, 2));

		textField = new JTextField();
		textField.setBounds(10, 11, 173, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		label = new JLabel("");
		label.setBounds(10, 34, 173, 20);
		contentPane.add(label);

		button_0 = new JButton("Evaluate");
		button_0.setBounds(190, 11, 100, 43);
		contentPane.add(button_0);

		button_1 = new JButton("1");
		button_1.setBounds(10, 62, 50, 20);
		contentPane.add(button_1);

		button_2 = new JButton("2");
		button_2.setBounds(70, 62, 50, 20);
		contentPane.add(button_2);

		button_3 = new JButton("3");
		button_3.setBounds(130, 62, 50, 20);
		contentPane.add(button_3);

		button_4 = new JButton("4");
		button_4.setBounds(10, 99, 50, 20);
		contentPane.add(button_4);

		button_5 = new JButton("5");
		button_5.setBounds(70, 99, 50, 20);
		contentPane.add(button_5);

		button_6 = new JButton("6");
		button_6.setBounds(130, 99, 50, 20);
		contentPane.add(button_6);

		button_7 = new JButton("7");
		button_7.setBounds(10, 139, 50, 20);
		contentPane.add(button_7);

		button_8 = new JButton("8");
		button_8.setBounds(70, 139, 50, 20);
		contentPane.add(button_8);

		button_9 = new JButton("9");
		button_9.setBounds(130, 139, 50, 20);
		contentPane.add(button_9);

		button_10 = new JButton("0");
		button_10.setBounds(70, 170, 50, 20);
		contentPane.add(button_10);

		button_11 = new JButton("+");
		button_11.setBounds(200, 62, 50, 20);
		contentPane.add(button_11);

		button_12 = new JButton("-");
		button_12.setBounds(200, 99, 50, 20);
		contentPane.add(button_12);

		button_13 = new JButton("*");
		button_13.setBounds(200, 139, 50, 20);
		contentPane.add(button_13);

		button_14 = new JButton("\\");
		button_14.setBounds(200, 170, 50, 20);
		contentPane.add(button_14);

		button_15 = new JButton("=");
		button_15.setBounds(133, 170, 50, 20);
		contentPane.add(button_15);

		button_16 = new JButton(",");
		button_16.setBounds(10, 170, 50, 20);
		contentPane.add(button_16);

		button_17 = new JButton("^");
		button_17.setBounds(133, 200, 50, 20);
		contentPane.add(button_17);

		button_18 = new JButton("1/^");
		button_18.setBounds(200, 200, 60, 20);
		contentPane.add(button_18);

		// add event listeners
		button_0.addActionListener( this );
		button_1.addActionListener( this );
		button_2.addActionListener( this );
		button_3.addActionListener( this );
		button_4.addActionListener( this );
		button_5.addActionListener( this );
		button_6.addActionListener( this );
		button_7.addActionListener( this );
		button_8.addActionListener( this );
		button_9.addActionListener( this );
		button_10.addActionListener( this );
		button_11.addActionListener( this );
		button_12.addActionListener( this );
		button_13.addActionListener( this );
		button_14.addActionListener( this );
		button_15.addActionListener( this );
		button_16.addActionListener( this );
		button_17.addActionListener( this );
		button_18.addActionListener( this );
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//if press evaluate or =
		if(e.getSource().equals(button_0) || e.getSource().equals(button_15)){

			result=this.textField.getText();
			result=result.replaceAll("\\s+", ",");			   	//replace all whitespace to ,

			//self check
			String[] parsed_input = result.split("(\\s|,)");
			for(String item : parsed_input){
				System.out.println(item);
			}

			IExpressionBuilder builder = new ConcreteBuilder(); //Builder Pattern
			Director dir = new Director(builder);

			//NodeFactory nodeF=new NodeFactory();
			Stack<ConcreteNode> cNode = new Stack<ConcreteNode>();

			IExpression expression=dir.evaluate(result,cNode);		 // e.g.: IExpression expression=dir.evaluate("5 5 + 3 -");

			result=Integer.toString(expression.Interpret());   	 // e.g.: (10 - 2) + 3 = 11
			label.setText(result);

			if(labelStack.size()!=0){								 //erase the previous graph labels
				for(JLabel labels: labelStack){
					contentPane.remove(labels);
				}
			}

			//Build tree graph
			ImageContext image =new ImageContext();

			for(ConcreteNode cnode: cNode){
				JLabel label=cnode.drawNode(image);
				contentPane.add(label);
				labelStack.push(label);
			}
			ConcreteNode.reSetXY();
			repaint();
			//

			result="";
			System.out.println("Result: "+result);
		}
		else if(e.getSource().equals(button_1)){
			result=this.textField.getText()+"1";
		}
		else if(e.getSource().equals(button_2)){
			result=this.textField.getText()+"2";
		}
		else if(e.getSource().equals(button_3)){
			result=this.textField.getText()+"3";
		}
		else if(e.getSource().equals(button_4)){
			result=this.textField.getText()+"4";
		}
		else if(e.getSource().equals(button_5)){
			result=this.textField.getText()+"5";
		}
		else if(e.getSource().equals(button_6)){
			result=this.textField.getText()+"6";
		}
		else if(e.getSource().equals(button_7)){
			result=this.textField.getText()+"7";
		}
		else if(e.getSource().equals(button_8)){
			result=this.textField.getText()+"8";
		}
		else if(e.getSource().equals(button_9)){
			result=this.textField.getText()+"9";
		}
		else if(e.getSource().equals(button_10)){
			result=this.textField.getText()+"0";
		}
		else if(e.getSource().equals(button_11)){
			result=this.textField.getText()+" + ";
		}
		else if(e.getSource().equals(button_12)){
			result=this.textField.getText()+" - ";
		}
		else if(e.getSource().equals(button_13)){
			result=this.textField.getText()+" * ";
		}
		else if(e.getSource().equals(button_14)){
			result=this.textField.getText()+" \\ ";
		}
		else if(e.getSource().equals(button_16)){
			result=this.textField.getText()+",";
		}
		else if(e.getSource().equals(button_17)){
			result=this.textField.getText()+" ^ ";
		}
		else if(e.getSource().equals(button_18)){
			result=this.textField.getText()+" 1/^";	//root operation
		}

		this.textField.setText(result);	
	}
}
