package pendu;

public class Main {

	public static void main(String[] args) {
		String word = args[0];
		Pendu newGamePendu = new Pendu(word);
		
		newGamePendu.runGame();
	}
}
