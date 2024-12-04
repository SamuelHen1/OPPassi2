import java.util.Objects;

public class Manager extends Employee {

    public Manager(String id, String name, double grossSalary, String degree) {
        this.id = id;
        this.name = name;
        this.degree = degree;
        this.grossSalary = grossSalary;

    }


    public String getEmployeeId(){
        return id;
    }



    public void calculateSalary(String degree){
        if (Objects.equals(degree, "BCs")){
            grossSalary = grossSalary;
        }
    }
    public String printEmployee(Employee employee){
            String printMe = employee.degree + " " + employee.name + "'s gross salary is " + employee.grossSalary + "SEK per month.";
            System.out.println(printMe);
            return printMe;
    }

}
