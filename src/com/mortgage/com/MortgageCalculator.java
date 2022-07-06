package com.mortgage.com;

import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {
        mortgage_Calculator();
    }
    public static double mortgage_Calculator(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal:  ");
        double principal = scanner.nextDouble();
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Annual Interest Rate:  ");
        double annual_interest_rate = scanner.nextDouble();
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Period (Years):  ");
        byte months_year = 12;
        byte percentage = 100;
        double period_years = scanner.nextDouble();
        double number_payments_due = period_years* months_year;
        double monthlyPayment = (annual_interest_rate/percentage)/months_year;
        double formular_top_line = principal * (monthlyPayment )*(Math.pow(1+monthlyPayment, number_payments_due));
        double formular_bottom_line = (Math.pow((1 + monthlyPayment), number_payments_due)) - 1;
        double mortgage = formular_top_line/formular_bottom_line;
        System.out.println("Mortgage is "+ mortgage);
        return mortgage;
    }
}
