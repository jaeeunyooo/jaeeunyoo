package com.jaeeunyoo.blog.util;

import java.time.LocalDateTime;
import java.time.Month;

public class DateFormatUtil {

    public static String formatDate(LocalDateTime localDateTime) {
        if(localDateTime == null) {
            return "";
        }

        return formatMonth(localDateTime) + " " + formatDayOfMonth(localDateTime) + ", " + localDateTime.getYear();
    }

    public static String formatDayOfMonth(LocalDateTime localDateTime) {
        if(localDateTime == null) {
            return "";
        }

        return String.format("%02d", localDateTime.getDayOfMonth());
    }

    public static String formatMonth(LocalDateTime localDateTime) {
        if(localDateTime == null) {
            return "";
        }

        Month month = localDateTime.getMonth();

        if(month == Month.JANUARY) {
            return "Jan";
        } else if(month == Month.FEBRUARY) {
            return "Feb";
        } else if(month == Month.MARCH) {
            return "Mar";
        } else if(month == Month.APRIL) {
            return "Apr";
        } else if(month == Month.MAY) {
            return "May";
        } else if(month == Month.JUNE) {
            return "Jun";
        } else if(month == Month.JULY) {
            return "Jul";
        } else if(month == Month.AUGUST) {
            return "Aug";
        } else if(month == Month.SEPTEMBER) {
            return "Sep";
        } else if(month == Month.OCTOBER) {
            return "Oct";
        } else if(month == Month.NOVEMBER) {
            return "Nov";
        } else if(month == Month.DECEMBER) {
            return "Dec";
        } else {
            return "";
        }
    }
}
