package mk.finki.ukim.mk.lab.Repository;

import mk.finki.ukim.mk.lab.Model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository {
    List<Pizza> listPizzas();
    Pizza savePizza(Pizza pizza);
    Optional<Pizza> getPizzaByName(String name);
    void deletePizza(String name);
    void deletePizza(Pizza pizza);
}
