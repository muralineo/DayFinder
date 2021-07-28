package com.myproject;

import java.util.Scanner;

public class FindMyDay extends YearClass implements DayCheck{

    String[] months = {"january", "february", "march", "april", "may", "june", "july",
            "august", "september","october", "november", "december"};
    boolean checkMonth = false;
    boolean checkDay = false;
    boolean checkYear = false;
    int codeLeap;
    int dayCode;
    int codeCentury;
    int codeMonth;
    int codeYear;
    int year;
    String month;
    int date;

    // Ensures that the user inputs correct date
    @Override
    public boolean CheckValidDay(int date) {
        if (date > 0 && date <= 31) {
            checkDay = true;
        } else{
            System.out.println("Enter valid date");
        }
        return checkDay;
    }

    // Ensures that the user inputs valid month
    @Override
    public boolean checkValidMonth(String month) {

        for (String s : months) {
            if (month.equals(s)) {
                checkMonth = true;
                break;
            }
        }

        return checkMonth;
    }

    // Ensures that the user inputs valid year
    @Override
    public boolean checkValidYear(int year) {
        if (year >= 1700 && year < 2400){
            checkYear = true;
        }
        return checkYear;
    }

    public void findDay () {
        Scanner scan = new Scanner(System.in);
        // Gets inputs from user
        System.out.println("Enter the year from 1700 to 2399: ");
        year = scan.nextInt();

        System.out.println("Enter the month Ex: January  : ");
        month = scan.next().toLowerCase();

        System.out.println("Enter the day Ex: 01 or 21");
        date = scan.nextInt();

        // Calling methods from parent class
        codeYear = yearCode(year);
        codeMonth = monthCode(month);
        codeLeap = leapYearCode(year);
        codeCentury = centuryCode(year);


        if (checkValidYear(year) && checkValidMonth(month) && CheckValidDay(date) ) {

            if ((codeLeap == 1) && (month.equals("January") || month.equals("February"))) {

                dayCode = (codeYear + codeMonth + codeCentury + date - codeLeap) % 7;
            }
            else {

                dayCode = (codeYear + codeMonth + codeCentury + date) % 7;
            }

            switch (dayCode){
                case 0:
                    System.out.println("Sunday");
                    break;

                case 1:
                    System.out.println("Monday");
                    break;

                case 2:
                    System.out.println("Tuesday");
                    break;

                case 3:
                    System.out.println("Wednesday");
                    break;

                case 4:
                    System.out.println("Thursday");
                    break;

                case 5:
                    System.out.println("Friday");
                    break;

                case 6:
                    System.out.println("Saturday");
                    break;
            }

        } else {
            System.out.println("Enter valid input and try again");

        }
    }

    public static void main(String[] args) {

        FindMyDay myDay = new FindMyDay();
        myDay.findDay();
    }



}
