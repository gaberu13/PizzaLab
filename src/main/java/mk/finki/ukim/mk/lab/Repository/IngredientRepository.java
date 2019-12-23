package mk.finki.ukim.mk.lab.Repository;

import mk.finki.ukim.mk.lab.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
