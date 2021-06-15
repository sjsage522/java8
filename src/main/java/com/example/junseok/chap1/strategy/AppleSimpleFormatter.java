package com.example.junseok.chap1.strategy;

import com.example.junseok.domain.Apple;
import com.example.junseok.chap1.family.AppleFormatter;

public class AppleSimpleFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
