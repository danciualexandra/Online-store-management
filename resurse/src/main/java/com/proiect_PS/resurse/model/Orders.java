package com.proiect_PS.resurse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private Date orderedDate = new Date(System.currentTimeMillis());

    private double totalSum;
    @OneToOne
    private Customer customer;

    public Orders(Long orderId, Date shippedDate, String orderAdress, double totalSum) {
        this.orderId = orderId;


        this.totalSum = totalSum;
    }
}
