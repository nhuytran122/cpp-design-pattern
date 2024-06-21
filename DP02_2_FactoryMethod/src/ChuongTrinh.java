public class ChuongTrinh {
	static void testFactoryMethod() {
		// 1. Khai báo
		ConVật x;
//		ConVậtFactory f;

		// 2. Tạo đối tượng
		// x = (new MèoFactory()).getConVật();
		// x = (new ChóFactory()).getConVật();
		x = (new GàFactory()).getConVật();

		// 3. Thể hiện hoạt cảnh
		x.kêu();
	}

	public static void main(String[] args) {
		testFactoryMethod();
	}
}