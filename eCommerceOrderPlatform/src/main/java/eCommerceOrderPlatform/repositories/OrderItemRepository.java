package eCommerceOrderPlatform.repositories;

import eCommerceOrderPlatform.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

    @Query("SELECT o FROM OrderItem o WHERE o.isActive=true")
    List<OrderItem> getAllOrderItems();

    @Query ("SELECT o FROM OrderItem o WHERE o.isActive=true AND o.id=:id")
    OrderItem getOrderItemById(@Param("id") Long id);
}
