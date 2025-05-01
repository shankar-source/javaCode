package FunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalProgrammingPOC {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Shankar", 5000)); 
        employees.add(new Employee(2, "Sumith", 60000));
        employees.add(new Employee(3, "Shiva", 70000));
        employees.add(new Employee(4, "Sourabh", 80000));


        //Predicate to filter employees with salary greater than 60000
        Predicate<Employee> higherSalaryPredicate =emp -> emp.getSalary()>60000;
        System.out.println("Employees with salary grater than 60000:");
        employees.stream().filter(higherSalaryPredicate).forEach(System.out::println);

         // 2. Function: Convert salary to another currency (e.g., USD to INR conversion)
        // Assuming 1 USD = 75 INR for this example
       
        Function<Employee, Double> convertSalary = emp -> emp.getSalary() * 82.5;
        System.out.println("\nSalaries converted to INR:");
        employees.stream().map(emp -> convertSalary.apply(emp)).forEach(System.out::println);

        // 3. Supplier: Generate a default employee
        Supplier<Employee> defaultEmployeeSupplier = () -> new Employee(0, "Default Employee", 0);
        System.out.println("\nDefault Employee: " + defaultEmployeeSupplier.get());

        // 4. Consumer: Print employee details
        Consumer<Employee> printEmployee = emp -> System.out.println("Employee: " + emp);
        System.out.println("\nEmployee Details:");
        employees.forEach(printEmployee);

    }
}
