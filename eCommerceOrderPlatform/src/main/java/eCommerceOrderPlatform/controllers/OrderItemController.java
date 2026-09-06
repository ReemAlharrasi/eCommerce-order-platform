package eCommerceOrderPlatform.controllers;

import eCommerceOrderPlatform.entities.OrderItem;
import eCommerceOrderPlatform.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orderItem")
public class OrderItemController {

    OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping("add")
    public Long addOrderItem(
            @RequestParam Integer quantity,
            @RequestParam Double unitPrice) {

        return orderItemService.createOrderItem(quantity, unitPrice);
    }

    @GetMapping("getAll")
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("getById")
    public OrderItem getById(@RequestParam Long id) {
        return orderItemService.getById(id);
    }

    @PutMapping("update")
    public OrderItem updateOrderItem(
            @RequestParam Long id,
            @RequestParam Integer quantity,
            @RequestParam Double unitPrice) {

        return orderItemService.updateOrderItem(
                id, quantity, unitPrice
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteOrderItem(@RequestParam Long id) {
        return orderItemService.deleteById(id);
    }
}