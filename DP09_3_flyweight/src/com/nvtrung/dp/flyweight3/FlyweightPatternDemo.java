package com.nvtrung.dp.flyweight3;

import com.xcopilot.Circle;

public class FlyweightPatternDemo {
	private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };
	private static final String materials[] = { "Gỗ", "Giấy", "Sắt", "Vải" };

	public static void main(String[] args) {
		for (int i = 0; i < 100; ++i) {
			System.out.println(i + "...");
			var màu = getRandomColor();
			var vậtLiệu = getRandomMaterial();
			var x = getRandomX();
			var y = getRandomY();
			var r = (int) (1 + 1000 * Math.random());

			// Tạo ra đối tượng intrinsct
			var objThuGon = IntrinsicObjectFactory.getIntrinsictObject(màu, vậtLiệu);

			// Tạo ra đối tượng circle từ đối tượng objThuGon
			var circle = new Circle();
			circle.setX(x);
			circle.setY(y);
			
			circle.setR(objThuGon.getR()*r/objThuGon.getR());
			circle.setMaterial(objThuGon.getVậtLiệu());
			circle.setColor(objThuGon.getMàuSắc());
			
			// Sử dụng đối tượng circle
			circle.doDraw();
		}
	}

	private static String getRandomColor() {
		// 0 -> colors.length - 1
		return colors[(int) (Math.random() * colors.length)];
	}

	private static String getRandomMaterial() {
		return materials[(int) (Math.random() * materials.length)];
	}

	private static int getRandomX() {
		return (int) (Math.random() * 100);
	}

	private static int getRandomY() {
		return (int) (Math.random() * 100);
	}
}