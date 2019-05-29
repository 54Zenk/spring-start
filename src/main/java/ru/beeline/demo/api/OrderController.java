package ru.beeline.demo.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.beeline.demo.entity.Orderz;
import ru.beeline.demo.service.OrderService;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrder")
    public Orderz getOrderById(@RequestParam Long id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/getAllOrders")
    public List<Orderz> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/createOrder")
    public void createOrder(@RequestBody Orderz orderz) {
        orderService.save(orderz);
    }
}
