package mk.finki.ukim.mk.lab.Repository;

import mk.finki.ukim.mk.lab.Model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza, String> {
}
