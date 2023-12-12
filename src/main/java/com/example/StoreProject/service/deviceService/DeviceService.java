package com.example.StoreProject.service.deviceService;

import com.example.StoreProject.entity.deposit.Deposit;
import com.example.StoreProject.entity.device.Device;
import com.example.StoreProject.entity.store.Store;
import com.example.StoreProject.exception.deviceException.DeviceNotFoundException;
import com.example.StoreProject.exception.deviceException.DeviceUpdateNotFoundException;
import com.example.StoreProject.repository.depositRepository.DepositRepository;
import com.example.StoreProject.repository.deviceRepository.DeviceRepository;
import com.example.StoreProject.repository.storeRepository.StoreRepository;
import com.example.StoreProject.service.depositService.DepositServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceService {
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    DepositRepository depositRepository;
    @Autowired
    StoreRepository storeRepository;

    @Transactional
    public Device saveDevice(Device device, Integer idDeposit, Integer idStore) {

        Deposit deposit = depositRepository.findById(idDeposit).orElseThrow(() ->
                new RuntimeException("Nu a fost gasit depositul cu id-ul: " + idDeposit));
        Store store = storeRepository.findById(idStore).orElseThrow(()->
                new RuntimeException("Nu a fost gasit magazinul cu id_ul dat: " + idStore));
        device.setStore(store);
        device.setDeposit(deposit);
       // return ResponseEntity.ok("ok");
         return  deviceRepository.save(device);
    }


    public ResponseEntity<Object> saveAllDevice(List<Device> deviceList) {
        return ResponseEntity.status(HttpStatus.OK).body(deviceRepository.saveAll(deviceList));
    }

    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(deviceRepository.findAll());
    }

    public ResponseEntity<Object> getByIdDevice(Integer idDevice) {
        return ResponseEntity.status(HttpStatus.OK).body(deviceRepository.findById(idDevice));
    }

    public ResponseEntity<Object> deleteDevice(Integer idDevice) {
        return ResponseEntity.status(HttpStatus.OK).body(deviceRepository.deleteByIdDevice(idDevice));
    }

    @Transactional
    public ResponseEntity<Object> updateDeviceById(Device device, Integer idDevice) throws DeviceNotFoundException, DeviceUpdateNotFoundException {
        Device device1 = deviceRepository.findById(idDevice).orElseThrow(() ->
                new DeviceNotFoundException("Nu a fost gasit device-ul cu id-ul: " + idDevice));
        Map<Object, String> map = new HashMap<>();

        if (device.getNameDevice().isEmpty()) {
            map.put(device.getNameDevice(), "Introduceti denumirea device-ului!");
        } else {
            device1.setNameDevice(device.getNameDevice());
        }
        if (device.getTypeDevice().isEmpty()) {
            map.put(device.getTypeDevice(), "Introduceti tipul device-ului!");
        } else {
            device1.setTypeDevice(device.getTypeDevice());
        }
        if (device.getProducer().isEmpty()) {
            map.put(device.getProducer(), "Introduceti producatorul device-ului");
        }
        device1.setProducer(device.getProducer());
        device1.setDescription(device.getDescription());
        if (!map.isEmpty()) {
            throw new DeviceUpdateNotFoundException("A aparut o eroare la actualizarea device-ului! " + map);
        }
        deviceRepository.save(device);

        return ResponseEntity.ok("Device-ul a fost actualizat cu succes!");
    }

}
