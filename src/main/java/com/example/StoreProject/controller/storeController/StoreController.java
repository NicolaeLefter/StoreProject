package com.example.StoreProject.controller.storeController;

import com.example.StoreProject.entity.store.Store;
import com.example.StoreProject.repository.storeRepository.StoreRepository;
import com.example.StoreProject.service.storeService.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/store")
public class StoreController {

    @Autowired
    StoreServiceImpl storeService;
    @Autowired
    StoreRepository storeRepository;

    @PostMapping("/save")
    public ResponseEntity<Object> addStore(@RequestBody Store store){
        return ResponseEntity.status(HttpStatus.OK).body(storeService.saveStore(store));
    }
    @GetMapping("/get/byId/{idStore}")
    public ResponseEntity<Object> getStoreById(@PathVariable Integer idStore){
        return ResponseEntity.status(HttpStatus.OK).body(storeRepository.findById(idStore));
    }
    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllStore(){
        return ResponseEntity.status(HttpStatus.OK).body(storeRepository.findAll());
    }
    @PutMapping("/update/{idStore}")
    public ResponseEntity<Object> updateStore(@RequestBody Store store, @PathVariable Integer idStore){
        return ResponseEntity.status(HttpStatus.OK).body(storeService.updateStore(store,idStore));
    }
    @DeleteMapping("/delete/{idStore}")
    public ResponseEntity<Object> deleteByIdStore(@PathVariable Integer idStore){
        return ResponseEntity.status(HttpStatus.OK).body(storeRepository.deleteByIdStore(idStore));
    }
}
