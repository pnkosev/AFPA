import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String occupation;
	private int ageCategory;
	private String empCat;
	
	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, String name, String occupation, int id, String empCat) {
		super(source);
		
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = id;
		this.empCat = empCat;
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
	
	public String getEmpCat() {
		return this.empCat;
	}
}
