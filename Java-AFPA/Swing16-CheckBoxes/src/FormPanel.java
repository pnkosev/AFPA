import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
	private FormListener formListener;
	private JList<AgeCategory> ageList;
	private JComboBox<String> empBox;
	private JCheckBox citizenCheckBox;
	private JTextField taxField;
	private JLabel taxLabel;

	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		okBtn = new JButton("Ok");	
		ageList = new JList<>();
		empBox = new JComboBox<>();
		citizenCheckBox = new JCheckBox();
		taxField = new JTextField(10);
		taxLabel = new JLabel("Tax ID: ");
		
		// Set up Tax ID
		taxLabel.setEnabled(false);
		taxField.setEnabled(false);
		
		citizenCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isTicked = citizenCheckBox.isSelected();
				taxLabel.setEnabled(isTicked);
				taxField.setEnabled(isTicked);
			}
		});
		//
		
		// Set up list box
		DefaultListModel<AgeCategory> ageModel = new DefaultListModel<>();
		ageModel.addElement(new AgeCategory(0, "Under 18"));
		ageModel.addElement(new AgeCategory(1, "18 to 65"));
		ageModel.addElement(new AgeCategory(2, "65 or over"));
		ageList.setModel(ageModel);
		
		ageList.setPreferredSize(new Dimension(110, 68));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(1);
		//
		
		// Set up combo box
		DefaultComboBoxModel<String> empModel = new DefaultComboBoxModel<>();
		empModel.addElement("employed");
		empModel.addElement("self-employed");
		empModel.addElement("unemployed");
		empBox.setModel(empModel);
		empBox.setSelectedIndex(0);
		//empBox.setEditable(true);                      // editSable item
		//
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCat = ageList.getSelectedValue();
				String empCat = String.valueOf(empBox.getSelectedItem());
				boolean isUSCitizen = citizenCheckBox.isSelected();
				String taxId = taxField.getText();
				
				// Undo all actions
				nameField.setText("");
				occupationField.setText("");
				taxField.setText("");
				citizenCheckBox.setSelected(false);
				taxLabel.setEnabled(citizenCheckBox.isSelected());
				taxField.setEnabled(citizenCheckBox.isSelected());
				ageList.setSelectedIndex(1);
				empBox.setSelectedIndex(0);
				//
				
				FormEvent ev = new FormEvent(this, name, occupation, ageCat.getId(), empCat, taxId, isUSCitizen);
				
				if (formListener != null) {
					formListener.formEventOccurred(ev);
				}
			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		layoutComponents();
	}
	
	public void layoutComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
				
		// First row
		
		gbc.gridy = 0;
		
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(nameField, gbc);
		
		// Next row
		
		gbc.gridy++;
		
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(occupationLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(occupationField, gbc);
		
		// Next row
		
		gbc.gridy++;
		
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Age: "), gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(ageList, gbc);
		
		// Next row
		
		gbc.gridy++;
		
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Employment: "), gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(empBox, gbc);
		
		// Next row
		
		gbc.gridy++;
		
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("US Citizen: "), gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(citizenCheckBox, gbc);
		
		// Next row
		
		gbc.gridy++;
		
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(taxLabel, gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(taxField, gbc);
		
		// Next row
		
		gbc.gridy++;
		
		gbc.weightx = 1;
		gbc.weighty = 2;
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(okBtn, gbc);
	}

	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}
}

class AgeCategory {
	private int id;
	private String text;
	
	public AgeCategory(int id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public String toString() {
		return this.text;
	}
	
	public int getId() {
		return this.id;
	}
}
