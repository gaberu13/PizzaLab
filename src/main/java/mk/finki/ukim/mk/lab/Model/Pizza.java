package mk.finki.ukim.mk.lab.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    private String name;
    private String description;
    @ManyToMany(fetch= FetchType.EAGER)
    private List<Ingredient> ingredients;
    private boolean veggie;

    public Pizza(String name, ArrayList<Ingredient> ingredients, boolean veggie) {
        this.name=name;
        this.ingredients=ingredients;
        this.veggie=veggie;
    }


    public void addIngredients(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        ingredient.getPizzas().add(this);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
