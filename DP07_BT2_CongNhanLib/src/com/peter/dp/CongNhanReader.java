package com.peter.dp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CongNhanReader {
		public static List<CongNhan> readFromFile(String filename) throws IOException, ParseException {
				List<CongNhan> lst = new ArrayList<>();
				BufferedReader br = new BufferedReader(new FileReader(filename));
				while (true) {
						String line = br.readLine();
						if (line == null)
								break;
						
						String[] info = line.split(",");
						if (info.length < 2)
								continue;
						
						String hoten = info[0];
						SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
						Date ngayBatDau = d.parse(info[1]);
						
						CongNhan x = new CongNhan(hoten, ngayBatDau);
						lst.add(x);
				}
				br.close();
				
				return lst;
		}
}