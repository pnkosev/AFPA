import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel {
	private String discoveredWord;
	private JLabel discoveredWordLabel;
	private JLabel messageLabel;
	
	public Header(String word) {
		this.discoveredWord = word;
		this.discoveredWordLabel = new JLabel();
		this.discoveredWordLabel.setText(this.discoveredWord);
		this.messageLabel = new JLabel();
		this.messageLabel.setText("");
		
		setBorder(BorderFactory.createTitledBorder("Current state of the discovered word:"));
		
		add(discoveredWordLabel);
		add(messageLabel);
	}

	public void setDiscoveredWord(String discoveredWord) {
		this.discoveredWord = discoveredWord;
		updateWordLabel();
	}
	
	private void updateWordLabel() {
		this.discoveredWordLabel.setText(this.discoveredWord);
	}
	
	public void updateMessageLabel(String msg) {
		this.messageLabel.setText(msg);
	}
}
