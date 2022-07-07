package com.mortgage.com;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {
        mortgageCalculator();

    }

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public static void mortgageCalculator() {
        double principal, annualInterestRate, periodYears, downPayment, balanceMonth, balancePerMonth, totalPaid;
        int count;
        Scanner scanner = new Scanner(System.in);
        principal = getPrincipal(scanner);
        annualInterestRate = getAnnualInterestRate(scanner);
        periodYears = getPeriodYears(scanner);
        downPayment = getDownPayment(scanner);
        final double monthsYear = 12, percentage = 100;
        extracted(principal, annualInterestRate, periodYears, downPayment, monthsYear, percentage);

    }

    private static void extracted(double principal, double annualInterestRate, double periodYears, double downPayment, double monthsYear, double percentage) {
        int count;
        double balanceMonth;
        double totalPaid;
        double balancePerMonth;
        double downPaymentPrincipal = (downPayment / percentage) * principal;
        double numberPaymentsDue = periodYears * monthsYear;
        double monthlyPayment = (annualInterestRate / percentage) / monthsYear;
        double downLessPrincipal = principal - downPaymentPrincipal;
        double formularTopLine = monthlyPayment * Math.pow((1 + monthlyPayment), numberPaymentsDue);
        double formularBottomLine = (Math.pow((1 + monthlyPayment), numberPaymentsDue)) - 1;
        double mortgage = downLessPrincipal * (formularTopLine / formularBottomLine);
        double topBalanceLine = (downLessPrincipal * monthlyPayment) * Math.pow((1 + monthlyPayment), numberPaymentsDue);
        double bottomBalanceLine = Math.pow((1 + monthlyPayment), numberPaymentsDue) - 1;
        System.out.println("Your mortgage is " + mortgage + " monthly, after removing a down payment of " + downPaymentPrincipal);
        count = 0;
        totalPaid = mortgage * numberPaymentsDue;
        downPaymentPrincipal = totalPaid;
        while (true) {
            if (totalPaid >= mortgage) {
                count++;
                balanceMonth = (topBalanceLine / bottomBalanceLine);
                balancePerMonth = totalPaid - balanceMonth;
                totalPaid = balancePerMonth;
                System.out.println("After you pay your mortgage for month " + count + ". Your balance after paying " + mortgage + " will $" + df.format(balancePerMonth));
            } else {
                count++;
                System.out.println("Your last payment is $" + df.format(totalPaid) + " You have paid off your last Mortgage in " + count + "months. You paid $" + df.format(downPaymentPrincipal));
                break;
            }
        }
    }

    private static double getDownPayment
            (Scanner scanner) {
        double downPayment;
        while (true) {
            System.out.print("Down Payment Percentage:  ");
            downPayment = scanner.nextDouble();
            if (downPayment >= 0 && downPayment <= 95) {
                break;
            }
            System.out.println("Percentage should be between 1 and 50.");
        }
        return downPayment;
    }

    private static double getPeriodYears
            (Scanner scanner) {
        double periodYears;
        while (true) {
            System.out.print("Period (Years):  ");
            periodYears = scanner.nextDouble();
            if (periodYears >= 1 && periodYears <= 50) {
                break;
            }
            System.out.println("Years should be between 1 and 50.");
        }
        return periodYears;
    }

    private static double getAnnualInterestRate
            (Scanner scanner) {
        double annualInterestRate;
        while (true) {
            System.out.print("Annual Interest Rate:  ");
            annualInterestRate = scanner.nextDouble();
            if (annualInterestRate >= 0.1 && annualInterestRate <= 99) {
                break;
            }
            System.out.println("Enter an interest rate between 1 and 100");
        }
        return annualInterestRate;
    }

    private static double getPrincipal(Scanner scanner) {
        double principal;
        while (true) {
            System.out.print("Principal:  ");
            principal = scanner.nextDouble();
            if (principal >= 1000 && principal <= 2000000000) {
                break;
            }
            System.out.println("Enter a figure between 1000 and 200000000");
        }

        return principal;
    }
}


