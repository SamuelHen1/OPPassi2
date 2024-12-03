import java.util.*;
public abstract class Company {
    ArrayList<Employee> employees;


    public Employee retrieveEmployee(String id){
        for(Employee employee: employees){
            if ((employee.getEmployeeId()).equals(id)){
                return employee;
            }
        }

        return null;
    }


    // For regular employees
    public void createEmployee(String id, String name, double grossSalary){
         Employee employee = new Employee(id, name, grossSalary);
         employees.add(employee);
    }


    // For the managers
    public void createEmployee(String id, String name, double grossSalary, String degree){
        Employee employee = new Employee(id, name, grossSalary, degree);
        employees.add(employee);
    }


    // For the students
    public void createEmployee(String id, String name, int gpa){
        Employee employee = new Employee(id, name,gpa);
        employees.add(employee);
    }
    // For the directors
    public void createEmployee(String id, String name, double grossSalary, String degree, String Department){
        Employee employee = new Employee(id, name, grossSalary, degree, department);
        employees.add(employee);
    }


    public void removeEmployee(String id){
        Employee employee = retrieveEmployee(id);
        if (employee == null){
            System.out.println("booo");
        }
        else{
        employees.remove(employee);
        }
    }
    public void updateName(String id, String newName){
        Employee employee = retrieveEmployee(id);
        employee.setName(newName);
        System.out.println();
    }
    public void updateSalary(String id, double newSalary){

        //employees.get(id).setSalary(newSalary);
        System.out.println("hello");
    }
    public void printEmployee(String id){
        System.out.println(retrieveEmployee(id));

    }
}

