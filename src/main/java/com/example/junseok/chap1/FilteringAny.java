package com.example.junseok.chap1;

import com.example.junseok.chap1.family.Predicate;

import java.util.ArrayList;
import java.util.List;

public class FilteringAny {

    /**
     * 리스트 형식으로 추상화
     * 형식 파라미터 T 활용 (제네릭)
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {

        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) result.add(e);
        }

        return result;
    }
}
