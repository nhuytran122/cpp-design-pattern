package _05_Builder;

public class ChuongTrinh {
	public static void main(String[] args) {
		Cake banh = new Cake.Builder(0.2, 0.6).build();
		System.out.println(banh);
	}
}
