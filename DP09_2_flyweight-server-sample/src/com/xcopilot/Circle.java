package com.xcopilot;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Circle {
	private int x;
	private int y;
	private int r; // bán kính
	private String color; // màu sắc
	private String material; // vật liệu
	
	public void doDraw() {
		System.out.printf("Vẽ đường tròn tâm (%d, %d) bán kính %d, màu %s, chất liệu %s ra màn hình\n",
				x, y, r, color, material);
	}
}
