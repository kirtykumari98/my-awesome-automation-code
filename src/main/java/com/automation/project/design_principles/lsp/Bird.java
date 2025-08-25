package com.automation.project.design_principles.lsp;

public class Bird {


    public class FlyingBird extends Bird {

        public void fly() {
            System.out.println("I'm flying");
        }

    }

    public class Dove extends FlyingBird {
    }

    public class Ostrich extends Bird {
    }

}
