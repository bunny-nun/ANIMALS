package view.commands;

import view.menu.Menu;

import java.util.ArrayList;

public class ChangeCommands extends Command {
    public ChangeCommands(Menu menu) {
        super("Обучить животное новым командам", menu);
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
            int commandCounter = 1;
            int command = -1;
            ArrayList<Integer> commands = new ArrayList<>();
            while (commandCounter < 4) {
                System.out.printf("Введите ID команды %d (для просмотра списка всех команд введите 0):\n", commandCounter);
                String text = this.scanner.nextLine();
                if (text.matches("\\d+")) {
                    command = Integer.parseInt(text);
                }
                if (command == 0) {
                    this.presenter.showAllCommands();
                }
                if (command > 0 && command <= this.presenter.getCommandListLength()) {
                    commands.add(command);
                    commandCounter++;
                } else {
                    if (command != 0) {
                        System.out.println("Введено некорректное значение, повторите ввод");
                    }
                }
            }
            int command1 = commands.get(0);
            int command2 = commands.get(1);
            int command3 = commands.get(2);
            String result = this.presenter.changeCommands(name, birthday, command1, command2, command3);
            if (!result.isBlank()) {
                System.out.printf("Команды успешно разучены:\n%s", result);
            } else {
                System.out.println("Животное с такими параметрами не найдено");
            }
        }
    }
}