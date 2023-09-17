package presenter;

import model.Animal;
import model.AnimalCommand;
import model.service.Service;
import view.View;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void showAllAnimals() {
        for (Animal animal : this.service.getAnimalList()) {
            System.out.println(animal.toString());
        }
        System.out.println();
    }

    public void showAllCommands() {
        for (AnimalCommand command : this.service.getCommandList().values()) {
            System.out.println(command.toString());
        }
        System.out.println();
    }
}

