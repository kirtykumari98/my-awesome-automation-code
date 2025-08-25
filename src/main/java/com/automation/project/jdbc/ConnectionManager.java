package com.automation.project.jdbc;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionManager {

    private static final Logger logger= LogManager.getLogger(ConnectionManager.class);
    private String userName="admin";
    private String password= "12345678";
    private String dbUrl="jdbc:mysql://database-3.cyogzf28qsik.us-west-2.rds.amazonaws.com:3306/new_schema";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

}
