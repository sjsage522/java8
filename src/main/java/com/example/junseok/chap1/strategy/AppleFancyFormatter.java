package com.example.junseok.chap1.strategy;

import com.example.junseok.domain.Apple;
import com.example.junseok.chap1.family.AppleFormatter;

public class AppleFancyFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristic + " " + apple.getColor() + " apple";
    }
}
