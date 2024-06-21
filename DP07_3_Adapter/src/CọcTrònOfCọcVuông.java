class CọcTrònOfCọcVuông extends CọcTròn { // IS-A

	private CọcVuông x; // HAS-A
	
	public CọcTrònOfCọcVuông(CọcVuông x) {
			this.x = x;
	}
	
	@Override
	public double getBánKính() {
		return x.getKíchThước() * Math.sqrt(0.5);
	}
}