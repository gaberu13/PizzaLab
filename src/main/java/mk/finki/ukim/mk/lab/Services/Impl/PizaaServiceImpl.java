package mk.finki.ukim.mk.lab.Services.Impl;

import mk.finki.ukim.mk.lab.Model.Pizza;
import mk.finki.ukim.mk.lab.Repository.PizzaRepository;
import mk.finki.ukim.mk.lab.Services.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizaaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizaaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public List<Pizza> listPizzas() {
        return this.pizzaRepository.getAllPizzas();
    }
}

