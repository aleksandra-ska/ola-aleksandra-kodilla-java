package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumberExterminator {
    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> evenNumber = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumber.add(number);
            }
        }
        return evenNumber;
    }
}

