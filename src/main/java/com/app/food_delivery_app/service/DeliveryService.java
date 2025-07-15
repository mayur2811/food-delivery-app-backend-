package com.app.food_delivery_app.service;

import com.app.food_delivery_app.model.Delivery;
import com.app.food_delivery_app.repository.DeliveryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> getDeliveryById(Long deliveryId) {
        return deliveryRepository.findById(deliveryId);
    }

    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Delivery updateDelivery(Long deliveryId, Delivery deliveryDetails) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new RuntimeException("Delivery not found with id " + deliveryId));
        delivery.setDeliveryAddress(deliveryDetails.getDeliveryAddress());
        delivery.setDeliveryStatus(deliveryDetails.getDeliveryStatus());
        delivery.setDeliveryPerson(deliveryDetails.getDeliveryPerson());
        return deliveryRepository.save(delivery);
    }

    public void deleteDelivery(Long deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new RuntimeException("Delivery not found with id " + deliveryId));
        deliveryRepository.delete(delivery);
    }
}