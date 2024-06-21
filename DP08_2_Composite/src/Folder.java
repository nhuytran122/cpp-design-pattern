import java.util.List;
import java.util.ArrayList;
@lombok.Getter
@lombok.Setter
public class Folder implements Component {
	
	private String name;

	// danh sách các đối tượng chứa trong thư mục này
	private List<Component> lstItem = new ArrayList<>();

	public Folder(String name, List<Component> lstItem) {
		super();
		this.name = name;
		this.lstItem = lstItem;
		editChildPath();
	}
	
	@Override
	public long getTotalSize() {
		long kq = 0;
		for (Component x : this.lstItem)
			kq += x.getTotalSize();

		return kq;
	}

	public List<Component> getLstItem() {
		return lstItem;
	}

	@Override
	public void editPath(String str) {
		setName(str + this.name);
		for(Component x: this.lstItem) {
			x.editPath(str);
		}
		
	}
	
	private void editChildPath() {
		for(Component x: this.lstItem) {
			x.editPath(name + "/");
		}
	}
}