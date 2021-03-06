import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private FormPanel formPanel;
	private ModelPendu modelPendu;
	private Header header;
	private PenduPanel penduPanel;
	
	public MainFrame(String hiddenWord) {
		super("Hangman");

		setLayout(new BorderLayout());
		
		this.formPanel = new FormPanel();
		this.modelPendu = new ModelPendu(hiddenWord);
		this.header = new Header(getDiscoveredWord());
		this.penduPanel = new PenduPanel();
		
		formPanel.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				char letter = e.getLetter();
				updateHeaderMsg("");
				
				if (isLetterAlreadyUsed(letter)) {
					updateHeaderMsg("You have already used this letter, please try again!");
				} else {
					addLetterAsUsed(letter);
					incrementTries();
					
					if (hasLetter(letter) && isLetterAStar(letter)) {
						modifyDiscoveredWord(letter);
						updateHeaderWord(getDiscoveredWord());
						incrementLettersGuessed();
					} else {
						decrementLifes();
						redrawImg();
					}
				}
				
				if (hasWon()) {
					redrawImg(12);
					disableFields();
				} else if (hasLost()) {
					redrawImg(11);
					updateHeaderMsg("The word was: " + getHiddenWord());
					disableFields();
				}
			}
		});
		
		add(formPanel, BorderLayout.SOUTH);
		add(header, BorderLayout.NORTH);
		add(penduPanel, BorderLayout.CENTER);
		
		setSize(280, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private boolean isLetterAlreadyUsed(char letter) {
		return this.modelPendu.getLettersUsed().contains(letter);
	}
	
	private void addLetterAsUsed(char letter) {
		this.modelPendu.addUsedLetter(letter);
	}
	
	private void incrementTries() {
		int currentTries = this.modelPendu.getNbTries();
		this.modelPendu.setNbTries(currentTries + 1);
	}
	
	private boolean hasLetter(char letter) {
		int index = getIndexOfLetter(letter);
		return index > -1;
	}
	
	private int getIndexOfLetter(char letter) {
		return this.modelPendu.getHiddenWord().indexOf(letter);
	}
	
	private boolean isLetterAStar(char letter) {
		int index = getIndexOfLetter(letter);
		return this.modelPendu.getDiscoveredWord()[index] == '*';
	}
	
	private void modifyDiscoveredWord(char letter) {
		String hiddenWord = this.modelPendu.getHiddenWord();
		char[] discoveredWord = this.modelPendu.getDiscoveredWord();
		char[] discoveredWordCopy = new char[discoveredWord.length];
		discoveredWordCopy = discoveredWord.clone();
		
		for (int j = 0; j < hiddenWord.length(); j++) {
			if (hiddenWord.charAt(j) == letter) {
				discoveredWordCopy[j] = letter;
			}
		}
		
		this.modelPendu.setDiscoveredWord(discoveredWordCopy);
	}
	
	private void incrementLettersGuessed() {
		int currentLettersGuessed = this.modelPendu.getLettersGuessed();
		this.modelPendu.setLettersGuessed(currentLettersGuessed + 1);
	}

	private void decrementLifes() {
		int currentLifes = this.modelPendu.getNbLifes();
		this.modelPendu.setNbLifes(currentLifes - 1);
	}

	private String getDiscoveredWord() {
		return String.valueOf(this.modelPendu.getDiscoveredWord());
	}

	private void updateHeaderMsg(String msg) {
		header.updateMessageLabel(msg);
	}

	private void updateHeaderWord(String word) {
		header.setDiscoveredWord(word);
	}
	
	private boolean hasWon() {
		String hiddenWord = getHiddenWord();
		String discoveredWord = getDiscoveredWord();
		return hiddenWord.equals(discoveredWord);
	}
	
	private boolean hasLost() {
		int currentLifes = this.modelPendu.getNbLifes();
		return currentLifes <= 0;
	}

	private String getHiddenWord() {
		return this.modelPendu.getHiddenWord();
	}

	private void redrawImg() {
		int currentValue = this.penduPanel.getValue();
		this.penduPanel.setValue(currentValue + 1);
		this.penduPanel.repaint();
	}
	
	private void redrawImg(int val) {
		this.penduPanel.setValue(val);
		this.penduPanel.repaint();
	}
	
	private void disableFields() {
		this.formPanel.disableButton();
		this.formPanel.disableTextField();
	}
}
