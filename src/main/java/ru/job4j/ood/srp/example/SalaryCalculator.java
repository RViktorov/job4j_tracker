package ru.job4j.ood.srp.example;
//в классе нарушение SRP, т.к в нем и расчет зар. платы и вывод ее на печать,
// необходимо печать вынести в другой класс
public class SalaryCalculator {

    public double calculateSalary(int hours) {
        return hours * 5000;
    }

    public void printSalary(double salary) {
        System.out.println("Salary: " + salary);
    }

}