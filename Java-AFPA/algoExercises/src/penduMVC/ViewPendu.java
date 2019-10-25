package penduMVC;

import java.util.Scanner;

public class ViewPendu {
	Scanner scanner = new Scanner(System.in);
	
	public ViewPendu() {}
	
	public String getHiddenWord() {
		askHiddenWord();
		return scanner.nextLine();
	}
	
	private void askHiddenWord() {
		System.out.println("Please enter hidden word:");
	}
	
	public char getLetter() {
		askLetter();
		return scanner.nextLine().charAt(0);
	}

	private void askLetter() {
		System.out.println("Please enter a letter:");
	}

	public void printCongrats() {
		System.out.println("Super! Continuez.");
	}

	public void printSorry() {
		System.out.println("Dommage... Coninuez quand même");
	}

	public void printLetterAlreadyUsed(char letter) {
		System.out.println(String.format("%s has already been used, please enter another letter!", letter));
	}
	
	public void printDiscoveredWord(String word) {
		System.out.println(String.format("Vous en êtes à %s", word));
	}
	
	public void printWon(int tries) {
		System.out.println(String.format("Bravo! Vous avez gagné en %d essais!", tries));
	}

	public void printLost(String word, int lettersGuessed) {
		System.out.println(String.format("Perdu! Le mot était %s", word));
		System.out.println(String.format("Vous avez trouvé %d bonnes lettres ; vous ferez mieux la prochaine fois!", lettersGuessed));
	}
}
