package mk.finki.ukim.mk.lab.Services.Impl;

import mk.finki.ukim.mk.lab.Exeptions.InvalidIngredientException;
import mk.finki.ukim.mk.lab.Model.Ingredient;
import mk.finki.ukim.mk.lab.Model.Pizza;
import mk.finki.ukim.mk.lab.Repository.IngredientRepository;
import mk.finki.ukim.mk.lab.Services.IngredientsService;

import java.util.List;
import java.util.Optional;

public class IngredientsServiceImpl implements IngredientsService {
    private final IngredientRepository ingredientRepository;

    public IngredientsServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.listIngredients();
    }

    @Override
    public Ingredient addIngredient(String name, boolean spicy, float amount, boolean veggie, List<Pizza> pizzas) {
       Ingredient ingredient = new Ingredient(name,spicy,amount,veggie,pizzas);
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Optional<Ingredient> getIngredient(String name) {
        return ingredientRepository.getIngredient(name);
    }

    @Override
    public void deleteIngredient(String name) {
    ingredientRepository.getIngredient(name);
    }

    @Override
    public Ingredient updateIngredient(String name, boolean spicy, float amount, boolean veggie) {
        Ingredient ingredient = ingredientRepository.getIngredient(name).orElseThrow(InvalidIngredientException::new);
        ingredient.setName(name);
        ingredient.setSpicy(spicy);
        ingredient.setAmount(amount);
        ingredient.setVeggie(veggie);
        return this.ingredientRepository.save(ingredient);
    }
}
