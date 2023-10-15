package view.commands;

import view.menu.Menu;

public class ShowAllAnimals extends Command {
    public ShowAllAnimals(Menu menu) {
        super("Показать список всех животных", menu);
    }

    @Override
    public void execute() {
        this.presenter.showAllAnimals();
    }
}