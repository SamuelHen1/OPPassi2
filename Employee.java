import java.sql.Array;
import java.util.ArrayList;

public abstract class Employee {

    String id;
    String name;
    String degree;
    double grossSalary;
    String department;
    int gpa;

    public abstract String printEmployee(Employee employee);


    public abstract String getEmployeeId();

    public abstract String getNetSalary();
}
