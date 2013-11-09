package calculator;

import java.util.HashMap;
import java.util.Map;


//FlyweightFactory
public class NodeFactory {
	
	 private Map<String, ConcreteNodeProxy> map = new HashMap<String, ConcreteNodeProxy>();
	 
	 //constructor
	 NodeFactory(){
		 loadCache();
	 }
	
	//gives back a clone, based on the operation type
	public ConcreteNode getNode(String exp){
		 ConcreteNodeProxy cNodeProxy=map.get(exp);
		 
		 if(cNodeProxy==null){
			    cNodeProxy = new ConcreteNodeProxy();
	            map.put(exp, cNodeProxy);
	            System.out.println("We should not enter here, it means there is a new operation..");
		 }
		 return cNodeProxy.clone();
	 }

	//loads the Map with prototypes
	public void loadCache(){
		 
		ConcreteNodeProxy cNodePlus = new ConcreteNodeProxy();
		cNodePlus.setOperator("+");
		map.put("+",cNodePlus);
		
		ConcreteNodeProxy cNodeMinus = new ConcreteNodeProxy();
		cNodeMinus.setOperator("-");
		map.put("-",cNodeMinus);
		
		ConcreteNodeProxy cNodeMulti = new ConcreteNodeProxy();
		cNodeMulti.setOperator("*");
		map.put("*",cNodeMulti);
		
		ConcreteNodeProxy cNodeDiv = new ConcreteNodeProxy();
		cNodeDiv.setOperator("\\");
		map.put("\\",cNodeDiv);
		
		ConcreteNodeProxy cNodeRoot = new ConcreteNodeProxy();
		cNodeRoot.setOperator("1/^");
		map.put("1/^",cNodeRoot);
		
		ConcreteNodeProxy cNodeSqrt = new ConcreteNodeProxy();
		cNodeSqrt.setOperator("^");
		map.put("^",cNodeSqrt);
		
		ConcreteNodeProxy cNodeNum = new ConcreteNodeProxy();
		cNodeNum.setOperator("num");
		cNodeNum.setNum();
		map.put("num",cNodeNum);
	 }
}
