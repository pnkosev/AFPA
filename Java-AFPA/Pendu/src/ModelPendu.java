import java.util.Arrays;
import java.util.HashSet;

public class ModelPendu {
	private String hiddenWord;
	private char[] discoveredWord;
	private HashSet<Character> lettersUsed;
	private HashSet<Character> uniqueLetters;
	private int lettersGuessed;
	private int nbLifes;
	private int nbTries;

	public ModelPendu(String word) {
		this.hiddenWord = word;
		this.discoveredWord = new char[this.hiddenWord.length()];
		Arrays.fill(this.discoveredWord, '*');
		this.lettersUsed = new HashSet<>();
		this.uniqueLetters = new HashSet<>();
		initializeUniqueLetters();
		this.nbLifes = this.uniqueLetters.size() * 2 > 10 ? 10 : this.uniqueLetters.size() * 2;
		this.lettersGuessed = 0;
	}
	
	private void initializeUniqueLetters() {
		for (int i = 0; i < hiddenWord.length(); i++) {
			uniqueLetters.add(hiddenWord.charAt(i));
		}
	}

	public HashSet<Character> getLettersUsed() {
		return this.lettersUsed;
	}

	public void addUsedLetter(char letter) {
		this.lettersUsed.add(letter);
	}

	public String getHiddenWord() {
		return this.hiddenWord;
	}

	public char[] getDiscoveredWord() {
		return this.discoveredWord;
	}

	public void setDiscoveredWord(char[] discoveredWord) {
		this.discoveredWord = discoveredWord;
	}

	public int getLettersGuessed() {
		return this.lettersGuessed;
	}

	public void setLettersGuessed(int lettersGuessed) {
		this.lettersGuessed = lettersGuessed;
	}

	public int getNbLifes() {
		return this.nbLifes;
	}

	public void setNbLifes(int nbLifes) {
		this.nbLifes = nbLifes;
	}

	public int getNbTries() {
		return this.nbTries;
	}

	public void setNbTries(int nbTries) {
		this.nbTries = nbTries;
	}
	
}
