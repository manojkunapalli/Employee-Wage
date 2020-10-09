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
        Scanner input = new Scanner(System.in);
        System.out.print("number of days Employee worked = ");
        int num_days = input.nextInt();
        int hours_per_day = 0;
        String str = "";
        int TotalSalary=0;
        Random rand = new Random();
        int employeeType;
        for(int i=1;i<=num_days;i++){
             employeeType = 1 + rand.nextInt( 2 );
            switch (employeeType) {
                case 1:
                    str="Full Time Employee";
                    hours_per_day=8;
                    break;
                case 2:
                    str="Part Time Employee";
                    hours_per_day=4;
            }
            wage = ( hours_per_day ) * wage_per_hour;
            TotalSalary+=wage;
            System.out.println("Salary of "+str+" on the day "+i+" = "+wage);
        }
        System.out.println("Total Salary = "+TotalSalary);
    }

    public static void main(String[] args){
        System.out.println("Welcome to Employee Computation program");

        Random rand = new Random();
        //Employee Attendance
        int present_absent = rand.nextInt(1);
        check_Attendance(present_absent);

        //Employee wage calculation
        calculate_Wage();
    }
}
