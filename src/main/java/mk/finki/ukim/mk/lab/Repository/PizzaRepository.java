package mk.finki.ukim.mk.lab.Repository;

import mk.finki.ukim.mk.lab.Model.Pizza;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public  class PizzaRepository {
    static List<Pizza> pizzas = new ArrayList<>(10);
    public List<Pizza> getAllPizzas() {
        return pizzas;
    }

}
