package com.example.StoreProject.service.storeService;

import com.example.StoreProject.entity.store.Store;
import com.example.StoreProject.exception.storeException.StoreNotFoundException;
import com.example.StoreProject.repository.storeRepository.StoreRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StoreServiceImpl {
    @Autowired
    StoreRepository storeRepository;

    @Transactional
    public ResponseEntity<Object> saveStore(Store store) {
        return ResponseEntity.status(HttpStatus.OK).body(storeRepository.save(store));
    }
    @Transactional
    public ResponseEntity<Object> saveAllStore(List<Store> storeList){
        return ResponseEntity.status(HttpStatus.OK).body(storeRepository.saveAll(storeList));
    }
    @Transactional
    public ResponseEntity<Object> updateStore(Store store, Integer idStore){
        Store store1 = storeRepository.findById(idStore).orElseThrow(()->
                new StoreNotFoundException("Nu a fost gasit magazinul cu id-ul: " + idStore));
        Map<Object,String> map = new HashMap<>();

        if (store.getNameStore().isEmpty()){
            map.put(store.getNameStore(), "De numirea magazinului trebuie nu este introdusa!");
        }else {
            store1.setNameStore(store.getNameStore());
        }
        store1.setAddress(store.getAddress());
        store1.setGrafic(store.getGrafic());
        store1.setDeviceList(store.getDeviceList());

        if (!map.isEmpty()){
            throw  new RuntimeException("A aparut o eroare la actualizarea magazinului!" + map);
        }
        return ResponseEntity.ok("Mahazinul a fost actualizat cu succes!");
    }
}
