public class ChuongTrinh {

	public static void main(String[] args) {
		testConVật();
	}

	private static void testConVật() {
		// 1. Khởi tạo con vật x
		ConVậtFactory f = new ConVậtFactory();
		ConVật animal = f.getConVật("CHÓ");

		// 2. Thể hiện hoạt cảnh của game
		animal.kêu();
	}

}