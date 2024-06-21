public class LỗTròn {
	private double bánKính;
	
	
	public LỗTròn(double bánKính) {
		super();
		this.bánKính = bánKính;
	}

	public double getBánKính() { 
		return this.bánKính; 
	}
	
	// kiểm tra xem cọc tròn x có chui lọt lỗ này không?
	public boolean isFit(CọcTròn x) {
		return this.getBánKính() >= x.getBánKính();
	}
}