package com.kodilla.testing;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main (String[] args) {
        Calculator calculator = new Calculator();
        int sum = calculator.add(8, 17);
        int result = calculator.substract(28, 1);

        if(sum < 100000) {
            System.out.println(sum);
        }else{
            System.out.println("Error!");
        }
        if(result < 100000) {
            System.out.println(result);
        }else{
            System.out.println("Error!");
        }
    }

}


