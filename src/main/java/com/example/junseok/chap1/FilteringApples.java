package com.example.junseok.chap1;

import com.example.junseok.domain.Apple;
import com.example.junseok.chap1.family.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

public class FilteringApples {

    /**
     * Strategy Pattern
     * 각 알고리즘(전략)을 캡슐화 하는 알고리즘 패밀리를 정의해둔 다음에 런타임에 알고리즘을 선택하는 기법
     * 알고리즘 패밀리 -> ApplePredicate
     * 전략 -> AppleHeavyWeighPredicate, AppleGreenColorPredicate
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) result.add(apple);
        }

        return result;
    }
}
