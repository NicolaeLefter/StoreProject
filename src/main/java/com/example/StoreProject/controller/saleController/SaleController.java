package com.example.StoreProject.controller.saleController;

import com.example.StoreProject.entity.sale.Sale;
import com.example.StoreProject.repository.saleRepository.SaleRepository;
import com.example.StoreProject.service.saleService.SaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sale")
public class SaleController {
    @Autowired
    SaleRepository saleRepository;
    @Autowired
    SaleServiceImpl saleService;
    @PostMapping("/save")
    public ResponseEntity<Object> saveSale(@RequestBody Sale sale){
        return ResponseEntity.status(HttpStatus.OK).body(saleRepository.save(sale));
    }
    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(saleRepository.findAll());
    }
    @GetMapping("/get/{idSale}")
    public ResponseEntity<Object> getSaleById(@PathVariable Integer idSale){
        return ResponseEntity.status(HttpStatus.OK).body(saleRepository.findById(idSale));
    }
    @DeleteMapping("/delete/{idSale}")
    public ResponseEntity<Object> deleteByIdSale(@PathVariable Integer idSale){
        return ResponseEntity.status(HttpStatus.OK).body(saleRepository.deleteByIdSale(idSale));
    }
    @PutMapping("/update/{idSale}")
    public ResponseEntity<Object> updateSale(@RequestBody Sale sale, @PathVariable Integer idSale){
        return ResponseEntity.status(HttpStatus.OK).body(saleService.updateSale(sale, idSale));
    }
}
