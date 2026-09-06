package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Customer;
import eCommerceOrderPlatform.entities.Order;
import eCommerceOrderPlatform.repositories.CustomerRepository;
import eCommerceOrderPlatform.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;
    CustomerRepository customerRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    // create
    public Long createOrder(String status, Double totalAmount, Long customerId) {
        Order order = new Order();
        order.setOrderDate(new Date());
        order.setStatus(status);
        order.setTotalAmount(totalAmount);
        order.setCustomer(resolveCustomer(customerId));
        order = orderRepository.save(order);
        return order.getId();
    }

    // get all
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    // get by id
    public Order getById(Long id) {
        Order order = orderRepository.getOrderById(id);
        if (order == null) return new Order();
        return order;
    }

    // update
    public Order updateOrder(Long id, String status, Double totalAmount, Long customerId) {
        Order order = orderRepository.getOrderById(id);
        if (order == null) return new Order();
        order.setStatus(status);
        order.setTotalAmount(totalAmount);
        order.setCustomer(resolveCustomer(customerId));
        return orderRepository.save(order);
    }

    // delete
    public Boolean deleteById(Long id) {
        Order order = orderRepository.getOrderById(id);
        if (order == null) return false;
        order.setIsActive(false);
        order.setUpdatedDate(new Date());
        orderRepository.save(order);
        return true;
    }

    private Customer resolveCustomer(Long customerId) {
        if (customerId == null) return null;
        return customerRepository.getCustomerById(customerId);
    }
}
