package mk.finki.ukim.mk.lab.Repository;

import mk.finki.ukim.mk.lab.Model.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {
    List<Ingredient> listIngredients();
    Ingredient save(Ingredient ingredient);
    Optional<Ingredient> getIngredient(String name);
    void deleteIngredient(String name);
}
