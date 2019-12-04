package mk.finki.ukim.mk.lab.Repository.jpa;

import mk.finki.ukim.mk.lab.Model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPizzaRepository  extends JpaRepository<Pizza,String> {
}
