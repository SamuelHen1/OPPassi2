package assignment3;

import static java.lang.Double.parseDouble;

public class RegularEmployee extends Employee{
    public RegularEmployee(String id, String name, double grossSalary) {
        this.id = id;
        this.name = name;
        this.grossSalary =  parseDouble(String.format ("%.2f",grossSalary));
    }

    public String getEmployeeId(){

        return id;
    }

    @Override
    public double getGrossSalary() {

        return grossSalary;
    }

    @Override
    public void setName(String newName) {
        name = newName;
    }

    @Override
    public void setGrossSalary(double newGrossSalary) {
        grossSalary = parseDouble(String.format ("%.2f",newGrossSalary));
    }

    public double truncateSalary(double grossSalary){
        double truncatedSalary = Math.floor(grossSalary*100)/100.0;
        return truncatedSalary;
    }

    public String printEmployee(Employee employee){
        double truncatedSalary = truncateSalary(getGrossSalary());
        String printMe = employee.name + "'s gross salary is " + String.format("%.2f",truncatedSalary) + " SEK per month.";
        System.out.println(printMe);
        return printMe;
    }
}
