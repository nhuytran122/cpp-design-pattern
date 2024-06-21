package com.nvtrung.quanlybaixe4.models;

import java.util.Date;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class VeXe {
	/***
	 * Loại xe: 0 -> xe đạp, 2 -> xe máy, 4 -> ô tô
	 */
	private String loạiXe;

	/**
	 * Biển số. Chỉ có tác dụng với Xe máy và Ô tô
	 */
	private String biểnSố;

	/**
	 * Số vé. Chỉ có tác dụng với Xe đạp
	 */
	private String sốVé;

	/**
	 * Thời điểm xe vào bãi
	 */
	private Date thờiĐiểmVào;

	/**
	 * Tình trạng của xe khi vào bãi. Chỉ có tác dụng với ô tô
	 */
	private String tìnhTrạngKhiVào;

	/**
	 * Thời điểm xe ra khỏi bãi
	 */
	private Date thờiĐiểmRa;

	/**
	 * Tình trạng của xe khi ra khỏi bãi. Chỉ có tác dụng với ô tô
	 */
	private String tìnhTrạngKhiRa;

	public String getBiểnSốHoặcSốVé() {
		if (loạiXe.equals("0"))
			return this.getSốVé();
		else
			return this.getBiểnSố();
	}

	public String getTênLoạiXe() {
		if (this.loạiXe.equals("0"))
			return "Xe đạp";
		else if (this.loạiXe.equals("2"))
			return "Xe máy";
		else
			return "Xe ô tô";
	}

	public String getTìnhTrạng1() {
		if (loạiXe.equals("4"))
			return this.getTìnhTrạngKhiVào();
		else
			return "-";
	}

	public String getTìnhTrạng2() {
		if (loạiXe.equals("4"))
			return this.getTìnhTrạngKhiRa();
		else
			return "-";
	}

	public String getKey() {
		return String.format("%s;%s;%s", loạiXe, biểnSố, sốVé);
	}

	public Double getGiá() {
		if (this.getThờiĐiểmRa() == null)
			return null;

		if (this.loạiXe.equals("0")) {
			return -1.0;
		} else if (this.loạiXe.equals("2")) {
			return -2.0;
		} else {
			return -4.0;
		}
	}
}
