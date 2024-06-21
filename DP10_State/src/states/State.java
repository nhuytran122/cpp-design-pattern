package states;

public interface State {
	void onCalling();
	void onSMSReceived();
	void onSystemNotification();
}
