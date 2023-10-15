package view.commands;

import presenter.Presenter;
import view.menu.Menu;

import java.util.Scanner;

public abstract class Command {
    protected String description;
    protected Menu menu;
    protected Presenter presenter;
    protected Scanner scanner;

    public Command(String description, Menu menu) {
        this.description = description;
        this.menu = menu;
        this.presenter = this.menu.getPresenter();
        this.scanner = this.menu.getView().getScanner();
    }

    public abstract void execute();

    public String getDescription() {
        return this.description;
    }
}