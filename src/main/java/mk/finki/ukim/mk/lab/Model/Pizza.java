package mk.finki.ukim.mk.lab.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    private String name;
    private String description;
    private List<Ingredient> ingredients;
    private boolean veggie;

}
