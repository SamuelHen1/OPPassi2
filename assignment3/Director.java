package assignment3;


import static java.lang.Double.parseDouble;
import static java.lang.Math.floor;

public class Director extends Employee {
    public Director(String id, String name, double grossSalary, String degree, String department) {
        this.id = id;
        this.name = name;
        this.degree = degree;
        this.grossSalary = parseDouble(String.format ("%.2f",grossSalary));
        this.department = department;
    }

    public String getEmployeeId(){

        return id;
    }

    @Override
    public double getGrossSalary() {
        double finalGrossSalary;
        if (degree == "BSc"){
            finalGrossSalary = grossSalary * 1.1 + 5000;
        }
        else if (degree == "MSc") {
            finalGrossSalary = grossSalary * 1.2 + 5000;
        }
        else{
            finalGrossSalary = grossSalary * 1.35 + 5000;
        }

        return finalGrossSalary;
    }

    @Override
    public void setName(String newName) {
        name = newName;
    }

    @Override
    public void setGrossSalary(double newGrossSalary) {
        grossSalary = parseDouble(String.format ("%.2f",newGrossSalary));
    }

    public void setDegree(String newDegree){
        degree = newDegree;
    }
    public void setDepartment(String newDepartment){
        department = newDepartment;
    }

    public double truncateSalary(double grossSalary){
        double truncatedSalary = Math.floor(grossSalary*100)/100.0;
        return truncatedSalary;
    }

    public String printEmployee(Employee employee){
        double truncatedSalary = truncateSalary(getGrossSalary());
        String printMe = employee.degree + " " + employee.name + "'s gross salary is " + String.format("%.2f",truncatedSalary) + " SEK per month. Dept: " + department;
        System.out.println(printMe);
        return printMe;
    }


}




