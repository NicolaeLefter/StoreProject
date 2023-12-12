package com.example.StoreProject.controller.clientController;

import com.example.StoreProject.entity.client.Client;
import com.example.StoreProject.repository.clientRepository.ClientRepository;
import com.example.StoreProject.service.clientService.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ClientServiceImpl clientService;


    @PostMapping("/save")
    public ResponseEntity<Object> addClient(@RequestBody Client client) {
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.save(client));
    }

    @PostMapping("/saveAll")
    public ResponseEntity<Object> addAllClient(@RequestBody List<Client> clientList) {
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.saveAll(clientList));
    }
    @GetMapping("/get/{idClient}")
    public ResponseEntity<Object> getClientById(@PathVariable Integer idClient){
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.findById(idClient));
    }
    @GetMapping("/getAll")
    public ResponseEntity<Object>getAllClients(){
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.findAll());
    }
    @PutMapping("/update/{idClient}")
    public ResponseEntity<Object> updateClient(@RequestBody Client client, @PathVariable Integer idClient){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClient(client, idClient));
    }
    @DeleteMapping("/delete/{idClient}")
    public ResponseEntity<Object> deleteClientById(@PathVariable Integer idClient){
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.deleteByIdClient(idClient));
    }

}
