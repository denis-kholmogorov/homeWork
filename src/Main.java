import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> todoList = new ArrayList<>();
        int number;

        for (;;) {
            String[] taskText;
            String text = scanner.nextLine();
            String[] subTask = text.split(" ", 2);


            if (text.matches("^LIST$")) {   // LIST
                System.out.println("Список заданий: ");
                for (String word : todoList) {
                    System.out.println(word);
                }
            }

            if (text.matches("^ADD \\d+ .+")) {  //ADD + NUMBER
                taskText = text.split("^ADD \\d+ ");
                number = Integer.parseInt(subTask[1]);
                if(number <= todoList.size()) {
                    todoList.add(number, taskText[1]);
                    System.out.println("Добавлено задание под № " + number);
                }
                else {
                    System.out.println("Введите номер задания меньше чем " + (todoList.size() + 1));
                }
            }

            if (text.matches("^EDIT \\d+ .+")){    // EDIT + NUMBER
                taskText = text.split("^EDIT \\d+ ");
                number = Integer.parseInt(subTask[1]);
                if(number < todoList.size()) {
                    todoList.set(number, taskText[1]);
                    System.out.println("Изменено задание под № " + number);
                }
                else {
                    System.out.println("Введите номер задания меньше чем " + todoList.size());
                }
            }
            if (text.matches("^ADD \\D+")) {  // ADD
                taskText = text.split("^[A-Z]+ ");
                todoList.add(taskText[1]);
                System.out.println("Добавлено задание");

            }
            if (text.matches("^DELETE \\d+$")){   // DELETE
                number = Integer.parseInt(subTask[1]);
                if(number < todoList.size()) {
                    todoList.remove(number);
                    System.out.println("Удалено задание № " + number);
                }
                else {
                    System.out.println("Введите номер задания меньше чем " + todoList.size());
                }
            }
        }
    }
}

