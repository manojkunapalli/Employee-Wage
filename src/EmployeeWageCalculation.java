import java.util.Random;
import java.util.Scanner;

public class EmployeeWageCalculation {
    public static void check_attendance() {
        Random rand = new Random();
        int present_absent = rand.nextInt(1);
        if(present_absent == 1){
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }
    }

    public static void calculate_Wage() {
        int wage;
        int wage_per_hour = 20;
        int hours_per_day = 8;
        Scanner input = new Scanner(System.in);
        System.out.print("number of days Employee worked = ");
        int num_days = input.nextInt();
        wage = ( num_days * hours_per_day ) * wage_per_hour;
        System.out.println("Employee wage for working hours = "+wage);
    }

    public static void main(String[] args){
        System.out.println("Welcome to Employee Computation program");

        //Employee Attendance
        check_attendance();
        //Employee wage calculation
        calculate_Wage();
    }
}
