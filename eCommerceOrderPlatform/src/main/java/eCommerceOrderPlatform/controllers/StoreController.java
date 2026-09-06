package eCommerceOrderPlatform.controllers;

import eCommerceOrderPlatform.entities.Store;
import eCommerceOrderPlatform.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("store")
public class StoreController {

    StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("add")
    public Long addStore(@RequestParam String name, @RequestParam String location){
        return storeService.createStore(name,location);
    }

    @GetMapping("getAll")
    public List<Store> getAllStores(){
        return storeService.getAllStores();
    }

    @GetMapping("getById")
    public Store getById(@RequestParam Long id){
        return storeService.getById(id);
    }

    @PutMapping("update")
    public Store updateStore(@RequestParam Long id,@RequestParam String name, @RequestParam String location){
        return storeService.updateStore(id,name,location);
    }

    @DeleteMapping("delete")
    public Boolean deleteStore(@RequestParam Long id) {
        return storeService.deleteById(id);
    }
}
