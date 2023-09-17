package org.gunganghadang.service;

import lombok.RequiredArgsConstructor;
import org.gunganghadang.app.ml.DietAnalysisMLResponseDto;
import org.gunganghadang.app.ml.MLServerClient;
import org.gunganghadang.domain.dietAnalysis.FoodNutrient;
import org.gunganghadang.domain.dietAnalysis.FoodNutrientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DietAnalysisService {
    private final MLServerClient mlServerClient;
    private final FoodNutrientRepository foodNutrientRepository;

    public DietAnalysisMLResponseDto getFoodName(@RequestParam("image") MultipartFile image) throws IOException{
        return mlServerClient.analyzeDietImage(image);
    }

     // 음식 이름으로 영양소 정보 찾기
    public List<FoodNutrient> getFoodNutrient(ArrayList<String> foodList) {
        return foodNutrientRepository.findByName(foodList);
    }
}
