public class Employee {
    private String id;
    private String name;
    double grossSalary;
    private String degree;
    private int gpa;
    private String department;

    //For regular employees
    public Employee(String id, String name, double grossSalary){
        this.id = id;
        this.name = name;
        this.grossSalary = grossSalary;
    }

    // For the managers
    public Employee(String id, String name, double grossSalary, String degree){
        this.id = id;
        this.name = name;
        this.grossSalary = grossSalary;
        this.degree = degree;
    }
    // For the students
    public Employee(String id, String name, int gpa){
        this.id = id;
        this.name = name;
        this.grossSalary = grossSalary;
        this.gpa = gpa;
    }
    // For the directors

    public Employee(String id, String name, String degree, String department){
        this.id = id;
        this.name = name;
        this.grossSalary = grossSalary;
        this.degree = degree;
        this.department = department;
    }

    public String getEmployeeInfo(){
        return name + "'s gross salary is " + grossSalary + "SEK per month.";
    }
    public double getNetSalary(){
        return grossSalary - (grossSalary * 0.1);
    }
    public String getEmployeeId(){
        return id;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setName(String newName){
         name = newName;
    }
    public void setSalary(double newSalary){
        grossSalary = newSalary;
    }

}
