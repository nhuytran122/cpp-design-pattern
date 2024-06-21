import java.util.Date;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public abstract class ThongTinVe {
	private Date thoiDiemVao = null;
	private Date thoiDiemRa = null;
	
	abstract String getId(); // xe đạp --> số vé, xe máy -> bks, ô tô -> bks
	abstract String getLoạiXe();
	abstract String getTìnhTrạng1();
	abstract String getTìnhTrạng2();
	
	abstract double getGiá();
	abstract boolean cóThểTínhGiá();
	
	// hàm để xác định được 1 đối tượng trong danh sách cho trước
	abstract String getKey();
}