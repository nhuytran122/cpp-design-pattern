package _21T1020105_implement;

import _21T1020105_model.CauHinh;
import _21T1020105_service.SinhVienRepo;

public class SinhVienRepoFactory {
	public SinhVienRepo createSinhVienRepo(CauHinh cfg) {
		if (cfg.getLoaiNguon().equals(cfg.LOAI_TEXT_FILE) ){
			return new SinhVienRepoTXT(cfg.getChuoiKetNoi());
		} else {
			return new SinhVienRepoSqlServer(cfg.getChuoiKetNoi());
		}
	}
}