package calculator;

import java.util.HashMap;
import java.util.Map;

public class NodeFactory {
	
	 private Map<IExpression, ConcreteNode> node = new HashMap<IExpression, ConcreteNode>();
	 
	 public ConcreteNode getNode(IExpression exp){
		 ConcreteNode cNode=node.get(exp);
		 if(cNode==null){
			    cNode = new ConcreteNode(exp);
	            node.put(exp, cNode);
		 }
		
		 return cNode;
	 }
	
	 public int getSize(){
		 return node.size();
	 }	 
}
