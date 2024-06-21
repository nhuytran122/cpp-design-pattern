package _21T1020105_model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@lombok.Getter
@lombok.Setter
public class CauHinh {
	public static String LOAI_TEXT_FILE = "TEXT_FILE";
	public static String LOAI_SQL = "MS_SQLSERVER";
	
	private String loaiNguon;
	private String chuoiKetNoi;
	private static CauHinh _instance = null;

	private CauHinh() {
        try {
        	BufferedReader br = new BufferedReader(new FileReader("config2.txt"));
            loaiNguon = br.readLine();
            chuoiKetNoi = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static CauHinh getInstance() {
        if (_instance == null) {
            _instance = new CauHinh();
        }
        return _instance;
    }
}