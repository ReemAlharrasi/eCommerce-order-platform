package eCommerceOrderPlatform.controllers;

import eCommerceOrderPlatform.entities.Shipment;
import eCommerceOrderPlatform.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shipment")
public class ShipmentController {

    ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping("add")
    public Long addShipment(
            @RequestParam String trackingNumber,
            @RequestParam String status) {

        return shipmentService.createShipment(
                trackingNumber, status
        );
    }

    @GetMapping("getAll")
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @GetMapping("getById")
    public Shipment getById(@RequestParam Long id) {
        return shipmentService.getById(id);
    }

    @PutMapping("update")
    public Shipment updateShipment(
            @RequestParam Long id,
            @RequestParam String trackingNumber,
            @RequestParam String status) {

        return shipmentService.updateShipment(
                id, trackingNumber, status
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteShipment(@RequestParam Long id) {
        return shipmentService.deleteById(id);
    }
}