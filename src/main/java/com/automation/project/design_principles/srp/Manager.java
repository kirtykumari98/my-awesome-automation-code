package com.automation.project.design_principles.srp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.HashSet;

public class Manager
{
    static Logger logger = LogManager.getLogger(Manager.class);
    private String firstName;
    private String lastName;
    private LocalDate hireDate;
    private HashSet<Manager> subordinates;

    public Manager(String firstName, String lastName, LocalDate hireDate) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.hireDate=hireDate;
    }
    public void addSubordinate(Manager subordinate) {
        subordinates.add(subordinate);
    }
    public void removeAllSubordinates() {
        subordinates.clear();
    }
    public void print() {
        logger.info("Employee Details.... ");
    }
}
