import java.util.*;

interface EmployeeWageInterface {
    void calculateWage(List<EmpWageBuilder> arraylist,int index);
}

class EmpWageBuilder implements EmployeeWageInterface {
    public String companyName;
    public int numOfWorkingDays;
    public double wagePerHour;
    public int workingHoursPerMonth;
    Map<String,Double> salaryMap = new HashMap<>();

    EmpWageBuilder(String companyName,int numOfWorkingDays,double wagePerHour,int workingHoursPerMonth) {
        this.companyName = companyName;
        this.numOfWorkingDays = numOfWorkingDays;
        this.wagePerHour = wagePerHour;
        this.workingHoursPerMonth = workingHoursPerMonth;
    }

    public void calculateWage(List<EmpWageBuilder> arraylist,int index) {
        double wage;
        int hoursPerDay = 0;
        String str = "";
        double TotalSalary=0;
        int TotalHours=0;
        Random rand = new Random();
        int employeeType;
        Map<Integer,Double> map = new HashMap<>();

        System.out.println("Calculating Wages for a month of "+arraylist.get(index).companyName+"............");
        for(int i=1;i<=arraylist.get(index).numOfWorkingDays;i++) {
            if(TotalHours <= arraylist.get(index).workingHoursPerMonth) {
                employeeType = 1 + rand.nextInt(2);
                switch (employeeType) {
                    case 1:
                        str = "FullTimeEmployee";
                        hoursPerDay = 8;
                        TotalHours += hoursPerDay;
                        break;
                    case 2:
                        str = "PartTimeEmployee";
                        hoursPerDay = 4;
                        TotalHours += hoursPerDay;
                        break;
                }
                wage = (hoursPerDay) * arraylist.get(index).wagePerHour;
                map.put(i,wage);
                TotalSalary += wage;
            } else {
                break;
            }
        }
        System.out.println("Day                 DailyWage");
        for ( Map.Entry<Integer, Double>  t  :  map.entrySet() )  {
            System.out.println(t.getKey() +"            ----->      "+t.getValue());
        }

        System.out.println();
        System.out.println(arraylist.get(index).companyName+" Total Working hours = "+TotalHours);
        salaryMap.put(arraylist.get(index).companyName,TotalSalary);
    }
}

public class EmployeeWageCalculation {
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

    public static void main(String[] args){
        System.out.println("**********************************Welcome to Employee Computation program**********************************\n");

        List<EmpWageBuilder> arraylist = new ArrayList<>();

        EmpWageBuilder philips = new EmpWageBuilder("Philips",22,247.43,176);
        EmpWageBuilder jio = new EmpWageBuilder("Jio",20,198.54,165);
        EmpWageBuilder cognizant = new EmpWageBuilder("Cognizant",15,160.78,160);

        arraylist.add(philips);
        arraylist.add(jio);
        arraylist.add(cognizant);

        //Employee Attendance
        checkAttendance();

        //Employee wage calculation
        philips.calculateWage(arraylist,0);
        jio.calculateWage(arraylist,1);
        cognizant.calculateWage(arraylist,2);
    }
}
