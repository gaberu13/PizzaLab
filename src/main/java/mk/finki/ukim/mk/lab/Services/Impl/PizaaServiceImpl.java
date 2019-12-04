package mk.finki.ukim.mk.lab.Services.Impl;

import mk.finki.ukim.mk.lab.Model.Pizza;
import mk.finki.ukim.mk.lab.Repository.PizzaRepository;
import mk.finki.ukim.mk.lab.Services.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizaaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizaaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }


    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.listPizzas();
    }

    @Override
    public Pizza addPizza(Pizza pizza) {
        return pizzaRepository.savePizza(pizza);
    }

    @Override
    public Optional<Pizza> getPizza(String name) {
        return pizzaRepository.getPizzaByName(name);
    }

    @Override
    public void deletePizza(String name) {
    pizzaRepository.deletePizza(name);
    }

    @Override
    public void deletePizza(Pizza pizza) {
    pizzaRepository.deletePizza(pizza);
    }
}

