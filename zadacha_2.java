// Пусть дан список сотрудников:
//Иван Иванов  //Светлана Петрова //Кристина Белова
//Анна Мусина  //Анна Крутова  //Иван Юрин
//Петр Лыков  //Павел Чернов  //Петр Чернышов
//Мария Федорова  //Марина Светлова  //Мария Савина
//Мария Рыкова  //Марина Лугова  //Анна Владимирова
//Иван Мечников  //Петр Петин  //Иван Ежов
//Написать программу, которая найдет и выведет повторяющиеся имена
// с количеством повторений. Отсортировать по убыванию популярности.


import java.util.*;

public class zadacha_2 {
    public static void main(String[] args) {
        LinkedList<String> employers = new LinkedList<>();
        employers.add("Иван Иванов");
        employers.add("Светлана Петрова");
        employers.add("Кристина Белова");
        employers.add("Анна Мусина");
        employers.add("Анна Крутова");
        employers.add("Иван Юрин");
        employers.add("Петр Лыков");
        employers.add("Павел Чернов");
        employers.add("Петр Чернышов");
        employers.add("Мария Федорова");
        employers.add("Марина Светлова");
        employers.add("Мария Савина");
        employers.add("Мария Рыкова");
        employers.add("Марина Лугова");
        employers.add("Анна Владимирова");
        employers.add("Иван Мечников");
        employers.add("Петр Петин");
        employers.add("Иван Ежов");

        LinkedList<String> names = new LinkedList<>(); //только имена
        for (String name: employers) {
            String[] substr = name.split(" ");
            names.add(substr[0]);
        }

        Set names_set = new HashSet(names);
        LinkedList<String> names_uniq = new LinkedList<>(names_set); // имена без повторений

        Map<String, Integer> names_count = new HashMap<>(); // имена и кол-во повторений
        for (String item: names_uniq) {  //добавили все неповторяющиеся имена
            names_count.put(item, 0);
        }
        for (String name: names) {  // добавили кол-во повторений имен
            names_count.put(name, names_count.get(name)+1);
        }
        System.out.println(names_count);
        // сортировка по кол-ву упоминаний
        names_count.entrySet().stream().sorted(Map.Entry.<String, Integer> comparingByValue()
                .reversed()).forEach(System.out::println);

    }
}
