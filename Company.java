import java.awt.image.ReplicateScaleFilter;
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
    public double getNetSalary(String id) {
        double grossSalary;
        Employee employee = retrieveEmployee(id);

        if (employee == null) { // Error handling if id is not found.
            System.out.println("Employee " + id + " was not registered yet.");

        }
        else {
            grossSalary = employee.getGrossSalary();
            if (employee instanceof Director) {
                if (grossSalary <= 30000) {
                    return grossSalary * 0.9;
                } else if (grossSalary <= 50000) {
                    return grossSalary * 0.8;
                } else if (grossSalary >= 50000) {
                    return (30000 * 0.8) + ((grossSalary - 30000) * 0.6);
                }
            }
            else {
                return grossSalary * 0.8;

            }
        }
        return 0.0;

    }

    public double getTotalNetSalary(){
        double totalNetSalary = 0;
        for (Employee employee: employees){
            totalNetSalary += getNetSalary(employee.id);
        }
        return totalNetSalary;
    }
    public String updateEmployeeName(String id, String newName){
        Employee employee = retrieveEmployee(id);
        employee.setName(newName);
        return "Employee " + id + " was updated successfully";
    }

    public String updateManagerDegree(String id, String newDegree){
        Employee employee = retrieveEmployee(id);
        if (employee instanceof Manager){
            Manager currentManager = (Manager) employee;
            currentManager.setDegree(newDegree);
            return "Employee " + id + " was updated successfully";
        }
        else if (employee instanceof Director){
            Director currentDirector = (Director) employee;
            currentDirector.setDegree(newDegree);
            return "Employee " + id + " was updated successfully";
        }
        return "Employee " + id + " was updated unsuccessfully";
    }
    public String updateDirectorDept(String id, String newDepartment) {
        Employee employee = retrieveEmployee(id);
        if (employee instanceof Director) {
            Director currentDirector = (Director) employee;
            currentDirector.setDepartment(newDepartment);
            return "Employee " + id + " was updated successfully";

        }
        return "Employee " + id + " was updated unsuccessfully";
    }
    public String updateGrossSalary(String id, double newGrossSalary){
        Employee employee = retrieveEmployee(id);
        employee.setGrossSalary(newGrossSalary);
        return "Employee " + id + " was updated successfully";
    }

    public void removeEmployee(String id){
        Employee employee = retrieveEmployee(id);
        employees.remove(employee);
    }


    public String promoteToManager(String id, String degree){
        Employee employee = retrieveEmployee(id);
        createEmployee(employee.id, employee.name, employee.grossSalary, degree);
        employees.remove(employee);
        return employee.id + " promoted successfully to Manager";
    }

    public String promoteToDirector(String id, String degree, String department){
        Employee employee = retrieveEmployee(id);
        createEmployee(employee.id, employee.name, employee.grossSalary, degree, department);
        employees.remove(employee);
        return employee.id + " promoted successfully to Director";
    }

    public String promoteToIntern(String id, int gpa) {
        Employee employee = retrieveEmployee(id);
        createEmployee(employee.id, employee.name, gpa, employee.grossSalary);
        employees.remove(employee);
        return employee.id + " promoted successfully to Intern";
    }

    // For regular employees
    public String createEmployee(String id, String name, double grossSalary){
         Employee employee = new RegularEmployee(id, name, grossSalary);
         employees.add(employee);
         return "Employee " + id + "was registered successfully.";
    }

    // For the managers
    public String createEmployee(String id, String name, double grossSalary, String degree){
        Employee employee = new Manager(id,name,grossSalary,degree);
        employees.add(employee);
        return "Employee " + id + "was registered successfully.";

    }


    // For the interns
    public String createEmployee(String id, String name, int gpa, double grossSalary){
        Employee employee = new Intern(id, name,gpa, grossSalary);
        employees.add(employee);
        return "Employee " + id + "was registered successfully.";

    }

    // For the directors
    public String createEmployee(String id, String name, double grossSalary, String degree, String department){
        Employee employee = new Director(id, name, grossSalary, degree, department);
        employees.add(employee);
        return "Employee " + id + "was registered successfully.";

    }

    // Prints employee
    public String printEmployee(String id){
        Employee employee = retrieveEmployee(id);
        if (employee == null) {  // Error handling if id is not found.
            return"Employee " + id + " was not registered yet.";
        }
        else {
           return employee.printEmployee(employee);
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

    public String printSortedEmployees(){

        ArrayList<Employee> sortedList = new ArrayList<>();
        ArrayList<Employee> unsortedList = new ArrayList<>(employees);

        while (!unsortedList.isEmpty()){
            double smallestSalary = unsortedList.get(0).grossSalary;
            int knownIndex = 0;

            for(int i = 0; i < unsortedList.size(); i++){
                Employee current = unsortedList.get(i);
                if(current.grossSalary < smallestSalary ) {
                    smallestSalary = current.grossSalary;
                    knownIndex = i;
                }
            }
            sortedList.add(unsortedList.get(knownIndex));
            unsortedList.remove(knownIndex);
        }
        String message = "";
        for(Employee employee: sortedList){
            message += printEmployee(employee.id)+"\n";
        }
        return message;
        }



    public String printAllEmployees() {
        String message = "All registered employees: \n";
        for (Employee employee: employees){
            message += printEmployee(employee.id)+"\n";
        }
        return message;
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


