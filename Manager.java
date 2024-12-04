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
        grossSalary = newGrossSalary;
    }

    public void setDegree(String newDegree){
        degree = newDegree;
    }

 /*
    public void calculateSalary(String degree){
        if (Objects.equals(degree, "BCs")){
            grossSalary = grossSalary;
        }
    }
    */

    public String printEmployee(Employee employee){
            String printMe = employee.degree + " " + employee.name + "'s gross salary is " + employee.grossSalary + "SEK per month.";
            System.out.println(printMe);
            return printMe;
    }

}
