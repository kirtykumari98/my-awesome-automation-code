package com.automation.project.designpatterns.decorator.examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DecoratorPatternDriver {
    static Logger logger= LogManager.getLogger(DecoratorPatternDriver.class);

    public static void main(String[] args) {
        // christmas tree with just one Garland
        ChristmasTree tree1 = new Garland(new ChristmasTreeImpl());
        logger.info(tree1.decorate());

        // christmas tree with two Garlands and one Bubble lights
        ChristmasTree tree2 = new BubbleLights(new Garland(new Garland(new ChristmasTreeImpl())));
        logger.info(tree2.decorate());

        ChristmasTree tree3 = new ChristmasTreeImpl();
        logger.info(tree3.decorate());
    }

}