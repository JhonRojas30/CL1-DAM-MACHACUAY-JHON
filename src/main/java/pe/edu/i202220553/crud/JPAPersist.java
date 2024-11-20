package pe.edu.i202220553.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220553.entity.City;
import pe.edu.i202220553.entity.Country;
import pe.edu.i202220553.entity.CountryLanguage;

import java.util.Arrays;

public class JPAPersist {

    public static void main(String[] args) {

        // Referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        // Validación previa antes de las operaciones
        if (em != null && em.isOpen()) {
            // Iniciar transacción
            em.getTransaction().begin();

            // Crear un país
            Country country = new Country(
                    "PZ1",              // Código del país
                    "PERUZUELA",             // Nombre
                    "South America",    // Continente
                    "CARALIMA",             // Capital
                    1285216.0,          // Superficie
                    0,                  // Indica si está en guerra
                    34000000,           // Población
                    75.5,               // Expectativa de vida hombres
                    79.5,               // Expectativa de vida mujeres
                    229.0,              // Producto interno bruto
                    "Inti",              // Moneda
                    "Incaico",        // Tipo de gobierno
                    "Manco Capac",    // Líder
                    2,                  // Niveles de desarrollo
                    "PZ",               // Código ISO
                    null, null          // Otros valores opcionales
            );

            // Crear ciudades asociadas al país
            City city1 = new City(null, "Arecuzco", country, "Luriwashintong", 9674755);
            City city2 = new City(null, "LimMer", country, "Los olvidados", 433000);
            City city3 = new City(null, "Sierra de Ancon", country, "Neptuno", 543343443);

            // Asociar ciudades al país
            country.setCities(Arrays.asList(city1, city2, city3));

            // Crear lenguajes asociados al país
            CountryLanguage language1 = new CountryLanguage("PZ1", "Lorol", "T", 84.0, country);
            CountryLanguage language2 = new CountryLanguage("PZ1", "Ñaja", "F", 15.0, country);

            // Asociar lenguajes al país
            country.setLanguages(Arrays.asList(language1, language2));

            // Persistir país (lo que automáticamente persistirá las relaciones)
            em.persist(country);

            // Confirmar transacción
            em.getTransaction().commit();

            // Mensaje de éxito
            System.out.println("El país y sus entidades relacionadas han sido persistidos exitosamente.");
        } else {
            System.out.println("No se pudo iniciar la transacción, verifique la configuración de JPA.");
        }

        // Cerrar recursos
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
