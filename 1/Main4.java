import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        try {
            String userInput = readNonEmptyStringFromUser();
            System.out.println("Введенная строка: " + userInput);
        } catch (EmptyStringException e) {
            System.out.println("Ошибка: Пустые строки вводить нельзя!");
        }
    }

    public static String readNonEmptyStringFromUser() throws EmptyStringException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            throw new EmptyStringException();
        }

        return input;
    }
}

class EmptyStringException extends Exception {
    // Класс пользовательского исключения для пустых строк
}
