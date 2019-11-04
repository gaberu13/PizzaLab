package mk.finki.ukim.mk.lab.Web;

import mk.finki.ukim.mk.lab.Services.PizzaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="show-pizza",urlPatterns = "/")
public class ShowPizza extends HttpServlet {
    private final PizzaService pizzaService;

    public ShowPizza(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
