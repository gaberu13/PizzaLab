package mk.finki.ukim.mk.lab.Web;
import mk.finki.ukim.mk.lab.Exeptions.InvalidPizzaException;
import mk.finki.ukim.mk.lab.Model.Ingredient;
import mk.finki.ukim.mk.lab.Model.Pizza;
import mk.finki.ukim.mk.lab.Services.IngredientsService;
import mk.finki.ukim.mk.lab.Services.PizzaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pizzas")
public class ShowPizza {
  private final PizzaService pizzaService;
  private final IngredientsService ingredientsService;

  public ShowPizza(PizzaService pizzaService, IngredientsService ingredientsService) {
    this.pizzaService = pizzaService;
    this.ingredientsService = ingredientsService;
  }

  @GetMapping
  public List<Pizza> getAllPizzas(){
    return this.pizzaService.getAllPizzas();
  }

  @PostMapping
  public Pizza createPizza(@RequestParam String name,
                           @RequestParam("ingredients") ArrayList<Ingredient> list,
                           @RequestParam boolean veggie,
                           HttpServletResponse response,
                           UriComponentsBuilder builder){
    Pizza result = new Pizza(name,list,veggie);
    response.setHeader("Location", String.valueOf(builder.path("/api/pizzas/{id}").buildAndExpand(builder.toUriString())));
    return result;
  }

  @GetMapping("/{id}")
  public Pizza getPizza(@PathVariable String name){
    return this.pizzaService.getPizza(name).orElseThrow(InvalidPizzaException::new);
  }

  // Return pizzas that have total ingredients less than given parameter
  @GetMapping
  public List<Pizza> getPizzasWithIngredientsLessThan(@RequestParam int totalIngredients){
    return this.pizzaService.getAllPizzas().stream().filter(p -> p.getIngredients().size() < totalIngredients).collect(Collectors.toList());
  }

  // Put method in background deletes the current object and creates a new one with the given parameters
  @PutMapping("/{id}")
  public Pizza editPizza(@RequestParam String name,
                         @RequestParam ArrayList<Ingredient> ingredients,
                         @RequestParam boolean veggie){
    Pizza oldPizza = this.pizzaService.getPizza(name).orElseThrow(InvalidPizzaException::new);
    Pizza newPizza = new Pizza(name,ingredients,veggie);
    this.pizzaService.deletePizza(oldPizza);
    return this.pizzaService.addPizza(newPizza);
  }

  @DeleteMapping("/{id}")
  public void deletePizza(@PathVariable String name){
    this.pizzaService.deletePizza(name);
  }

  // Return the common ingredients of two pizzas
  @GetMapping("/compare")
  public List<Ingredient> comparePizzasByIngredients(@RequestParam String pizzaName1,
                                                     @RequestParam String pizzaName2){
    List<Ingredient> commonIngredients = new ArrayList<>();
    Pizza pizza_1 = this.pizzaService.getPizza(pizzaName1).orElseThrow(InvalidPizzaException::new);
    Pizza pizza_2 = this.pizzaService.getPizza(pizzaName2).orElseThrow(InvalidPizzaException::new);
    for(Ingredient ingredient : pizza_1.getIngredients()){
      for(Ingredient ingredient1 : pizza_2.getIngredients()){
        if(ingredient.getName().compareTo(ingredient1.getName())==0){
          commonIngredients.add(ingredient);
          break;
        }
      }
    }
    return commonIngredients;
  }
}
