package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapesList = new ArrayList<>();

    public List<Shape> getShapesList() {
        return shapesList;
    }

    public void addFigure(Shape shape){
        shapesList.add(shape);
    }

    public boolean removeFigure(Shape shape){
        return shapesList.remove(shape);
    }

    public Shape getFigure(int figureNumber) {
        if (figureNumber >= 0 && figureNumber < shapesList.size()) {
            return shapesList.get(figureNumber);
        } else {
            return null;
        }
    }
    public void showFigures() {
        System.out.println(shapesList.toString());
    }

}
