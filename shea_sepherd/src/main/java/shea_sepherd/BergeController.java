package shea_sepherd;

import java.io.Serializable;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class BergeController implements Serializable {

	@Inject
	private SessionController sessionController;
	
	private GeisternetzDAO geisternetzDAO = new GeisternetzDAO();	
	private Person berger;
	private List<Geisternetz> gemeldeteNetze;
	private List<Geisternetz> zuBergendeNetze;	
	
	
	//parameterloser Konstruktor
	public BergeController() {	
	}
	
	@PostConstruct
	public void init() {
		// Berger aus SessionController laden
        berger = sessionController.getAngemeldeterNutzer();
        // Sicherstellen, dass berger korrekt geladen ist
        if (berger == null) {
            return;
        }
        // Initialisierung der Netze
        gemeldeteNetze = zeigeGemeldeteNetze();
        zuBergendeNetze = zeigeZuBergendeNetzePerson(berger);
	}

	//UEL Methoden
	public void netzBergen(Geisternetz geisternetz) {
		geisternetz.setBerger(berger);
		geisternetz.setStatus(GeisternetzStatus.BERGUNG_BEVORSTEHEND);
		geisternetzDAO.updateNet(geisternetz);
		gemeldeteNetze = zeigeGemeldeteNetze();
		zuBergendeNetze = zeigeZuBergendeNetzePerson(berger);
	}
	
	public void netzGeborgenMelden(Geisternetz geisternetz) {
		geisternetz.setStatus(GeisternetzStatus.GEBORGEN);
		geisternetzDAO.updateNet(geisternetz);
		zuBergendeNetze = zeigeZuBergendeNetzePerson(berger);
	}
	
	public void netzVerschollenMelden(Geisternetz geisternetz) {
		geisternetz.setStatus(GeisternetzStatus.VERSCHOLLEN);
		geisternetzDAO.updateNet(geisternetz);
		zuBergendeNetze = zeigeZuBergendeNetzePerson(berger);
	}
	
	
	//DAO-Methoden
	public List<Geisternetz> zeigeGemeldeteNetze() {
		return geisternetzDAO.showNetsForGemeldet();
	}
	
	public List<Geisternetz> zeigeZuBergendeNetzePerson(Person berger){
		return geisternetzDAO.showNetsForZurBergungPerson(berger);
	}
	
	//Navigation
	public String logout() {
		setSessionController(null);
		return "index.xthml";
	}
	
	//Getters and Setters
	public Person getBerger() {
			//ggf. Angemeldeten nutzer wieder hinzufügen?
        return berger;
    }

	public void setBerger(Person berger) {
		this.berger = berger;
	}

	public SessionController getSessionController() {
		return sessionController;
	}

	public void setSessionController(SessionController sessionController) {
		this.sessionController = sessionController;
	}

	public List<Geisternetz> getGemeldeteNetze() {
		return gemeldeteNetze;
	}

	public void setGemeldeteNetze(List<Geisternetz> gemeldeteNetze) {
		this.gemeldeteNetze = gemeldeteNetze;
	}

	public List<Geisternetz> getZuBergendeNetze() {
		return zuBergendeNetze;
	}

	public void setZuBergendeNetze(List<Geisternetz> zuBergendeNetze) {
		this.zuBergendeNetze = zuBergendeNetze;
	}
	
	
	
	
	
	

}
