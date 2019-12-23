package mk.finki.ukim.mk.lab.Services;

import mk.finki.ukim.mk.lab.Exeptions.NotAVeggiePizzaException;
import mk.finki.ukim.mk.lab.Model.Ingredient;
import mk.finki.ukim.mk.lab.Model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaService  {
    public List<Pizza> getPizzas();

    public Pizza getPizza(String name);

    public Pizza addPizza(Pizza pizza) throws NotAVeggiePizzaException;

    public Pizza editPizza(String name, Pizza pizza) throws NotAVeggiePizzaException;

    public void removePizza(String name);

    public List<Ingredient> compareIngredients(String name1, String name2);

    public List<Pizza> getPizzasLessIngredients(int numIngredients);

}
