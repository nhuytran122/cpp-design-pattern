package com.nvtrung.baixe.models;

import java.util.Date;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
abstract public class VeXe {
	public static String NA = "Not Available";
	public static String XE_DAP = "0";
	public static String XE_MAY = "2";
	public static String XE_OTO = "4";

	private Date thoiDiemVao;
	private Date thoiDiemRa;

	abstract public String getBiểnSốHoặcSốVé();

	abstract public String getTênLoạiXe();

	abstract public String getTìnhTrạng1();

	abstract public String getTìnhTrạng2();

	abstract public Double getGiáGiữXe();

	abstract public String getKey();
}
