package mk.finki.ukim.mk.lab.Services.Impl;

import mk.finki.ukim.mk.lab.Exeptions.TooManySpicyIngredientsException;
import mk.finki.ukim.mk.lab.Model.Ingredient;
import mk.finki.ukim.mk.lab.Model.Pizza;
import mk.finki.ukim.mk.lab.Repository.IngredientRepository;
import mk.finki.ukim.mk.lab.Services.IngredientsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    private final IngredientRepository ingredientRepository;


    public IngredientsServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) throws TooManySpicyIngredientsException {

        if(ingredient.getSpicy()) {
            checkSpicyIngredients();
        }

        checkIngredient(ingredient);

        return ingredientRepository.save(ingredient);
    }

    private void checkSpicyIngredients() throws TooManySpicyIngredientsException {
        if(getSpicyIngredients().size()>=3){
            throw new TooManySpicyIngredientsException();
        }
    }

    private void checkIngredient(Ingredient ingredient) {
        ingredientRepository.findById(ingredient.getName()).orElseThrow(RuntimeException::new);
    }



    @Override
    public void removeIngredient(String name) {
        ingredientRepository.deleteById(name);
    }

    @Override
    public Ingredient getIngredient(String name) {
        return ingredientRepository.findById(name).orElseThrow(RuntimeException::new);
    }

    @Override
    public Ingredient editIngredient(String name, Ingredient ingredient) throws TooManySpicyIngredientsException {

        if(!this.getIngredient(name).getSpicy() && ingredient.getSpicy())
            checkSpicyIngredients();

        this.removeIngredient(name);
        return ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public Page<Ingredient> getIngredientsPaged(int page, int size) {
        return ingredientRepository.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    @Override
    public List<Ingredient> getSpicyIngredients() {
        return ingredientRepository.findAll().stream().filter(Ingredient::getSpicy).collect(Collectors.toList());
    }

    @Override
    public List<Pizza> getPizzasWithIngredient(String name) {
        Ingredient ingredient = ingredientRepository.findById(name).orElseThrow(RuntimeException::new);
        return ingredient.getPizzas();
    }
}
