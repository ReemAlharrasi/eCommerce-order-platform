package eCommerceOrderPlatform.controllers;

import eCommerceOrderPlatform.entities.Order;
import eCommerceOrderPlatform.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("add")
    public Long addOrder(
            @RequestParam String status,
            @RequestParam Double totalAmount,
            @RequestParam(required = false) Long customerId) {

        return orderService.createOrder(status, totalAmount, customerId);
    }

    @GetMapping("getAll")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("getById")
    public Order getById(@RequestParam Long id) {
        return orderService.getById(id);
    }

    @PutMapping("update")
    public Order updateOrder(
            @RequestParam Long id,
            @RequestParam String status,
            @RequestParam Double totalAmount,
            @RequestParam(required = false) Long customerId) {

        return orderService.updateOrder(
                id, status, totalAmount, customerId
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteOrder(@RequestParam Long id) {
        return orderService.deleteById(id);
    }
}
