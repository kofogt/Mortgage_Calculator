package com.mortgage.com;

import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {
        mortgageCalculator();
    }
    private static void mortgageCalculator(){
        double principal;
        double annualInterestRate;
        double periodYears;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Principal:  ");
            principal = scanner.nextDouble();
            if (principal>= 1000 && principal <=2000000000){
                break;
            }
            System.out.println("Enter a figure between 1000 and 200000000");
        }
        while (true){
            System.out.print("Annual Interest Rate:  ");
            annualInterestRate = scanner.nextDouble();
            if (annualInterestRate>= 1 && annualInterestRate<=100){
                break;
            }
            System.out.println("Enter an interest rate between 1 and 100");
        }
        while (true){
            System.out.print("Period (Years):  ");
            periodYears = scanner.nextDouble();
            if (periodYears>= 1&& periodYears <=50){
                break;
            }
            System.out.println("Years should be between 1 and 50.");
        }
        final int monthsYear = 12;
        final int percentage = 100;
        double numberPaymentsDue = periodYears* monthsYear;
        double monthlyPayment = (annualInterestRate/percentage)/monthsYear;
        double formularTopLine = principal * (monthlyPayment )*(Math.pow(1+monthlyPayment, numberPaymentsDue));
        double formularBottomLine = (Math.pow((1 + monthlyPayment), numberPaymentsDue)) - 1;
        double mortgage = formularTopLine/formularBottomLine;
        System.out.println("Your mortgage is "+ mortgage+" monthly.");
    }
}


