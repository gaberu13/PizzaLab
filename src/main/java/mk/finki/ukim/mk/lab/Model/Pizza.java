package mk.finki.ukim.mk.lab.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private boolean veggie;
    @ManyToMany(mappedBy = "pizzas")
    private List<Ingredient> ingredients;



    public Pizza(String name, List<Ingredient> ingredients, Boolean veggie, String description) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.veggie = veggie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isVeggie() {
        return veggie;
    }

    public void setVeggie(boolean veggie) {
        this.veggie = veggie;
    }




    public int getNumIngredients()
    {
        return ingredients.size();
    }



    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public boolean getVeggie() {
       return  veggie;
    }
}
