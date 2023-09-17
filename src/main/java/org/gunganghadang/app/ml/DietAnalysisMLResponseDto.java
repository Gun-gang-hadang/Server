package org.gunganghadang.app.ml;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
// ML 결과로 나온 음식 이름을 받기 위한 dto
public class DietAnalysisMLResponseDto {
    ArrayList<String> foodList;

    public void setFoodList(ArrayList<String> foodList) {
        this.foodList = foodList;
    }
}
