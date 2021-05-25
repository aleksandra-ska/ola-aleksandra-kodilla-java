package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;


public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Tests begining");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Tests ending");
    }

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("TESTS")
    class Tests {
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circle("Circle", 5.0);
            //When
            shapeCollector.addFigure(shape);
            //Then
            Assertions.assertEquals(1, shapeCollector.getShapesList().size());
        }
        @Test
        void testRemoveFigureNotExist() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circle("Circle", 5.0);
            shapeCollector.addFigure(shape);
            //When
            boolean result = shapeCollector.removeFigure(new Circle("Circle", 4.0));
            //Then
            Assertions.assertFalse(result);
            Assertions.assertEquals(1, shapeCollector.getShapesList().size());
        }

        @Test
        void testRemoveFigure() {
           //Given
          ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circle("Circle", 5.0);
            shapeCollector.addFigure(shape);
            //When
            boolean result = shapeCollector.removeFigure(shape);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapesList().size());
        }

        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circle("Circle", 5.0);
            shapeCollector.addFigure(shape);
            //When
            Shape shapeResult;
            shapeResult = shapeCollector.getFigure(0);
            //Then
            Assertions.assertEquals(shape, shapeResult);
        }

        @Test
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circle("Circle", 5.0);
            shapeCollector.addFigure(shape);
            ArrayList<Shape> shapes = new ArrayList<>();
            shapes.add(shape);
            //When
            List<Shape> shapesResult = shapeCollector.getShapesList();
            //Then
            Assertions.assertEquals(shapes.toString(), shapesResult.toString());
        }
    }
}
