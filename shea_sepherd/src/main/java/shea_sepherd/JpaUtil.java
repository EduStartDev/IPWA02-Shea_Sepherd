package shea_sepherd;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private static EntityManagerFactory emf;

    // Statische Initialisierung der EntityManagerFactory
    static {
        try {
            emf = Persistence.createEntityManagerFactory("ghostnetsPersistenceUnit");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("EntityManagerFactory konnte nicht initialisiert werden.");
        }
    }

    // Methode zum Erstellen eines EntityManagers
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Methode zum Schließen der EntityManagerFactory
    public static void close() {
        if (emf != null) {
            emf.close();
        }
    }
}

