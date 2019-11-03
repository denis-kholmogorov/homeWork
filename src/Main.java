import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> todoList = new ArrayList<>();

        for (; ; ) {
            String text = scanner.nextLine();
            System.out.println(text.matches("^[A-Z]+ \\d+ .+"));
            String[] taskWithNumber = text.split("^[A-Z]+ \\d+ ");
            String[] taskNoNumber = text.split("^[A-Z]+ ");
            String[] subTask = text.split(" ");

            if (subTask[0].equals("LIST")) {
                for (String word : todoList) {
                    System.out.println(word);
                }
            }

            if (subTask[0].equals("ADD") && taskWithNumber.length == 2) {
                if (Integer.parseInt(subTask[1]) > todoList.size()) {
                    System.out.println("Введите номер задания меньше чем " + (todoList.size()+1));
                } else {
                    todoList.add(Integer.parseInt(subTask[1]), taskWithNumber[1]);
                }
            } else if (subTask[0].equals("ADD") && taskWithNumber.length == 1) {
                todoList.add(taskNoNumber[1]);
            }

            if (subTask[0].equals("EDIT")) {
                if (Integer.parseInt(subTask[1])> todoList.size()) {
                    System.out.println("Введите номер задания меньше чем " + (todoList.size()+1));
                } else {
                    todoList.set(Integer.parseInt(subTask[1]), taskWithNumber[1]);
                }
            }
            if (subTask[0].equals("DELETE")) {
                if (Integer.parseInt(subTask[1]) > todoList.size()) {
                    System.out.println("Введите номер задания меньше чем " + (todoList.size()+1));
                } else {
                    todoList.remove(Integer.parseInt(subTask[1]));
                }
            }
        }
    }
}
