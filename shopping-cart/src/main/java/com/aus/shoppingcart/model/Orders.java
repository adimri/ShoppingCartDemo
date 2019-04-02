package com.aus.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(pattern = "MM-dd-yyyy") private LocalDate dateCreated;

    private String status;

    @OneToMany(mappedBy = "pk.order")
    @Valid
    private List<OrderDetails> orderDetails = new ArrayList<>();

    @Transient
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<OrderDetails> orderDetails = getOrderDetails();
        for (OrderDetails orderD : orderDetails) {
            sum += orderD.getTotalPrice();
        }

        return sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.orderDetails.size();
    }
}