package mk.finki.ukim.mk.lab.bootstrap;

import lombok.Getter;
import mk.finki.ukim.mk.lab.Model.Ingredient;
import mk.finki.ukim.mk.lab.Model.Pizza;
import mk.finki.ukim.mk.lab.Repository.jpa.JpaIngredientRepository;
import mk.finki.ukim.mk.lab.Repository.jpa.JpaPizzaRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter

public class DataHolder {
    public static final List<Pizza> pizzas =new ArrayList<>();
    public static final List<Ingredient> ingredients =new ArrayList<>();
    private final JpaPizzaRepository jpaPizzaRepository;
    private final JpaIngredientRepository jpaIngredientRepository;

    public DataHolder(JpaPizzaRepository jpaPizzaRepository, JpaIngredientRepository jpaIngredientRepository) {
        this.jpaPizzaRepository = jpaPizzaRepository;
        this.jpaIngredientRepository = jpaIngredientRepository;
    }
    @PostConstruct
    public void init(){
        Ingredient tomato_sauce = new Ingredient("tomato sauce",true,100,true,new ArrayList<>());
        Ingredient fresh_cream = new Ingredient("fresh cream",true,500,false,new ArrayList<>());
        Ingredient mozzarella = new Ingredient("mozzarella",false,500,false,new ArrayList<>());
        Ingredient bacon = new Ingredient("bacon",true,100,true,new ArrayList<>());
        Ingredient dough = new Ingredient("dough",true,100,true,new ArrayList<>());
        Ingredient mushrooms = new Ingredient("mushrooms",true,100,true,new ArrayList<>());
        Ingredient ricotta = new Ingredient("ricotta",true,100,true,new ArrayList<>());
        Ingredient pizza_sauce = new Ingredient("pizza sauce",true,100,true,new ArrayList<>());
        Ingredient olive_oil = new Ingredient("olive oli",true,100,true,new ArrayList<>());
        Ingredient pepperoni = new Ingredient("pepperoni",true,100,true,new ArrayList<>());
        Ingredient cheddar = new Ingredient("cheddar",true,100,true,new ArrayList<>());
        Ingredient cheese = new Ingredient("cheese",true,100,true,new ArrayList<>());
        Ingredient ham = new Ingredient("ham",true,100,true,new ArrayList<>());
        Ingredient onions = new Ingredient("onions",true,100,true,new ArrayList<>());
        Ingredient barbecue_sauce = new Ingredient("barbecue sauce",true,100,true,new ArrayList<>());
        Ingredient chicken_meat = new Ingredient("chicken meat",true,100,true,new ArrayList<>());
        Ingredient taleggio = new Ingredient("tomato taleggio",true,100,true,new ArrayList<>());
        Ingredient sausage = new Ingredient("sausage",true,100,true,new ArrayList<>());
        Ingredient gorgonzola = new Ingredient("gorgonzola",true,100,true,new ArrayList<>());
        Ingredient parmesan = new Ingredient("parmesan",true,100,true,new ArrayList<>());
        Ingredient beef = new Ingredient("beef",true,100,true,new ArrayList<>());
        Ingredient mascarpone = new Ingredient("mascarpone",true,100,true,new ArrayList<>());

        ingredients.add(tomato_sauce);
        ingredients.add(fresh_cream);
        ingredients.add(mozzarella);
        ingredients.add(bacon);
        ingredients.add(dough);
        ingredients.add(mushrooms);
        ingredients.add(ricotta);
        ingredients.add(pizza_sauce);
        ingredients.add(olive_oil);
        ingredients.add(pepperoni);
        ingredients.add(cheese);
        ingredients.add(cheddar);
        ingredients.add(ham);
        ingredients.add(onions);
        ingredients.add(barbecue_sauce);
        ingredients.add(chicken_meat);
        ingredients.add(taleggio);
        ingredients.add(sausage);
        ingredients.add(gorgonzola);
        ingredients.add(parmesan);
        ingredients.add(beef);
        ingredients.add(mascarpone);

        if(this.jpaPizzaRepository.count() == 0 && this.jpaIngredientRepository.count() == 0) {
            this.jpaPizzaRepository.saveAll(pizzas);
            this.jpaIngredientRepository.saveAll(ingredients);
        }

    }
}
