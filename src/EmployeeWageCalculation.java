import java.util.*;

public class EmployeeWageCalculation {
    public String companyName;
    public int numOfWorkingDays;
    public double wagePerHour;
    public int workingHoursPerMonth;

    EmployeeWageCalculation(String companyName,int numOfWorkingDays,double wagePerHour,int workingHoursPerMonth) {
        this.companyName = companyName;
        this.numOfWorkingDays = numOfWorkingDays;
        this.wagePerHour = wagePerHour;
        this.workingHoursPerMonth = workingHoursPerMonth;
    }

    public static void checkAttendance() {
        System.out.println("*****Attendance Check*****");
        Random rand = new Random();
        int presentOrAbsent = 1 + rand.nextInt(2);
        if(presentOrAbsent == 1) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }
    }

    public double calculateWage(EmployeeWageCalculation[] array,int index) {
        double wage;
        int hoursPerDay = 0;
        String str = "";
        double TotalSalary=0;
        int TotalHours=0;
        int fullTimeWorkingHours=0;
        int partTimeWorkingHours=0;
        Random rand = new Random();
        int employeeType;
        Map<String,Integer> map = new HashMap<>();
        System.out.println("Calculating Wages for a month of "+array[index].companyName+"............");
        for(int i=1;i<=array[index].numOfWorkingDays;i++) {
            if(TotalHours <= array[index].workingHoursPerMonth) {
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
                wage = (hoursPerDay) * array[index].wagePerHour;
                TotalSalary += wage;
            } else {
                break;
            }
        }
        System.out.println("EmployeeType                 WorkingHours");
        for ( Map.Entry<String, Integer>  t  :  map.entrySet() )  {
            System.out.println(t.getKey() +"     ----->      "+t.getValue());
        }

        System.out.println();
        System.out.println(companyName+" Total Working hours = "+TotalHours);
        return TotalSalary;
    }

    @Override
    public String toString() {
        return "Company name => "+companyName+"\nnumber of working days => "+numOfWorkingDays+"\nWage per Hour => "+wagePerHour+"\nWorking Hours Per Month => "+workingHoursPerMonth;
    }

    public static void main(String[] args){
        System.out.println("**********************************Welcome to Employee Computation program**********************************\n");

        EmployeeWageCalculation[] array = new EmployeeWageCalculation[3];
        EmployeeWageCalculation philips = new EmployeeWageCalculation("Philips",22,247.43,176);
        EmployeeWageCalculation jio = new EmployeeWageCalculation("Jio",20,198.54,165);
        EmployeeWageCalculation cognizant = new EmployeeWageCalculation("Cognizant",15,160.78,160);

        array[0] = philips;
        array[1] = jio;
        array[2] = cognizant;

        //Employee Attendance
        checkAttendance();

        //Given Details
        System.out.println("Given details of Companies...................");
        for(EmployeeWageCalculation details:array){
            System.out.println("***************************************************************");
            System.out.println(details);
        }
        System.out.println("***************************************************************");

        //Employee wage calculation
        System.out.println("Total Salary = "+philips.calculateWage(array,0)+"\n");
        System.out.println("Total Salary = "+jio.calculateWage(array,1)+"\n");
        System.out.println("Total salary = "+cognizant.calculateWage(array,2)+"\n");
    }
}
