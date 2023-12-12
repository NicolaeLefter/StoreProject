package com.example.StoreProject.entity.sale;

import com.example.StoreProject.entity.device.Device;
import com.example.StoreProject.entity.employes.Employes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale")
    private Integer idSale;

    @Column(name = "date_sale")
    private Date dateSale;

    @Column(name = "price_sale")
    private Double priceSale;
    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employes employes;
    @ManyToOne
    @JoinColumn(name = "id_device")
    private Device device;

    public Integer getIdSale() {
        return idSale;
    }

    public void setIdSale(Integer idSale) {
        this.idSale = idSale;
    }

    public Date getDateSale() {
        return dateSale;
    }

    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }

    public Double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(Double priceSale) {
        this.priceSale = priceSale;
    }

    public Employes getEmployes() {
        return employes;
    }

    public void setEmployes(Employes employes) {
        this.employes = employes;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
