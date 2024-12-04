import java.lang.reflect.Array;
import java.util.*;
public class Company {
    ArrayList<Employee> employees = new ArrayList<>();


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
         Employee employee = new RegularEmployee(id, name, grossSalary);
         employees.add(employee);
    }

    // For the managers
    public void createEmployee(String id, String name, double grossSalary, String degree){
        Employee employee = new Manager(id,name,grossSalary,degree);
        employees.add(employee);
    }


    // For the interns
    public void createEmployee(String id, String name, int gpa, double grossSalary){
        Employee employee = new Intern(id, name,gpa, grossSalary);
        employees.add(employee);
    }

    // For the directors
    public void createEmployee(String id, String name, double grossSalary, String degree, String department){
        Employee employee = new Director(id, name, grossSalary, degree, department);
        employees.add(employee);
    }

    // Prints employee
    public void printEmployee(String id){
        Employee employee = retrieveEmployee(id);
        if (employee == null) {  // Error handling if id is not found.
            System.out.println("Employee " + id + " was not registered yet.");
        }
        else {
            employee.printEmployee(employee);
        }
    }

    public String updateInternGPA(String id, int gpa){
        Employee employee = retrieveEmployee(id);
        if (employee == null) { // Error handling if id is not found.
            System.out.println("Employee " + id + " was not registered yet.");
        }
        else {
            if (employee instanceof Intern){
                Intern currentIntern = (Intern) employee;
                currentIntern.setGPA(gpa); // Downcasts so we don't need to add the method in the abstract class
            }

        }
return "hi";
    }
    /*
    public void printSortedEmployees(){
        ArrayList<Employee> sortedList = new ArrayList<>();
        ArrayList<Employee> unsortedList = new ArrayList<>(employees);
        double smallestSalary = 0;
        for (Employee employee: unsortedList){
            if
        }
        }
     */


    public void  printAllEmployees() {
        System.out.println("All registered employees:");
        for (Employee employee: employees){
            printEmployee(employee.id);
        }
    }
    public void mapEachDegree(){
        Map<String, Integer> hashMap = new HashMap<>();
        int bscAmount = 0;
        int mscAmount = 0;
        int phdAmount = 0;

        for (Employee employee: employees){
            if (employee instanceof Director || employee instanceof Manager){
                switch(employee.degree){
                    case "PhD":
                        phdAmount += 1;
                        break;
                    case "MSc":
                        mscAmount += 1;
                        break;
                    case "BSc":
                        bscAmount += 1;
                        break;
                }
            }
        }
        hashMap.put("BSc",bscAmount);
        hashMap.put("MSc",mscAmount);
        hashMap.put("PhD",phdAmount);
        System.out.println("Academic background of employees:");
        for(Map.Entry<String, Integer> hashMapPair : hashMap.entrySet()) {
            if (hashMapPair.getValue() > 0){
                System.out.printf("%s: => %d\n",hashMapPair.getKey(),hashMapPair.getValue());
            }
        }


    }
/*
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

 */
}


