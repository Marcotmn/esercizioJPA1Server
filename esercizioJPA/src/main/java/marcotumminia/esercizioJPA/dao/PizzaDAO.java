package marcotumminia.esercizioJPA.dao;

import java.util.List;

import marcotumminia.esercizioJPA.entities.Pizza;

public interface PizzaDAO {
	public void save(Pizza pizza);

	public void findByIdAndUpdate(int id, Pizza pizza);

	public void findByIdAndDelete(int id);

	public Pizza findById(int id);

	public List<Pizza> findAll();

	public long count();

	public List<Pizza> findByPartialNameIgnoreCase(String name);
}

