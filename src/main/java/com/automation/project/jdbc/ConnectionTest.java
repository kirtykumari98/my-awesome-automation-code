package com.automation.project.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;

import static java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE;

public class ConnectionTest {

    private static final Logger logger = LogManager.getLogger(ConnectionTest.class);

    Statement statement;
    ResultSet resultSet;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionTest connectionTest = new ConnectionTest();
//        connectionTest.displayTrainerDetails();
//        connectionTest.displayTraineeDetails();
        connectionTest.updateTrainerDetails();
        connectionTest.updateTraineeDetails();
    }

    public void displayTraineeDetails() throws ClassNotFoundException, SQLException {
        Connection connection = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            String query = "select * from Student";
            resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
                logger.debug("Trainee id is: " + resultSet.getInt("idStudent"));
                logger.info("Trainee name is: " + resultSet.getString("name"));
                logger.info("Trainee batch is: " + resultSet.getString("trainerName"));
                logger.info("Trainee mentor is: " + resultSet.getString("batchName"));
//            }
        } finally {
            connection.close();
        }
    }

    public void displayTrainerDetails() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String query = "select * from Trainer";
//            String queryTwo= "select * from Student";
            resultSet = statement.executeQuery(query);
//            statement.executeQuery(queryTwo);
            resultSet.last();
//            while(resultSet.next()){
                logger.info("Trainer id is: " + resultSet.getInt("idTrainer"));
                logger.info("Trainer name is: " + resultSet.getString("name"));
                logger.info("Trainer batch is: " + resultSet.getString("batchName"));
//            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }
    }

    public void updateTrainerDetails() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            String query = "update Trainer set name='Krishna' where idTrainer=4";
            logger.info("after udpate: " + statement.executeUpdate(query));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }
    }

    public void updateTraineeDetails() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            String query = "update Student set name='Sanjana' where idStudent=1";
            statement.executeUpdate(query);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        ConnectionManager manager = new ConnectionManager();
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(manager.getDbUrl(), manager.getUserName(), manager.getPassword());
    }
}
