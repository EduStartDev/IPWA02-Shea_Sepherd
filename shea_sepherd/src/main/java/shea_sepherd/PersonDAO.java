package shea_sepherd;

import java.util.List;

import jakarta.persistence.*;

public class PersonDAO {
	
	private EntityManager em;
	
	
	//Methoden für Datenbankoperationen
	public void add(Person p) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
			em.persist(p);
		em.getTransaction().commit();
	}
	
	public Person findPerson(Person person) {
		em = JpaUtil.getEntityManager();
		List<Person> personen = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
		for (Person p : personen) {
			if (person.equals(p)){
				return p;
			}
		} return null;
	}
}
