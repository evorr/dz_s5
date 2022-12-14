// Реализуйте структуру телефонной книги с помощью HashMap,
// учитывая, что 1 человек может иметь несколько телефонов.

import java.util.*;

public class zadacha_1 {
    public static void main(String[] args) {
        Map<String, List<String>> phbook = new HashMap<>();
        Scanner iScanner = new Scanner(System.in);

        String stop = "";
        do {
            System.out.printf("Добваить контакт? (y - да/ n - нет) ");
            String adcnt = iScanner.nextLine();
            if(adcnt.equals("y")) {
                System.out.printf("Введите имя: ");
                String name = iScanner.nextLine();
                System.out.printf("Введите телефон: ");
                String number = iScanner.nextLine();

                List<String> numbers = new ArrayList<>();
                numbers.add(number);
                System.out.printf("Добваить еще номер? (y - да/ n - нет) ");
                String answer = iScanner.nextLine();
                if(answer.equals("y")) {
                    System.out.printf("Введите телефон: ");
                    String number2 = iScanner.nextLine();
                    numbers.add(number2);
                }
                phbook.put(name, numbers);
            }
            stop = adcnt;
        } while (stop.equals("y"));

        // вывод всех контактов
        for (var item:phbook.entrySet()) {
            System.out.println(item.getKey());
            for (var num:item.getValue()) {
                System.out.println(num);
            }
        }

        // поиск контакта по имени
        System.out.printf("Введите для поиска имя: ");
        String search = iScanner.nextLine();
        if(phbook.containsKey(search)){
            for (var item: phbook.entrySet()) {
                if (item.getKey().contains(search)){
                    System.out.println(item.getKey());
                    for (var num:item.getValue()) {
                        System.out.println(num);
                    }
                }
            }
        }
        else {
            System.out.println("контакта нет");
        }
    }
}