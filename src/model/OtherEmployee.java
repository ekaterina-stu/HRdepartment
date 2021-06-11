package model;

import java.math.BigDecimal;

public class OtherEmployee extends Employee {
    private String description;

    public OtherEmployee(String name, String dateOfBirthString, String dateOfWorkString, BigDecimal salary) {
        super(name, dateOfBirthString, dateOfWorkString, salary);
    }

    public OtherEmployee(String name, String dateOfBirthString, String dateOfWorkString, BigDecimal salary, String description) {
        super(name, dateOfBirthString, dateOfWorkString, salary);
        this.description = description;
    }

    public OtherEmployee(Employee employee) {
        super(employee.getName(), employee.getDateOfBirth(), employee.getDateOfWork(), employee.getSalary());
    }
}
