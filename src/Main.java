import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> todoList = new ArrayList<>();
        String[] taskText;
        int number = 0;

        for (; ; ) {
            String text = scanner.nextLine();
            String[] subTask = text.split(" ");

            if (text.matches("^[A-Z]+ \\d+ .+")) {
                taskText = text.split("^[A-Z]+ \\d+ ");
                number = Integer.parseInt(subTask[1]);
            }
            else {
                taskText= text.split("^[A-Z]+ ");
            }
//LIST
            if (subTask[0].equals("LIST")) {
                for (String word : todoList) {
                    System.out.println(word);
                }
            }
//ADD
            if (subTask[0].equals("ADD") && taskText.length == 2) {
                if (number > todoList.size()) {
                    System.out.println("Введите номер задания меньше чем " + (todoList.size()+1));
                } else {
                    todoList.add(number, taskText[1]);
                }
            } else if (subTask[0].equals("ADD") && taskText.length == 1) {
                todoList.add(taskText[1]);
            }
//EDIT
            if (subTask[0].equals("EDIT")) {
                if (number> todoList.size()) {
                    System.out.println("Введите номер задания меньше чем " + (todoList.size()+1));
                } else {
                    todoList.set(number, taskText[1]);
                }
            }
//DELETE
            if (subTask[0].equals("DELETE")) {
                if (number > todoList.size()) {
                    System.out.println("Введите номер задания меньше чем " + (todoList.size()+1));
                } else {
                    todoList.remove(number);
                }
            }
        }
    }
}
