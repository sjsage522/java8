package com.example.junseok.chap3;

import com.example.junseok.domain.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class AppleSortImpl {

    public static void main(String[] args) {

        //step 1
        List<Integer> weights = Arrays.asList(7, 4, 4, 10);
        List<Apple> inventory = map(weights, Apple::new);
        System.out.println("inventory = " + inventory);

        inventory.sort(new AppleComparator());

        //step 2
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return Integer.compare(a1.getWeight(), a2.getWeight());
            }
        });

        //step 3 -> Comparator 의 함수디스크립터는 (T, T) -> int
        inventory.sort((Apple a1, Apple a2) -> Integer.compare(a1.getWeight(), a2.getWeight()));

//        Comparator<Apple> comparator = Comparator.comparing((Apple a) -> a.getWeight());
        Comparator<Apple> comparator = Comparator.comparing(Apple::getWeight);

        /**
         * 코드 의미가 명확해졌다. -> 'Apple 을 weight 별로 비교해서 inventory 를 sort 하라'
         */
        inventory.sort(Comparator.comparing(Apple::getWeight));

        /**
         * 역정렬
         */
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());

        /**
         * 무게를 내림차순으로 정렬, 두 사과의 무게가 같다면 색깔의 이름순으로 정렬
         */
        inventory.sort(Comparator.comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));
        System.out.println("inventory = " + inventory);
    }

    private static List<Apple> map(List<Integer> weights, BiFunction<Integer, String, Apple> f) {

        List<Apple> result = new ArrayList<>();
        int count = 0;
        for (Integer weight : weights) {
            String color = "RED";
            if (count % 2 == 0) color = "GREEN";
            result.add(f.apply(weight, color));
            count++;
        }

        return result;
    }

    private static class AppleComparator implements Comparator<Apple> {

        @Override
        public int compare(Apple a1, Apple a2) {
            return Integer.compare(a1.getWeight(), a2.getWeight());
        }
    }
}
