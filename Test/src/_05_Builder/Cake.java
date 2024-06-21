package _05_Builder;

public class Cake {

	private double duong, bot, vani;
	
	public Cake(Builder b) {
		this.duong = b.duong;
		this.bot = b.bot;
		this.vani = b.vani;
	}
	
	
	@Override
	public String toString() {
		return "Cake [duong=" + duong + ", bot=" + bot + ", vani=" + vani + "]";
	}


	public static class Builder{
		private double duong, bot, vani;
		public Builder(double duong, double bot) {
			this.duong = duong;
			this.bot = bot;
		}
		
		public Builder vani(double vani) {
			this.vani = vani;
			return this;
		}
		
		public Cake build() {
			return new Cake(this);
		}
	}
}
