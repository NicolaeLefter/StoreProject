package com.example.StoreProject.entity.device;

import com.example.StoreProject.entity.deposit.Deposit;
import com.example.StoreProject.entity.store.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity(name = "device1")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_device")
    private Integer idDevice;
    @Column(name = "name_device")
    private String nameDevice;
    @Column(name = "producer")
    private String producer;
    @Column(name = "type_device")
    private String typeDevice;
    @Column(name = "description")
    private String description;
    @Column(name = "price_device")
    private Double priceDevice;
   //MANYTOMANY RELATII
   @ManyToOne
    @JoinColumn(name = "id_deposit")
    private Deposit deposit;

    @ManyToOne
    @JoinColumn(name = "id_store")
    private Store store;

    public Double getPriceDevice() {
        return priceDevice;
    }

    public void setPriceDevice(Double priceDevice) {
        this.priceDevice = priceDevice;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Integer getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(Integer idDevice) {
        this.idDevice = idDevice;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getTypeDevice() {
        return typeDevice;
    }

    public void setTypeDevice(String typeDevice) {
        this.typeDevice = typeDevice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
