package _07_Adapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SinhVienReader {
	public static List<SinhVien> loadFromFile(String filename) {
		List<SinhVien> lst = new ArrayList<>();
		try {
			FileReader f = new FileReader("sv.txt");
			BufferedReader br = new BufferedReader(f);
			while(true) {
				String st = br.readLine();
				if(st == null || st =="") break;
				String[] tt = st.split(",");
				if(tt.length < 3)
					continue;
				lst.add(new SinhVien(tt[0], tt[1], Double.parseDouble(tt[2])));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
}
