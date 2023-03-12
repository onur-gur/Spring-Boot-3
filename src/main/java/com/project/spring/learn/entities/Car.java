package com.project.spring.learn.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "plate", unique = true)
    private String plate;
    @Column(name = "daily_price")
    private BigDecimal dailyPrice;
    @Column(name = "model_year")
    private Integer modelYear;
    @Column(name = "state")
    private State state;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
