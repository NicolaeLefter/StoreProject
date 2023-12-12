package com.example.StoreProject.entity.deposit;

import com.example.StoreProject.entity.device.Device;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deposit")
    private Integer idDeposit;
    @Column(name = "name_deposit")
    private String nameDeposit;

    @Column(name = "total_numbers_device")
    private Integer totalNumbersDevice;
    @JsonIgnore
    @OneToMany(mappedBy = "deposit")
    private List<Device> deviceList;

    public Integer getIdDeposit() {
        return idDeposit;
    }

    public void setIdDeposit(Integer idDeposit) {
        this.idDeposit = idDeposit;
    }

    public String getNameDeposit() {
        return nameDeposit;
    }

    public void setNameDeposit(String nameDeposit) {
        this.nameDeposit = nameDeposit;
    }

    public Integer getTotalNumbersDevice() {
        return totalNumbersDevice;
    }

    public void setTotalNumbersDevice(Integer totalNumbersDevice) {
        this.totalNumbersDevice = totalNumbersDevice;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }
}
