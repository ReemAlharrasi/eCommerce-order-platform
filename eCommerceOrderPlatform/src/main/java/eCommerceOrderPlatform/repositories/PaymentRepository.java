package eCommerceOrderPlatform.repositories;

import eCommerceOrderPlatform.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository  extends JpaRepository<Payment,Long> {
    @Query("SELECT p FROM Payment p WHERE p.isActive=true")
    List<Payment> getAllPayments();

    @Query ("SELECT p FROM Payment p WHERE p.isActive=true AND p.id=:id")
    Payment getPaymentById(@Param("id") Long id);
}
