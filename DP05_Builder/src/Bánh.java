public class Bánh {
	// thuộc tính bắt buộc có
	private double đường;
	private double bột;
	
	// thuộc tính tuỳ chọn
	private double vani;
	private double nướcDừa;
	private double cacao;
	private double ớt;
	private double tiêu;
	
	// 1. Tạo ra inner class của class Bánh
	public static class Builder {
		// thuộc tính bắt buộc có
		private double đường;
		private double bột;
		
		// thuộc tính tuỳ chọn
		private double vani;
		private double nướcDừa;
		private double cacao;
		private double ớt;
		private double tiêu;
	
		// 2. Tạo hàm dựng cho inner class với các thuộc tính bắt buộc phải có
		public Builder(double đường, double bột) {
			this.đường = đường;
			this.bột = bột;
		}
	
		// 3. Với mỗi thuộc tính X là optional, tạo hàm 
		// Builder x(Type value) { this.x = value; return this; }
		public Builder vani(double value) {
			this.vani = value;
			return this;
		}
	
		public Builder nướcDừa(double value) {
			this.nướcDừa = value;
			return this;
		}
	
		public Builder cacao(double value) {
			this.cacao = value;
			return this;
		}
	
		public Builder ớt(double value) {
			this.ớt = value;
			return this;
		}
		
		public Builder tiêu(double value) {
			this.tiêu = value;
			return this;
		}
	
		// 4. Tạo hàm build()
		public Bánh build() {
			return new Bánh(this);
		}
	}

	// 5. hàm dựng với đối số Builder
	private Bánh(Builder b) {
		this.đường = b.đường;
		this.bột = b.bột;
		this.vani = b.vani;
		this.nướcDừa = b.nướcDừa;
		this.cacao = b.cacao;
		this.tiêu = b.tiêu;
		this.ớt = b.ớt;
	}

	@Override
	public String toString() {
		return "Bánh [đường=" + đường + ", bột=" + bột + ", vani=" + vani + ", nướcDừa=" + nướcDừa + ", cacao=" + cacao
				+ ", ớt=" + ớt + ", tiêu=" + tiêu + "]";
	}
	
	
}