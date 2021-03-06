import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private char letter;
	
	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, char letter) {
		super(source);
		
		this.letter = letter;
	}
	
	public char getLetter() {
		return this.letter;
	}

	public void setLettre(char lettre) {
		this.letter = lettre;
	}
}
