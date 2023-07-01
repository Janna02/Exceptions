import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        System.out.println("Введена корректная строка - " + getInputString());
    }

    public static String getInputString() {
        String text = "";
        boolean flag = true;
        System.out.println("Введите строку: ");
        try (Scanner scanner = new Scanner(System.in)) {
            while (flag) {
                text = scanner.nextLine();
                if (text == "")
                    System.out.println("Некорректное значение.");
                else {
                    scanner.close();
                    flag = false;

                }
            }
        }
        return text;
    }

}
