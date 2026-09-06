package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Payment;
import eCommerceOrderPlatform.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaymentService {

    PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // create
    public Long createPayment(Double amount, String method, String status) {
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setMethod(method);
        payment.setStatus(status);
        payment.setPaidDate(new Date());
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
    public Payment updatePayment(Long id, Double amount, String method, String status) {
        Payment payment = paymentRepository.getPaymentById(id);
        if (payment == null) return new Payment();
        payment.setAmount(amount);
        payment.setMethod(method);
        payment.setStatus(status);
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
}