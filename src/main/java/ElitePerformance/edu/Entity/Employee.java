package ElitePerformance.edu.Entity;

import lombok.Data;
@Data
public class Employee {
    private Long employeeId;
    private String name;
    private String designation;
    private double baseSalary;
    private String role;
}