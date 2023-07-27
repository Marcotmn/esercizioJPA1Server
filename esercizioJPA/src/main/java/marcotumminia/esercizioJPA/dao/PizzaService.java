package marcotumminia.esercizioJPA.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import marcotumminia.esercizioJPA.entities.Pizza;
import marcotumminia.esercizioJPA.exceptions.ItemNotFoundException;

@Service // Specializzazione di @Component
@Slf4j
public class PizzaService implements PizzaDAO {
	@Autowired
	private PizzaRepository pizzaRepo;

	public void save(Pizza pizza) {
		// eventuale logica addizionale custom...
		pizzaRepo.save(pizza);
		log.info(pizza.getName() + " salvato!");
	}

	public List<Pizza> findAll() {
		return pizzaRepo.findAll();
	}

	public Pizza findById(int id) throws ItemNotFoundException {
//		Optional<User> user = usersRepo.findById(id);
//
//		if (user.isPresent()) {
//			return user.get();
//		} else {
//			throw new ItemNotFoundException(id);
//		}
		return pizzaRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}

	public void findByIdAndUpdate(int id, Pizza pizza) throws ItemNotFoundException {
		Pizza found = this.findById(id); // Lo cerco nel db
		// poi aggiorno i suoi dati con quelli passati come parametro
		found.setId(id);
		found.setName(pizza.getName());
		found.setPrice(pizza.getPrice());
		found.setCalories(pizza.getCalories());
		// risalvo su db l'utente modificato
		pizzaRepo.save(found);
	}

	public void findByIdAndDelete(int id) throws ItemNotFoundException {
		Pizza found = this.findById(id);
		pizzaRepo.delete(found);
	}

	public long count() {
		return pizzaRepo.count();
	}

	public List<Pizza> findByPartialNameIgnoreCase(String name) {
		return pizzaRepo.findByNameStartingWithIgnoreCase(name);
	}
}
