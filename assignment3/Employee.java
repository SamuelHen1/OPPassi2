package assignment3;

public abstract class Employee {

    String id;
    String name;
    String degree;
    double grossSalary;
    String department;
    int gpa;

    public abstract String printEmployee(Employee employee);


    public abstract String getEmployeeId();

    public abstract double getGrossSalary();

    public abstract void setName(String newName);

    public abstract void setGrossSalary(double grossSalary);

    public abstract double truncateSalary(double grossSalary);
}

