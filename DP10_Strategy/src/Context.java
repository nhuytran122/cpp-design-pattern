
public class Context {
    private iSortStrategy strategy;

    public Context(iSortStrategy strategy) {
		super();
		this.strategy = strategy;
	}

	public Context() {
		// TODO Auto-generated constructor stub
	}

	public void setStrategy(iSortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sapXep(int[] arr) {
        strategy.sapXep(arr);
    }
}
