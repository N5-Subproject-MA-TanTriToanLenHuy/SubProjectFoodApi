package com.example.subprojectfoodapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
@Table(name="Customers")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Order> orderList;

    public Customer() {
    }

    public Customer(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }
}
