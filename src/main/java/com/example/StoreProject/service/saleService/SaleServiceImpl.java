package com.example.StoreProject.service.saleService;

import com.example.StoreProject.entity.sale.Sale;
import com.example.StoreProject.exception.saleException.SaleNotFoundException;
import com.example.StoreProject.repository.saleRepository.SaleRepository;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class SaleServiceImpl {
    @Autowired
    SaleRepository saleRepository;

    @Transactional
    public ResponseEntity<Object> updateSale(Sale sale, Integer idSale) {
        Sale sal = saleRepository.findById(idSale).orElseThrow(() ->
                new SaleNotFoundException("Nu a fost gasit cecul cu id-ul: " + idSale));
        sal.setDateSale(sale.getDateSale());
        sal.setDevice(sale.getDevice());
        sal.setPriceSale(sale.getPriceSale());
        sal.setEmployes(sale.getEmployes());

        return ResponseEntity.ok("Cecul a fost actualizat cu succes!");
    }
}
