/* Створіть проект.
 Потрібно: Описати клас з іменем Price, що містить такі поля:
  назву товару;
  назву магазину, в якому продається товар;
  вартість товару у гривнях.
 Написати програму, яка виконує такі дії:
  введення з клавіатури даних до масиву,
 що складається з двох елементів типу Price (записи мають бути впорядковані в алфавітному порядку за назвами магазинів);
  виведення на екран інформації про товари, що продаються в магазині,
 назва якого введена з клавіатури (якщо такого магазину немає, вивести виняток).
 */

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Price implements Comparable<Price> {
    String productName;
    String shopName;
    double price;

    public Price(String productName, String shopName, double price) {
        this.productName = productName;
        this.shopName = shopName;
        this.price = price;
    }

    @Override
    public int compareTo(Price price) {
        return this.shopName.compareTo(price.shopName);
    }

    @Override
    public String toString() {
        return "назва товару: " + productName + ", назва магазину: " + shopName + ", вартість товару : " + price;
    }
}

 class NewPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Price[] prices = new Price[2];

        for (int i = 0; i < 2; i++) {
            System.out.println("Введіть назву продукта: ");
            String productName = scanner.nextLine();

            System.out.println("Введіть назву магазина: ");
            String shopName = scanner.nextLine();

            System.out.println("Введіть вартість товару у гривнях: ");
            double price = scanner.nextDouble();

            scanner.nextLine();
            prices[i] = new Price(productName, shopName, price);
        }

        Arrays.sort(prices);

        System.out.println("Ввести назву магазина:");
        String shopName = scanner.nextLine();

        boolean found = false;
        for (Price price : prices) {
            if (price.shopName.equals(shopName)) {
                System.out.println(price);
                found = true;
            }
        }

        if (!found) {
            throw new NoSuchElementException("Такого магазину немає.");
        }
    }
}



