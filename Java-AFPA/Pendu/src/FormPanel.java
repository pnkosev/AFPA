import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	
	private JLabel letterLabel;
	private JTextField letterField;
	private JButton okBtn;
	private FormListener formListener;

	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.height = 100;
		setPreferredSize(dim);
		
		letterLabel = new JLabel("Letter: ");
		letterField = new JTextField(10);
		okBtn = new JButton("Ok");
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char letter = letterField.getText().charAt(0);
				letterField.setText("");
				
				FormEvent ev = new FormEvent(this, letter);
				
				if (formListener != null) {
					formListener.formEventOccurred(ev);
				}
			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Enter a letter");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
				
		// First row
		
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(letterLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(letterField, gbc);
		
		// Second row
		
		gbc.weightx = 1;
		gbc.weighty = 2;
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(okBtn, gbc);
	}

	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}
	
	public void disableButton() {
		this.okBtn.setEnabled(false);
	}
	
	public void disableTextField() {
		this.letterField.setEnabled(false);
	}
}
