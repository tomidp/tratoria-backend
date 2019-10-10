package com.dp.tratoria.playing;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Players {

  public static void main(String[] args) throws  Exception {
    // Today Date
    System.out.println("Test");
    Date today = new Date();
    System.out.println("Today Date :" + today.toString());

    // One Week from Today (https://stackoverflow.com/questions/23307324/how-do-i-add-2-weeks-to-a-date-in-java)
    int noOfDays = 7;
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
    Date oneWeekFromToday = calendar.getTime();
    System.out.println("Two weeks from today :" + oneWeekFromToday.toString());

    // https://www.mkyong.com/java/how-to-compare-dates-in-java/
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date holiday1 = sdf.parse("2018-12-03");
    Date holiday2 = sdf.parse("2018-12-04");
    Date holiday3 = new Date();

    int countHoliday = 0;
    // Check is holiday between pickup policy
    if (holiday1.after(today) && holiday1.before(oneWeekFromToday)) {
      countHoliday++;
    }
    if (holiday2.after(today) && holiday2.before(oneWeekFromToday)) {
      countHoliday++;
    }

    // Check is today is holiday or not
    // Is Today saturday or sunday
    // Check if today is one of holiday
    if (holiday3.equals(today)) {
      countHoliday++;
    }

    Calendar todayCheck = Calendar.getInstance();
    if (todayCheck.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
      countHoliday = countHoliday + 2;
    }
    if (todayCheck.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
      countHoliday++;
    }
    System.out.println("Count Holiday :"+ countHoliday);

    // Get PickupDate
    // Check pickupDateMax
    Calendar calendarPD = Calendar.getInstance();
    calendarPD.add(Calendar.DAY_OF_YEAR, noOfDays + countHoliday);
    Date pickupDateMax = calendarPD.getTime();

    int countHoliday2= 0;
    // Check is holiday between pickup policy
    if (holiday3.equals(pickupDateMax)) {
      countHoliday2++;
    }

    if (calendarPD.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
      countHoliday2 = countHoliday2 + 2;
    }
    if (calendarPD.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
      countHoliday2++;
    }
    System.out.println("Count Holiday 2:"+ countHoliday2);

    Calendar finalcalendarPD = Calendar.getInstance();
    finalcalendarPD.setTime(pickupDateMax);
    finalcalendarPD.add(Calendar.DAY_OF_YEAR, countHoliday2);
    System.out.println("Pickup Date Max :" + finalcalendarPD.getTime().toString());
  }
}
