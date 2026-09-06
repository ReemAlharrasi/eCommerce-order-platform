package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Order;
import eCommerceOrderPlatform.entities.Shipment;
import eCommerceOrderPlatform.repositories.OrderRepository;
import eCommerceOrderPlatform.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShipmentService {

    ShipmentRepository shipmentRepository;
    OrderRepository orderRepository;

    @Autowired
    public ShipmentService(ShipmentRepository shipmentRepository, OrderRepository orderRepository) {
        this.shipmentRepository = shipmentRepository;
        this.orderRepository = orderRepository;
    }

    // create
    public Long createShipment(String trackingNumber, String status, Long orderId) {
        Shipment shipment = new Shipment();
        shipment.setTrackingNumber(trackingNumber);
        shipment.setStatus(status);
        shipment.setShippedDate(new Date());
        shipment.setOrder(resolveOrder(orderId));
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
    public Shipment updateShipment(Long id, String trackingNumber, String status, Long orderId) {
        Shipment shipment = shipmentRepository.getShipmentById(id);
        if (shipment == null) return new Shipment();
        shipment.setTrackingNumber(trackingNumber);
        shipment.setStatus(status);
        shipment.setOrder(resolveOrder(orderId));
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

    private Order resolveOrder(Long orderId) {
        if (orderId == null) return null;
        return orderRepository.getOrderById(orderId);
    }
}
