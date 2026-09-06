package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Store;
import eCommerceOrderPlatform.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StoreService {
    StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    //create
    public Long createStore(String name, String location){
        Store store = new Store();
        store.setName(name);
        store.setLocation(location);
        store.setIsActive(true);
        store.setCreatedDate(new Date());
        store.setUpdatedDate(new Date());
        store=storeRepository.save(store);
        return store.getId();
    }

    //get all
    public List<Store> getAllStores(){
        return storeRepository.getAllStores();
    }

    //get by id
    public Store getById(Long id){
        Store store = storeRepository.getStoreById(id);
        if (store == null) return new Store();
        return store;
    }

    //update
    public Store updateStore(Long id, String name, String location){
        Store store = storeRepository.getStoreById(id);
        if (store == null) return new Store();
        store.setName(name);
        store.setLocation(location);
        store.setUpdatedDate(new Date());
        store=storeRepository.save(store);
        return store;
    }

    //delete
    public Boolean deleteById(Long id){
        Store store = storeRepository.getStoreById(id);
        if (store == null) return false;
        store.setIsActive(false);
        store.setUpdatedDate(new Date());
        storeRepository.save(store);
        return true;
    }
}
