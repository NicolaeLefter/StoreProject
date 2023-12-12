package com.example.StoreProject.repository.storeRepository;

import com.example.StoreProject.entity.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

    Object deleteByIdStore(Integer idStore);
}
