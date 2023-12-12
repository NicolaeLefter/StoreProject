package com.example.StoreProject.service.depositService;

import com.example.StoreProject.entity.deposit.Deposit;
import com.example.StoreProject.exception.depositException.DepositNotFoundException;
import com.example.StoreProject.repository.depositRepository.DepositRepository;
import com.example.StoreProject.repository.deviceRepository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.Map;

@Service
public class DepositServiceImpl {
    @Autowired
    DepositRepository depositRepository;

    public ResponseEntity<Object> saveDepozit(Deposit deposit) {
        return ResponseEntity.status(HttpStatus.OK).body(depositRepository.save(deposit));
    }

    @Transactional
    public ResponseEntity<Object> countTotalNumberDevices(Integer idDeposit) {
        return ResponseEntity.status(HttpStatus.OK).body(depositRepository.countTotalDevicesInDeposit(idDeposit));
    }
    @Transactional
    public ResponseEntity<Object> updateDepozitByid(Deposit deposit, Integer idDeposit){
        Deposit deposit1 = depositRepository.findById(idDeposit).orElseThrow(()->
                new DepositNotFoundException("Nu a fost gasit depozitul cu id-ul: " + idDeposit));

        Map<Object,String> map = new HashMap<>();

        if (deposit.getNameDeposit().isEmpty()){
            map.put(deposit.getNameDeposit(), "Setati o denumire depozitului!");
        }else{
            deposit1.setNameDeposit(deposit.getNameDeposit());
            deposit1.setDeviceList(deposit.getDeviceList());
            deposit1.setTotalNumbersDevice(deposit.getTotalNumbersDevice());
            if (!map.isEmpty()){
                throw  new RuntimeException("A aparut o eroare la actualizarea depozitului!" + map);
            }
        }
        return ResponseEntity.ok("Depozitul a fost actualizat cu succes!");
    }


}
