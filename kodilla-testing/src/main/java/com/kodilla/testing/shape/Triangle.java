package com.kodilla.testing.shape;

public class Triangle implements Shape{
    private String shapeName;
    private double edge;
    private double height;

    public Triangle(String shapeName, double edge, double height) {
        this.shapeName = shapeName;
        this.edge = edge;
        this.height = height;
    }
    public double getEdge(){
        return edge;
    }
    public double getHeight(){
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        return Double.compare(triangle.edge, edge) == 0;

    }
    @Override
    public String getShapeName() {
        return this.shapeName;
    }

    @Override
    public double getField() {
        return (0.5*edge*height);
    }
}