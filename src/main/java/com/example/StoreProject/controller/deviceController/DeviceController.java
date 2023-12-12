package com.example.StoreProject.controller.deviceController;

import com.example.StoreProject.entity.device.Device;
import com.example.StoreProject.exception.deviceException.DeviceNotFoundException;
import com.example.StoreProject.exception.deviceException.DeviceUpdateNotFoundException;
import com.example.StoreProject.repository.deviceRepository.DeviceRepository;
import com.example.StoreProject.service.deviceService.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/device")
public class DeviceController {
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    DeviceService deviceService;
    @PostMapping("/save")
    public ResponseEntity<Object> addDevice(@RequestBody Device device,@RequestParam Integer idDeposit,
                                            @RequestParam Integer idStore){
        return ResponseEntity.status(HttpStatus.OK).body(deviceService.saveDevice(device,idDeposit, idStore));
    }
    @GetMapping("/get/byId/{idDevice}")
    public ResponseEntity<Object> getByIdDevice(@PathVariable Integer idDevice){
        return ResponseEntity.status(HttpStatus.OK).body(deviceRepository.findById(idDevice));
    }
    @GetMapping("getAll")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(deviceRepository.findAll());
    }
    @DeleteMapping("/delete/{idDevice}")
    public ResponseEntity<Object> deleteByIdDevice(@PathVariable Integer idDevice){
        return ResponseEntity.status(HttpStatus.OK).body(deviceService.deleteDevice(idDevice));
    }
    @PutMapping("/update/byId/{idDevice}")
    public ResponseEntity<Object> updateDevice(@RequestBody Device device, @PathVariable Integer idDevice) throws DeviceUpdateNotFoundException, DeviceNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(deviceService.updateDeviceById(device, idDevice));
    }


}

