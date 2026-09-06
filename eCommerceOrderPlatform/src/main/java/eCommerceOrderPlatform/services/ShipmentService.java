package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Shipment;
import eCommerceOrderPlatform.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShipmentService {

    ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    // create
    public Long createShipment(String trackingNumber, String status) {
        Shipment shipment = new Shipment();
        shipment.setTrackingNumber(trackingNumber);
        shipment.setStatus(status);
        shipment.setShippedDate(new Date());
        shipment = shipmentRepository.save(shipment);
        return shipment.getId();
    }

    // get all
    public List<Shipment> getAllShipments() {
        return shipmentRepository.getAllShipments();
    }

    // get by id
    public Shipment getById(Long id) {
        Shipment shipment = shipmentRepository.getShipmentById(id);
        if (shipment == null) return new Shipment();
        return shipment;
    }

    // update
    public Shipment updateShipment(Long id, String trackingNumber, String status) {
        Shipment shipment = shipmentRepository.getShipmentById(id);
        if (shipment == null) return new Shipment();
        shipment.setTrackingNumber(trackingNumber);
        shipment.setStatus(status);
        return shipmentRepository.save(shipment);
    }

    // delete
    public Boolean deleteById(Long id) {
        Shipment shipment = shipmentRepository.getShipmentById(id);
        if (shipment == null) return false;
        shipment.setIsActive(false);
        shipment.setUpdatedDate(new Date());
        shipmentRepository.save(shipment);
        return true;
    }
}