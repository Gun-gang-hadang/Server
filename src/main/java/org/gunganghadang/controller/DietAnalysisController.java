package org.gunganghadang.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gunganghadang.app.ml.MLServerClient;
import org.gunganghadang.domain.dietAnalysis.FoodNutrient;
import org.gunganghadang.service.DietAnalysisService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class DietAnalysisController {
    private final MLServerClient mlServerClient;
    private final DietAnalysisService dietAnalysisService;
    private ArrayList<String> foodList;

    @PostMapping("/api/v1/analyze/image")
    public ArrayList<String> sendImageToMLAndGetFoodName(@RequestParam("image") MultipartFile image)  throws IOException {
        foodList = mlServerClient.analyzeDietImage(image).getFoodList();
        log.info("food 정렬: {}", foodList);
        return foodList;
    }

    @GetMapping("/api/v1/analyze/nutrient")
    public List<FoodNutrient> sendFoodNutrients() {
        return dietAnalysisService.getFoodNutrient(foodList);
    }
}
