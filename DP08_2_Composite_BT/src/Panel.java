import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

class Panel implements IControl {
    private List<IControl> controls = new ArrayList<>();
    private Color backColor;
    
	public Panel(ArrayList<IControl> controls, Color backColor) {
		super();
		this.controls = controls;
		this.backColor = backColor;
	}
	
	public Panel(Color backColor) {
        this.backColor = backColor;
        this.controls = new ArrayList<>();
    }

	@Override
	public void setBackColor(Color color) {
	    this.backColor = color;
	    for (IControl control : controls) {
	        control.setBackColor(color);
//	        if (control instanceof Panel) {
//	            ((Panel) control).setBackColor(color); // Cập nhật màu nền cho các Panel con một cách đệ quy
//	        }
	    }
	}
	
	public void add(IControl control) {
//        control.setBackColor(this.backColor);
        controls.add(control);
    }

	public Color getBackColor() {
		return this.backColor;
	}
}