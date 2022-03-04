package model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DatesAndCalendar {

    private static void displayCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
//        LocalDate localDate = new java.util.LocalDate();
//        calendar.setTime(new Date());
//        System.out.println(calendar.getTime());

    }
}

//    private static void displaySetDate  () {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2022, 02, 28);
//        LocalDate localDate = calendar.getTime(new Date());
//        System.out.println(date);


