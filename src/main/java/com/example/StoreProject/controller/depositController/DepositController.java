package com.example.StoreProject.controller.depositController;

import com.example.StoreProject.entity.deposit.Deposit;
import com.example.StoreProject.repository.depositRepository.DepositRepository;
import com.example.StoreProject.service.depositService.DepositServiceImpl;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/deposit")
public class DepositController {

    @Autowired
    DepositRepository depositRepository;
    @Autowired
    DepositServiceImpl depositService;

    @PostMapping("/save")
    public ResponseEntity<Object> addDeposit(@RequestBody Deposit deposit) {
        return ResponseEntity.status(HttpStatus.OK).body(depositService.saveDepozit(deposit));
    }

    @GetMapping("/totalDevices/{idDeposit}")
    public ResponseEntity<Object> countTotalNumberDevices(@PathVariable Integer idDeposit) {
        return ResponseEntity.status(HttpStatus.OK).body(depositService.countTotalNumberDevices(idDeposit));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(depositRepository.findAll());
    }

    @GetMapping("get/id/{idDeposit}")
    public ResponseEntity<Object> getDepositById(@PathVariable Integer idDeposit) {
        return ResponseEntity.status(HttpStatus.OK).body(depositRepository.findById(idDeposit));
    }

    @PutMapping("/update/{idDeposit}")
    public ResponseEntity<Object> updateDeposit(@RequestBody Deposit deposit, @PathVariable Integer idDepost) {
        return ResponseEntity.status(HttpStatus.OK).body(depositService.updateDepozitByid(deposit, idDepost));
    }

    @DeleteMapping("/delete/{idDeposit}")
    public ResponseEntity<Object> deleteDeposit(@PathVariable Integer idDeposit) {
        return ResponseEntity.status(HttpStatus.OK).body(depositRepository.deleteByIdDeposit(idDeposit));

    }
}
