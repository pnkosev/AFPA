package pendu2;

import java.util.Arrays;

public class Pendu {
	private String hiddenWord;
	private char[] discoveredWord;
	private int nbLifes = 0;
	private int lettersGuessed = 0;
	
	public Pendu(String word) {
		this.hiddenWord = word;
		this.discoveredWord = new char[word.length()];
		fillWordWithStars();
		this.nbLifes = word.length() * 2;
	}
	
	private void fillWordWithStars() {
		Arrays.fill(this.discoveredWord, '*');
	}
	
	public void decrementLifes() {
		this.nbLifes--;
	}
	
	public int getLifes() {
		return this.nbLifes;
	}
	
	public String getHiddenWord() {
		return this.hiddenWord;
	}

	public boolean isHiddenWordDiscovered() {
		return this.hiddenWord.equals(String.valueOf(this.discoveredWord));
	}
	
	public int getIndexOfletter(char letter) {
		return this.hiddenWord.indexOf(letter);
	}
	
	public String getDiscoveredWordAsString() {
		return String.valueOf(this.discoveredWord);
	}
	
	public int getLettersGuessed() {
		return this.lettersGuessed;
	}
	
	public boolean isLetterAStar(int index) {
		return this.discoveredWord[index] == '*';
	}
	
	public void incrementLetteresGuessed() {
		this.lettersGuessed++;
	}
	
	public void modifyDiscoveredWord(char character) {
		for (int j = 0; j < this.hiddenWord.length(); j++) {
			if (this.hiddenWord.charAt(j) == character) {
				if (this.discoveredWord[j] == '*') {
					this.discoveredWord[j] = character;
				}
			}
		}
	}
	
}
