import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.peter.dp.CongNhan;
import com.peter.dp.CongNhanReader;
import com.peter.dp.SinhVien;
import com.peter.dp.SinhVienReader;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {        
        // Đọc danh sách sinh viên và công nhân từ file
        List<SinhVien> lstSV = SinhVienReader.readFromFile("sv.txt");
        List<CongNhan> lstCN = CongNhanReader.readFromFile("cn.txt");
        
        // Tạo danh sách tổng hợp các đối tượng SinhVien và CongNhan
        List<PhanTu> lst = new ArrayList<PhanTu>();
        for (SinhVien sv: lstSV) {
        	lst.add(new PhanTuCuaSinhVien(sv));
        }
        
        for (CongNhan cn: lstCN) {
        	lst.add(new PhanTuCuaCongNhan(cn));
        }
        /*Collections.sort(lst, (nv1, nv2) -> {
            String priority1 = nv1.getXepLoai();
            String priority2 = nv2.getXepLoai();
            return priority1.compareTo(priority2);
        });*/
        
        PhanTu tmp = null;
        for (int i = 0; i < lst.size() - 1; i++) {
            for (int j = i + 1; j < lst.size(); j++) {
                String x = lst.get(i).getXepLoai();
                String y = lst.get(j).getXepLoai();
                if (x.compareTo(y) > 0) {
                    tmp = lst.get(i);
                    lst.set(i, lst.get(j));
                    lst.set(j, tmp);
                }
            }
        }
        
        // In ra màn hình danh sách các đối tượng đã sắp xếp
        System.out.println("STT           Họ tên               Loại         Độ ưu tiên");
        for (int i = 0; i < lst.size(); i++) {
            System.out.printf("%-14d%-22s%-16s%s\n", i + 1, lst.get(i).getTen(), lst.get(i).getLoaiDoiTuong(), lst.get(i).getXepLoai());
        }
    }
}
