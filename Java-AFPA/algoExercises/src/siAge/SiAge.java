package siAge;

import java.util.Scanner;

public class SiAge {
	private short age;
	
	public SiAge() {
		saisirAgeEtAfficheMsg();
	}

	private void saisirAge() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter your age:");
		this.age = Short.parseShort(scanner.nextLine());
	}
	
	private void showMessage() {
		if (this.age < 18) {
            System.out.println("Programme réservé aux personnes majeures");
        } else if (this.age <= 26) {
            System.out.println("Statut jeune");
        } else if (this.age <= 65) {
            System.out.println("Statut adulte");
        } else {
            System.out.println("Programme réservé aux personnes non-retraitées");
        }
	}
	
	public short getAge() {
		return this.age;
	}

	public void setAge(short age) {
		this.age = age;
	}
	
	public void saisirAgeEtAfficheMsg() {
		saisirAge();
		showMessage();
	}
}
