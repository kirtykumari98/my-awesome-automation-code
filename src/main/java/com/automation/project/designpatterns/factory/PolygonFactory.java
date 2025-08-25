package com.automation.project.designpatterns.factory;

public class PolygonFactory {
    public Polygon getPolygon(int numberOfSides) {

        Polygon polygon;
        switch (numberOfSides) {
            case 3:
                polygon = new Triangle();
                break;
            case 4:
                polygon = new Square();
                break;
            case 5:
                polygon = new Pentagon();
                break;
            case 7:
                polygon = new Heptagon();
                break;
            case 8:
                polygon = new Octagon();
                break;
            default:
                polygon = new Triangle();

        }
        return polygon;
    }
}
