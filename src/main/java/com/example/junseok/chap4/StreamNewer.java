package com.example.junseok.chap4;

import com.example.junseok.domain.Dish;

import java.util.List;

import static com.example.junseok.domain.Dish.menu;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamNewer {

    public static void main(String[] args) {

        //JAVA8
        List<String> lowCaloricDishesName =
                menu.stream()
                        .filter(d -> d.getCalories() < 400)      //400칼로리 이하의 요리 선택
                        .sorted(comparing(Dish::getCalories))    //칼로리로 요리 정렬
                        .map(Dish::getName)                      //요리명 추출
                        .collect(toList());                      //모든 요리명을 리스트에 저장
        System.out.println("lowCaloricDishesName = " + lowCaloricDishesName);


        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(d -> d.getCalories() > 350)      //파이프라인 연산 만들기, 첫 번째로 고칼로리 요리를 필터링한다.
                        .map(Dish::getName)                      //요리명 추출
                        .limit(3)                                //선착순 세 개만 선택
                        .collect(toList());                      //결과를 다른 리스트로 저장
        System.out.println("threeHighCaloricDishNames = " + threeHighCaloricDishNames);

        /**
         * 먼저 menu에 stream 메서드를 호출해서 스트림을 얻음
         * 데이터 소스는 요리 리스트(메뉴)
         * 데이터 소소는 연속된 요소를 스트림에 제공, 스트림은 일련의 데이터 처리연산을 적용
         * collect를 제외한 모든 연산은 서로 파이프라인을 형성할 수 있도록 스트림을 반환
         */
    }
}
