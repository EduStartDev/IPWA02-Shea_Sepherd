package shea_sepherd;

import java.io.Serializable;
import java.util.List;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class MeldeController implements Serializable {
	
	private Geisternetz geisternetz = new Geisternetz();
	private GeisternetzDAO geisternetzDAO = new GeisternetzDAO();
	private Person person = new Person();
	private PersonDAO personDAO = new PersonDAO();
	private List<Geisternetz> geisternetze = zeigeGemeldeteUndZuBergendeNetze();
	
	private boolean telefonnummerErforderlich;
	private boolean speicherButtonClicked;

	//Parameterloser Konstruktor
	public MeldeController() {
	}
	
	
	//UEL Methoden
	public void speicherePersonUndNetz() {
		if (!validiereGeisternetz()) {
		        return; 
		}
		geisternetz.setMelder(person);
		speicherePerson();
		speichereGeisternetz();
		geisternetze = zeigeGemeldeteUndZuBergendeNetze();
	}
	
	public void netzVerschollen(Geisternetz geisternetz) {
		personPruefenUndSpeichern();
		geisternetz.setBerger(person);
		geisternetz.setStatus(GeisternetzStatus.VERSCHOLLEN);
		geisternetzDAO.updateNet(geisternetz);
		geisternetze = zeigeGemeldeteUndZuBergendeNetze();
		person = new Person();
	}
	
	
	//DAO Methoden
	public List<Geisternetz> zeigeGemeldeteUndZuBergendeNetze() {
		return geisternetzDAO.showNetsForVerschollen();
	}
	
	public void personPruefenUndSpeichern() {
		//Prüfen ob die Person bereits in der Datenbank gespeichert ist, andernfalls wird sie gespeichert
		Person vorhandenePerson = personDAO.findPerson(person);		
		if (vorhandenePerson == null) {
			personDAO.add(person);
		} //Falls Person in der Datenbank existiert, wird diese geladen
		else {
			person = vorhandenePerson;
		}
	}
		
	public void speichereGeisternetz() {
		geisternetzDAO.add(geisternetz);
		geisternetz = new Geisternetz();
	}

	public void speicherePerson() {
		personDAO.add(person);
		person = new Person();
	}
	
	private boolean validiereGeisternetz() {
		boolean isValid = true;    
		if (geisternetz.getLatitude() < -90 || geisternetz.getLatitude() > 90) {
			isValid = false;
			FacesContext.getCurrentInstance().addMessage("latitude", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Latitude muss zwischen -90 und 90 liegen.", ""));
		}
		if (geisternetz.getLongitude() < -180 || geisternetz.getLongitude() > 180) {
			isValid = false;
			FacesContext.getCurrentInstance().addMessage("longitude", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Longitude muss zwischen -180 und 180 liegen.", ""));
		}
		if (geisternetz.getGeschaetzteGroesse() < 1 || geisternetz.getGeschaetzteGroesse() > 500) {
			isValid = false;
			FacesContext.getCurrentInstance().addMessage("groesse", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Größe des Netzes muss zwischen 1 und 500 liegen.", ""));
		}	    
		return isValid;
	}

	//Navigation
	public String index() {
		 return "index.xhtml?faces-redirect=true";
	}
	

	//Required Felder anpassen
	public void requiredFuerSpeichern() {
		setzeTelefonnummerNichtErforderlich();
		setzeSpeicherButtonClickedTrue();
	}
	
	public void requiredFuerVerschollen() {
		setzeTelefonnummerErforderlich();
		setzeSpeicherButtonClickedFalse();
	}
	
	public void setzeTelefonnummerNichtErforderlich() {
		setTelefonnummerErforderlich(false);
	}
	
	public void setzeTelefonnummerErforderlich() {
		setTelefonnummerErforderlich(true);
	}
	
	public void setzeSpeicherButtonClickedTrue() {
		setSpeicherButtonClicked(true);
	}
	
	public void setzeSpeicherButtonClickedFalse() {
		setSpeicherButtonClicked(false);
	}
	
	//Getters and Setters
	public Geisternetz getGeisternetz() {
		return geisternetz;
	}

	public void setGeisternetz(Geisternetz geisternetz) {
		this.geisternetz = geisternetz;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public List<Geisternetz> getGeisternetze() {
		return geisternetze;
	}


	public void setGeisternetze(List<Geisternetz> geisternetze) {
		this.geisternetze = geisternetze;
	}

	public boolean isTelefonnummerErforderlich() {
		return telefonnummerErforderlich;
	}
	
	public void setTelefonnummerErforderlich(boolean telefonnummerErforderlich) {
		this.telefonnummerErforderlich = telefonnummerErforderlich;
	}


	public boolean isSpeicherButtonClicked() {
		return speicherButtonClicked;
	}


	public void setSpeicherButtonClicked(boolean speicherButtonClicked) {
		this.speicherButtonClicked = speicherButtonClicked;
	}
	
	
	
	
	
	

}
