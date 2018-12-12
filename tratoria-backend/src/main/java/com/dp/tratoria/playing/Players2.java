package com.dp.tratoria.playing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Players2 {

  public static List<Date> getHolidays() throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date holiday1 = sdf.parse("2018-12-03");
    Date holiday2 = sdf.parse("2018-12-04");
    List<Date> holidays = new ArrayList<Date>();
    holidays.add(holiday1);
    holidays.add(holiday2);
    return holidays;
  }

  public static int getAddWeekend(Date date) throws Exception {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    int result = 0;
    if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
      result = result + 2;
    }
    if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
      result++;
    }
    return result;
  }

  public static int getHolidayCounter(List<Date> holidays, Date startDate, Date maxPickupDate) throws Exception {
    int countHoliday = 0;
    for (Date holidayDate : holidays) {
      if (holidayDate.after(startDate) && holidayDate.before(maxPickupDate)) {
        countHoliday++;
      }
    }
    return countHoliday;
  }

  public static Date getDatePlus7Days(Date date) throws Exception {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_YEAR, 7);
    return cal.getTime();
  }

  public static void main(String[] args) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date startDate = sdf.parse("2018-11-30");
    System.out.println("Start date :" +startDate);
    Date initialPickupDate = getDatePlus7Days(startDate);
    int holidayCounter = getHolidayCounter(getHolidays(), startDate, initialPickupDate);
    Calendar finalPickupDate = getFinalPickupDate(initialPickupDate, holidayCounter);
    System.out.println("Final pickup date :" +finalPickupDate.getTime());
  }

  private static Calendar getFinalPickupDate(Date initialPickupDate, int holidayCounter)
      throws Exception {
    Calendar processPickupDate = Calendar.getInstance();
    processPickupDate.setTime(initialPickupDate);
    processPickupDate.add(Calendar.DAY_OF_YEAR, holidayCounter);
    System.out.println("Process pickup date :" +processPickupDate.getTime());
    int weekendPickupCounter = getAddWeekend(processPickupDate.getTime());
    processPickupDate.add(Calendar.DAY_OF_YEAR, weekendPickupCounter);
    return processPickupDate;
  }
}
