package com.nvtrung.dp.flyweight3;

import java.util.HashMap;

import com.xcopilot.Circle;
import com.xcopilot.XCopilot;

public class IntrinsicObjectFactory {
	private static final HashMap<String, IntrinsicObject> cache = new HashMap<>();

	public static IntrinsicObject getIntrinsictObject(String color, String material) {
		String key = color + "." + material;
		var obj = cache.get(key);

		if (obj == null) {
			var circle = XCopilot.generateCircle(100, 100, 100, color, material); // 2s
			obj = new IntrinsicObject(100, circle.getColor(), circle.getMaterial());
			cache.put(key, obj);
			System.out.printf("Đã tạo xong đối tượng IntrinsictObject với màu %s, chất liệu %s\n", color, material);
		} else {
			System.out.printf("Dùng lại đối tượng IntrinctObject với màu %s, chất liệu %s\n", color, material);
		}
		
		return obj;
	}
}
