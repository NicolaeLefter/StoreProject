package com.example.StoreProject.service.deliveryService;

import com.example.StoreProject.entity.store.DeliveryMonitoring;
import com.example.StoreProject.repository.deliveryRepository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeliveryServiceImpl {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Transactional
    public ResponseEntity<Object> updateDelivery(DeliveryMonitoring deliveryMonitoring, Integer id) {
        DeliveryMonitoring delivery = deliveryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Nu a fost gasita comanda cu id-ul: " + id));
        Map<Object, String> map = new HashMap<>();

        if (deliveryMonitoring.getAddress().isEmpty()) {
            map.put(deliveryMonitoring.getAddress(), "Adresa de livrare este obligatorie!");
        } else {
            delivery.setAddress(deliveryMonitoring.getAddress());
        }
        if (deliveryMonitoring.getNameClient().isEmpty()) {
            map.put(deliveryMonitoring.getNameClient(), "Introduceti numele clientului!");
        } else {
            delivery.setNameClient(deliveryMonitoring.getNameClient());
        }
        delivery.setPhoneNumber(deliveryMonitoring.getPhoneNumber());
        delivery.setStatusOrder(deliveryMonitoring.getStatusOrder());
        if (!map.isEmpty()) {
            throw new RuntimeException("S-a produs o eroare la actualizarea comenzii!" + map);
        }
        return ResponseEntity.ok("Delivery update succesfull!");
    }
}
