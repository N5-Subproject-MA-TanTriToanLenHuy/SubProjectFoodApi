package com.example.subprojectfoodapi.Entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author MPHuy on 19/11/2021
 */
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Foods")
public class Food {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    private String name;
    private Type type;
    private double price;
    private String description;

    public Food() {
    }

    public Food(String name, Type type, double price, String description) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
  ;
    }
}
