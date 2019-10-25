import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel {
	private JButton helloButton;
	private JButton byeButton;
	
	public Toolbar() {
		helloButton = new JButton("Hello");
		byeButton = new JButton("Goodbye");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(byeButton);
	}
}
