package com.ex1.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelper
{
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void printCurrentDate()
    {
        System.out.println(LocalDate.now().format(formatter));
    }

    public static void main(String[] args)
    {
        DateHelper.printCurrentDate();
    }
}
