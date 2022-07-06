package com.mortgage.com;

import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {
        mortgage_Calculator();
    }
    private static double mortgage_Calculator(){
        double principal;
        double annual_interest_rate;
        double period_years;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Principal:  ");
            principal = scanner.nextDouble();
            if (principal>= 1000 && principal <=2000000){
                break;
            }
            System.out.println("Enter a figure between 1000 and 2000000");
        }
        while (true){
            System.out.print("Annual Interest Rate:  ");
            annual_interest_rate = scanner.nextDouble();
            if (annual_interest_rate>= 1 && annual_interest_rate<=100){
                break;
            }
            System.out.println("Enter an interest rate between 1 and 100");
        }
        while (true){
            System.out.print("Period (Years):  ");
            period_years = scanner.nextDouble();
            if (period_years>= 1&& period_years <=50){
                break;
            }
            System.out.println("Years should be between 1 and 50.");
        }
        byte months_year = 12;
        byte percentage = 100;
        double number_payments_due = period_years* months_year;
        double monthlyPayment = (annual_interest_rate/percentage)/months_year;
        double formular_top_line = principal * (monthlyPayment )*(Math.pow(1+monthlyPayment, number_payments_due));
        double formular_bottom_line = (Math.pow((1 + monthlyPayment), number_payments_due)) - 1;
        double mortgage = formular_top_line/formular_bottom_line;
        System.out.println("Mortgage is "+ mortgage);
        return mortgage;
    }
}
