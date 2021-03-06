import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String occupation;
	private int ageCategory;
	
	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, String name, String occupation, int id) {
		super(source);
		
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = id;
	}
	
	public int getAgeCategory() {
		return this.ageCategory;
	}

	public String getName() {
		return this.name;
	}

	public String getOccupation() {
		return this.occupation;
	}
}
