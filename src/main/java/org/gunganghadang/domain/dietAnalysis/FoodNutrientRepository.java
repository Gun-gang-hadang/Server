package org.gunganghadang.domain.dietAnalysis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodNutrientRepository extends JpaRepository<FoodNutrient, Long> {
    @Query("SELECT f FROM FoodNutrient f WHERE f.name IN :foodList")
    List<FoodNutrient> findByName(@Param("foodList") List<String> foodList);
}
