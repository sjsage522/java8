package com.example.junseok.chap2.ExecuteAround;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        /**
         * 함수형 인터페이스를 이용해서 람다를 전달하는 방법
         */

        String oneLine = processFile((BufferedReader br) -> br.readLine());
        System.out.println(oneLine);

        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(twoLines);
    }

    private static String processFile(BufferedReaderProcessor processor) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/example/junseok/chap2/ExecuteAround/data.txt"))) {
            return processor.process(br);
        }
    }

    @FunctionalInterface
    private interface BufferedReaderProcessor {
        String process(BufferedReader br) throws IOException;
    }
}
