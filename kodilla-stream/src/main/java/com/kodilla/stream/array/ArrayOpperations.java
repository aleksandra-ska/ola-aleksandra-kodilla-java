package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOpperations {

    static double getAverage(int [] numbers) {
        IntStream.range(0, numbers.length)
    .forEach(r -> System.out.println(numbers[r]));

        double Average = IntStream.range(0, numbers.length)
                .map(r -> numbers[r])
                .average().getAsDouble();

        return Average;

    }

}
