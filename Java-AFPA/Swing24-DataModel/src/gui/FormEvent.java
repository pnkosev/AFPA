package gui;
import java.util.EventObject;

public class FormEvent extends EventObject {

	private String name;
	private String occupation;
	private int ageCategory;
	private String empCat;
	private String taxId;
	private boolean isUSCitizen;
	private String gender;

	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String name, String occupation, int id, String empCat, String taxId, boolean usCitizen, String gender) {
		super(source);

		this.name = name;
		this.occupation = occupation;
		this.ageCategory = id;
		this.empCat = empCat;
		this.taxId = taxId;
		this.isUSCitizen = usCitizen;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public String getOccupation() {
		return occupation;
	}

	public int getAgeCategory() {
		return ageCategory;
	}

	public String getEmpCat() {
		return empCat;
	}

	public String getTaxId() {
		return taxId;
	}

	public boolean isUSCitizen() {
		return isUSCitizen;
	}

	public String getGender() {
		return gender;
	}
}
