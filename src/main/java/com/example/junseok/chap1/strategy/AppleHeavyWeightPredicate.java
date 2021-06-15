package com.example.junseok.chap1.strategy;

import com.example.junseok.domain.Apple;
import com.example.junseok.chap1.family.ApplePredicate;

public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
