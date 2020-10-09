import java.util.Random;

public class EmployeeWageCalculation {
    public static void main(String[] args){
        System.out.println("Welcome to Employee Computation program");

        //Employee Attendance
        Random rand = new Random();
        int present_absent = rand.nextInt(1);
        if(present_absent == 1){
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }
    }
}
