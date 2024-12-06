package shea_sepherd;


import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nutzername;
	private String telefonnummer;
		
	//Parameterloser Konstruktor für Hibernate
	public Person() {		
	}
	
	//Personen sind identisch, wenn Nutzername und Telefonnummer gleich sind
	@Override
	public int hashCode() {
		return Objects.hash(nutzername, telefonnummer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(nutzername, other.nutzername) && Objects.equals(telefonnummer, other.telefonnummer);
	}



	//Getters and Setters
	public long getId() {
		return id;
	}
	
	public String getNutzername() {
		return nutzername;
	}


	public void setNutzername(String nutzername) {
		this.nutzername = nutzername;
	}


	public String getTelefonnummer() {
		return telefonnummer;
	}


	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	
	
	
	

}
