import java.util.Random;
import java.util.Scanner;

public class EmployeeWageCalculation {
    public static void check_Attendance(int present_absent) {
        if(present_absent == 1){
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }
    }

    public static void calculate_Wage() {
        int wage;
        int wage_per_hour = 20;
        System.out.println("Calculating Wages for a month ...");
        int num_days = 20;
        int hours_per_day = 0;
        String str = "";
        int TotalSalary=0;
        int TotalHours=0;
        Random rand = new Random();
        int employeeType;
        for(int i=1;i<=num_days;i++){
            if(TotalHours <= 100) {
                employeeType = 1 + rand.nextInt(2);
                switch (employeeType) {
                    case 1:
                        str = "Full Time Employee";
                        hours_per_day = 8;
                        TotalHours += hours_per_day;
                        break;
                    case 2:
                        str = "Part Time Employee";
                        hours_per_day = 4;
                        TotalHours += hours_per_day;
                }
                wage = (hours_per_day) * wage_per_hour;
                TotalSalary += wage;
                System.out.println("Salary of " + str + " on the day " + i + " = " + wage);
            } else {
                System.out.println("Total working hours reached 100 and above..................");
                break;
            }
        }
        System.out.println("Total Salary = "+TotalSalary);
        System.out.println("Total Working hours = "+TotalHours);
    }

    public static void main(String[] args){
        System.out.println("Welcome to Employee Computation program");

        Random rand = new Random();
        //Employee Attendance
        int present_absent = 1 + rand.nextInt(2);
        check_Attendance(present_absent);

        //Employee wage calculation
        calculate_Wage();
    }
}
