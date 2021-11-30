package com.example.subprojectfoodapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author MPHuy on 19/11/2021
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="tbl_customers")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private String name;

    private String phoneNumber;

    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Order> orderList;
}
