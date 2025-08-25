package com.automation.project.designpatterns.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EmployeeTest {
    static Logger logger =  LogManager.getLogger(EmployeeTest.class);
    public static void main(String[] args) {
        Employee employee = new Employee.EmployeeBuilder("Sanjana", "Namburu", 21, 7)
                .setPhone("0045-1234556")
                .setAddress("Guntur")
                .setMail("sj@gmail.com").build();
        logger.info(employee.toString());
        Employee secondEmployee = new Employee.EmployeeBuilder("Kirty", "Kumari", 21, 10)
                .setPhone("98738383833")
                .setMail("kk@gmail.com").build();
        logger.info(secondEmployee.toString());
        Employee suresh = new Employee.EmployeeBuilder("Suresh", "Yarava", 21, 15)
               .build();
        logger.info(suresh.toString());
    }

}
