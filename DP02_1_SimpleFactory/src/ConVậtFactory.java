class ConVậtFactory {
	public ConVật getConVật(String loại) {
		if (loại == "GÀ")
			return new Gà();
		else if (loại == "CHÓ")
			return new Chó();
		else 
			return new Mèo();
	}
}