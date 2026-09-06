package eCommerceOrderPlatform.repositories;

import eCommerceOrderPlatform.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {

    @Query ("SELECT s FROM Store s WHERE s.isActive=true")
    List<Store> getAllStores();

    @Query ("SELECT s FROM Store s WHERE s.isActive=true AND s.id=:id")
    Store getStoreById(@Param("id") Long id);
}
