package com.davdev.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nutrition implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Short protein;

    private Short carbohydrates;

    private Short fats;

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}