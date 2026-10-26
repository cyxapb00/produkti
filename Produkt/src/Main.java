import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] product = {"Хлеб", "Яблоко", "Молоко"};
        int[] price = {100, 200, 300};
        int[] count = new int[product.length];

        showAssortment(product, price);
        customerBuys(count);
        showCart(product, price, count);
    }

    private static void showCart(String[] product, int[] price, int[] count) {
        System.out.println("Ваша корзина:");
        int sum = 0;
        for (int i = 0; i < product.length; i++) {
            int totalPrice = price[i] * count[i];
            sum += totalPrice;
            System.out.printf("%s - %d шт. по %d руб. =  %d руб в сумме\n",
                    product[i], count[i], price[i], totalPrice);
        }
        System.out.printf("Итого: %d рублей", sum);
    }

    private static void customerBuys(int[] count) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите товар и количество или введите end:");
            String answer = scanner.nextLine();
            if (answer.equals("end")) {
                break;
            }
            String[] positionAndQuantity = answer.split(" ");
            int position = Integer.parseInt(positionAndQuantity[0]) - 1;
            int quantity = Integer.parseInt(positionAndQuantity[1]);

            count[position] += quantity;
        }
        System.out.println();
    }

    private static void showAssortment(String[] product, int[] price) {
        System.out.println("Список возможных товаров для покупки:");
        for (int i = 0; i < product.length; i++) {
            System.out.printf("%d. %s - %d руб/шт \n", i + 1, product[i], price[i]);
        }
        System.out.println();
    }
}
