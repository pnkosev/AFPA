import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {
	private JButton helloButton;
	private JButton byeButton;
	private TextPanel textPanel;
	
	public Toolbar() {
		helloButton = new JButton("Hello");
		byeButton = new JButton("Goodbye");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(byeButton);
		
		helloButton.addActionListener(this);
		byeButton.addActionListener(this);
	}

	public void setTextPanel(TextPanel textPanel) {
		this.textPanel = textPanel;
	}

	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		
		if (clicked == helloButton) {
			textPanel.appendText("Hello \n");
		} else if (clicked == byeButton) {
			textPanel.appendText("Goodbye \n");
		}
	}
}
