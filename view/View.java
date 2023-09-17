package view;

import presenter.Presenter;
import view.menu.Menu;

import java.util.Scanner;

public class View {
    private Presenter presenter;
    private final Scanner scanner;
    private boolean status;

    public View() {
        this.scanner = new Scanner(System.in);
        this.status = true;
    }

    public void start() {
        while (status) {
            Menu menu = new Menu(this, this.presenter);
            System.out.println(String.format("Выберите действие:\n%s", menu.toString()));
            int choice = this.scanner.nextInt();
            menu.run(choice);
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
