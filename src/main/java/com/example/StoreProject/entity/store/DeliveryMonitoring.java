package com.example.StoreProject.entity.store;

import jakarta.persistence.*;

@Entity(name = "delivery")
public class DeliveryMonitoring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_delivery")
    private Integer idDelivery;
    @Column(name = "name_client")
    private String nameClient;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "total_amount")
    private Double totalAmount;
    @Column(name = "status_order")
    private String statusOrder;

    public Integer getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(Integer idDelivery) {
        this.idDelivery = idDelivery;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }
}
