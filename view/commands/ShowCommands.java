package view.commands;

import view.menu.Menu;

public class ShowCommands extends Command {
    public ShowCommands(Menu menu) {
        super("Посмотреть список команд, которые выполняет животное", menu);
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
            String result = this.presenter.showCommands(name, birthday);
            if (!result.isBlank()) {
                System.out.printf(result);
            } else {
                System.out.println("Животное с такими параметрами не найдено");
            }
        }
    }
}