class KhuyenMaiABC extends KhuyenMai { //// cong them 1000 tin nhan trong thang cho thue bao

	public KhuyenMaiABC(ThueBao thuebao) {
		this.thuebao = thuebao;
		// TODO Auto-generated constructor stub
	}
		@Override 
		public int getPhiThueBao() {
			return thuebao.getPhiThueBao() + 10000;
		}

		@Override
		public int getSoPhutGoiFree() {
				return thuebao.getSoPhutGoiFree(); // khong anh huong gi den so phut goi free cua thue bao
		}
		
		@Override
		public int getSoTinNhanFree() {
				return thuebao.getSoTinNhanFree() + 1000;
		}
		
		@Override
		public int getGiaGoi() {
				// goi 1 phut ton bao nhieu
				return thuebao.getGiaGoi();
		}
		
		@Override
		public int getGiaTinNhan() {
				// 1 tin nhan ton bao nhieu	
				return thuebao.getGiaTinNhan();
		}
}