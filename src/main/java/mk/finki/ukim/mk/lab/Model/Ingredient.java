package mk.finki.ukim.mk.lab.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    private String name;
    private boolean spicy;
    private float amount;
    private boolean veggie;
    private List<Pizza> pizzas;

    public Ingredient(String name, boolean spicy, float amount, boolean veggie, List<Pizza> pizzas) {
        this.name = name;
        this.spicy = spicy;
        this.amount = amount;
        this.veggie = veggie;
        this.pizzas = pizzas;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setAmount(float amount) {
        this.amount=amount
    }

    public void setSpicy(boolean spicy) {
        this.spicy=spicy;
    }

    public void setVeggie(boolean veggie) {
        this.veggie=veggie;
    }
}

