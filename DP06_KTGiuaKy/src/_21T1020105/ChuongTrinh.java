package _21T1020105;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ChuongTrinh {
    public static void main(String[] args) throws Exception {
        // Đọc cấu hình từ file config.txt
        CauHinh cfg = CauHinh.getInstance();

        SinhVienRepo repo = (new SinhVienRepoFactory()).createSinhVienRepo(cfg);
        System.out.println(repo.getClass());
        
        if (repo != null) {
        	ArrayList<SinhVien> lstSV = repo.selectAll();
        	System.out.println("Test selectAll:");
            for(SinhVien sv: lstSV)
            	System.out.println(sv);
            
            SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
            SinhVien newSV = new SinhVien("21T1020303", "Nguyen Minh Anh", false, d.parse("06/12/2003"));
            repo.insertStudent(newSV);
            System.out.println("\nTest Insert: ");
            for(SinhVien sv: repo.selectAll())
            	System.out.println(sv);

            repo.deleteStudent("21T1020303");
            lstSV = repo.selectAll();
            
            System.out.println("\nTest Delete: ");
            for(SinhVien sv: repo.selectAll())
            	System.out.println(sv);
        }
    }
}