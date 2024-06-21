import java.util.Arrays;

public class ChuongTrinh {
	public static void main(String[] args) {
		
		Component baitap01 = new File("baitap01", 5);
		Component baitap02 = new File("baitap02", 3);
		Component abc = new File("abc", 12);
		Component test = new File("test", 1);

		Component LYTHUYET = new Folder("LY THUYET", Arrays.asList(abc));
		Component JAVA = new Folder("JAVA", Arrays.asList(baitap01,baitap02, LYTHUYET));
		Component CSHARP = new Folder("C#", Arrays.asList());
		Component LAPTRINH = new Folder("LAP TRINH", Arrays.asList(JAVA, CSHARP, test));
		
		
		System.out.println("Duong dan cua baitap02 la: " + baitap02.getName());
        System.out.println("Kich thuoc cua baitap02 la: " + baitap02.getTotalSize());
		System.out.println("Duong dan cua LYTHUYET la: " + LYTHUYET.getName());
        System.out.println("Kich thuoc cua LYTHUYET la: " + LYTHUYET.getTotalSize());
		System.out.println("Kich thuoc cua LAPTRINH la: " + LAPTRINH.getTotalSize());
	}
}