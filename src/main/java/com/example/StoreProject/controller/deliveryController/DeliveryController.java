package com.example.StoreProject.controller.deliveryController;

import com.example.StoreProject.entity.store.DeliveryMonitoring;
import com.example.StoreProject.repository.deliveryRepository.DeliveryRepository;
import com.example.StoreProject.service.deliveryService.DeliveryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/delivery")
public class DeliveryController {
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    DeliveryServiceImpl deliveryService;

    @PostMapping("/save")
    public ResponseEntity<Object> addDelivery(@RequestBody DeliveryMonitoring deliveryMonitoring) {
        return ResponseEntity.status(HttpStatus.OK).body(deliveryRepository.save(deliveryMonitoring));
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> getByIdDelivery(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(deliveryRepository.findById(id));
    }
    @GetMapping("/get")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(deliveryRepository.findAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateDelivery(@RequestBody DeliveryMonitoring deliveryMonitoring, @PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(deliveryService.updateDelivery(deliveryMonitoring,id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteByIdDelivery(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(deliveryRepository.deleteByIdDelivery(id));
    }

}
