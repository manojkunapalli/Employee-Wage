import java.util.*;

public class EmployeeWageCalculation {
    public static final int numOfWorkingDays = 20;
    private static final int wagePerHour = 20;
    public int presentOrAbsent = 0;

    public void checkAttendance() {
        if(this.presentOrAbsent == 1){
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }
    }

    public static int calculateWage() {
        int wage;
        int hoursPerDay = 0;
        String str = "";
        int TotalSalary=0;
        int TotalHours=0;
        int fullTimeWorkingHours=0;
        int partTimeWorkingHours=0;
        Random rand = new Random();
        int employeeType;
        Map<String,Integer> map = new HashMap<>();

        System.out.println("Calculating Wages for a month ...");
        for(int i=1;i<=numOfWorkingDays;i++){
            if(TotalHours <= 100) {
                employeeType = 1 + rand.nextInt(2);
                switch (employeeType) {
                    case 1:
                        str = "FullTimeEmployee";
                        hoursPerDay = 8;
                        TotalHours += hoursPerDay;
                        fullTimeWorkingHours+=hoursPerDay;
                        map.put(str,fullTimeWorkingHours);
                        break;
                    case 2:
                        str = "PartTimeEmployee";
                        hoursPerDay = 4;
                        TotalHours += hoursPerDay;
                        partTimeWorkingHours+=hoursPerDay;
                        map.put(str,partTimeWorkingHours);
                        break;
                }
                wage = (hoursPerDay) * wagePerHour;
                TotalSalary += wage;
                System.out.println("Salary of " + str + " on the day " + i + " = " + wage);
            } else {
                System.out.println();
                System.out.println("Total working hours reached 100 and above..................");
                break;
            }
        }

        System.out.println();
        System.out.println("EmployeeType                 WorkingHours");

        for ( Map.Entry<String, Integer>  t  :  map.entrySet() )  {
            System.out.println(t.getKey() +"     ----->      "+t.getValue());
        }

        System.out.println();
        System.out.println("Total Working hours = "+TotalHours);
        return TotalSalary;
    }

    public static void main(String[] args){
        System.out.println("Welcome to Employee Computation program");

        Random rand = new Random();
        EmployeeWageCalculation obj = new EmployeeWageCalculation();

        //Employee Attendance
        obj.presentOrAbsent = 1 + rand.nextInt(2);
        obj.checkAttendance();

        //Employee wage calculation
        System.out.println("Total Salary = "+calculateWage());
    }
}
