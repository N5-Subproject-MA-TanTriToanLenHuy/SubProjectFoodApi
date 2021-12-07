package com.example.subprojectfoodapi.Entity;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="tbl_carts")
public class Cart {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private String name;

    private double price;

    private String urlImage;

    private int quantity;

}
