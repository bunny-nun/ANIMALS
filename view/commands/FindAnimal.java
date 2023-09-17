package view.commands;

import view.menu.Menu;

import java.util.ArrayList;

public class FindAnimal extends Command {
    public FindAnimal(Menu menu) {
        super("Найти животное", menu);
    }

    @Override
    public void execute() {
        boolean nameNotEmpty = false;
        while (!nameNotEmpty) {
            System.out.println("Введите имя животного:");
            String name = this.scanner.nextLine();
            if (!name.isBlank()) {
                nameNotEmpty = true;
            } else {
                System.out.println("Введено некорректное значение, повторите ввод");
            }
            boolean dateCorrect = false;
            String birthday = "";
            while (!dateCorrect) {
                System.out.println("Введите дату рождения животного в формате \"yyyy-MM-dd\":");
                birthday = this.scanner.nextLine();
                if (birthday.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    dateCorrect = true;
                } else {
                    System.out.println("Введено некорректное значение, повторите ввод");
                }
            }
            String result = this.presenter.find(name, birthday);
            if (!result.isBlank()) {
                System.out.printf("Животное найдено:\n%s\n\n", result);
            } else {
                System.out.println("Животное с такими параметрами не найдено");
            }
        }
    }
}