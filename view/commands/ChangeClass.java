package view.commands;

import view.menu.Menu;

public class ChangeClass extends Command {
    public ChangeClass(Menu menu) {
        super("Определить животное в правильный класс", menu);
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
            boolean choiceCorrect = false;
            int choice = 0;
            while (!choiceCorrect) {
                System.out.println("Выберите новый класс животного:");
                System.out.println("""
                    1 - cat
                    2 - dog
                    3 - hamster
                    4 - horse
                    5 - camel
                    6 - donkey""");
                String text = this.scanner.nextLine();
                if (text.matches("\\d")) {
                    choice = Integer.parseInt(text);
                }
                if (choice > 0 && choice < 7) {
                    choiceCorrect = true;
                } else {
                    System.out.println("Введено некорректное значение, повторите ввод");
                }
            }
            String animalClass = switch (choice) {
                case 1 -> "cat";
                case 2 -> "dog";
                case 3 -> "hamster";
                case 4 -> "horse";
                case 5 -> "camel";
                case 6 -> "donkey";
                default -> "";
            };
            String result = this.presenter.changeClass(name, birthday, animalClass);
            if (!result.isBlank()) {
                System.out.printf("Класс животного успешно изменен:\n%s\n\n", result);
            } else {
                System.out.println("Животное с такими параметрами не найдено");
            }

        }
    }
}