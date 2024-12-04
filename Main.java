import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Company facade = new Company();
        facade.createEmployee("Sam","Tsetsen",2,"BCs", "tinyDicks");

        facade.printEmployee("Sam");
        facade.createEmployee("Olle", "Moez", 1, "BCs");
        facade.printEmployee("Olle");
    }

}
