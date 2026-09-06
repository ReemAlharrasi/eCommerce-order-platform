package eCommerceOrderPlatform.repositories;

import eCommerceOrderPlatform.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    @Query("SELECT a FROM Address a WHERE a.isActive=true")
    List<Address> getAllAddresses();

    @Query ("SELECT a FROM Address a WHERE a.isActive=true AND a.id=:id")
    Address getAddressById(@Param("id") Long id);
}
