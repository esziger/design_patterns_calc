package calculator;

import java.util.HashMap;
import java.util.Map;


//FlyweightFactory
public class NodeFactory {
	
	private Map<String, IExpressionProxy> map = new HashMap<String, IExpressionProxy>();
	 
	 //constructor
	 NodeFactory(){
		 loadCache();
	 }
	
	//gives back a clone, based on the operation type
	public IExpression getNode(String exp){
		IExpressionProxy cNodeProxy=map.get(exp);
		 
		 if(cNodeProxy==null){
	            System.out.println("We should not enter here, it means there is a new operation..");
		 }
		 return cNodeProxy.clone();
	 }

	//loads the Map with prototypes
	public void loadCache(){
		 
		IExpressionProxy cNodePlus = new IExpressionProxy("+");
		map.put("+",cNodePlus);
		
		IExpressionProxy cNodeMinus = new IExpressionProxy("-");
		map.put("-",cNodeMinus);
		
		IExpressionProxy cNodeMulti = new IExpressionProxy("*");
		map.put("*",cNodeMulti);
		
		IExpressionProxy cNodeDiv = new IExpressionProxy("\\");
		map.put("\\",cNodeDiv);
		
		IExpressionProxy cNodeRoot = new IExpressionProxy("1/^");
		map.put("1/^",cNodeRoot);
		
		IExpressionProxy cNodeSqrt = new IExpressionProxy("^");
		map.put("^",cNodeSqrt);
		
		IExpressionProxy cNodeNum = new IExpressionProxy("num");
		map.put("num",cNodeNum);
	 }
}
