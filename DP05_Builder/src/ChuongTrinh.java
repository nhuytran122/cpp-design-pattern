
public class ChuongTrinh {
	public static void main(String[] args) {
		Bánh b = new Bánh.Builder(1.5, 0.7)
				.cacao(5)
				.tiêu(0.5)
				.nướcDừa(4.5)
				.ớt(0.3)
				.build();
		System.out.println(b);
	}
}
