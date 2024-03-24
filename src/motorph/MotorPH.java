package motorph;


import java.text.DecimalFormat;

import java.util.Scanner;


/**

 *

 * @author ACER

 */

public class MotorPH {


    /**

     * @param args the command line arguments

     */

    public static void main(String[] args) {

       


        try (var scanner = new Scanner(System.in)) {

            DecimalFormat df = new DecimalFormat("#,##0.00");// Format total cost to display two decimal places

           

            // Input employee ID

            System.out.print("Enter employee ID#: ");

            int EmpId = scanner.nextInt();

            scanner.nextLine();

           

            // Input employee name

            System.out.print("Enter employee full name: ");

            String fullName = scanner.nextLine();

           

            // Input login time

            System.out.print("Enter login time (in military format, e.g., 0800): ");

            int loginTime = scanner.nextInt();

           

            // Input logout time

            System.out.print("Enter logout time (in military format, e.g., 1700): ");

            int logoutTime = scanner.nextInt();

           

            // Calculate total work time

            int totalWorkTime = calculateTotalWorkTime(loginTime, logoutTime);

           

            // Input cost per hour

            System.out.print("Enter cost per hour: ");

            double costPerHour = scanner.nextDouble();

           

            // Display total time and cost

            System.out.println("\nEmployee ID: " + EmpId);

            System.out.println("Employee Name: " + fullName);

            System.out.println("Time In: " + formatTime(loginTime));

            System.out.println("Time Out: " + formatTime(logoutTime));

            System.out.println("Total Work Time: " + formatTotalWorkTime(totalWorkTime));

           

            // Calculate deduction if login is greater than or equal to 0811

            // (MonthlySalary or the TotalCost - BIRMonthlyRate)*20%

            double deduction = 0.0;

            if (loginTime >= 811) {

                double totalCost = calculateTotalCost(totalWorkTime, costPerHour);

                double withholdingTax = 0.20 * (totalCost - deduction);

                double sssDeduction = 1123.00;

                double philhealthDeduction = 375.00;

                double pagIbigDeduction = 100.00;

                deduction = sssDeduction + philhealthDeduction + pagIbigDeduction;

               

                // deduction = calculateDeduction(loginTime);

                System.out.println("\nSSS: P 1,123.00");

                System.out.println("PhilHealth: P 375.00");

                System.out.println("Pag-Ibig: P 100.00");

                System.out.println("Withholding Tax: " + df.format(withholdingTax));

                System.out.println("Deduction: P " + df.format(deduction));

            }

           

            // Calculate total cost

            double totalCost = calculateTotalCost(totalWorkTime, costPerHour);

           

            // Add deduction to the total cost

            totalCost -= deduction;

            System.out.println("Total Cost: P " + df.format(totalCost));

        } // Format total cost to display two decimal places

                        }


                        // Method to calculate total work time

                        public static int calculateTotalWorkTime(int loginTime, int logoutTime) {

                                int loginHour = loginTime / 100;

                                int loginMinute = loginTime % 100;


                                int logoutHour = logoutTime / 100;

                                int logoutMinute = logoutTime % 100;


                                int totalWorkHour = logoutHour - loginHour;

                                int totalWorkMinute = logoutMinute - loginMinute;


                                if (totalWorkMinute < 0) {

                                        totalWorkHour--;

                                        totalWorkMinute += 60;

                                }


                                return totalWorkHour * 60 + totalWorkMinute;

                        }


                        // Method to calculate total cost

                        public static double calculateTotalCost(int totalWorkTime, double costPerHour) {

                                return (totalWorkTime / 60.0) * costPerHour;

                        }


                        // Method to format time (add leading zeros if necessary)

                        public static String formatTime(int time) {

                                int hour = time / 100;

                                int minute = time % 100;

                                return String.format("%02d:%02d", hour, minute);

                        }


                        // Method to format total work time

                        public static String formatTotalWorkTime(int totalWorkTime) {

                                int hours = totalWorkTime / 60;

                                int minutes = totalWorkTime % 60;

                                return hours + " hours " + minutes + " minutes";

                        }

                   

                        

        }

