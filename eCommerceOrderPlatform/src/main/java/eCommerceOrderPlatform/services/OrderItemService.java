package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.OrderItem;
import eCommerceOrderPlatform.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderItemService {

    OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    // create
    public Long createOrderItem(Integer quantity, Double unitPrice) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(quantity);
        orderItem.setUnitPrice(unitPrice);
        orderItem = orderItemRepository.save(orderItem);
        return orderItem.getId();
    }

    // get all
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.getAllOrderItems();
    }

    // get by id
    public OrderItem getById(Long id) {
        OrderItem orderItem = orderItemRepository.getOrderItemById(id);
        if (orderItem == null) return new OrderItem();
        return orderItem;
    }

    // update
    public OrderItem updateOrderItem(Long id, Integer quantity, Double unitPrice) {
        OrderItem orderItem = orderItemRepository.getOrderItemById(id);
        if (orderItem == null) return new OrderItem();
        orderItem.setQuantity(quantity);
        orderItem.setUnitPrice(unitPrice);
        return orderItemRepository.save(orderItem);
    }

    // delete
    public Boolean deleteById(Long id) {
        OrderItem orderItem = orderItemRepository.getOrderItemById(id);
        if (orderItem == null) return false;
        orderItem.setIsActive(false);
        orderItem.setUpdatedDate(new Date());
        orderItemRepository.save(orderItem);

        return true;
    }
}