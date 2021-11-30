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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="tbl_customers")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private Date orderDate;

    private int quantity;

    private double total;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;

}
