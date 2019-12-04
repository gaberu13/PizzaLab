package mk.finki.ukim.mk.lab.Repository.jpa;

import mk.finki.ukim.mk.lab.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaIngredientRepository extends JpaRepository<Ingredient,String> {
}
