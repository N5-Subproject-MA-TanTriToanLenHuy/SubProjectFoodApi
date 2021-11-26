package com.example.subprojectfoodapi.Entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author MPHuy on 19/11/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
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

}
