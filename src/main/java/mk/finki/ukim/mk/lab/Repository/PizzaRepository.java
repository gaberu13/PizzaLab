package mk.finki.ukim.mk.lab.Repository;

import mk.finki.ukim.mk.lab.Model.Pizza;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public  class PizzaRepository {
    private List<Pizza> pizzas = new ArrayList<>(10);
    public PizzaRepository(){
        this.pizzas.add(  new Pizza("Margherita ","tomato sauce, mozzarella"));
        this.pizzas.add(   new Pizza("Carbonara ","fresh cream, mozzarella, bacon"));
        this.pizzas.add(   new Pizza("Vegetariana ","tomato sauce, mushrooms"));
        this.pizzas.add(   new Pizza("Vegetariana ","tomato sauce, mushrooms"));
        this.pizzas.add(   new Pizza("Calzone ","Pizza dough, ricotta, pepperoni, pizza sauce, olive oil"));
        this.pizzas.add(  new Pizza("Cheddar  ","cheddar, tomato sauce"));
        this.pizzas.add(  new Pizza("Capricciosa  ","fresh cream, mozzarella, bacon"));
    }

    public List<Pizza> getAllPizzas() {
        return pizzas;
    }

}