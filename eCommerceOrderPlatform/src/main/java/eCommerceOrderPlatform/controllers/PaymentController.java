package eCommerceOrderPlatform.controllers;

import eCommerceOrderPlatform.entities.Payment;
import eCommerceOrderPlatform.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment")
public class PaymentController {

    PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("add")
    public Long addPayment(
            @RequestParam Double amount,
            @RequestParam String method,
            @RequestParam String status,
            @RequestParam(required = false) Long orderId) {

        return paymentService.createPayment(
                amount, method, status, orderId
        );
    }

    @GetMapping("getAll")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("getById")
    public Payment getById(@RequestParam Long id) {
        return paymentService.getById(id);
    }

    @PutMapping("update")
    public Payment updatePayment(
            @RequestParam Long id,
            @RequestParam Double amount,
            @RequestParam String method,
            @RequestParam String status,
            @RequestParam(required = false) Long orderId) {

        return paymentService.updatePayment(
                id, amount, method, status, orderId
        );
    }

    @DeleteMapping("delete")
    public Boolean deletePayment(@RequestParam Long id) {
        return paymentService.deleteById(id);
    }
}
