@lombok.AllArgsConstructor
@lombok.Getter 
@lombok.Setter
public class File implements Component {
		
		private String name;
		private long size;
	
		@Override
		public long getTotalSize() {
			return this.size;
		}

		@Override
		public void editPath(String str) {
			setName(str + this.name);
		}
		
}