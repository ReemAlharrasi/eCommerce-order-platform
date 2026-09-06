package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Order;
import eCommerceOrderPlatform.entities.Payment;
import eCommerceOrderPlatform.repositories.OrderRepository;
import eCommerceOrderPlatform.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaymentService {

    PaymentRepository paymentRepository;
    OrderRepository orderRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    // create
    public Long createPayment(Double amount, String method, String status, Long orderId) {
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setMethod(method);
        payment.setStatus(status);
        payment.setPaidDate(new Date());
        payment.setOrder(resolveOrder(orderId));
        payment = paymentRepository.save(payment);
        return payment.getId();
    }

    // get all
    public List<Payment> getAllPayments() {
        return paymentRepository.getAllPayments();
    }

    // get by id
    public Payment getById(Long id) {
        Payment payment = paymentRepository.getPaymentById(id);
        if (payment == null) return new Payment();
        return payment;
    }

    // update
    public Payment updatePayment(Long id, Double amount, String method, String status, Long orderId) {
        Payment payment = paymentRepository.getPaymentById(id);
        if (payment == null) return new Payment();
        payment.setAmount(amount);
        payment.setMethod(method);
        payment.setStatus(status);
        payment.setOrder(resolveOrder(orderId));
        return paymentRepository.save(payment);
    }

    // delete
    public Boolean deleteById(Long id) {
        Payment payment = paymentRepository.getPaymentById(id);
        if (payment == null) return false;
        payment.setIsActive(false);
        payment.setUpdatedDate(new Date());
        paymentRepository.save(payment);
        return true;
    }

    private Order resolveOrder(Long orderId) {
        if (orderId == null) return null;
        return orderRepository.getOrderById(orderId);
    }
}
