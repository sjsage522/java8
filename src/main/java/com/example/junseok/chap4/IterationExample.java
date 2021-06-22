package com.example.junseok.chap4;

import com.example.junseok.domain.Dish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;


public class IterationExample {

    private static final List<Dish> menu = Dish.menu;

    public static void main(String[] args) {

        for_each();
        iterator();
        stream();
    }

    private static void stream() {
        List<String> names = menu.stream()
                .map(Dish::getName)
                .collect(toList()); /* 파이프라인을 실행 -> 반복자는 필요 없다. */
    }

    private static void iterator() {
        //내부적으로 숨겨졌던 반복자를 사용한 외부 반복
        List<String> names = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) { //명시적 반복
            Dish dish = iterator.next();
            names.add(dish.getName());
        }
    }

    private static void for_each() {
        //for-each : 외부 반복
        List<String> names = new ArrayList<>();
        for (Dish dish : menu) {
            names.add(dish.getName());
        }
    }
}
