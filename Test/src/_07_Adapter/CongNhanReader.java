package _07_Adapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CongNhanReader {
	public static List<CongNhan> loadFromFile(String filename) {
		List<CongNhan> lst = new ArrayList<>();
		try {
			FileReader f = new FileReader("cn.txt");
			BufferedReader br = new BufferedReader(f);
			while(true) {
				String st = br.readLine();
				if(st == null || st =="") break;
				String[] tt = st.split(",");
				if(tt.length < 2)
					continue;
				lst.add(new CongNhan(tt[0], new SimpleDateFormat("dd/MM/yyyy").parse(tt[1])));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
}
