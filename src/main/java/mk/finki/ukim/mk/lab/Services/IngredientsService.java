package mk.finki.ukim.mk.lab.Services;

import mk.finki.ukim.mk.lab.Model.Ingredient;
import mk.finki.ukim.mk.lab.Model.Pizza;

import java.util.List;
import java.util.Optional;

public interface IngredientsService {
    List<Ingredient> getAllIngredients();
    Ingredient addIngredient(String name, boolean spicy, float amount, boolean veggie, List<Pizza> pizzas);
    Ingredient addIngredient(Ingredient ingredient);
    Optional<Ingredient> getIngredient(String name);
    void deleteIngredient(String name);
    Ingredient updateIngredient(String name,boolean spicy,float amount,boolean veggie);
}
