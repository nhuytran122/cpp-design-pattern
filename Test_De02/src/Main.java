import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
	public static void main(String[] args) throws ParseException {
		XuLyData tmp = new XuLyData();
		List<SinhVien> lst = tmp.selectAll();
		inDS(lst);
		tmp.insertSV(new SinhVien("SV03", "Nhu Y Tran", false, new SimpleDateFormat("dd/MM/yyyy").parse("12/02/2003")));
		inDS(lst);
		lst = tmp.selectAll();
		inDS(lst);
	}
	
	
	private static void inDS(List<SinhVien> lst) {
//		System.out.println("\n");
		for(SinhVien tmp : lst)
			System.out.println(tmp);
	}
}