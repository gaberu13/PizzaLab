package mk.finki.ukim.mk.lab.Web;

import lombok.extern.slf4j.Slf4j;
import mk.finki.ukim.mk.lab.Model.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class ShowPizza {
  @GetMapping
    public String showPizzas(Model model){
      List<Pizza> pizzas = Arrays.asList(
              new Pizza("Margherita ","tomato sauce, mozzarella"),
              new Pizza("Carbonara ","fresh cream, mozzarella, bacon"),
              new Pizza("Vegetariana ","tomato sauce, mushrooms"),
              new Pizza("Calzone ","Pizza dough, ricotta, pepperoni, pizza sauce, olive oil"),
              new Pizza("Cheddar  ","cheddar, tomato sauce"),
              new Pizza("Capricciosa  ","fresh cream, mozzarella, bacon")
      );
      model.addAttribute("pizzas",pizzas);
      return "listPizzas";
  }
}
