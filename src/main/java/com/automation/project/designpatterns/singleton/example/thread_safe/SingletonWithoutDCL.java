package com.automation.project.designpatterns.singleton.example.thread_safe;

public class SingletonWithoutDCL {
    private static SingletonWithoutDCL instance;

    public String value;

    private SingletonWithoutDCL(String value) {
        this.value = value;
    }

    synchronized public static SingletonWithoutDCL getInstance(String value) {
        if (instance == null) {
            instance = new SingletonWithoutDCL(value);
        }
        return instance;
    }
}
