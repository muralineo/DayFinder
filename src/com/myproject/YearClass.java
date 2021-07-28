package com.myproject;

public abstract class YearClass  implements LeapYear, CenturyYear{



    public abstract boolean checkValidMonth(String month);
    public abstract boolean checkValidYear(int year);

    public int yearCode(int year){
        return ((year % 100) + ((year % 100) / 4)) % 7;
    }

    public int monthCode(String month){
        int codeMonth = 0;
        switch (month){
            case "january":
            case "october":
                codeMonth = 0;
                break;
            case "february":
            case "november":
            case "march":
                codeMonth = 3;
                break;
            case "april":
            case "july":
                codeMonth = 6;
                break;
            case "may":
                codeMonth = 1;
                break;
            case "june":
                codeMonth = 4;
                break;
            case "august":
                codeMonth = 2;
                break;
            case "september":
            case "december":
                codeMonth = 5;
                break;
            default:
                System.out.println("Enter the correct month. Ex: January");
                break;
        }

        return codeMonth;
    }

    @Override
    public int centuryCode(int year) {
        int codeCentury = 0;
        if (year >= 1700 && year <= 1799){
            codeCentury = 4;
        }
        else if (year >= 1800 && year <= 1899) {
            codeCentury = 2;
        }
        else if (year >= 1900 && year <= 1999 ){
            codeCentury = 0;
        }
        else if (year >= 2000 && year <= 2099){
            codeCentury = 6;
        }
        else if (year >= 2100 && year <= 2199){
            codeCentury = 4;
        }
        else if (year >= 2200 && year <= 2299) {
            codeCentury = 2;
        }
        else if (year >= 2300 && year <= 2399) {
            codeCentury = 0;
        } else{
            System.out.println("Enter a valid year between 1700 and 2399");
        }

        return codeCentury;
    }

    @Override
    public int leapYearCode(int year) {
        int codeLeapYear = 0;
        if (year % 4 == 0 && year % 100 != 0) {
            codeLeapYear = 1;
        }
        else if (year % 100 == 0 && year % 400 == 0) {
            codeLeapYear = 1;
        }

        return codeLeapYear;
    }
}
