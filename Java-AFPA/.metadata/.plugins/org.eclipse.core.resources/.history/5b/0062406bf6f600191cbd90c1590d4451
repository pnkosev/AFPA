import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String occupation;
	private String ageCategory;
	
	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, String name, String occupation, String category) {
		super(source);
		
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = category;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(String ageCategory) {
		this.ageCategory = ageCategory;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
}
