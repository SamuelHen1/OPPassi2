import java.util.*;
public abstract class Company {
    ArrayList<Employee> employees;


    public Employee retriveEmployee(String id){
        for(Employee employee: employees){
            if ((employee.getEmployeeId()).equals(id)){
                return employee;
            }

        }
        return null;
    }
    public void createEmployee(String id, String name, double grossSalary){
         Employee employee = new Employee(id, name, grossSalary);
         employees.add(employee);

    }
    public void removeEmployee(String id){
        Employee employee = retriveEmployee(id);
        employees.remove(employee);
    }
    public void updateName(String id, String newName){
        Employee employee =retriveEmployee(id);
        employee.setName(newName);
        System.out.println();
    }
    public void updateSalary(String id, double newSalary){
        employees.get(id).setSalary(newSalary);
    }
}

