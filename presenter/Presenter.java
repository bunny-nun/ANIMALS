package presenter;

import model.Animal;
import model.AnimalCommand;
import model.service.Counter;
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

    public int getCommandListLength() {
        return this.service.getCommandList().size();
    }

    public String create(String animalClass, String name, String birthday, int command1, int command2, int command3) {
        this.service.add(animalClass, name, birthday, command1, command2, command3);
        Animal animal = this.service.loadAnimal(animalClass, name, birthday);
        if (animal != null) return animal.toString();
        else return "";
    }

    public String find(String name, String birthday) {
        Animal animal = this.service.find(name, birthday);
        if (animal != null) return animal.toString();
        else return "";
    }

    public boolean delete(String name, String birthday) {
        Animal animal = this.service.find(name, birthday);
        return this.service.delete(animal);
    }

    public String changeClass(String name, String birthday, String animalClass) {
        Animal animal = this.service.find(name, birthday);
        if (animal != null) {
            int command1 = animal.getCommands().get(0).getCommandID();
            int command2 = animal.getCommands().get(1).getCommandID();
            int command3 = animal.getCommands().get(2).getCommandID();
            this.service.add(animalClass, name, birthday, command1, command2, command3);
            Animal newAnimal = this.service.loadAnimal(animalClass, name, birthday);
            if (newAnimal != null) {
                this.service.delete(animal);
                return newAnimal.toString();
            }
            else return "";
        } else return "";
    }

    public String showCommands(String name, String birthday) {
        Animal animal = this.service.find(name, birthday);
        if (animal != null) {
            StringBuilder commands = new StringBuilder();
            for (AnimalCommand command : animal.getCommands()) {
                commands.append(command.toString()).append("\n");
            }
            commands.append("\n");
            return commands.toString();
        }
        else return "";
    }

    public String changeCommands(String name, String birthday, int command1, int command2, int command3) {
        Animal animal = this.service.find(name, birthday);
        if (animal != null) {
            boolean result = this.service.changeCommands(animal, command1, command2, command3);
            if (result) return showCommands(name, birthday);
            else return "";
        }
        else return "";
    }

    public int getCount() {
        return Counter.getCount();
    }
}

