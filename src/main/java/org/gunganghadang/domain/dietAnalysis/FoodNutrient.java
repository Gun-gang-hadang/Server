package org.gunganghadang.domain.dietAnalysis;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class FoodNutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long food_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int gram;

    @Column(nullable = false)
    private String amount;

    @Column(nullable = false)
    private int kcal;

    @Column(nullable = false)
    private double carbs;

    @Column(nullable = false)
    private double protein;

    @Column(nullable = false)
    private double fat;

    @Builder
    public FoodNutrient(String name, int gram, String amount, int kcal, double carbs, double protein, double fat) {
        this.name = name;
        this.gram = gram;
        this.amount = amount;
        this.kcal = kcal;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
    }
}
