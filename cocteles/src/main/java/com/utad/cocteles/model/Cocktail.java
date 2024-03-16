package com.utad.cocteles.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fav_cocktail")
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

}
