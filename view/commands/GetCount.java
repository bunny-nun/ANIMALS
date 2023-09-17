package view.commands;

import view.menu.Menu;

public class GetCount extends Command {
    public GetCount(Menu menu) {
        super("Узнать количество животных", menu);
    }

    @Override
    public void execute() {
        int count = this.presenter.getCount();
        System.out.printf("Количество животных: %d\n", count);;
    }
}
