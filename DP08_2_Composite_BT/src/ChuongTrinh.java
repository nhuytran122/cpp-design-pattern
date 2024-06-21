import java.awt.Color;

public class ChuongTrinh {
    public static void main(String[] args) {
    	System.out.println("BEFORE: ");
        Button btnX = new Button("Đóng lại", Color.YELLOW);
        Label lblThongBao = new Label("Test", Color.GREEN);
        Panel pnl = new Panel(Color.GREEN);
        Panel pnl2 = new Panel(Color.YELLOW);
        Button btnX2 = new Button("XXX", Color.CYAN);
        
        System.out.println("Button color: " + btnX.getBackColor());
        System.out.println("Label color: " + lblThongBao.getBackColor());
        System.out.println("Panel color: " + pnl.getBackColor());
        System.out.println("Panel2 color: " + pnl2.getBackColor());
        System.out.println("Button2 color: " + btnX2.getBackColor());
        
        pnl.add(pnl2);
        pnl2.add(btnX2);
        pnl.add(btnX);
        pnl.add(lblThongBao);
        
        pnl.setBackColor(Color.RED); // Thiết lập màu nền cho Panel và tất cả các đối tượng con của nó
        
        System.out.println("\nAFTER: ");
        System.out.println("- Panel color: " + pnl.getBackColor());
        System.out.println("\t- Button color: " + btnX.getBackColor());
        System.out.println("\t- Label color: " + lblThongBao.getBackColor());
        System.out.println("\t- Panel2 color: " + pnl2.getBackColor());
        System.out.println("\t\t- Button2 color: " + btnX2.getBackColor());
    }
}