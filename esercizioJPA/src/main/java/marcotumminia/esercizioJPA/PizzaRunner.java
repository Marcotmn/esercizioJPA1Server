package marcotumminia.esercizioJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import marcotumminia.esercizioJPA.dao.PizzaDAO;
import marcotumminia.esercizioJPA.entities.Pizza;
import marcotumminia.esercizioJPA.exceptions.ItemNotFoundException;

@Component
@Slf4j
public class PizzaRunner implements CommandLineRunner {
//
	@Autowired // Spring hai un Bean di tipo UsersDAO nel tuo "scatolone" (application
				// context)?
	private PizzaDAO uDAO;
	@Override
	public void run(String... args) throws Exception {
		Pizza Margherita = Pizza.builder().name("Margherita").price(5.99).calories(1024.00).build();
		// Pizza margherita = new Pizza("Margherita", "5.99", "1024.00");

		uDAO.save(Margherita);

		try {
			Pizza salami = Pizza.builder().name("Salami").price(6.99).calories(1100.00).build();
			// uDAO.findByIdAndUpdate(1, giovanni);

		} catch (ItemNotFoundException e) {
			log.error(e.getMessage());
		}
		// log.info("Numero cancellati: " + numeroModificati);

		try {

			uDAO.findByIdAndDelete(102);
			// log.info("Numero cancellati: " + numeroCancellati);
		} catch (ItemNotFoundException e) {
			log.error(e.getMessage());
		}
		log.info("********************* COUNT ********************");
		log.info("Count --> " + uDAO.count());
		try {
			log.info("********************* FIND BY ID ********************");
			log.info(uDAO.findById(52).toString());

		} catch (ItemNotFoundException e) {
			log.error(e.getMessage());
		}
		log.info("********************* FIND ALL ********************");
		uDAO.findAll().forEach(pizza -> log.info(pizza.toString()));

		log.info("********************* FIND ALL IGNORE CASE ********************");
		uDAO.findByPartialNameIgnoreCase("g").forEach(pizza -> log.info(pizza.toString()));
	}

}