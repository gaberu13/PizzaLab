package mk.finki.ukim.mk.lab.Services.Impl;

import mk.finki.ukim.mk.lab.Model.Order;
import mk.finki.ukim.mk.lab.Services.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order placeOrder(String pizzaType, String clientName, String address) {
        return null;
    }
}
