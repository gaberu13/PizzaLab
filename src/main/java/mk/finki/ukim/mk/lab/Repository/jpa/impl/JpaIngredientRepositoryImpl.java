package mk.finki.ukim.mk.lab.Repository.jpa.impl;

import mk.finki.ukim.mk.lab.Model.Ingredient;
import mk.finki.ukim.mk.lab.Repository.IngredientRepository;
import mk.finki.ukim.mk.lab.Repository.jpa.JpaIngredientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaIngredientRepositoryImpl implements IngredientRepository {
    private final JpaIngredientRepository jpaIngredientRepository;

    public JpaIngredientRepositoryImpl(JpaIngredientRepository jpaIngredientRepository) {
        this.jpaIngredientRepository = jpaIngredientRepository;
    }

    @Override
    public List<Ingredient> listIngredients() {
        return jpaIngredientRepository.findAll();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return jpaIngredientRepository.save(ingredient);
    }

    @Override
    public Optional<Ingredient> getIngredient(String name) {
        return jpaIngredientRepository.findById(name);
    }

    @Override
    public void deleteIngredient(String name) {
    jpaIngredientRepository.deleteById(name);
    }
}
