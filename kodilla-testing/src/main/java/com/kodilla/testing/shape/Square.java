package com.kodilla.testing.shape;

public class Square implements Shape{
    String shapeName;
    double edge;

    public Square(String shapeName, double edge) {
        this.shapeName = shapeName;
        this.edge = edge;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return Double.compare(square.edge, edge) == 0;
    }
    @Override
    public String getShapeName() {
        return this.shapeName;
    }

    @Override
    public double getField() {
        return (edge*edge);
    }
}


