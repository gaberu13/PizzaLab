package mk.finki.ukim.mk.lab.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@Data

@Table(name = "Ingredients")
public class Ingredient {
    @Id
    private String name;
    private boolean spicy;
    private float amount;
    private boolean veggie;

    public Ingredient(String name, boolean spicy, float amount, boolean veggie, List<Pizza> pizzas) {
        this.name = name;
        this.spicy = spicy;
        this.amount = amount;
        this.veggie = veggie;
        this.pizzas = pizzas;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    List<Pizza> pizzas;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isVeggie() {
        return veggie;
    }

    public void setVeggie(boolean veggie) {
        this.veggie = veggie;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public boolean getSpicy() {
     return spicy;
    }

    public boolean getVeggie() {
        return veggie;
    }
}
