package com.automation.project.design_principles.lsp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClassInvariantExample {
    static Logger logger= LogManager.getLogger(ClassInvariantExample.class);
    private final String name;

    public ClassInvariantExample(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        ClassInvariantExample classInvariantExample= new ClassInvariantExample("Sharada");
//        classInvariantExample.name=null;

    }

}
