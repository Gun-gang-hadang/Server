# Server


## DB
1. 영양소 정보 DB (food_nutrient)
   
   ```
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("바나나", 150, "1개", 114, 30, 1.7, 0.3);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("밥", 210, "1공기", 306, 61.6, 11.1, 1.8);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("방울토마토", 100, "7개",	25, 5.6, 1.2, 0.2);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("부침개", 100, "1개", 147, 18.2, 6.9, 5.3);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("브로콜리", 30, "1개", 8, 1.6, 0.8, 0.1);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("비엔나 소시지", 30, "1인분", 65, 1, 4, 4.6);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("빵", 26, "1인분",69, 13.16, 1.99, 0.86);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("사과", 250, "1개", 142, 35.3, 0.5, 1.7);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("고구마", 170, "1개", 235, 55.2, 2.8, 0.4);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("삶은 달걀", 45, "1개", 65, 0.6, 6.1, 3.9);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("상추", 50, "1인분", 9, 1.8, 1, 0.1);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("삼겹살구이", 200, "1인분", 933, 1.4, 45.1, 83.4);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("생선구이", 110, "1마리", 123, 0.31, 25.53, 1.33);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("스크램블 에그", 94, "1인분", 171, 5.2, 10.2, 13.4);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("야채볶음", 100, "1접시", 60, 8.1, 2.9, 2.3);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("양배추쌈", 65, "1인분", 85, 9.7, 2.4, 4.3);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("양상추샐러드", 150, "1인분", 188, 6.1, 7.4, 15.4);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("어묵국", 200, "1인분", 72 ,9.5, 4.6, 1.8);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("오이", 300, "1개", 35, 9, 3.2, 0.1);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("우유", 244, "1컵", 122, 11.49, 8.03, 4.88);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("조미김", 4, "1봉지", 25, 1.55 ,0.68, 1.91);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("죽", 450, "1인분", 250, 44, 10, 3.6);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("참외", 85, "1인분", 26, 6.31, 0.65, 0.15);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("콩나물 무침", 30, "1접시", 38, 5.99, 2.31, 1.13);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("파프리카", 30, "1인분", 6, 1.39, 0.26, 0.05);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("포도", 80, "1인분", 55, 14.48, 0.58, 0.13);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("해물볶음", 400, "1인분", 419, 32.2, 38.2, 15.3);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("훈제연어", 85, "1인분", 99, 0, 15.54, 3.67);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("미역국", 230, "1인분", 83, 5.59, 7.87, 3.73);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("단호박찜", 57, "1인분", 17, 4.12, 0.58, 0.09);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("달걀찜", 150, "1인분", 220, 2.85, 15.66, 15.78);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("배추김치", 40, "1접시", 13, 2.49, 1.04, 0.19);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("된장국", 200, "1인분", 76, 9.93, 5.55, 1.85);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("된장찌개", 200, "1인분", 171, 16.77, 15.01, 5.6);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("무김치", 50, "1접시", 18, 3.81, 0.78, 0.16);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("순두부찌개", 300, "1인분", 259, 5.62, 18.25, 17.99);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("샌드위치", 130, "1인분", 252, 27.29, 8.09, 12.08);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("토마토", 120, "1개", 22, 4.82, 1.08, 0.25);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("잡채", 200, "1접시", 209, 31.7, 5.56, 7.45);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("찜닭", 200, "1인분", 385, 31.6, 27.8, 15.4);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("감자볶음", 90, "1인분", 107, 13.72, 1.5, 5.4);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("달걀볶음밥", 300, "1인분", 493, 53.3, 15.2, 23.6);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("고추 장아찌", 35, "1접시", 21, 4.3, 0.7, 0.4);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("국수", 160, "1인분", 219, 3.3, 40, 7.2);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("떡국", 300, "1인분", 345, 66.6, 11.2, 3.2);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("미역나물", 100, "1접시", 82, 10, 1.9, 0.4);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("달걀후라이", 50, "1개", 89, 0.4, 6.2, 6.8);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("닭갈비", 300, "1인분", 585, 43.18, 26.98, 40.2);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("갈비찜", 200, "1인분", 597, 15.44, 34.53, 43.59);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("오리구이", 150, "1인분", 462, 0, 29.68, 37.19);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("오믈렛", 65, "1인분", 65, 5, 7, 1.9);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("만두국", 400, "1인분", 248, 27.3, 12.3, 10);
   insert into food_nutrient(name, gram, amount, kcal, carbs, protein, fat) values ("치킨너겟", 100, "1인분", 226, 9, 14, 15);
   ```
2. 
