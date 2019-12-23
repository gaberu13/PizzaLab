package mk.finki.ukim.mk.lab.Web;


import mk.finki.ukim.mk.lab.Exeptions.TooManySpicyIngredientsException;
import mk.finki.ukim.mk.lab.Model.Ingredient;
import mk.finki.ukim.mk.lab.Model.Pizza;
import mk.finki.ukim.mk.lab.Services.Impl.IngredientsServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping(path = "/ingredients", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class ShowIngridients {

    private final IngredientsServiceImpl service;

    public ShowIngridients(IngredientsServiceImpl service) {
        this.service=service;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient AddIngredient(@RequestHeader String name,
                                    @RequestParam("spicy") Boolean spicy,
                                    @RequestParam("amount") float amount,
                                    @RequestParam("veggie") Boolean veggie,
                                    HttpServletResponse response,
                                    UriComponentsBuilder builder) throws TooManySpicyIngredientsException {

        Ingredient i = new Ingredient(name,spicy,amount,veggie, new ArrayList<Pizza>());
        Ingredient result = service.addIngredient(i);
        return result;
    }

    @PatchMapping("/{id}")
    public Ingredient EditIngredient(@PathVariable String id,
                                     @RequestParam("spicy") Boolean spicy,
                                     @RequestParam("amount") float amount,
                                     @RequestParam("veggie") Boolean veggie
    ) throws TooManySpicyIngredientsException {
        Ingredient i = new Ingredient(id,spicy,amount,veggie, new ArrayList<Pizza>());
        return service.editIngredient(id, i);
    }

    @DeleteMapping("/{id}")
    public void RemoveIngredient(@PathVariable String id)
    {
        service.removeIngredient(id);
    }

    @GetMapping("/{id}")
    public Ingredient GetIngredient(@PathVariable String id)
    {
        return service.getIngredient(id);
    }

    @GetMapping()
    public List<Ingredient> GetIngredients(){
        return service.getIngredients();
    }

    @GetMapping(params = "page, size")
    public Page<Ingredient> GetIngredientsPaged(@RequestParam int page, @RequestParam int size){
        return service.getIngredientsPaged(page,size);
    }

    @GetMapping(params = "spicy")
    public List<Ingredient> GetSpicyIngredients(@RequestParam Boolean spicy){
        return service.getSpicyIngredients();
    }

    @GetMapping("/{id}/pizzas")
    public List<Pizza> GetPizzasWithIngredient(@PathVariable("id") String id){
        return service.getPizzasWithIngredient(id);
    }


}
