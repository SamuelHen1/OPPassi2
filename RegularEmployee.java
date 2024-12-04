public class RegularEmployee extends Employee{
    public RegularEmployee(String id, String name, double grossSalary) {
        this.id = id;
        this.name = name;
        this.grossSalary = grossSalary;
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
        grossSalary = newGrossSalary;
    }


    public String printEmployee(Employee employee){
        String printMe = employee.name + "'s gross salary is " + employee.grossSalary + "SEK per month.";
        System.out.println(printMe);
        return printMe;
    }
}
