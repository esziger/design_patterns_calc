package calculator;

import javax.swing.ImageIcon;

public class ImageContext{

	public ImageIcon getNumIcon(){
		ImageIcon icon = createImageIcon("circle.png",
                "Icon for numbers");
		return icon;
	}
	
	public ImageIcon getExpIcon(){
		ImageIcon icon = createImageIcon("circleb.png",
                "Icon for expressions");
		return icon;
	}
	
	
	protected static ImageIcon createImageIcon(String path,String description) {
		if (path != null) {
			return new ImageIcon(path, description);
		} 
		else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
}
