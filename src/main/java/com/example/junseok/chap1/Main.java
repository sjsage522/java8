package com.example.junseok.chap1;

import com.example.junseok.chap1.domain.Apple;
import com.example.junseok.chap1.strategy.AppleHeavyWeightPredicate;
import com.example.junseok.chap1.strategy.AppleSimpleFormatter;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));


        printHeavyApples(inventory);
        printFormattingApples(inventory);

    }

    private static void printHeavyApples(List<Apple> inventory) {

        /**
         * 전달한 ApplePredicate 객체에 의해 filterApples 메서드의 동작이 결정된다.
         */
        List<Apple> heavyApples = FilteringApples.filterApples(inventory, new AppleHeavyWeightPredicate());

        System.out.println(heavyApples);
    }

    private static void printFormattingApples(List<Apple> inventory) {

        FormattingApples.prettyPrintApple(inventory, new AppleSimpleFormatter());
    }
}
