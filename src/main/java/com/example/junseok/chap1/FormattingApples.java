package com.example.junseok.chap1;

import com.example.junseok.domain.Apple;
import com.example.junseok.chap1.family.AppleFormatter;

import java.util.List;

public class FormattingApples {

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {

        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }
}
