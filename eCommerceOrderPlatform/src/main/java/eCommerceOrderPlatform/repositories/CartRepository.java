package eCommerceOrderPlatform.repositories;

import eCommerceOrderPlatform.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    @Query("SELECT c FROM Cart c WHERE c.isActive=true")
    List<Cart> getAllCarts();

    @Query ("SELECT c FROM Cart c WHERE c.isActive=true AND c.id=:id")
    Cart getCartById(@Param("id") Long id);
}
