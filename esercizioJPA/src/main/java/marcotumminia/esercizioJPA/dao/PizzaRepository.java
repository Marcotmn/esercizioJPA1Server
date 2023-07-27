package marcotumminia.esercizioJPA.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marcotumminia.esercizioJPA.entities.Pizza;

@Repository // Specializzazione di @Component
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

	// "SELECT u FROM User WHERE name= :name"
	Optional<Pizza> findByName(String name);

	// "SELECT u FROM User WHERE name= :name AND surname = :surname"
	List<Pizza> findByNameAndPrice(String name, Double price);

	// "SELECT u FROM User WHERE LOWER(u.name) LIKE CONCAT(LOWER(:name), '%')
	List<Pizza> findByNameStartingWithIgnoreCase(String name);

	// DOCS https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
}
