
public class Main {
	public static void main(String[] args) {
		ThueBao tb;
		tb = new ThueBaoTomato();
		inThongtin(tb);
		tb = new KhuyenMaiABC(tb);
		inThongtin(tb);
		tb = new KhuyenMaiABC(tb);
		inThongtin(tb);
	}
	private static void inThongtin(ThueBao tb) {
		System.out.println("\nPhi thue bao: " + tb.getPhiThueBao());
		System.out.println("So phut goi Free: " + tb.getSoPhutGoiFree());
		System.out.println("So tin nhan Free: " + tb.getSoTinNhanFree());
		System.out.println("Gia goi: " + tb.getGiaGoi());
		System.out.println("Gia tin nhan: " + tb.getGiaTinNhan());
	}
}
