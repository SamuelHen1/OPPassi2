package assignment3;

import static java.lang.Double.parseDouble;


public class Intern extends Employee {
    public Intern(String id, String name, int gpa, double grossSalary) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.grossSalary = parseDouble(String.format ("%.2f",grossSalary));
    }

    public String getEmployeeId(){

        return id;
    }
    //BRO CHANGE THIS SIVERT
    @Override
    public double getGrossSalary() {
        return 0;
    }

    @Override
    public void setName(String newName) {
        name = newName;
    }

    @Override
    public void setGrossSalary(double newGrossSalary) {
        grossSalary = parseDouble(String.format ("%.2f",newGrossSalary));
    }

    public double getGrossSalary(int gpa,double grossSalary){
        double finalGrossSalary;
        int salaryBonus = 1000;

        if (gpa <= 5 && gpa >= 0) {
            finalGrossSalary = 0;
        }
        else if (gpa <= 8 && gpa > 5) {
            finalGrossSalary = grossSalary;
        }
        else if (gpa <= 10 && gpa > 8) {
            finalGrossSalary = grossSalary + salaryBonus;
        }
        else {
            finalGrossSalary = grossSalary;
        }

        return finalGrossSalary;
    }

    public void setGPA(int gpa) {

        this.gpa = gpa;
    }

    public double truncateSalary(double grossSalary){
        double truncatedSalary = Math.floor(grossSalary*100)/100.0;
        return truncatedSalary;
    }

    public String printEmployee(Employee employee){

        double truncatedSalary = truncateSalary(getGrossSalary(employee.gpa,employee.grossSalary));
        String printMe = employee.name + "'s gross salary is " + String.format("%.2f",truncatedSalary) + " SEK per month. GPA: " + gpa;
        System.out.println(printMe);
        return printMe;
    }

}
