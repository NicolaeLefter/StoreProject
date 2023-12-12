package com.example.StoreProject.repository.clientRepository;

import com.example.StoreProject.entity.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {


    Object deleteByIdClient(Integer idClient);
}
