package com.xcopilot;

public class XCopilot {
	public static Circle generateCircle(int x, int y, int r, String color, String material) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new Circle(x, y, r, color, material);
	}
}
