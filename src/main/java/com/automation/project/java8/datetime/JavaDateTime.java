package com.automation.project.java8.datetime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;


public class JavaDateTime {
public static Logger logger= LogManager.getLogger(JavaDateTime.class);
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
//        logger.log(Level.ERROR,"Chronology is "+localDate.getChronology());
        System.out.println(localDate.getChronology());
        System.out.println("Tomorrow is " + localDate.plusDays(1));
        System.out.println("Yesterday was " + localDate.minusDays(1));
        //info message
        //debug level message
        //warn level message
        //error level message
        //fatal level message - server

        System.out.println("Yesterday was in another format " + localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Yesterday was in another format " + localDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy")));
//        LocalDate.parse("12-09-17");

        //Formatting from String to date and back to date.
        String date = "12-09-17";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        localDate = LocalDate.parse(date, formatter);
        System.out.println(localDate);
        formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        date = localDate.format(formatter);

        //Zone Id
        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));

        LocalDate todayUS= LocalDate.now(ZoneId.systemDefault());
        System.out.println("Current Date in IST=" + todayUS);

        LocalTime time= LocalTime.now();
        logger.info("time now is : "+ time);
        LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
        logger.info("one hour after 6:30 is "+sevenThirty);

        //ZoneId

        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
        logger.info("The first zoneId fetched is "+allZoneIds.iterator().next());
        ZoneId zoneId = ZoneId.of(allZoneIds.iterator().next());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
        logger.info("Zoned time for "+ allZoneIds.iterator().next()+" is "+ zonedDateTime);

    }
}
