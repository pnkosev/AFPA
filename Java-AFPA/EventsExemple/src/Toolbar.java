import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel {
	private JButton helloButton;
	
	private StringListener listner;
	
	public Toolbar() {
		helloButton = new JButton("YOYO");
		
		add(helloButton);
		
		helloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton clicked = (JButton) e.getSource();
				String buttonText = clicked.getText();
				
				if (listner != null) {
					listner.emitMsg(buttonText);
				}
			}
		});
	}

	public void setListner(StringListener listner) {
		this.listner = listner;
	}
}
