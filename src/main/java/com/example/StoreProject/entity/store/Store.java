package com.example.StoreProject.entity.store;

import com.example.StoreProject.entity.client.Client;
import com.example.StoreProject.entity.device.Device;
import com.example.StoreProject.entity.employes.Employes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "store1")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_store")
    private Integer idStore;
    @Column(name = "name_store")
    private String nameStore;
    @Column(name = "address")
    private String address;
    @Column(name = "grafic")
    private String grafic;
    @JsonIgnore
    @OneToMany(mappedBy = "store")
    private List<Device> deviceList;
    @JsonIgnore
    @OneToMany(mappedBy = "store")
    private List<Employes> employesList;

    public Store(Integer idStore) {
        this.idStore = idStore;
    }
    public Store(){

    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }


    public Integer getIdStore() {
        return idStore;
    }

    public void setIdStore(Integer idStore) {
        this.idStore = idStore;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGrafic() {
        return grafic;
    }

    public void setGrafic(String grafic) {
        this.grafic = grafic;
    }
}
