package assignment3;

import static java.lang.Double.parseDouble;


public class Manager extends Employee {

    public Manager(String id, String name, double grossSalary, String degree) {
        this.id = id;
        this.name = name;
        this.degree = degree;
        this.grossSalary = parseDouble(String.format ("%.2f",grossSalary));

    }


    public String getEmployeeId(){

        return id;
    }

    @Override
    public double getGrossSalary() {
        double finalGrossSalary;

        if (degree.equals("BSc")){
            finalGrossSalary = grossSalary * 1.1;
        }
        else if (degree.equals("MSc")) {
            finalGrossSalary = grossSalary * 1.2;
        }
        else{
            finalGrossSalary = grossSalary * 1.35;
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

    public double truncateSalary(double grossSalary){
        double truncatedSalary = Math.floor(grossSalary*100)/100.0;
        return truncatedSalary;
    }

    public String printEmployee(Employee employee){
            double truncatedSalary = truncateSalary(getGrossSalary());
            String printMe = employee.degree + " " + employee.name + "'s gross salary is " + String.format("%.2f",truncatedSalary) + " SEK per month.";
            System.out.println(printMe);
            return printMe;
    }

}
