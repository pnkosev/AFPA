import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {
	private JButton helloButton;
	private JButton byeButton;
	
	private StringListener textListener;
	
	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		
		helloButton = new JButton("Hello");
		byeButton = new JButton("Goodbye");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(byeButton);
		
		helloButton.addActionListener(this);
		byeButton.addActionListener(this);
	}

	public void setStringListener(StringListener listener) {
		this.textListener = listener;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		
		if (clicked == helloButton) {
			if (textListener != null) {
				textListener.textEmitted("Hello\n");
			}
			//textPanel.appendText("Hello \n");
		} else if (clicked == byeButton) {
			if (textListener != null) {
				textListener.textEmitted("Goodbye\n");
			}
			//textPanel.appendText("Goodbye \n");
		}
	}
}
