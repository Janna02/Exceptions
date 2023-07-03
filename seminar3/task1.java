package seminar3;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class task1 {
    public static void main(String[] args) throws IOException {

        String[] data = validInfo();
        writeFile(data);
        readFile(data[0]);
    }

    public static String[] getInfoFromUser() {
        String[] text;
        System.out.println("Введите данные: ");
        try (Scanner scanner = new Scanner(System.in)) {
            text = scanner.nextLine().split(" ");
            scanner.close();
        }
        return text;
    }

    public static void printInfo(String[] info) {
        for (String string : info) {
            System.out.println(string);
        }
    }

    public static String[] validInfo() {
        boolean flag = true;
        String[] arr = null;
        int exc;
        while (flag) {
            arr = getInfoFromUser();
            exc = 0;
            if (checkEmpty(arr) == false) {
                exc++;
                throw new RuntimeException("Неверное количество данных. Повторите ввод.");
            }
            if (checkQuantity(arr) == false) {
                exc++;
                throw new RuntimeException("Неверное количество данных. Повторите ввод.");
            }
            if (checkValidFIO(arr) == false) {
                exc++;
                throw new RuntimeException("Неверно введено ФИО. Повторите ввод.");
            }
            if (checkValidDateOfBirth(arr) == false) {
                exc++;
                throw new RuntimeException("Неверно введена дата рождения. Повторите ввод.");
            }
            if (checkValidNumberPhone(arr) == false) {
                exc++;
                throw new RuntimeException("Неверно введен номер телефона. Повторите ввод.");
            }
            if (exc == 0) {
                System.out.println("Данные введены корректно.");
                flag = false;
                return arr;
            }
        }
        return arr;
    }

    public static boolean checkEmpty(String[] arr) {
        if (arr != null)
            return true;
        return false;
    }

    public static boolean checkQuantity(String[] arr) {
        if (arr.length == 5)
            return true;
        return false;
    }

    public static boolean checkValidFIO(String[] arr) {
        if ((arr[0].matches("[a-zA-Z]+")) && (arr[1].matches("[a-zA-Z]+")) &&
                (arr[2].matches("[a-zA-Z]+")) && (arr[0].length() > 1) &&
                (arr[1].length() > 1) && (arr[2].length() > 1))
            return true;
        return false;
    }

    public static boolean checkValidDateOfBirth(String[] arr) {
        String[] dateOfBirth = arr[3].split("\\.");
        if (((dateOfBirth[0].length() == 1) || (dateOfBirth[0].length() == 2)) && (dateOfBirth[0].matches("[0-9]+")) &&
                ((dateOfBirth[1].length() == 1) || (dateOfBirth[1].length() == 2)) && (dateOfBirth[1].matches("[0-9]+"))
                &&
                (dateOfBirth[2].length() == 4) && (dateOfBirth[2].matches("[0-9]+")))
            return true;
        return false;
    }

    public static boolean checkValidNumberPhone(String[] arr) {
        if ((arr[4].length() >= 6) && (arr[4].length() <= 11) && (arr[4].matches("[0-9]+")))
            return true;
        return false;
    }

    public static void writeFile(String[] arr) {
        String fileName = arr[0] + ".txt";
        String dataToString = String.join(", ", arr);
        try {
            FileWriter writer = new FileWriter(fileName, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(dataToString);
            bufferWriter.write("\n");
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
            e.printStackTrace();
        }
    }

    public static void readFile(String fileName) throws IOException {
        fileName += ".txt";
        Path path = Paths.get(fileName);
        try (Stream<String> text = Files.lines(path, StandardCharsets.UTF_8)) {
            text.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            e.printStackTrace();
        }
    }

}
