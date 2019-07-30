import javax.swing.JFrame;

public class Window extends JFrame{
	public static void main (String[] args)
	{
		Window panel = new Window();
		panel.add(new Algorthims());
		panel.setTitle("Selection Sort");
		panel.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setSize(1705, 950	);
		panel.setLocationRelativeTo(null);
		panel.setResizable(false);
		panel.setVisible(true);
	}

}
