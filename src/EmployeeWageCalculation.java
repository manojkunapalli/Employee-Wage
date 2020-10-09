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

    public static void calculate_Wage(int employeeType) {
        int wage;
        int wage_per_hour = 20;
        Scanner input = new Scanner(System.in);
        if(employeeType == 0){
            int hours_per_day = 8;
            System.out.println("FullTime Employee");
            System.out.print("number of days Employee worked = ");
            int num_days = input.nextInt();
            wage = ( num_days * hours_per_day ) * wage_per_hour;
            System.out.println("Employee wage for working hours = "+wage);
        } else {
            System.out.println("PartTime Employee");
            int hours_per_day = 8;
            System.out.print("number of days Employee worked = ");
            int num_days = input.nextInt();
            wage = ( num_days * hours_per_day ) * wage_per_hour;
            System.out.println("Employee wage for working hours = "+wage);
        }
    }

    public static void main(String[] args){
        System.out.println("Welcome to Employee Computation program");

        Random rand = new Random();
        //Employee Attendance
        int present_absent = rand.nextInt(1);
        check_Attendance(present_absent);

        //Employee wage calculation
        int empType = rand.nextInt(1);
        calculate_Wage(empType);
    }
}
