import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите данные в формате: Фамилия Имя Отчество дата рождения номер телефона пол");
            String input = scanner.nextLine();

            String[] data = input.split("\\s+");
            if (data.length != 6) {
                throw new InvalidDataException("Ошибка: Некорректное количество данных.");
            }

            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            if (!isValidDate(birthDate)) {
                throw new InvalidDataException("Ошибка: Некорректный формат даты рождения.");
            }

            if (gender != 'м' && gender != 'ж') {
                throw new InvalidDataException("Ошибка: Некорректный пол.");
            }

            String fileName = surname + ".txt";
            FileWriter fileWriter = new FileWriter(fileName, true);
            String record = surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender;
            fileWriter.write(record + "\n");
            fileWriter.close();

            System.out.println("Данные успешно записаны в файл: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Некорректный формат номера телефона.");
        } catch (InvalidDataException e) {
            System.err.println(e.getMessage());
        }
    }

    public static boolean isValidDate(String date) {
        return date.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }
}

class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}
