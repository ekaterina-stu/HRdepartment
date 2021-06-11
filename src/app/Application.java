package app;
import model.Manager;
import service.DateOfWorkComparator;
import service.HrDepartment;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args)  {
        HrDepartment hr = new HrDepartment();
        String menu = "Выберите команду:" +
                "\n1 - создать сотрудника" +
                "\n2 - удалить сотрудника" +
                "\n3 - изменить тип сотрудника" +
                "\n4 - привязать сотрудника к менеджеру" +
                "\n5 - вывести список сотрудников" +
                "\n6 - сортировать список сотрудников по фамилиям" +
                "\n7 - сортировать список сотрудников по датам принятия на работу" +
                "\n0 - выход из программы";
        boolean isExit = true;
        while (isExit) {
            Collections.sort(hr.getEmployees());
            hr.printAllEmployees();
            System.out.println(menu);
            Scanner scanner = new Scanner(System.in);
            int menuNumber = scanner.nextInt();

            if (menuNumber == 1) {
                System.out.println("Выберите тип сотрудника:" +
                        "\nа) Работник;" +
                        "\nб) Менеджер;" +
                        "\nв) Другой сотрудник");
                String worker = scanner.next();
                String innerMenu = "Введите данные в формате: ФИО, дата рождения (ДД-ММ-ГГГГ), " +
                                    "дата принятия на работу (ДД-ММ-ГГГГ), зарплата";
                if (worker.equals("а")) {
                    System.out.println(innerMenu);
                    hr.createEmployeeFromString(scanner.next());
                }
                if (worker.equals("б")) {
                    System.out.println(innerMenu);
                    hr.createManagerFromString(scanner.next());
                }
                if (worker.equals("в")) {
                    System.out.println(innerMenu + ", описание сотрудника");
                    hr.createOtherEmployeeFromString(scanner.next());
                }
            }
            if (menuNumber == 2) {
                System.out.println("Выберите, кого из работников вы хотите удалить. Нажмите его порядковый номер:");
                int deleteNumber = scanner.nextInt() - 1;
                hr.deleteEmployee(deleteNumber);
            }
            if (menuNumber == 3) {
                System.out.println("Выберите, кого из работников вы хотите перевести. Нажмите его порядковый номер:");
                int promoteNumber = scanner.nextInt() - 1;
                if (hr.getEmployees().get(promoteNumber).getClass().getSimpleName().equals("Employee")) {
                    hr.promoteEmployeeToManager(promoteNumber);
                }
            }
            if (menuNumber == 4) {
                System.out.println("Выберите, кого из работников вы хотите прикрепить. Нажмите его порядковый номер:");
                int employeeNumber = scanner.nextInt() - 1;
                System.out.println("Выберите, к кому из менеджеров вы хотите прикрепить работника. Нажмите его порядковый номер:");
                int managerNumber = scanner.nextInt() - 1;
                hr.linkEmployeeToManager(hr.getEmployees().get(employeeNumber), (Manager)hr.getEmployees().get(managerNumber));
                System.out.println("Готово! Работнику ");
                hr.showManagersList((Manager)hr.getEmployees().get(managerNumber));
                System.out.println("назначен менеджер");
            }
            if (menuNumber == 5) {
                hr.printAllEmployees();
            }
            if (menuNumber == 6) {
              Collections.sort(hr.getEmployees());
              hr.printAllEmployees();
            }
            if (menuNumber == 7) {
              Comparator dateOfWorkComparator = new DateOfWorkComparator();
              Collections.sort(hr.getEmployees(), dateOfWorkComparator);
              hr.printAllEmployees();
            }
            if (menuNumber == 0) {
                isExit = false;
            }
        }
    }
}
/*
        Все необходимые классы/Интерфейсы придумать самостоятельно.
        В фирме все работники делятся на следующие типы:
        1) Работник:
        - ФИО
        - Дата рождения
        - Дата принятия на работу
        - Зарплата
        2) Менеджер
        - ФИО
        - Дата рождения
        - Дата принятия на работу
        - Зарплата
        - Список работников в подчинении данного менеджера
        3) Другие (руководство, секретари и т.д.)
        - ФИО
        - Дата рождения
        - Дата принятия на работу
        - Зарплата
        - Текстовое описание сотрудника
        Список сотрудников должен позволять добавлять, удалять, изменять тип сотрудника,
        привязывать сотрудника к менеджеру, сортировать список по фамилиям, датам принятия на работу
        Работа в консоли должна выглядеть так:
        1. Вывести список сотрудников
        2. Создать сотрудника
        ...
        0. Выход из программы

        реализовать пока только одну функцию добавление нового сотрудника
 */

//        try {
//            Employee e2 = e.clone();
//            System.out.println(e2);
//        }
//        catch (CloneNotSupportedException e1) {
//            e1.printStackTrace();
//        }

//Иванов,21-09-1978,01-09-2000,67000.98
//Сидоров,01-01-1960,01-02-1990,85000.55
//Петрова,04-04-1990,02-09-2020,45000.45,Секретарь
