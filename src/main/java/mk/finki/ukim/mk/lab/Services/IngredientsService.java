package mk.finki.ukim.mk.lab.Services;

import mk.finki.ukim.mk.lab.Exeptions.TooManySpicyIngredientsException;
import mk.finki.ukim.mk.lab.Model.Ingredient;
import mk.finki.ukim.mk.lab.Model.Pizza;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IngredientsService {
    public Ingredient addIngredient (Ingredient ingredient) throws TooManySpicyIngredientsException;

    public void removeIngredient(String name);

    public Ingredient getIngredient(String name);

    public Ingredient editIngredient (String name,Ingredient ingredient) throws TooManySpicyIngredientsException;

    public List<Ingredient> getIngredients();

    public Page<Ingredient> getIngredientsPaged(int page, int size);

    public List<Ingredient> getSpicyIngredients();

    public List<Pizza> getPizzasWithIngredient(String name);
}
