import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Company facade = new Company();
        facade.createEmployee("Sam","Tsetsen",2,"MSc", "tinyDicks");
        facade.createEmployee("Olle", "Moez", 1, "BSc");
        facade.createEmployee("auhdu", "42", 1, "PhD");

        facade.mapEachDegree();
        facade.printAllEmployees();
    }

}
