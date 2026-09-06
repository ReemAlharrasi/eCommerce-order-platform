package eCommerceOrderPlatform.repositories;

import eCommerceOrderPlatform.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository  extends JpaRepository<CartItem,Long> {

    @Query("SELECT c FROM CartItem c WHERE c.isActive=true")
    List<CartItem> getAllCartItems();

    @Query ("SELECT c FROM CartItem c WHERE c.isActive=true AND c.id=:id")
    CartItem getCartItemById(@Param("id") Long id);
}
