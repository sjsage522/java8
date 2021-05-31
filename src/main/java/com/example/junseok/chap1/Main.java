package com.example.junseok.chap1;

import com.example.junseok.chap1.domain.Apple;
import com.example.junseok.chap1.family.ApplePredicate;
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


        /**
         * class 동작 파라미터화
         */
        printHeavyApples(inventory);
        printFormattingApples(inventory);

        /**
         * 익명 클래스 동작파라미터화
         */
        printGreenApples(inventory);

        /**
         * 람다 동작 파라미터화
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        filtering(inventory, numbers);
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

    private static void printGreenApples(List<Apple> inventory) {
        System.out.println(FilteringApples.filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "green".equals(apple.getColor());
            }
        }));
    }

    /**
     * 유연함과 간결성
     */
    private static void filtering(List<Apple> inventory, List<Integer> numbers) {

        List<Apple> redApples = FilteringAny.filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(redApples);


        List<Integer> evenNumbers = FilteringAny.filter(numbers, (Integer i) -> i % 2 == 0);
        System.out.println(evenNumbers);
    }
}
