package com.kodilla.stream.world;

import com.kodilla.stream.array.ArrayOpperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.kodilla.stream.array.ArrayOpperations.getAverage;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int sampleNumbers[] = {5, 3, 5, 4, 1, 5, 5, 2, 5};

        //When
        double result = getAverage(sampleNumbers);

        //Then
        Assertions.assertEquals(3.89, result, 0.01);


    }
}
