package view.commands;

import view.menu.Menu;

public class Exit extends Command {
    public Exit(Menu menu) {
        super("Завершить работу", menu);
    }

    @Override
    public void execute() {
        this.menu.getView().setStatus(false);
    }
}
