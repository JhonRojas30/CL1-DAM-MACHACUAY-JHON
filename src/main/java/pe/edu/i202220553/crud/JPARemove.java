package pe.edu.i202220553.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220553.entity.Country;

public class JPARemove {

    public static void main(String[] args) {

        // referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        // Inicia la transacción
        em.getTransaction().begin();

// Busca el país con el código "PNM"
        Country country = em.find(Country.class, "PZ1");

// Verifica si se encontró el país
        if (country != null) {
            // Si el país existe, lo elimina
            em.remove(country);
            // Confirma la transacción
            em.getTransaction().commit();
            System.out.println("Pais Eliminado Satisfactoriamente");
        } else {
            // Si el país no se encuentra, no realiza ninguna acción
            em.getTransaction().rollback();
            System.out.println("Pais no encontrado");
        }

// Cierra la sesión
        em.close();



    }
}
