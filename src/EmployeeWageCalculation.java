import java.util.*;

interface EmployeeWageInterface {
    double calculateWage(List<EmpWageBuilder> arraylist,int index);
}

class EmpWageBuilder implements EmployeeWageInterface {
    public String companyName;
    public int numOfWorkingDays;
    public double wagePerHour;
    public int workingHoursPerMonth;

    EmpWageBuilder(String companyName,int numOfWorkingDays,double wagePerHour,int workingHoursPerMonth) {
        this.companyName = companyName;
        this.numOfWorkingDays = numOfWorkingDays;
        this.wagePerHour = wagePerHour;
        this.workingHoursPerMonth = workingHoursPerMonth;
    }

    public double calculateWage(List<EmpWageBuilder> arraylist,int index) {
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
        System.out.println("Calculating Wages for a month of "+arraylist.get(index).companyName+"............");
        for(int i=1;i<=arraylist.get(index).numOfWorkingDays;i++) {
            if(TotalHours <= arraylist.get(index).workingHoursPerMonth) {
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
                wage = (hoursPerDay) * arraylist.get(index).wagePerHour;
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
}

public class EmployeeWageCalculation extends EmpWageBuilder{
    EmployeeWageCalculation(String companyName, int numOfWorkingDays, double wagePerHour, int workingHoursPerMonth) {
        super(companyName, numOfWorkingDays, wagePerHour, workingHoursPerMonth);
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

    @Override
    public String toString() {
        return "Company name => "+companyName+"\nnumber of working days => "+numOfWorkingDays+"\nWage per Hour => "+wagePerHour+"\nWorking Hours Per Month => "+workingHoursPerMonth;
    }

    public static void main(String[] args){
        System.out.println("**********************************Welcome to Employee Computation program**********************************\n");

        List<EmpWageBuilder> arraylist = new ArrayList<>();

        EmployeeWageCalculation philips = new EmployeeWageCalculation("Philips",22,247.43,176);
        EmployeeWageCalculation jio = new EmployeeWageCalculation("Jio",20,198.54,165);
        EmployeeWageCalculation cognizant = new EmployeeWageCalculation("Cognizant",15,160.78,160);

        arraylist.add(philips);
        arraylist.add(jio);
        arraylist.add(cognizant);

        //Employee Attendance
        checkAttendance();

        //Given Details
        System.out.println("Given details of Companies...................");
        for(EmpWageBuilder details:arraylist){
            System.out.println("***************************************************************");
            System.out.println(details);
        }
        System.out.println("***************************************************************");

        //Employee wage calculation
        System.out.println("Total Salary = "+philips.calculateWage(arraylist,0)+"\n");
        System.out.println("Total Salary = "+jio.calculateWage(arraylist,1)+"\n");
        System.out.println("Total salary = "+cognizant.calculateWage(arraylist,2)+"\n");
    }
}
