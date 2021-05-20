package com.kodilla.testing;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main (String[] args) {
        Calculator calculator = new Calculator();
        int sum = calculator.add(8, 2);
        int result = calculator.substract(10, 1);

        if(sum == 10) {
            System.out.println(sum);
        }else{
            System.out.println("Error!");
        }
        if(result == 7) {
            System.out.println(result);
        }else{
            System.out.println("Error!");
        }
    }

}


