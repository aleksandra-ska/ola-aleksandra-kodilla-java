package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {
    private static OddNumberExterminator oddNumberExterminator;
    @BeforeEach
            public void before(){
        System.out.println("Test Case: begin");
    }
    @AfterEach
            public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeAll
    public static void beforeAll(){
        oddNumberExterminator = new OddNumberExterminator();
    }
    @DisplayName("CHECK EMPTY LIST WORKING CORRECT")
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        List<Integer> empty = new ArrayList<>();
        //When
        List<Integer> check = oddNumberExterminator.exterminate(empty);
        System.out.println("Empty list test: OK");
        //Then
        Assertions.assertEquals(empty, check);
    }
    @Test
    public void testOddNumberExterminatorNormalList(){
        //Given
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);
        numberList.add(6);
        List<Integer> shouldBe = new ArrayList<>();
        shouldBe.add(2);
        shouldBe.add(4);
        shouldBe.add(6);
        //When
        List<Integer> check = oddNumberExterminator.exterminate(numberList);
        //Then
        Assertions.assertEquals(shouldBe, check);
    }
}

