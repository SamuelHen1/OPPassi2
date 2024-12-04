import java.util.Objects;

public class Manager extends Employee {
    private String degree;
    public Manager(String id, String name, double grossSalary, String degree) {
        super(id, name, grossSalary);
        this.degree = degree;

    }

    public void calculateSalary(String degree){
        if (Objects.equals(degree, "BCs")){
            grossSalary = grossSalary
        }
    }

}
