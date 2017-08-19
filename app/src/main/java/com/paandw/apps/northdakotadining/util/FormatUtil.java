package com.paandw.apps.northdakotadining.util;

import org.threeten.bp.LocalDateTime;

public class FormatUtil {
    public static String stripHTML(String htmlString){
         return htmlString.replaceAll("<[^<>]+>([^<>]*)<[^<>]+>", "").replaceAll("&nbsp;", "").replaceAll(" +", " ");
    }

    public static String getSelectedDateText(LocalDateTime date){
        String dayOfWeek = date.getDayOfWeek().toString();
        String monthOfYear = date.getMonth().toString();
        String dayOfMonth = date.getDayOfMonth() + "";

        if(dayOfWeek.equalsIgnoreCase("Sunday")){
            dayOfWeek = "Sunday";
        } else if(dayOfWeek.equalsIgnoreCase("Monday")){
            dayOfWeek = "Monday";
        } else if(dayOfWeek.equalsIgnoreCase("Tuesday")){
            dayOfWeek = "Tuesday";
        } else if(dayOfWeek.equalsIgnoreCase("Wednesday")){
            dayOfWeek = "Wednesday";
        } else if(dayOfWeek.equalsIgnoreCase("Thursday")){
            dayOfWeek = "Thursday";
        } else if(dayOfWeek.equalsIgnoreCase("Friday")){
            dayOfWeek = "Friday";
        } else if(dayOfWeek.equalsIgnoreCase("Saturday")){
            dayOfWeek = "Saturday";
        }

        if(monthOfYear.equalsIgnoreCase("January")){
            monthOfYear = "January";
        } else if(monthOfYear.equalsIgnoreCase("February")){
            monthOfYear = "February";
        } else if(monthOfYear.equalsIgnoreCase("March")){
            monthOfYear = "March";
        } else if(monthOfYear.equalsIgnoreCase("April")){
            monthOfYear = "April";
        } else if(monthOfYear.equalsIgnoreCase("May")){
            monthOfYear = "May";
        } else if(monthOfYear.equalsIgnoreCase("June")){
            monthOfYear = "June";
        } else if(monthOfYear.equalsIgnoreCase("July")){
            monthOfYear = "July";
        } else if(monthOfYear.equalsIgnoreCase("August")){
            monthOfYear = "August";
        } else if(monthOfYear.equalsIgnoreCase("September")){
            monthOfYear = "September";
        } else if(monthOfYear.equalsIgnoreCase("October")){
            monthOfYear = "October";
        } else if(monthOfYear.equalsIgnoreCase("November")){
            monthOfYear = "November";
        } else if(monthOfYear.equalsIgnoreCase("December")){
            monthOfYear = "December";
        }

        return String.format("%s, %s %s", dayOfWeek, monthOfYear, dayOfMonth);
    }

    public static String getSelectedFromMenuText(String date){
        if(date.contains("Jan")){
            return date.replace("Jan", "January");
        } else if(date.contains("Feb")){
            return date.replace("Feb", "February");
        } else if(date.contains("Aug")){
            return date.replace("Aug", "August");
        } else if(date.contains("Sept")){
            return date.replace("Sept", "September");
        } else if(date.contains("Oct")){
            return date.replace("Oct", "October");
        } else if(date.contains("Nov")){
            return date.replace("Nov", "November");
        } else if(date.contains("Dec")){
            return date.replace("Dec", "December");
        } else {
            return date;
        }
    }

    public static String getMenuDateText(LocalDateTime date){
        String dayOfWeek = date.getDayOfWeek().toString();
        String monthOfYear = date.getMonth().toString();
        String dayOfMonth = date.getDayOfMonth() + "";

        if(dayOfWeek.equalsIgnoreCase("Sunday")){
            dayOfWeek = "Sunday";
        } else if(dayOfWeek.equalsIgnoreCase("Monday")){
            dayOfWeek = "Monday";
        } else if(dayOfWeek.equalsIgnoreCase("Tuesday")){
            dayOfWeek = "Tuesday";
        } else if(dayOfWeek.equalsIgnoreCase("Wednesday")){
            dayOfWeek = "Wednesday";
        } else if(dayOfWeek.equalsIgnoreCase("Thursday")){
            dayOfWeek = "Thursday";
        } else if(dayOfWeek.equalsIgnoreCase("Friday")){
            dayOfWeek = "Friday";
        } else if(dayOfWeek.equalsIgnoreCase("Saturday")){
            dayOfWeek = "Saturday";
        }

        if(monthOfYear.equalsIgnoreCase("January")){
            monthOfYear = "Jan";
        } else if(monthOfYear.equalsIgnoreCase("February")){
            monthOfYear = "Feb";
        } else if(monthOfYear.equalsIgnoreCase("March")){
            monthOfYear = "March";
        } else if(monthOfYear.equalsIgnoreCase("April")){
            monthOfYear = "April";
        } else if(monthOfYear.equalsIgnoreCase("May")){
            monthOfYear = "May";
        } else if(monthOfYear.equalsIgnoreCase("June")){
            monthOfYear = "June";
        } else if(monthOfYear.equalsIgnoreCase("July")){
            monthOfYear = "July";
        } else if(monthOfYear.equalsIgnoreCase("August")){
            monthOfYear = "Aug";
        } else if(monthOfYear.equalsIgnoreCase("September")){
            monthOfYear = "Sept";
        } else if(monthOfYear.equalsIgnoreCase("October")){
            monthOfYear = "Oct";
        } else if(monthOfYear.equalsIgnoreCase("November")){
            monthOfYear = "Nov";
        } else if(monthOfYear.equalsIgnoreCase("December")){
            monthOfYear = "Dec";
        }

        return String.format("%s, %s %s", dayOfWeek, monthOfYear, dayOfMonth);
    }
}
