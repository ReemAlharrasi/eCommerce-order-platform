package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Order;
import eCommerceOrderPlatform.entities.OrderItem;
import eCommerceOrderPlatform.entities.Product;
import eCommerceOrderPlatform.repositories.OrderItemRepository;
import eCommerceOrderPlatform.repositories.OrderRepository;
import eCommerceOrderPlatform.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderItemService {

    OrderItemRepository orderItemRepository;
    OrderRepository orderRepository;
    ProductRepository productRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository,
                            OrderRepository orderRepository,
                            ProductRepository productRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    // create
    public Long createOrderItem(Integer quantity, Double unitPrice, Long orderId, Long productId) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(quantity);
        orderItem.setUnitPrice(unitPrice);
        orderItem.setOrder(resolveOrder(orderId));
        orderItem.setProduct(resolveProduct(productId));
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
    public OrderItem updateOrderItem(Long id, Integer quantity, Double unitPrice, Long orderId, Long productId) {
        OrderItem orderItem = orderItemRepository.getOrderItemById(id);
        if (orderItem == null) return new OrderItem();
        orderItem.setQuantity(quantity);
        orderItem.setUnitPrice(unitPrice);
        orderItem.setOrder(resolveOrder(orderId));
        orderItem.setProduct(resolveProduct(productId));
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

    private Order resolveOrder(Long orderId) {
        if (orderId == null) return null;
        return orderRepository.getOrderById(orderId);
    }

    private Product resolveProduct(Long productId) {
        if (productId == null) return null;
        return productRepository.getProductById(productId);
    }
}
