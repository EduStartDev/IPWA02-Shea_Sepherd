package shea_sepherd;

import java.util.List;

import jakarta.persistence.*;


public class GeisternetzDAO {

    private EntityManager em;


    //Datenbankoperationen 
    public void add(Geisternetz g) {
    	em = JpaUtil.getEntityManager();
           em.getTransaction().begin();
            em.persist(g);
           em.getTransaction().commit();
        em.close();
    }
    
    public List<Geisternetz> showNetsForVerschollen(){
    	em = JpaUtil.getEntityManager();
    	return em.createQuery("SELECT g FROM Geisternetz g WHERE g.status IN ('GEMELDET', 'BERGUNG_BEVORSTEHEND')", Geisternetz.class).getResultList();
    }
    public List<Geisternetz> showNetsForGemeldet(){
    	em = JpaUtil.getEntityManager();
    	return em.createQuery("SELECT g FROM Geisternetz g WHERE g.status = 'GEMELDET'", Geisternetz.class).getResultList();
    }
    public List<Geisternetz> showNetsForZurBergungPerson(Person berger){
    	em = JpaUtil.getEntityManager();
    	return em.createQuery("SELECT g FROM Geisternetz g WHERE g.status = 'BERGUNG_BEVORSTEHEND' AND g.berger = :berger", Geisternetz.class)
    			.setParameter("berger", berger)
    			.getResultList();
    }
    
    public void updateNet(Geisternetz g) {
    	em = JpaUtil.getEntityManager();
    	em.getTransaction().begin();
    		em.merge(g);
    	em.getTransaction().commit();    		
    }
    
    
    
}
