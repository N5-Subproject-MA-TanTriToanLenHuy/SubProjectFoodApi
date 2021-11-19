package com.example.subprojectfoodapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * @author MPHuy on 19/11/2021
 */
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    private Date orderDate;
    private int quantity;
    private double total;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @JsonIgnore
    private Food food;
    public Order() {
    }

    public Order(Date orderDate, int quantity, double total) {
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.total = total;

    }
}
