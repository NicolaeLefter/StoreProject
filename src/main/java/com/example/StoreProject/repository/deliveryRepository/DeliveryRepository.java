package com.example.StoreProject.repository.deliveryRepository;

import com.example.StoreProject.entity.store.DeliveryMonitoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryMonitoring, Integer> {

    Object deleteByIdDelivery(Integer idDelivery);
}
