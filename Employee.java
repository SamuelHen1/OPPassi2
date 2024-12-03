public class Employee {
    private String id;
    private String name;
    double grossSalary;
    public Employee(String id, String name, double grossSalary){
        this.id = id;
        this.name = name;
        this.grossSalary = grossSalary;

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
