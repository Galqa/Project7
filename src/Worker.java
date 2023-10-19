/* Створіть проект. Потрібно: Описати клас з ім'ям Worker, що містить такі поля:
  прізвище та ініціали працівника;
  назва посади;
  рік надходження на роботу.
 Написати програму, яка виконує такі дії:
  введення з клавіатури даних до масиву, що складається з п'яти елементів типу Worker (записи мають бути впорядковані за абеткою);
  якщо значення року введено не у відповідному форматі, видає виняток.
  виведення на екран прізвища працівника, стаж роботи якого перевищує введене значення.
 */


import java.util.*;

class Worker implements Comparable<Worker> {
    String surname;
    String position;
    int year;

    public Worker(String surname, String position, int year) {
        this.surname = surname;
        this.position = position;
        this.year = year;
    }

    @Override
    public int compareTo(Worker other) {
        return this.surname.compareTo(other.surname);
    }
}

 class NewWorker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Worker> workers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Введіть прізвище та ініціали працівника:");
            String surname = scanner.nextLine();

            System.out.println("Введіть назву посади:");
            String position = scanner.nextLine();

            System.out.println("Введіть рік надходження на роботу:");
            int year;
            try {
                year = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Значення року введено не у відповідному форматі.");
                return;
            }
            workers.add(new Worker(surname, position, year));
        }

        Collections.sort(workers);

        System.out.println("Ввести стаж роботи:");
        int experience = scanner.nextInt();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        for (Worker worker : workers) {
            if (currentYear - worker.year > experience) {
                System.out.println(worker.surname);
            }
        }
    }
}












