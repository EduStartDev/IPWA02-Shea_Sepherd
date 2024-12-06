package shea_sepherd;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class SessionController implements Serializable {
	
	//Nutzer speichern, für netzBergen
	private Person angemeldeterNutzer;

	//parameterloser Konstruktor
	public SessionController() {
		
	}
	
	//Getter und Setter
	public Person getAngemeldeterNutzer() {
		return angemeldeterNutzer;
	}

	public void setAngemeldeterNutzer(Person angemeldeterNutzer) {
		this.angemeldeterNutzer = angemeldeterNutzer;
	}
	
	

}
