import java.util.Random;

public class ChuongTrinh {
	public static void main(String[] args) {
		int[] arr = new int[10000];
        Random rd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
	
		Context context = new Context();
		var t1 = System.currentTimeMillis();
		context.setStrategy(new SapXepNoiBot());
		context.sapXep(arr);
		var t2 = System.currentTimeMillis();
		// thoi gian thuc thi (1)  = t2 - t1 (ms)

//		context.setStrategy(new (SapXepChen());
//		context.sapXep(arr);
//		var t2 = System.currentTimeMillis();
//		// thoi gian thuc thi (2) = t2 - t1 (ms)
//
//		context.setStrategy(new (SapXepNhanh());
//		context.sapXep(arr);
//		var t2 = System.currentTimeMillis();
//		// thoi gian thuc thi (3) = t2 - t1 (ms)
	}
}
