package mk.finki.ukim.mk.lab.Services;
import mk.finki.ukim.mk.lab.Model.Order;


public interface OrderService  {
    Order placeOrder(String pizzaType, String clientName, String address);
}
