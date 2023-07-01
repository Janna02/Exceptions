import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        System.out.println("Введено корректное значение дробного числа- " + getFloatNumber());
    }

    public static Float getFloatNumber() {
        Float num = null;
        boolean flag = true;
        System.out.println("Введите дробное число: ");
        try (Scanner scanner = new Scanner(System.in)) {
            while (flag) {
                String text = scanner.nextLine();
                String[] splitString = text.split("\\.");
                if (splitString.length > 2 || splitString.length == 1 ||
                        !splitString[0].matches("[0-9]+") || !splitString[1].matches("[0-9]+"))
                    System.out.println("Попробуйте еще раз, требуется ввести дробное число(через точку)");
                else {
                    scanner.close();
                    flag = false;
                    num = Float.parseFloat(text);
                }
            }
        }
        return num;
    }
}
