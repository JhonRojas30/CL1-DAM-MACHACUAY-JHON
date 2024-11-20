package pe.edu.i202220553.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220553.entity.City;
import pe.edu.i202220553.entity.Country;

import java.util.List;

public class JPAFind {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        try {

            Country country = em.find(Country.class, "PER");

            if (country != null) {
                // OBTENEMOS LAS CIUDADES
                List<City> ciudades = country.getCities();


                ciudades.stream()
                        .filter(city -> city.getPopulation() > 700000)
                        .forEach(city -> System.out.println(city.getName()));
            } else {
                System.out.println("ERROR,Pais no encontrado");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
