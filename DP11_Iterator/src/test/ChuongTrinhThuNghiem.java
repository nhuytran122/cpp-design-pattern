package test;

import test.ite.IteratorSoNguyen;
import test.ite.implement.IteratorSoNguyenDuong;
import test.ite.implement.MyDataStructure;

public class ChuongTrinhThuNghiem {

	static void printWithIterator(IteratorSoNguyen it) {
		it.start();
		while (it.hasNext()) {
			int e = it.next();

			System.out.printf("%d ", e);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyDataStructure x = new MyDataStructure();
		x.add(15);
		x.add(2);
		x.add(100);
		x.add(-1340);
		x.add(135);
		x.add(12);
		x.add(-4);
		x.add(5);
		x.add(-3);

		IteratorSoNguyen it;
		it = x.getIteratorSoNguyenChuan();
		printWithIterator(it);
		
		it = x.getIteratorSoNguyenDuong();
		it = new IteratorSoNguyenDuong(1, 2, -4, 55, 566, -3, 1, -1, 10);

//		it = new IteratorSoNguyenVTChan(x.getLst());

		printWithIterator(it);
	}
}
