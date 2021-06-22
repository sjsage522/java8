package com.example.junseok.chap4;

import com.example.junseok.domain.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.example.junseok.domain.Dish.*;

public class StreamBasic {

    public static void main(String[] args) {

        //JAVA7
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu) { /* 누적자로 요소 필터링 */
            if (dish.getCalories() < 400) lowCaloricDishes.add(dish);
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() { /* 익명 클래스로 요리 정렬 */
            @Override
            public int compare(Dish dish1, Dish dish2) {
                return Integer.compare(dish1.getCalories(), dish2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName()); /* 정렬된 리스트를 처리하면서 요리 이름 선택 */
        }

        System.out.println(lowCaloricDishesName);

        /**
         * lowCaloricDishesName 리스트를 얻기 위해 lowCaloricDishes 라는 가비지 변수를 사용
         * lowCaloricDishes 는 컨테이너 역할만 하는 중간변수이다.
         */
    }
}
