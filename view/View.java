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
            System.out.println(String.format("Выберите действие:\n%s", menu));
            int choice = 0;
            boolean choiceCorrect = false;
            while (!choiceCorrect) {
                String text = this.scanner.nextLine();
                if (text.matches("\\d+")) {
                    choice = Integer.parseInt(text);
                }
                if (choice > 0 && choice <= menu.getMenuLength()) {
                    menu.run(choice);
                    choiceCorrect = true;
                } else {
                    System.out.println("Введено некорректное значение, повторите ввод");
                }
            }
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
