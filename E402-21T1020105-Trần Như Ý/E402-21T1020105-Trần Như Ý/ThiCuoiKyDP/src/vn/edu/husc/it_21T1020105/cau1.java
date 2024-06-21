package vn.edu.husc.it_21T1020105;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class cau1 {
	public static List<Shape> docDanhSach(){
		List<Shape> lst = new ArrayList<Shape>();
		try{
		     FileReader f = new FileReader("hinh.txt");
		     BufferedReader b = new BufferedReader(f);
		     while(true){
		          String st = b.readLine();
		          if(st == null || st == "") break;
		          String[] tt = st.split("[|]");
		          if (tt[0].equals("0"))
		        	  lst.add(new HinhTron(Double.parseDouble(tt[1])));
		          else if(tt[0].equals("1"))
		        	  lst.add(new HinhChuNhat(Double.parseDouble(tt[1]), Double.parseDouble(tt[2])));
		          else 
		        	  continue;
		     }
		     b.close();
		} catch(Exception e) {
		     e.printStackTrace();
		}
		return lst;
	}
}
