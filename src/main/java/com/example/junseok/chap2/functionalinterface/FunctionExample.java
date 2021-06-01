package com.example.junseok.chap2.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        List<Integer> list = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
        System.out.println(list); // [7, 2, 6]
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
