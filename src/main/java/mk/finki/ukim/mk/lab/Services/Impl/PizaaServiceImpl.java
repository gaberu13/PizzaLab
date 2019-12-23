package mk.finki.ukim.mk.lab.Services.Impl;

import mk.finki.ukim.mk.lab.Exeptions.NotAVeggiePizzaException;
import mk.finki.ukim.mk.lab.Model.Ingredient;
import mk.finki.ukim.mk.lab.Model.Pizza;
import mk.finki.ukim.mk.lab.Repository.PizzaRepository;
import mk.finki.ukim.mk.lab.Services.PizzaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizaaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;


    public PizaaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public List<Pizza> getPizzas() {
        return this.pizzaRepository.findAll();
    }

    @Override
    public Pizza getPizza(String name) {
        return pizzaRepository.findById(name).orElseThrow(RuntimeException::new);
    }

    @Override
    public Pizza addPizza(Pizza pizza) throws NotAVeggiePizzaException {

        if(pizza.getVeggie())
            checkVeggie(pizza);

        return pizzaRepository.save(pizza);
    }

    private void checkVeggie(Pizza pizza) throws NotAVeggiePizzaException
    {
        for (Ingredient i: pizza.getIngredients())
        {
            if(!i.getVeggie())
                throw new NotAVeggiePizzaException();
        }
    }

    @Override
    public Pizza editPizza(String name, Pizza pizza) throws NotAVeggiePizzaException {
        if(pizza.getVeggie())
            checkVeggie(pizza);

        this.removePizza(name);
        return pizzaRepository.save(pizza);
    }

    @Override
    public void removePizza(String name) {
        pizzaRepository.deleteById(name);
    }

    @Override
    public List<Ingredient> compareIngredients(String name1, String name2) {
        List<Ingredient> ingredients1 = this.getPizza(name1).getIngredients();
        List<Ingredient> ingredients2 = this.getPizza(name2).getIngredients();

        List<Ingredient> result = new ArrayList<Ingredient>();

        for (Ingredient i : ingredients1
        ) {
            for (Ingredient j : ingredients2
            )
                if (i == j)
                    result.add(j);

        }

        return result;
    }

    @Override
    public List<Pizza> getPizzasLessIngredients(int numIngredients) {
        return pizzaRepository.findAll().stream().filter(pizza -> pizza.getNumIngredients() < numIngredients).collect(Collectors.toList());
    }
}

