package com.example.StoreProject.repository.deviceRepository;

import com.example.StoreProject.entity.device.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {

    Object deleteByIdDevice(Integer idDevice);
}
