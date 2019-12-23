package mk.finki.ukim.mk.lab.Web;
import mk.finki.ukim.mk.lab.Exeptions.NotAVeggiePizzaException;
import mk.finki.ukim.mk.lab.Model.Ingredient;
import mk.finki.ukim.mk.lab.Model.Pizza;
import mk.finki.ukim.mk.lab.Services.PizzaService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping(path = "/pizzas", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class ShowPizza {

  private final PizzaService service;

  public ShowPizza(PizzaService service) {
    this.service = service;
  }

  @PostMapping
  public Pizza AddPizza(@RequestParam("name") String name,
                        @RequestParam(value = "veggie", defaultValue = "false", required = false) Boolean veggie,
                        @RequestParam("description")String description,
                        @RequestParam("ingredients") List<Ingredient> ingredients) throws NotAVeggiePizzaException {
    Pizza pizza = new Pizza(name,ingredients, veggie, description);
    return service.addPizza(pizza);
  }

  @PutMapping("/{id}")
  public Pizza EditPizza(@RequestParam("name") String name,
                         @RequestParam("veggie")Boolean veggie,
                         @RequestParam("description")String description
  ) throws NotAVeggiePizzaException {
    Pizza pizza = new Pizza(name,new ArrayList<Ingredient>(), veggie, description);
    return service.editPizza(name,pizza);
  }

  @DeleteMapping("/{id}")
  public void RemovePizza(@PathVariable String id)
  {
    service.removePizza(id);
  }

  @GetMapping("/{id}")
  public Pizza GetPizza(@PathVariable String id)
  {
    return service.getPizza(id);
  }

  @GetMapping()
  public List<Pizza> GetPizzas(){
    return service.getPizzas();
  }

  @GetMapping("/compare")
  public List<Ingredient> CompareIngredients(@RequestParam("pizza1") String pizza1,
                                             @RequestParam("pizza2") String pizza2){
    return service.compareIngredients(pizza1,pizza2);
  }

  @GetMapping(params = "totalIngredients")
  public List<Pizza> GetPizzasLessIngredients(@RequestParam("totalIngredients") int numIngredients){
    return service.getPizzasLessIngredients(numIngredients);
  }

}