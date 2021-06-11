package service;

import model.Employee;

import java.util.Comparator;

public class DateOfWorkComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getDateOfWork().compareTo(o2.getDateOfWork());
    }
}
