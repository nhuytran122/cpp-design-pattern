abstract class ThueBao {
		double soDu;
		abstract int getPhiThueBao();
		abstract int getSoPhutGoiFree();
		abstract int getSoTinNhanFree();
		abstract int getGiaGoi(); // goi 1 phut ton bao nhieu
		abstract int getGiaTinNhan(); // 1 tin nhan ton bao nhieu
		
		public double getSoDu() {
			return soDu;
		}
		public void setSoDu(double soDu) {
			this.soDu = soDu;
		}
}