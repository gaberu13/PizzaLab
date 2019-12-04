package mk.finki.ukim.mk.lab.Services;

import mk.finki.ukim.mk.lab.Model.Ingredient;
import mk.finki.ukim.mk.lab.Model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaService  {
    List<Pizza> getAllPizzas();
    Pizza addPizza(Pizza pizza);
    Optional<Pizza> getPizza(String name);
    void deletePizza(String name);
    void deletePizza(Pizza pizza);

}
