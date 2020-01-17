
public class Client extends Person {
	private String adress; 
	
	public Client(String firstName, String lastName, String adress) {
		super(firstName, lastName);
		this.adress = adress;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s living at %s", super.getFirstName(), super.getLastName(), this.adress);
	}
}
