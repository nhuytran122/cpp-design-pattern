import java.awt.Color;

public class Control implements IControl{
	private String text;
    private Color backColor;
    
	public Control() {
		super();
	}

	public Control(String text, Color backColor) {
		super();
		this.text = text;
		this.backColor = backColor;
	}

	@Override
	public void setBackColor(Color color) {
		 this.backColor = color;
		
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Color getBackColor() {
		return backColor;
	}
}
