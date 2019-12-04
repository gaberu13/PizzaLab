package mk.finki.ukim.mk.lab.Repository.jpa.impl;

import mk.finki.ukim.mk.lab.Model.Pizza;
import mk.finki.ukim.mk.lab.Repository.PizzaRepository;
import mk.finki.ukim.mk.lab.Repository.jpa.JpaPizzaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaPizzaRepositoryImpl  implements PizzaRepository {
    private final JpaPizzaRepository jpaPizzaRepository;

    public JpaPizzaRepositoryImpl(JpaPizzaRepository jpaPizzaRepository) {
        this.jpaPizzaRepository = jpaPizzaRepository;
    }

    @Override
    public List<Pizza> listPizzas() {
        return jpaPizzaRepository.findAll();
    }

    @Override
    public Pizza savePizza(Pizza pizza) {
        return jpaPizzaRepository.save(pizza);
    }

    @Override
    public Optional<Pizza> getPizzaByName(String name) {
        return jpaPizzaRepository.findById(name);
    }

    @Override
    public void deletePizza(String name) {
    jpaPizzaRepository.deleteById(name);
    }

    @Override
    public void deletePizza(Pizza pizza) {
        jpaPizzaRepository.delete(pizza);
    }
}
