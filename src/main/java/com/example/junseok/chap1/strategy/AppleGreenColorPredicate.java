package com.example.junseok.chap1.strategy;

import com.example.junseok.chap1.domain.Apple;
import com.example.junseok.chap1.family.ApplePredicate;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
