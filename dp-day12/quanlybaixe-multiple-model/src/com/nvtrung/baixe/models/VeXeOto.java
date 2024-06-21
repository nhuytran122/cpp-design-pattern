package com.nvtrung.baixe.models;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class VeXeOto extends VeXe {
	private String biểnSố;
	private String tìnhTrạngKhiVào;
	private String tìnhTrạngKhiRa;

	@Override
	public String getBiểnSốHoặcSốVé() {
		return this.getBiểnSố();
	}

	@Override
	public String getTênLoạiXe() {
		return "Xe Ôtô";
	}

	@Override
	public String getTìnhTrạng1() {
		return this.getTìnhTrạngKhiVào();
	}

	@Override
	public String getTìnhTrạng2() {
		return this.getTìnhTrạngKhiRa();
	}

	@Override
	public Double getGiáGiữXe() {
		if (this.getThoiDiemRa() == null)
			return null;

		if (this.tìnhTrạngKhiRa.equals(this.tìnhTrạngKhiVào) == false)
			return null;

		/*
		 * 5k cho mỗi nửa giờ tính xem từ lúc gửi -> lúc nhận có mấy ngày-đêm
		 */
		double tổngSốMs = this.getThoiDiemRa().getTime() - this.getThoiDiemVao().getTime();
		double sốMsMộtNửaGiờ = 30 * 60 * 1000;
		double sốNửaGiờ = Math.ceil(tổngSốMs / sốMsMộtNửaGiờ);

		return sốNửaGiờ * 5000;
	}

	@Override
	public String getKey() {
		return String.format("%s;%s;%s", VeXe.XE_OTO, this.getBiểnSố(), VeXe.NA);
	}

}
