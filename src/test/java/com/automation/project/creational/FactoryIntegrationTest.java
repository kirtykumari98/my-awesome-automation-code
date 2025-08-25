package com.automation.project.creational;

import com.automation.project.designpatterns.factory.Polygon;
import com.automation.project.designpatterns.factory.PolygonFactory;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;


public class FactoryIntegrationTest {
    Logger logger= LogManager.getLogger(FactoryIntegrationTest.class);
    @Test
    public void whenUsingFactoryForSquare_thenCorrectObjectReturned() {
        Polygon p;
        PolygonFactory factory = new PolygonFactory();

        //get the shape which has 4 sides
        p = factory.getPolygon(4);
        String result = "The shape with 4 sides is a " + p.getType();
        Assert.assertEquals("Square",p.getType());
        logger.info(result);
    }

    @Test
    public void doSomething()
    {

    }




}
