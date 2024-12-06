package shea_sepherd;

import java.io.Serializable;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class AuthController implements Serializable {

    private Person person = new Person();
    private PersonDAO personDAO = new PersonDAO();
    
    
    @Inject
    private SessionController sessionController;
    
    //parameterloser Konstruktor
    public AuthController() {    	
    }
    

    //UEL Methoden 
    public String anmelden() {
    	Person vorhandenePerson = personDAO.findPerson(person);
        if (vorhandenePerson == null) {
        	FacesContext.getCurrentInstance().addMessage("nutzername", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Name oder Telefonnummer falsch", "")); 
            return null;
        }
        sessionController.setAngemeldeterNutzer(vorhandenePerson);
        return "netzBergen.xhtml?faces-redirect=true";
    }
    
    public String hinzufuegenUndAnmelden() {
    	Person vorhandenePerson = personDAO.findPerson(person);
    	if (vorhandenePerson != null) {
    		FacesContext.getCurrentInstance().addMessage("nutzername", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nutzer existiert bereits.", ""));
    		return null;
    	} else {
    		personDAO.add(person);
    		Person gespeichertePerson = personDAO.findPerson(person);
            sessionController.setAngemeldeterNutzer(gespeichertePerson);
            return "netzBergen.xhtml?faces-redirect=true";
    	}    	
    }
    
    public String index() {
    	return "index.xhtml?faces-redirect=true";
    }

    //Getters and Setters
	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public SessionController getSessionController() {
		return sessionController;
	}


	public void setSessionController(SessionController sessionController) {
		this.sessionController = sessionController;
	}
    
    

   
}
