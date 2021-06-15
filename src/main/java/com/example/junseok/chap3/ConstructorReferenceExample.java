package com.example.junseok.chap3;

import com.example.junseok.domain.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferenceExample {

    public static void main(String[] args) {

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new); // map 메서드로 생성자 참조 전달

        System.out.println(apples);

        /**
         * Apple(Integer weight, String color)의 생성자 참조
         */
        BiFunction<Integer, String, Apple> conRef = Apple::new;
        Apple green = conRef.apply(10, "GREEN");
        System.out.println(green);

        /**
         * 람다 표현식
         */
        BiFunction<Integer, String, Apple> lambda = (Integer weight, String color) -> new Apple(weight, color);
        Apple red = lambda.apply(4, "RED");
        System.out.println(red);

        /**
         * 인수가 세 개인 생성자의 생성자 참조 사용
         */
        TriFunction<Integer, String ,String, Apple> custom = Apple::new;
        Apple apple = custom.apply(10, "RED", "SMALL");
        System.out.println(apple);
    }

    private static List<Apple> map(List<Integer> weights, Function<Integer, Apple> f) {

        List<Apple> result = new ArrayList<>();
        for (Integer weight : weights) {
            result.add(f.apply(weight));
        }

        return result;
    }
}
