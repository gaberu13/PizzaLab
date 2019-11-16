package mk.finki.ukim.mk.lab.Web;

import lombok.extern.slf4j.Slf4j;
import mk.finki.ukim.mk.lab.Model.Pizza;
import mk.finki.ukim.mk.lab.Repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class ShowPizza {
  @GetMapping
    public String showPizzas(Model model){
    List<Pizza> pizzas;
    final PizzaRepository pizzaRepository = new PizzaRepository();
    pizzas = pizzaRepository.getAllPizzas();
      model.addAttribute("pizzas",pizzas);
      return "listPizzas";
  }
}
