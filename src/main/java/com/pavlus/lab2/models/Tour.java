package com.pavlus.lab2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tour_tb")

public class Tour implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int tourCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "tourist_id"), name = "tourist_id")
    @JsonIgnoreProperties(value = {"tour_tb", "hibernateLazyInitializer"})
    private Tourist tourist;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "city_code"), name = "city_code")
    @JsonIgnoreProperties(value = {"tour_tb", "hibernateLazyInitializer"})
    private City city;
    private String tourName;
    private int duration;
    private int price;
    private String description;

}

