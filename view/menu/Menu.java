package view.menu;

import presenter.Presenter;
import view.View;
import view.commands.*;


import java.util.ArrayList;

public class Menu {
    protected ArrayList<Command> menu;
    protected View view;
    protected Presenter presenter;

    public Menu(View view, Presenter presenter) {
        this.view = view;
        this.presenter = presenter;
        this.menu = new ArrayList<>();
        this.menu.add(new AddAnimal(this));
        this.menu.add(new ShowAllAnimals(this));
        this.menu.add(new FindAnimal(this));
        this.menu.add(new ShowCommands(this));
        this.menu.add(new ChangeClass(this));
        this.menu.add(new ChangeCommands(this));
        this.menu.add(new DeleteAnimal(this));
        this.menu.add(new ShowAllCommands(this));
        this.menu.add(new Exit(this));
    }

    public void run(int choice) {
        this.menu.get(choice - 1).execute();
    }

    @Override
    public String toString() {
        StringBuilder menuStringBuilder = new StringBuilder();
        for (Command command : this.menu) {
            menuStringBuilder.append(String.format("%d - %s\n", this.menu.indexOf(command) + 1, command.getDescription()));
        }
        return menuStringBuilder.toString();
    }

    public View getView() {
        return this.view;
    }

    public Presenter getPresenter() {
        return this.presenter;
    }

    public int getMenuLength() {
        return this.menu.size();
    }
}
