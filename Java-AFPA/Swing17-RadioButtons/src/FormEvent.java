import java.util.EventObject;

public class FormEvent extends EventObject {

	private String name;
	private String occupation;
	private int ageCategory;
	private String empCat;
	private String taxId;
	private boolean isUSCitizen;

	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String name, String occupation, int id, String empCat, String taxId, boolean usCitizen) {
		super(source);

		this.name = name;
		this.occupation = occupation;
		this.ageCategory = id;
		this.empCat = empCat;
		this.taxId = taxId;
		this.isUSCitizen = usCitizen;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public void setAgeCategory(int ageCategory) {
		this.ageCategory = ageCategory;
	}

	public void setEmpCat(String empCat) {
		this.empCat = empCat;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public void setUSCitizen(boolean isUSCitizen) {
		this.isUSCitizen = isUSCitizen;
	}

	public String getEmpCat() {
		return this.empCat;
	}
	
	public String getTaxId() {
		return this.taxId;
	}
	
	public boolean getIsUSCitizen() {
		return this.isUSCitizen;
	}
}
