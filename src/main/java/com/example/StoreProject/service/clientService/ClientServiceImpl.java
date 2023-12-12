package com.example.StoreProject.service.clientService;

import com.example.StoreProject.entity.client.Client;
import com.example.StoreProject.exception.clientException.ClientNotFoundException;
import com.example.StoreProject.exception.clientException.ClientUpdateException;
import com.example.StoreProject.repository.clientRepository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientServiceImpl {

    @Autowired
    ClientRepository clientRepository;

@Transactional
    public ResponseEntity<Object> updateClient(Client client, Integer idClient) {
        Client client1 = clientRepository.findById(idClient).orElseThrow(() ->
                new ClientNotFoundException("Nu a fost gasit clientul cu id-ul: " + idClient));
        Map<Object, String> map = new HashMap<>();

        if (client.getIdnpClient().length() != 15) {
            map.put(client.getIdClient(), "Idnp-ul nu trebuie sa contina mai mult sau mai putin de 15 caractere!");
        } else {
            client1.setIdClient(client.getIdClient());
        }
        if (client.getAddress().isEmpty()) {
            map.put(client.getAddress(), "Adaugati adresa clientului!");
        } else {
            client1.setAddress(client.getAddress());
        }
        if (client.getFirstName().isEmpty() || client.getLastName().isEmpty()) {
            map.put(client.getFirstName() + client.getFirstName(), "Introduceti numele, prenumele clientului!");
        } else {
            client1.setFirstName(client.getFirstName());
            client1.setLastName(client.getLastName());
            client1.setPhoneNumber(client.getPhoneNumber());

        }
        if (!map.isEmpty()) {
            throw new ClientUpdateException("Actualizarea clientului a esuat!" + map);
        }
        return ResponseEntity.ok("Actualizarea clientului cu : " + idClient + " a fost realizata cu succes!");
    }


}
