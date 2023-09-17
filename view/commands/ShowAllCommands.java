package view.commands;

import view.menu.Menu;

public class ShowAllCommands extends Command {
    public ShowAllCommands(Menu menu) {
        super("Показать список всех команд", menu);
    }

    @Override
    public void execute() {
        this.presenter.showAllCommands();
    }
}