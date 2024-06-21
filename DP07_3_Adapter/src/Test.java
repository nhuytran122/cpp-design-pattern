class Test {
	public static void main(String[] args) {
			LỗTròn x = new LỗTròn(2);
			
			CọcTròn y = new CọcTròn(1, 2);
			
			// Kiểm tra xem y có vừa với x hay không
			System.out.println(x.isFit(y));
	
			CọcVuông z = new CọcVuông(0.5);
			// Kiểm tra xem z có vừa với x hay không
			CọcTrònOfCọcVuông z2 = new CọcTrònOfCọcVuông(z);
			System.out.println(x.isFit(z2));
		}
}