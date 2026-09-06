package eCommerceOrderPlatform.repositories;

import eCommerceOrderPlatform.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order,Long> {

    @Query("SELECT o FROM Order o WHERE o.isActive=true")
    List<Order> getAllOrders();

    @Query ("SELECT o FROM Order o WHERE o.isActive=true AND o.id=:id")
    Order getOrderById(@Param("id") Long id);
}
