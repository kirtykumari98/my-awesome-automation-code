package com.automation.project.design_principles.lsp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class BirdViolatingLsp {

    public  boolean canFly;
    public  boolean canWalk;

    public BirdViolatingLsp(boolean canFly, boolean canWalk) {
        this.canFly =canFly;
        this.canWalk = canWalk;
    }

    public String fly() {
        if (canFly) {
            return "I'm flying";
        } else {
            return "I'm not flying";
        }
    }

    public String walk() {
        return "I'm walking";
    }
}

class Dove extends BirdViolatingLsp {
    public Dove(boolean canFly, boolean canWalk) {
        super(canFly,canWalk);
    }

}

class Ostrich extends BirdViolatingLsp {

    public Ostrich(boolean canFly, boolean canWalk) {
        super(canFly,canWalk);
    }
}

public class BirdTest {
    static Logger logger = LogManager.getLogger(BirdTest.class);

    public static void main(String[] args) {
        BirdViolatingLsp dove = new Dove(true, true);
        logger.info("Dove says " + dove.fly());
        logger.info("Dove says " + dove.walk());
        BirdViolatingLsp ostrich = new Ostrich(false, true);
        logger.info("Ostrich says " + ostrich.fly());
        logger.info("Ostrich says " + ostrich.walk());
    }
}

