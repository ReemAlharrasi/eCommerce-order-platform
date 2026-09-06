package eCommerceOrderPlatform.repositories;

import eCommerceOrderPlatform.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("SELECT c FROM Customer c WHERE c.isActive=true")
    List<Customer> getAllCustomers();

    @Query ("SELECT c FROM Customer c WHERE c.isActive=true AND c.id=:id")
    Customer getCustomerById(@Param("id") Long id);
}
