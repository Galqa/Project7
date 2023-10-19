/*Створіть проект. Створіть клас Calculator.
У тілі класу створіть чотири методи для арифметичних дій:
(add – додавання, sub – віднімання, mul – множення, div – поділ).
Метод поділу повинен перевірити поділ на нуль, якщо перевірка не проходить, згенерувати виняток.
Користувач вводить значення, над якими хоче зробити операцію та вибрати саму операцію.
У разі виникнення помилок повинні викидатися винятки.
 */


import java.util.Scanner;

public class Calculator {
    //методи для арифметичних дій
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double sub(double num1, double num2) {
        return num1 - num2;
    }

    public double mul(double num1, double num2) {
        return num1 * num2;
    }
    //  перевіряємо поділ на нуль, якщо перевірка не проходить, згенерувати виняток
    public double div(double num1, double num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Помилка: ділення на нуль");
        }
        return num1 / num2;
    }
    // користувач вводить значення
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Введіть перше число:");
        double num1 = scanner.nextDouble();

        System.out.println("Введіть друге число:");
        double num2 = scanner.nextDouble();

        System.out.println("Вибрати операцію (add, sub, mul, div):");
        String operation = scanner.next();

        try {
            switch (operation) {
                case "add" -> System.out.println("Результат: " + calculator.add(num1, num2));
                case "sub" -> System.out.println("Результат: " + calculator.sub(num1, num2));
                case "mul" -> System.out.println("Результат: " + calculator.mul(num1, num2));
                case "div" -> System.out.println("Результат: " + calculator.div(num1, num2));
                default -> System.out.println("Невідома операція");
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}







