import java.awt.EventQueue;

public class Main  {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.setVisible(true);
					DbUtil.getDbConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
