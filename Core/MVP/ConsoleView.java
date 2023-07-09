package Core.MVP;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ConsoleView implements View {

    Scanner in = new Scanner(System.in);

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    public void consoleClear() {
        System.out.print("\033[H\033[J");
    }

    public String showMenu() {
        System.out.println("Меню розыгрыша игрушек:\n" + //
                "1. Добавить игрушку в розыгрыш\n" + //
                "2. Вывести все добавленные игрушки\n" + //
                "3. Выбрать призовую игрушку из коробки\n" + //
                "4. Вывести список призовых игрушек\n" + //
                "5. Выдать призовую игрушку из очереди\n" + //
                "6. Изменить вероятность выбора игрушки\n" + //
                "0. Выход из программы\n" + //
                "\n" + //
                "Ваш выбор:");
        return in.nextLine();

    }

    public void userWaiting() {
        System.out.println("Нажмите Enter, чтобы продолжить");
        in.nextLine();
    }

    public void showSuccessAddinMess() {
        System.out.println("игрушка добавлена успешно!");

    }

    public void showAddinToPrizeBoxMess() {
        System.out.println("Игрушка добавлена в очередь на выдачу.");
    }

    public void showPrizeToyMess() {
        System.out.println("Выдается игрушка:");
    }

    public void showSuccessDrawingMess() {
        System.out.println("Розыгрыш проведен! Выпала следующая игрушка:");
    
    }

    public void showSuccessChangeIdMess() {
        System.out.println("Вероятность выпадения изменена!");
    }

    public void showEmptyBoxMess() {
        System.out.println("Коробка пуста!");
    }

    public void showEmptyQueueMess() {
        System.out.println("Очередь на выдачу пуста!");
    }

    public void showGoobyeMess() {
        System.out.println("Программа завершила работу. До свидания!");
    }

    public void showUnknownCommMess() {
        System.out.println("Такого пункта меню нет");
    }

    public void showWrongIdMess(){
        System.out.println("Игрушки с таким ID нет");
    }

    public int getId() {
        System.out.println("Введите ID игрушки, которую надо изменить: ");
        try {
            int toyId = Integer.parseInt(in.nextLine());
            System.out.println("Успех: id принят!");
            return toyId;
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите число");
        }
        return -1;
    }

    @Override
    public String getToyName() {
        System.out.print("Имя игрушки: ");
        String toyName = in.nextLine();
        try {
            byte bytes[];
            bytes = toyName.getBytes(StandardCharsets.ISO_8859_1);
            String resultToyName = new String(bytes, StandardCharsets.UTF_8);
            return resultToyName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getToyProbability() {
        int probability = -1;
        while (probability > 100 || probability < 0) {
            System.out.print("Вероятность выбора игрушки от 0 до 100: ");
            if (!in.hasNextLine()) {
                System.out.println("Ошибка: поток ввода закрыт");
                return -1;
            }
            try {
                probability = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число от 0 до 100");
            }
        }
        return probability;
    }

    @Override
    public void display(String data) {
        System.out.println(data);

    }

}