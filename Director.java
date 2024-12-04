import java.util.Objects;

public class Director extends Employee {
    public Director(String id, String name, double grossSalary, String degree, String department) {
        this.id = id;
        this.name = name;
        this.degree = degree;
        this.grossSalary = grossSalary;
        this.department = department;
    }

    public String getEmployeeId(){
        return id;
    }




    public String printEmployee(Employee employee){
        String printMe = employee.degree + " " + employee.name + "'s gross salary is " + employee.grossSalary + "SEK per month. Dept: " + department;
        System.out.println(printMe);
        return printMe;
    }

}




