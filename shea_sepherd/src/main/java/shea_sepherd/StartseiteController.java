package shea_sepherd;

import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class StartseiteController implements Serializable {
	
	
	//Parameterloser Konstruktor
	public StartseiteController() {
	}
	
	
	//Navigation
	public String netzMelden() {
		return "netzMelden.xhtml?faces-redirect=true";
	}
	
	public String loginSeite() {
		return "authentification.xthml?faces-redirect=true";
	}

}
